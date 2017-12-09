/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mirko
 */
@Embeddable
public class WarningPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "UID")
    private int uid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WARNINGID")
    private int warningid;

    public WarningPK() {
    }

    public WarningPK(int uid, int warningid) {
        this.uid = uid;
        this.warningid = warningid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getWarningid() {
        return warningid;
    }

    public void setWarningid(int warningid) {
        this.warningid = warningid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) uid;
        hash += (int) warningid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WarningPK)) {
            return false;
        }
        WarningPK other = (WarningPK) object;
        if (this.uid != other.uid) {
            return false;
        }
        if (this.warningid != other.warningid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.WarningPK[ uid=" + uid + ", warningid=" + warningid + " ]";
    }
    
}
