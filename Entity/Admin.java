package Entity;

import java.util.Objects;

public class Admin implements Comparable<Admin> {
    private String AdminID;
    private String password;
    private String AdminName;

    public Admin(){
    }

    public Admin(String adminID, String password, String adminName) {
        this.AdminID = adminID;
        this.password = password;
        this.AdminName = adminName;
    }

    public String getAdminID() {
        return AdminID;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    @Override
    public int compareTo(Admin other) {
        return AdminID.compareTo(other.AdminID);
    }

    // Method of Entity
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + AdminID + '\'' +
                ", adminName='" + AdminName + '\'' +
                '}';
    }


}
