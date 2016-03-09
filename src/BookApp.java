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
		Book[] books = {new Book("Java1001", "Head First Java", "Kathy Sierra and Bert Bates", "Easy to read Java workbook", 47.50, true),
				new Book("Java1002", "Thinking in Java", "Bruce Eckel", "Details about Java under the hood", 20.00, true),
				new Book("Orcl1003", "OCP: Oracle Certified Professional Java SE", "Jeanne Boyarsky", "Everything you need to know in one place", 45.00, true),
				new Book("Python1004", "Automate the Boring Stuff with Python", "Al Sweigart", "Fun with Python", 10.50, true),
				new Book("Zombie1005", "The Maker\'s Guide to the Zombie Apocalypse", "Simon Monk", "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50, true),
				new Book("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "Donald Norris", "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75, true)};
		BookDB dbBook = new BookDB(books);
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
