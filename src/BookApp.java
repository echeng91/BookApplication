import java.util.Scanner;
import java.text.NumberFormat;

public class BookApp {

	public static void main(String[] args)
	{
		Book sample = new Book("Romance of the Three Kingdoms", 
				"Luo Guanzhong", 
				"The empire long divided must unite, long united must divide.", 
				36.99, true);
		sample.getDisplayText();
		
		Scanner sc = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.print("How many would you like to purchase?:\t");
		int copies;
		try
		{
			copies = sc.nextInt();
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Input. Will assume want to buy 0 books.");
			copies = 0;
		}
		finally
		{
			sc.close();
		}
		double paymentDue = sample.getPriceOfBooks(copies);
		System.out.println("You must pay " + currency.format(paymentDue));
	}
}
