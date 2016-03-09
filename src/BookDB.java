
public class BookDB {

	//Constructors
	public BookDB()
	{

	}
	//end Constructors

	//Getters
	public Book getBookFromSKU(String SKU)
	{
		Book foundBook;
		switch(SKU)
		{
		case "Java1001": foundBook = new Book("Java1001", "Head First Java", "Kathy Sierra and Bert Bates", "Easy to read Java workbook", 47.50, true);
		break;
		case "Java1002": foundBook = new Book("Java1002", "Thinking in Java", "Bruce Eckel", "Details about Java under the hood", 20.00, true);
		break;
		case "Orcl1003": foundBook = new Book("Orcl1003", "OCP: Oracle Certified Professional Java SE", "Jeanne Boyarsky", "Everything you need to know in one place", 45.00, true);
		break;
		case "Python1004": foundBook = new Book("Python1004", "Automate the Boring Stuff with Python", "Al Sweigart", "Fun with Python", 10.50, true);
		break;
		case "Zombie1005": foundBook = new Book("Zombie1005", "The Maker\'s Guide to the Zombie Apocalypse", "Simon Monk", "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50, true);
		break;
		case "Rasp1006": foundBook = new Book("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "Donald Norris", "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75, true);
		break;
		default: foundBook = new Book(SKU, "N/A", "N/A", "N/A", 0.00, false);
		break;
		}
		return foundBook;
	}
	//end Getters

	//Setters

	//end Setters

	//other methods
}
