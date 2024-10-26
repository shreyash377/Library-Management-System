package com.demo.Library_Management_System.dao;

import java.util.List;
import com.demo.Library_Management_System.entities.Library;

public interface LibraryDao {
	Library createLibrary(Library library);
    List<Library> getAllLibrary();
    Library getLibraryById(String libraryname);
    Library updateLibrary(String libraryname, Library updatedlibraryname);
    String deleteLibrary(String libraryname);
}
