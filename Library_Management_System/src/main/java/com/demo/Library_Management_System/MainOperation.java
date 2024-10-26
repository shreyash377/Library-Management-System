package com.demo.Library_Management_System;


import java.util.Scanner;
import com.demo.Library_Management_System.AllOperations;
import static com.demo.Library_Management_System.AllOperations.adminInputs;
//import static com.demo.Library_Management_System.AllOperations.quizInputs;


public class MainOperation {

	static Scanner sc=new Scanner(System.in);

	public static void mainOps()       //method
	{
		System.out.println("	Welcome..!!!	\n");
		while(true) {
			System.out.println("Press 1: Admin Details\n"
					+ "Press 2: Categories Deatils \n"
					+ "Press 3: Show Leaderboad\n"
					+ "Press 4: Question Details \n"
					+ "Press 5: Quit\n");
			int input=sc.nextInt();

			switch(input)
			{
			case 1:
				AllOperations.adminOperations();
				System.out.println("=======================================");
				break;
			case 2:
				//AllOperations.categoriesOperations();
				System.out.println("=======================================");
				break;

			case 3:
				//AllOperations.leaderboardOperations();
				System.out.println("=======================================");
				break;

			case 4:
				//AllOperations.questionOperations();
				System.out.println("=======================================");
				break;

			case 5:
				System.out.println("Exiting the application.");
				System.exit(0);


			default:
				System.out.println("Invalid choice, please try again.");
			}
		}
	}

	public static void main(String[] args) 
	{
		mainOps();
	}
}

