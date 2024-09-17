package assignment_1;

import java.util.*;

// Class to manage the Library

public class Library 
{
	private List<Book> books;
	private List<User> users;
	private static int totalBooks;  
	private static int totalUsers;  
	
	public Library()
	{
		books = new ArrayList<> ();   
		users = new ArrayList<> ();   
		totalBooks = 0;
		totalUsers = 0;
	}
	
	// Method to add a new book to the library
	
	public void addbook(Book b)
	{
		// Check if the book already exists by comparing the book ID
		
		for(Book j : books)
		{
			if(j.getBookid() == b.getBookid())
			{
				System.out.println("The book already exists!"); 
				return;
			}
		}
		
		// If the book doesn't exist, add it to the list
		
		books.add(b);
		totalBooks++;   
		
        System.out.println("Book " + b.getTitle() + " has been added to the Library successfully!");
	}
	
	// Method to remove a book from the library by its ID
	
	public void removebook(int bid)
	{
		boolean removal = false;  
		
		// Search for the book in the list
		
		for (Book b : books)
		{
			if (b.getBookid() == bid)
			{
				removal = true;
				
				// Check if the book is currently loaned out
				
				if (!b.isLoanstatus()) 
				{
					// Book is not loaned, remove it from the library
					
					books.remove(b);
					totalBooks--;
		        }
				else
				{
					System.out.println("The book is loaned out!");  
				}
				
				break; 
			}
		}		
		
		// If the removal flag is false, the book does not exist
		
		if(removal == false)
		{
			System.out.println("The book does not exist in this Library!");
		}
	}
	
	// Method to print all available (not loaned) books in the library
	
	public void printbooks() 
	{
        System.out.println("\nBooks in the Library:\n");
        
        for (Book b : books) 
        {
            if (!b.isLoanstatus()) 
            {
                System.out.println("Book ID: " + b.getBookid() + ", Book Title: " + b.getTitle() + ", Book Author: " + b.getAuthor());
            }
        }
        
        System.out.println("\nBooks that are currently loaned out:\n");
        
        int count = 0;
        
        for (Book b : books) 
        {
            if (b.isLoanstatus()) 
            {
                System.out.println("Book ID: " + b.getBookid() + ", Book Title: " + b.getTitle() + ", Book Author: " + b.getAuthor());
                count++;
            }
        }
        
        if(count == 0)
        {
        	System.out.println("No books currently loaned out!");
        }
    }
	
	// Method to add a new user to the library
	
	public void adduser(User u) 
	{
        // Check if the user already exists by comparing the user ID
		
        for(User j : users)
		{
			if(j.getUserid() == u.getUserid())
			{
				System.out.println("The user already exists!");  
				return;
			}
		}
		
        // If the user doesn't exist, add them to the list
        
        users.add(u);
        totalUsers++; 
        
        System.out.println("User " + u.getName() + " has been added to the Library successfully!");    
    }

    // Method to print the details of all users in the library
	
    public void printusers() 
	{
	    System.out.println("\nLibrary Users: \n");
	    
	    // Loop through the users and display their details
	    
	    for (User u : users) 
	    {
	        System.out.println("User ID: " + u.getUserid() + ", User Name: " + u.getName() + ", User Email Address: " + u.getEmail());
	    }
	}

	// Method to loan a book to a user
    
	public void loanbook(int uid, int bid, int loand)
    {
    	User u = null;  
    	
    	// Search for the user by their ID
    	
    	for (User user : users) 
    	{
            if (user.getUserid() == uid) 
            {
                u = user;  
            }
        }
    	
    	// If the user doesn't exist, display an error and exit the method
    	
    	if(u == null)
    	{
    		System.out.println("The User does not exist!");
    		
    		return;
    	}
    	
    	Book b = null;  
    	
    	// Search for the book by its ID
    	
    	for (Book book : books) 
    	{
            if (book.getBookid() == bid) 
            {
                b = book;  
            }
        }
    	
    	// If the book doesn't exist, display an error and exit the method
    	
    	if(b == null)
    	{
    		System.out.println("The Book does not exist!");
    		return;
    	}
    	
    	// If the book is not currently loaned
    	
    	if (!(b.isLoanstatus())) 
    	{
            // Check if the user is under their loan limit
    		
    		int currentlyloaned = u.getLoanedbooks().size();
    		
            if (u.getLoanlimit() > currentlyloaned) 
            {
                // Calculate the loan fee based on the loan duration
            	
                double f = b.calculateloan(loand);
                
                // Apply special fee calculation for PublicMember users
                
                if (u instanceof PublicMember) 
                {
                    f = (f * ((PublicMember) u).getBasefee());
                }
                
                // Set the book's loan status to true and loan the book to the user
                
                b.setLoanstatus(true);
                u.loanbook(b, f);
                
                System.out.println("Book '" + b.getTitle() + "' has been loaned to " + u.getName());
                System.out.println("Total loan fee: $" + f);
            } 
            else 
            {
                // User has reached their loan limit
            	
                System.out.println(u.getName() + " has already reached the loan limit.");
            }
        } 
    	else 
    	{
            System.out.println("Book is already loaned out!");  
        }
    }
    
    // Method to print all loans for a specific user
	
    public void printloans(int uid)
    {
    	User u = null;  
    	
    	// Search for the user by their ID
    	
    	for (User user : users) 
    	{
            if (user.getUserid() == uid) 
            {
                u = user; 
            }
        }        
    	
    	// If the user doesn't exist, display an error
    	
    	if(u == null)
    	{
    		System.out.println("The User does not exist!");
    		return;
    	}
    	else
    	{
            System.out.println("\nLoan Details for " + u.getName() + ":");
            u.displayloanedbooks();  
            System.out.println("Total Loan Fees: $" + u.getTotalloanfee());  
        }
    }
    
    // Method to return a loaned book to the library
    
    public void returnbook(int uid, int bid, int dl) 
    {
    	User u = null;  
    	
    	// Search for the user by their ID
    	
    	for (User user : users) 
    	{
            if (user.getUserid() == uid) 
            {
                u = user; 
            }
        }
    	
    	// If the user doesn't exist, display an error and exit the method
    	
    	if(u == null)
    	{
    		System.out.println("The User does not exist!");
    		return;
    	}
    	
    	Book b = null; 
    	
    	// Search for the book by its ID
    	
    	for (Book book : books) 
    	{
            if (book.getBookid() == bid) 
            {
                b = book; 
            }
        }
    	
    	// If the book doesn't exist, display an error and exit the method
    	
    	if(b == null)
    	{
    		System.out.println("The Book does not exist!");
    		return;
    	}

        // If the book is currently loaned
    	
        if (b.isLoanstatus()) 
        {
        	// Set the book's loan status to false and return it
        	
        	b.setLoanstatus(false);
            u.returnbook(b);
            
            // If the book is returned late, calculate the late fee
            
            if (dl > 0) 
            {
                double f = dl * 10.00; 
                u.setTotalloanfee(u.getTotalloanfee() + f);
                System.out.println("Late fee for returning book '" + b.getTitle() + "': $" + f);
            }
            
            System.out.println("Book '" + b.getTitle() + "' has been returned by " + u.getName());
        } 
        else 
        {
            System.out.println("Book is not currently loaned!"); 
        }
    }
}
