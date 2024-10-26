package com.demo.Library_Management_System.services;

import com.demo.Library_Management_System.entities.Admin; 
import java.util.List;

public interface AdminServices {

	Admin createAdmin(Admin admin);	
    List<Admin>getAllAdmin();
    Admin getAdminById(long adminId);
    Admin updateAdmin(long adminId, Admin updatedadmin);
    String deleteAdmin(long adminId);

}