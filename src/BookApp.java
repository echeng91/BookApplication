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
		dbBook.connect();
		System.out.print("Input SKU: ");
		String sku = sc.nextLine();
		Book searchBook = dbBook.getBookFromSKU(sku);
		if(searchBook.getIsInStock())
		{
			System.out.println(searchBook.getDisplayText());
		}
		else
		{
			System.out.println("No such book was found.");
		}

		/*
		//test using rotk
		Book sanguo = new Book("SANGUOYY", "Romance of the Three Kingdoms", 
				"Luo Guanzhong", 
				"The empire long divided must unite, long united must divide.", 
				36.99, true);
		dbBook.addBook(sanguo);
		searchBook = dbBook.getBookFromSKU("SANGUOYY");
		System.out.println(searchBook.getDisplayText());
		dbBook.updateBook("SANGUOYY", 39.99);
		searchBook = dbBook.getBookFromSKU("SANGUOYY");
		System.out.println(searchBook.getDisplayText());
		dbBook.deleteBook("SANGUOYY");
		searchBook = dbBook.getBookFromSKU("SANGUOYY");
		System.out.println(searchBook.getDisplayText());
		 */
		
		System.out.println("Input information of book to add.");
		System.out.print("SKU: ");
		sku = sc.nextLine();
		System.out.print("Title: ");
		String title = sc.nextLine();
		System.out.print("Author: ");
		String author = sc.nextLine();
		System.out.print("Description: ");
		String description = sc.nextLine();
		double price = 0;
		try {
			System.out.print("Price: $");
			price = sc.nextDouble();
			sc.nextLine();
		} catch (java.util.InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		dbBook.addBook(sku, title, author, description, price);
		
		System.out.println("Input SKU of book to change price of: ");
		sku = sc.nextLine();
		searchBook = dbBook.getBookFromSKU(sku);
		System.out.println("Current price of" + searchBook.getTitle() + ": $" + searchBook.getPrice());
		try {
			System.out.print("Input new price: $");
			price = sc.nextDouble();
			sc.nextLine();
			dbBook.updateBook(sku, price);
		} catch (java.util.InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Input SKU of book to delete: ");
		sku = sc.nextLine();
		dbBook.deleteBook(sku);

		dbBook.disconnect();
		sc.close();
	}
}
