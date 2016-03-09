import java.util.Scanner;
import java.text.NumberFormat;

public class BookApp {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		/*
		//Create Book Class and App
		Book sample = new Book("Romance of the Three Kingdoms", 
				"Luo Guanzhong", 
				"The empire long divided must unite, long united must divide.", 
				36.99, true);
		System.out.println(sample.getDisplayText());
		
		//Add a method to Book Class
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
		double paymentDue = sample.getPriceOfBooks(copies);
		System.out.println("You must pay " + currency.format(paymentDue));
		*/
		
		//Create a Book Database
		BookDB dbBook = new BookDB();
		System.out.print("Input SKU: ");
		String SKU = sc.nextLine();
		Book searchBook = dbBook.getBookFromSKU(SKU);
		if(searchBook.getIsInStock())
		{
			System.out.println(searchBook.getDisplayText());
		}
		else
		{
			System.out.println("No such book was found.");
		}
		sc.close();
	}
}
