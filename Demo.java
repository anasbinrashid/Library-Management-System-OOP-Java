package assignment_1;

import java.util.*;

// Main class for the library management system

public class Demo 
{
    public static void main(String[] args) 
    {    	
        Scanner sc = new Scanner(System.in);
        
        Library library = new Library();

        // Prepopulate the library with some books and users
        
        System.out.println("Prepopulating the Library!\n");

        Book novel = new Novel(1, "Great Expectations", "Charles Dickens", "ISBN1234", "Novel", 1970, 150.00); 
        Book textbook = new TextBook(2, "Physics", "Isaac Newton", "ISBN2345", "Education", 1880, 300.00);
        Book referencebook = new ReferenceBook(3, "Glossary", "William Shakespeare", "ISBN6789", "Reference", 1600, 250.00);
        User student = new Student(1, "Anas", "anas@nu.edu.pk", "03000000000", "Islamabad");
        User faculty = new Faculty(2, "Babar", "babar@nu.edu.pk", "03111111111", "Lahore");
        User publicmember = new PublicMember(3, "Shadab", "shadab@nu.edu.pk", "03222222222", "Rawalpindi");

        library.addbook(referencebook);
        library.addbook(textbook);
        library.addbook(novel);
        library.adduser(publicmember);
        library.adduser(faculty);
        library.adduser(student);

        int option;

        // Main loop to keep the program running until the user chooses to exit
        
        boolean loop = true;
        
        while (loop) 
        {
            // Display the main menu to the user
        	
            System.out.println("\n~~~ Library Management System ~~~");
            System.out.println("\n1. Add new book\n2. Display available books\n3. Remove a book\n4. Add new user\n5. Display user details\n6. Loan a book to a user\n7. Display loan details\n8. Return a book\n9. Exit");
            System.out.print("\nEnter your choice: ");

            option = sc.nextInt();

            // Add new book option
            
            if (option == 1) 
            {
                System.out.print("\nEnter the Type of Book\n\"1\" for TextBook, \"2\" for Novel, \"3\" for ReferenceBook: ");
                int ty = sc.nextInt();

                // Validate the input for book type
                
                while (ty > 3 || ty < 1) 
                {
                    System.out.print("Invalid Input! Enter again: ");
                    ty = sc.nextInt();
                }

                System.out.print("Enter Book ID: ");
                int bid = sc.nextInt();
                sc.nextLine(); 
                System.out.print("Enter Book Title: ");
                String t = sc.nextLine();
                System.out.print("Enter Book Author: ");
                String a = sc.nextLine();
                System.out.print("Enter Book ISBN: ");
                String i = sc.nextLine();
                System.out.print("Enter Book Publication Year: ");
                int py = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Book Genre: ");
                String g = sc.nextLine();
                System.out.print("Enter Base Loan Fee: ");
                double f = sc.nextDouble();

                Book nb;
                
                if (ty == 1) 
                {
                    nb = new TextBook(bid, t, a, i, g, py, f); 
                    library.addbook(nb);
                } 
                else if (ty == 2)
                {
                    nb = new Novel(bid, t, a, i, g, py, f); 
                    library.addbook(nb);
                } 
                else 
                {
                    nb = new ReferenceBook(bid, t, a, i, g, py, f); 
                    library.addbook(nb);
                }
            }
            
            // Display available books
            
            else if (option == 2) 
            {
                library.printbooks();
            }
            
            // Remove a book from the library
            
            else if (option == 3) 
            {
                System.out.print("\nEnter the ID of the book you want to remove: ");
                int bid = sc.nextInt();
                library.removebook(bid); 
            }
            
            // Add new user
            
            else if (option == 4) 
            {
                System.out.println("\nEnter the Type of User\n\"1\" for Student, \"2\" for Faculty, \"3\" for PublicMember");
                int ty = sc.nextInt();

                // Validate the input for user type
                
                while (ty > 3 || ty < 1) 
                {
                    System.out.println("Invalid Input!");
                    ty = sc.nextInt();
                }

                System.out.print("Enter User ID: ");
                int uid = sc.nextInt();
                sc.nextLine(); 
                System.out.print("Enter User Name: ");
                String n = sc.nextLine();
                System.out.print("Enter User Email: ");
                String e = sc.nextLine();
                System.out.print("Enter User Phone Number: ");
                String pn = sc.nextLine();
                System.out.print("Enter User Address: ");
                String a = sc.nextLine();

                User nu;
                
                if (ty == 1) 
                {
                    nu = new Student(uid, n, e, pn, a); 
                    library.adduser(nu);
                } 
                else if (ty == 2) 
                {
                    nu = new Faculty(uid, n, e, pn, a);
                    library.adduser(nu);
                } 
                else 
                {
                    nu = new PublicMember(uid, n, e, pn, a); 
                    library.adduser(nu);
                }
            }
            
            // Display user details
            
            else if (option == 5) 
            {
                library.printusers();
            }
            
            // Loan a book to a user
            
            else if (option == 6) 
            {
                int uid, bid, ld;
                
                System.out.print("\nEnter User ID: ");
                uid = sc.nextInt();
                System.out.print("Enter Book ID: ");
                bid = sc.nextInt();
                System.out.print("Enter the number of days you want to Loan the Book: ");
                ld = sc.nextInt();

                library.loanbook(uid, bid, ld);
            }
            
            // Display loan details of a user
            
            else if (option == 7) 
            {
                int uid;
                
                System.out.print("\nEnter User ID: ");
                
                uid = sc.nextInt();
                library.printloans(uid); // Display loan details for a user
            }
            
            // Return a book
            
            else if (option == 8)
            {
                System.out.print("\nEnter User ID: ");
                int uid = sc.nextInt();
                System.out.print("Enter Book ID: ");
                int bid = sc.nextInt();
                System.out.print("Enter Number of Days Late (if any): ");
                int dl = sc.nextInt();

                library.returnbook(uid, bid, dl);
            }
            
            // Exit the program
            
            else if (option == 9)
            {
                System.out.println("\nExiting the System!");
                break; 
            }
            
            // Handle invalid input
            
            else 
            {
                System.out.println("\nInvalid Input!");
            }
        }

        // Close the scanner

        sc.close();
    }
}
