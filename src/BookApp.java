
public class BookApp {

	public static void main(String[] args)
	{
		Book sample = new Book("Romance of the Three Kingdoms", 
				"Luo Guanzhong", 
				"The empire long divided must unite, long united must divide.", 
				36.99, true);
		sample.getDisplayText();
	}
}
