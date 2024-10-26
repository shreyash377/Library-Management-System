package com.demo.Library_Management_System;

import com.demo.Library_Management_System.services.AdminServices;
import com.demo.Library_Management_System.services.*;
import com.demo.Library_Management_System.serviceImpl.AdminServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.demo.Library_Management_System.entities.Admin;
import com.demo.Library_Management_System.serviceImpl.*;

public class AllOperations {

    static AdminServices adminService = new AdminServiceImpl();
    static BookService bookService = new BooksServiceImpl();
    static LibraryService LibraryService = new LibraryServiceImpl();
    static MemberService memberService = new MemberServiceImpl();
    
    // static FeedBackService feedBackService = new FeedBackServiceImpl();

    static Scanner sc = new Scanner(System.in);

    // Admin Input method
    public static Admin adminInputs() {
        // Collect Admin ID from user
        System.out.println("Enter Admin ID:");
        long adminId = 0;
        try {
            adminId = sc.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric Admin ID.");
            sc.next();  // consume invalid input
            return null;  // stop further processing
        }
        sc.nextLine();  // consume the newline character after the long input

        // Collect Admin name from user
        System.out.println("Enter Admin Name:");
        String adminName = sc.nextLine();

        // Collect Contact Number from user
        System.out.println("Enter Contact Number:");
        long contactNo = 0;
        try {
            contactNo = sc.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric Contact Number.");
            sc.next();  // consume invalid input
            return null;
        }
        sc.nextLine();  // consume the newline character

        // Collect Email ID from user
        System.out.println("Enter Email ID:");
        String emailId = sc.nextLine();

        // Return a new Admin object using the provided constructor
        return new Admin(adminId, adminName, contactNo, emailId);
    }

    // Admin Operations method
    public static void adminOperations() {
        while (true) {
            System.out.println("Press 1. Add Admin\nPress 2. Retrieve All Admins\n"
                    + "Press 3. Update Admin\nPress 4. Delete Admin\nPress 5. To get back to the main menu");
            
            int input = 0;
            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                sc.next();  // consume invalid input
                continue;  // prompt again
            }
            sc.nextLine();  // consume the newline character

            switch (input) {
                case 1:
                    // Adding a new Admin
                    Admin admin = adminInputs();
                    if (admin != null) {  // Proceed if input is valid
                        Admin savedAdmin = adminService.createAdmin(admin);  // Assuming you have a service method createAdmin
                        System.out.println("Admin has been saved successfully: " + savedAdmin);
                    }
                    break;

                case 2:
                    // Retrieve all Admins
                    List<Admin> admins = adminService.getAllAdmin();  // Assuming you have a service method getAllAdmin
                    for (Admin a : admins) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    // Update an Admin
                    System.out.println("Enter Admin ID to update:");
                    long adminIdToUpdate = 0;
                    try {
                        adminIdToUpdate = sc.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a numeric Admin ID.");
                        sc.next();  // consume invalid input
                        continue;
                    }
                    sc.nextLine();  // consume the newline character
                    Admin existingAdmin = adminService.getAdminById(adminIdToUpdate);  // Fetch the admin by ID

                    if (existingAdmin != null) {
                        Admin updatedAdmin = adminInputs();  // Get new input for the update
                        if (updatedAdmin != null) {  // Proceed if input is valid
                            Admin updatedInfo = adminService.updateAdmin(adminIdToUpdate, updatedAdmin);  // Call update service method
                            System.out.println("Admin data has been updated successfully: " + updatedInfo);
                        }
                    } else {
                        System.out.println("Admin not found.");
                    }
                    break;

                case 4:
                    // Delete an Admin
                    System.out.println("Enter Admin ID to delete:");
                    long deleteAdminId = 0;
                    try {
                        deleteAdminId = sc.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a numeric Admin ID.");
                        sc.next();  // consume invalid input
                        continue;
                    }
                    sc.nextLine();  // consume the newline character
                    String message = adminService.deleteAdmin(deleteAdminId);  // Assuming you have a service method deleteAdmin
                    System.out.println(message);
                    break;

                case 5:
                    // Return to main menu
                    return;

                default:
                    System.out.println("Invalid option! Please choose a number between 1 and 5.");
            }
        }
    }
}


