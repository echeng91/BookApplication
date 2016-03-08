
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
	public Book(String title_, String author_, String description_, double price_, boolean isInStock_)
	{
		this.title = title_;
		this.author = author_;
		this.description = description_;
		this.price = price_;
		this.isInStock = isInStock_;
	}
	public Book(String title_, String author_, String description_, double price_)
	{
		this.title = title_;
		this.author = author_;
		this.description = description_;
		this.price = price_;
	}
	public Book(String title_, String author_, String description_)
	{
		this.title = title_;
		this.author = author_;
		this.description = description_;
	}
	public Book(String title_, String author_)
	{
		this.title = title_;
		this.author = author_;
	}
	//end Constructors
	
	//Getters
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}
	public String getDescription()
	{
		return description;
	}
	public double getPrice()
	{
		return price;
	}
	public boolean getIsInStock()
	{
		return isInStock;
	}
	
	//end Getters
	
	//Setters
	public void setTitle(String title_)
	{
		title = title_;
	}
	public void setAuthor(String author_)
	{
		author = author_;
	}
	public void setDescription(String description_)
	{
		description = description_;
	}
	public void setPrice(double price_)
	{
		price = price_;
	}
	public void setIsInStock(boolean isInStock_)
	{
		isInStock = isInStock_;
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
