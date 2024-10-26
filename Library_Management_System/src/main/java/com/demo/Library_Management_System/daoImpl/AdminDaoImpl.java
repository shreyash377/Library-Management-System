package com.demo.Library_Management_System.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.Library_Management_System.dao.*;
import com.demo.Library_Management_System.entities.*;
import com.demo.Library_Management_System.HibernateUtil;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin createAdmin(Admin admin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(admin);  // Save admin
            transaction.commit();  // Commit transaction
            return admin;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback on error
            }
            System.out.println("HibernateException: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback on general error
            }
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmin() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Admin", Admin.class).list();  // Fetch all admins
        } catch (HibernateException e) {
            System.out.println("HibernateException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Admin getAdminById(long adminId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Admin.class, adminId);  // Fetch admin by ID
        } catch (HibernateException e) {
            System.out.println("HibernateException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Admin updateAdmin(long adminId, Admin updatedAdmin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Admin existingAdmin = session.get(Admin.class, adminId);
            if (existingAdmin != null) {
                existingAdmin.setAdminname(updatedAdmin.getAdminname());
                existingAdmin.setContactno(updatedAdmin.getContactno());
                existingAdmin.setEmailid(updatedAdmin.getEmailid());
                session.update(existingAdmin);
                transaction.commit();  // Commit transaction
                return existingAdmin;  // Return the updated admin
            } else {
                System.out.println("Admin not found");
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback on error
            }
            System.out.println("HibernateException: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback on general error
            }
            System.out.println("Exception: " + e.getMessage());
        }
        return null;  // Return null if the admin wasn't updated
    }

    @Override
    public String deleteAdmin(long adminId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Admin admin = session.get(Admin.class, adminId);
            if (admin != null) {
                session.delete(admin);  // Delete admin
                transaction.commit();  // Commit transaction
                return "Admin deleted successfully.";
            } else {
                return "Admin not found.";
            }
        } catch (HibernateException e) {
            System.out.println("HibernateException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return "Failed to delete the admin.";  // Return message on failure
    }
}
