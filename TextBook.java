package assignment_1;

//Class representing a TextBook, which extends the abstract class Book

public class TextBook extends Book
{
	public TextBook(int bid, String t, String a, String i, String g, int py, double d) 
	{
		super(bid, t, a, i, g, py, d);
	}
	
	public boolean extendable()
	{
		return true;						// TextBooks are extendable for loans
	}
	
	public double calculateloan(int duration)
	{
		double loan = getBaseloanfee() + (duration * 2);
		return loan; 						// The loan fee is based on duration
	}
	
	public boolean isLoanavailable()
	{
		return !(isLoanstatus());
	}
}
