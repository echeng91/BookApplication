
public class Book {

	private String title;
	private String author;
	private String description;
	private double price;
	private boolean isInStock;
	
	//Constructors
	public Book()
	{
		
	}
	public Book(String title, String author, String description, double price, boolean inStock)
	{
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.isInStock = inStock;
	}
	public Book(String title, String author, String description, double price)
	{
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
	}
	public Book(String title, String author, String description)
	{
		this.title = title;
		this.author = author;
		this.description = description;
	}
	public Book(String title, String author)
	{
		this.title = title;
		this.author = author;
	}
	//end Constructors
	
	//Getters
	public String getTitle()
	{
		return this.title;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getDescription()
	{
		return this.description;
	}
	public double getPrice()
	{
		return this.price;
	}
	public boolean getIsInStock()
	{
		return this.isInStock;
	}
	
	//end Getters
	
	//Setters
	public void setTitle(String title)
	{
		this.title = title;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public void setIsInStock(boolean inStock)
	{
		this.isInStock = inStock;
	}
	//end Setters
	
	//other methods
	public void getDisplayText()
	{
		System.out.println("Author:\t\t" + author);
		System.out.println("Title:\t\t" + title);
		System.out.println("Description:\t" + description);
	}
	public double getPriceOfBooks(int copies)
	{
		double totalPrice;
		if(isInStock)
		{
			totalPrice = price * copies;
		}
		else
		{
			System.out.println(title + " by " + author + " is out of stock.");
			totalPrice = 0.00;
		}
		return totalPrice;
	}
}
