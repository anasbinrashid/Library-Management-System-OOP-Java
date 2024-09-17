package assignment_1;

// Class representing a Novel, which extends the abstract class Book

public class Novel extends Book
{
    public Novel(int bid, String t, String a, String i, String g, int py, double d) 
    {
        super(bid, t, a, i, g, py, d); 
    }
    
    public boolean extendable()
    {
        return false; 						// Novels are non-extendable for loans
    }

    public double calculateloan(int duration)
    {
        double loan = getBaseloanfee();
        return loan; 						// The loan fee is constant regardless of the loan duration
    }

	public boolean isLoanavailable() 
	{
		return !(isLoanstatus());
	}
}
