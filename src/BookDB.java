import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDB {

	private static Connection con = null;

	//Constructors
	public BookDB()
	{

	}
	//end Constructors

	//Getters
	public Book getBookFromSKU(String SKU)
	{
		Book foundBook = new Book();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from books where sku = \'" + SKU + "\'";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				foundBook = new Book(rs.getString("title"), rs.getString("author"), rs.getString("description"), rs.getDouble("price"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return foundBook;
	}
	//end Getters

	//Setters

	//end Setters

	//other methods
	public int addBook(Book newBook)
	{
		int count = 0;
		try{
			PreparedStatement pstmt = con.prepareStatement("insert into books (sku, title, author, description, price) values(?, ?, ?, ?, ?)");
			pstmt.setString(1, newBook.getSKU());
			pstmt.setString(2, newBook.getTitle());
			pstmt.setString(3, newBook.getAuthor());
			pstmt.setString(4, newBook.getDescription());
			pstmt.setDouble(5, newBook.getPrice());
			count = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int addBook(String SKU, String title, String author, String description, double price)
	{
		int count = 0;
		try{
			PreparedStatement pstmt = con.prepareStatement("insert into books (sku, title, author, description, price) values(?, ?, ?, ?, ?)");
			pstmt.setString(1, SKU);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, description);
			pstmt.setDouble(5, price);
			count = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateBook(String SKU, double price)
	{
		int count = 0;
		try{
			PreparedStatement pstmt = con.prepareStatement("update books set price = ? where sku = ?");
			pstmt.setDouble(1, price);
			pstmt.setString(2, SKU);
			count = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteBook(String SKU)
	{
		int count = 0;
		try{
			PreparedStatement pstmt = con.prepareStatement("delete from books where sku = ?");
			pstmt.setString(1, SKU);
			count = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void connect()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void disconnect()
	{
		try {
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public int updateThreeBookTransaction(String sku1, String sku2, String sku3, double price1, double price2, double price3)
	{
		int count = 0;
		try{
			con.setAutoCommit(false);
			PreparedStatement update1 = con.prepareStatement("update books set price = ? where sku = ?");
			update1.setDouble(1, price1);
			update1.setString(2, sku1);
			count = update1.executeUpdate();
			PreparedStatement update2 = con.prepareStatement("update books set price = ? where sku = ?");
			update2.setDouble(1, price2);
			update2.setString(2, sku2);
			count = update2.executeUpdate();
			PreparedStatement update3 = con.prepareStatement("update books set price = ? where sku = ?");
			update3.setDouble(1, price3);
			update3.setString(2, sku3);
			count = update3.executeUpdate();
			con.commit();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
