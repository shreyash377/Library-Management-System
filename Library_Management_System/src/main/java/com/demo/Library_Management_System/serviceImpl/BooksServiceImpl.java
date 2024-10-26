package com.demo.Library_Management_System.serviceImpl;

import com.demo.Library_Management_System.dao.BooksDao;
import com.demo.Library_Management_System.entities.Books;
import com.demo.Library_Management_System.services.BookService;


import java.util.List;


public class BooksServiceImpl implements BookService {

   
    private BooksDao booksDao;

    @Override
    public Books createBook(Books book) {
        return booksDao.createBook(book);
    }

    @Override
    public List<Books> getAllBooks() {
        return booksDao.getAllBooks();
    }

    @Override
    public Books getBookById(int bookId) {
        return booksDao. getBookById(bookId);
    }

    @Override
    public Books updateBook(int bookId, Books updatedBook) {
        return booksDao.updateBook(bookId, updatedBook);
    }

    @Override
    public String deleteBook(int bookId) {
        booksDao.deleteBook(bookId);
        return "Book deleted successfully!";
    }
}
