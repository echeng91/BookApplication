
public class BookDB {

	private Book[] books;

	//Constructors
	public BookDB()
	{

	}
	public BookDB(Book[] books_)
	{
		books = books_;
	}
	//end Constructors

	//Getters
	public Book[] getBooks()
	{
		return books;
	}
	public Book getBookFromSKU(String SKU)
	{
		Book foundBook = new Book();
		foundBook.setSKU(SKU);
		for(int i = 0; i < books.length; i++)
		{
			if(books[i].getSKU().equals(SKU))
			{
				foundBook.setTitle(books[i].getTitle());
				foundBook.setAuthor(books[i].getAuthor());
				foundBook.setDescription(books[i].getDescription());
				foundBook.setPrice(books[i].getPrice());
				foundBook.setIsInStock(books[i].getIsInStock());
				break;
			}
		}
		return foundBook;
	}
	//end Getters

	//Setters
	public void setBooks(Book[] books_)
	{
		books = books_;
	}
	//end Setters

	//other methods
	/*
	 * adds one book and its SKU to database
	 */
	public void addBook(Book newBook)
	{
		Book[] tempBooks = new Book[books.length + 1];

		int counter = 0;
		try
		{
			while(counter < books.length)
			{
				tempBooks[counter] = books[counter];
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			//every book object should have a corresponding SKU
		}
	}
}
