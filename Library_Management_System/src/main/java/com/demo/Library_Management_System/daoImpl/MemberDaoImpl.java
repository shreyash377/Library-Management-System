package com.demo.Library_Management_System.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.Library_Management_System.dao.*;
import com.demo.Library_Management_System.entities.*;
import com.demo.Library_Management_System.HibernateUtil;

import java.util.List;


public class MemberDaoImpl implements MemberDao {

	 @Override
	    public Member createMember(Member member) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(member);  // Save library
	            transaction.commit();
	            return member;
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	    }

	    @Override
	    public List<Member> getAllMember() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Member", Member.class).list();  // Fetch all libraries
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	    }

	    @Override
	    public Member getMemberById(int MemberId) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(Member.class, MemberId);  // Fetch library by name
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	    }

	    @Override
	    public Member updateMember(int MemberId, Member updatedMember) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();

	            // Fetch the existing library from the database
	            Member existingMember = session.get(Member.class, MemberId);

	            if (existingMember != null) {
	                // Update the fields of the existing library with the new values
	            	 existingMember.setName(updatedMember.getName());
	                 existingMember.setAddress(updatedMember.getAddress());
	                 existingMember.setGender(updatedMember.getGender());
	                 existingMember.setContactno(updatedMember.getContactno());
	                 existingMember.setEmail(updatedMember.getEmail());
	                // Update the existing library in the database
	                session.update(existingMember);

	                // Commit the transaction
	                transaction.commit();

	                return existingMember;  // Return the updated library
	            } else {
	                System.out.println("Member not found");
	            }
	        } catch (HibernateException e) {
	            if (transaction != null) {
	                transaction.rollback();  // Rollback in case of an error
	            }
	            System.out.println("HibernateException: " + e.getMessage());
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();  // Rollback in case of a general error
	            }
	            System.out.println("Exception: " + e.getMessage());
	        }
	        return null;  // Return null if the library wasn't updated
	    }

	    @Override
	    public String deleteMember(int MemberId) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();

	            Member member = session.get(Member.class, MemberId);
	            if (member != null) {
	                session.delete(member);  // Delete library
	                transaction.commit();
	                return "Member deleted successfully.";
	            } else {
	                return "Member not found.";
	            }
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return "Failed to delete the Member.";
	    }
}
