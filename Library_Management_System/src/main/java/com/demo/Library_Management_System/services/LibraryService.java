package com.demo.Library_Management_System.services;

import com.demo.Library_Management_System.entities.Library;
import java.util.List;


public interface LibraryService {
	Library createLibrary(Library library);
    List<Library> getAllLibrary();
    Library getLibraryById(String libraryname);
    Library updateLibrary(String libraryname, Library updatedlibraryname);
    String deleteLibrary(String libraryname);
}
