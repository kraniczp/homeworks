import com.mycompany.librarydiary.Books;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class testBook {
    private final String testString = "Axcf123";
    //private Books books = new Books(testString,testString,testString);
    private Books books;
    
    public testBook() {
    }
    
    @Before
    public void init() {
        this.books = new Books(testString,testString,testString);
    }

    @Test
    public void testBooks(){
        assertEquals(testString, books.getTitle());
        assertEquals(testString, books.getAuthor());
        assertEquals(testString, books.getType());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
