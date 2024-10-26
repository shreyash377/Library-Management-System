package com.demo.Library_Management_System.dao;

import com.demo.Library_Management_System.entities.Books;
import java.util.List;

public interface BooksDao {

	Books createBook(Books book);
    List<Books> getAllBooks();
    Books getBookById(int bookId);
    Books updateBook(int bookId, Books updatedBook);
    String deleteBook(int bookId);
}
