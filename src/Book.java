
public class Book {

	private String title;
	private String author;
	private String description;
	private double price;
	private boolean isInStock;
	private String SKU;
	
	//Constructors
	public Book()
	{
		
	}
	public Book(String title_, String author_, String description_, double price_, boolean isInStock_)
	{
		title = title_;
		author = author_;
		description = description_;
		price = price_;
		isInStock = isInStock_;
	}
	public Book(String title_, String author_, String description_, double price_)
	{
		title = title_;
		author = author_;
		description = description_;
		price = price_;
		isInStock = true;
	}
	public Book(String title_, String author_, String description_)
	{
		title = title_;
		author = author_;
		description = description_;
	}
	public Book(String title_, String author_)
	{
		title = title_;
		author = author_;
	}
	public Book(String SKU_, String title_, String author_, String description_, double price_, boolean isInStock_)
	{
		SKU = SKU_;
		title = title_;
		author = author_;
		description = description_;
		price = price_;
		isInStock = isInStock_;
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
	public String getSKU()
	{
		return SKU;
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
	public void setSKU(String SKU_)
	{
		SKU = SKU_;
	}
	//end Setters
	
	//other methods
	public String getDisplayText()
	{
		String displayText = "Author:\t\t" + author + "\nTitle:\t\t" + title + "\nDescription:\t" + description + "\nPrice:\t" + price + "\n";
		return displayText;
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
			//Book is out of stock, thus customer need not pay anything.
			totalPrice = 0.00;
		}
		return totalPrice;
	}
}
