package com.demo.Library_Management_System.serviceImpl;

	import com.demo.Library_Management_System.dao.AdminDao;
	import com.demo.Library_Management_System.entities.Admin;
	import com.demo.Library_Management_System.services.AdminServices;
	import java.util.List;

	public class AdminServiceImpl implements AdminServices {

		private AdminDao adminDao;
		@Override
		public Admin createAdmin(Admin admin) {
			return adminDao.createAdmin(admin);  
		}

		@Override
		public List<Admin> getAllAdmin() {
			return adminDao.getAllAdmin();
		}

		@Override
		public Admin getAdminById(long adminId) {
			return adminDao.getAdminById(adminId);
		}

		@Override
		public Admin updateAdmin(long adminId, Admin updatedAdmin) {
			return adminDao.updateAdmin(adminId, updatedAdmin); 
		}

		@Override
		public String deleteAdmin(long adminId) {
			adminDao.deleteAdmin(adminId);
			return "User deleted successfully!";
		}
	}

