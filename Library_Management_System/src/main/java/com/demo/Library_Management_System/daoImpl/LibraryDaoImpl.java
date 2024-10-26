package com.demo.Library_Management_System.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.Library_Management_System.dao.*;
import com.demo.Library_Management_System.entities.*;
import com.demo.Library_Management_System.HibernateUtil;

import java.util.List;

public class LibraryDaoImpl implements LibraryDao {

    @Override
    public Library createLibrary(Library library) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(library);  // Save library
            transaction.commit();
            return library;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Library> getAllLibrary() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Library", Library.class).list();  // Fetch all libraries
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Library getLibraryById(String libraryname) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Library.class, libraryname);  // Fetch library by name
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Library updateLibrary(String libraryname, Library updatedLibrary) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Fetch the existing library from the database
            Library existingLibrary = session.get(Library.class, libraryname);

            if (existingLibrary != null) {
                // Update the fields of the existing library with the new values
                existingLibrary.setLibraryname(updatedLibrary.getLibraryname());
                existingLibrary.setLibraryaddress(updatedLibrary.getLibraryaddress());
                existingLibrary.setContactno(updatedLibrary.getContactno());

                // Update the existing library in the database
                session.update(existingLibrary);

                // Commit the transaction
                transaction.commit();

                return existingLibrary;  // Return the updated library
            } else {
                System.out.println("Library not found");
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
    public String deleteLibrary(String libraryname) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Library library = session.get(Library.class, libraryname);
            if (library != null) {
                session.delete(library);  // Delete library
                transaction.commit();
                return "Library deleted successfully.";
            } else {
                return "Library not found.";
            }
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Failed to delete the library.";
    }
}
