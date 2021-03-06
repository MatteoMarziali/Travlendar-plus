/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Preferences;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbeans.PreferencesFacadeLocal;

/**
 *
 * @author Mirko
 */
@WebServlet(name = "DisplayPreferences", urlPatterns = {"/DisplayPreferences"})
public class DisplayPreferences extends HttpServlet {

    @EJB
    private PreferencesFacadeLocal preferencesFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayPreferences</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayPreferences at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Preferences pref=null;
        try{
        HttpSession session = request.getSession();
        String uid = session.getAttribute("uid").toString();
        
        pref = preferencesFacade.find(Integer.parseInt(uid));
        
        }catch(NullPointerException e){
            response.sendRedirect("login.jsp");
        }
        
         
        //List<Product> products = productService.list(); // Obtain all products.
        request.setAttribute("mincarbonfootprint", pref.getMinimizecarbonfootprint() ? "checked" : ""); // Store var in request scope.
        request.setAttribute("avoidtolls", pref.getAvoidtolls() ? "checked" : ""); // Store var in request scope.
        request.setAttribute("avoidmotorways", pref.getAvoidmotorways() ? "checked" : ""); // Store var in request scope.
        
        request.setAttribute("maxw", pref.getMaxwalkingdistance()+"");
       
        request.setAttribute("maxc", pref.getMaxcyclingdistance()+"");
        
        request.setAttribute("nopublic", pref.getNopublictransportationsafter().getHours()+":"+pref.getNopublictransportationsafter().getMinutes());
        
        
        
        request.getRequestDispatcher("setupPreferences.jsp").forward(request, response); // Forward to JSP page to display them in a HTML form
   
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
