package com.demo.Library_Management_System.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.Library_Management_System.dao.*;
import com.demo.Library_Management_System.entities.*;
import com.demo.Library_Management_System.HibernateUtil;

import java.util.List;


public class BooksDaoImpl implements BooksDao {

	@Override
	public Books createBook(Books book) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(book);  // Save answer
			session.getTransaction().commit();
			return book;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Books>getAllBooks() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			return session.createQuery("from Books", Books.class).list();  // Fetch all answers
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Books getBookById(int bookId) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			return session.get(Books.class, bookId);  // Fetch answer by ID
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Books updateBook(int bookId, Books updatedBook) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Start the transaction only once
			transaction = session.beginTransaction();

			// Fetch the existing answer from the database
			Books existingBook = session.get(Books.class, bookId);

			if (existingBook != null) {
				// Update the fields of the existing answer with the new values
				existingBook.setBookname(updatedBook.getBookname());
				existingBook.setBookprice(updatedBook.getBookprice());
				existingBook.setBookstatus(updatedBook.getBookstatus());
				// Update the existing answer in the database
				session.update(existingBook);

				// Commit the transaction
				transaction.commit();

				return existingBook;  // Return the updated answer
			} else {
				System.out.println("Book not found");
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
		return null;  // Return null if the answer wasn't updated
	}


	@Override
	public String deleteBook(int bookId) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			// session.beginTransaction();
			Books book= session.get(Books.class, bookId);
			if (book != null) {
				session.delete(bookId);  
				session.getTransaction().commit();
				return "Book deleted successfully.";
			} else {
				return "Book not found.";
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Failed to delete the Bookx.";
	}
}
