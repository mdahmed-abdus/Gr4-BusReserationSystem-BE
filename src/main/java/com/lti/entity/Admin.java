
package com.lti.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bus_admin")
public class Admin {
	
	@Id
	int admin_Id;
	String adminName;
	String adminPassword;
	
	
	public int getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	@Override
	public String toString() {
		return "Admin [admin_Id=" + admin_Id + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
	
	
	

}

