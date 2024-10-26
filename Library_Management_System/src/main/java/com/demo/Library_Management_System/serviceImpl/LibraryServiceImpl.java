package com.demo.Library_Management_System.serviceImpl;

import java.util.List;
import com.demo.Library_Management_System.dao.LibraryDao;
import com.demo.Library_Management_System.entities.Library;
import com.demo.Library_Management_System.services.LibraryService;



public class LibraryServiceImpl implements LibraryService {

   
    private LibraryDao libraryDao;

    @Override
    public Library createLibrary(Library library) {
        return libraryDao.createLibrary(library);
    }

    @Override
    public List<Library> getAllLibrary() {
        return libraryDao.getAllLibrary();
    }

    @Override
    public Library getLibraryById(String libraryname) {
        return libraryDao.getLibraryById(libraryname);
    }

 
    @Override
    public String deleteLibrary(String libraryname) {
    	libraryDao.deleteLibrary(libraryname);
        return "Library deleted successfully!";
    }


    @Override
    public Library updateLibrary(String libraryname, Library updatedlibraryname) {
    	return libraryDao.updateLibrary(libraryname, updatedlibraryname);
	}

}
