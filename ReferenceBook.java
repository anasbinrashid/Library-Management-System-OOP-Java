package assignment_1;

//Class representing a ReferenceBook, which extends the abstract class Book

public class ReferenceBook extends Book
{
	public ReferenceBook(int bid, String t, String a, String i, String g, int py, double blf) 
	{
		super(bid, t, a, i, g, py, blf);
	}

	public boolean extendable()
	{
		return false;						// ReferenceBook are non-extendable for loans
	}
	
	public double calculateloan(int duration)
	{
		return 0.0; 						// ReferenceBook cannot be loaned
	}
	
	public boolean isLoanavailable()
	{
		return !(isLoanstatus());
	}
}
