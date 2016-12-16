import com.mycompany.librarydiary.BookLibrary;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class testBookLibrary {
    
    private final String testString = "Axcf123";
    //private BookLibrary booklibrary = new BookLibrary(testString,testString);
    private BookLibrary booklibrary;
    
    public testBookLibrary() {
    }
    
    @Before
    public void init() {
        this.booklibrary = new BookLibrary(testString,testString);
    }

    @Test
    public void testBooks(){
        assertEquals(testString, booklibrary.getPerson_ID());
        assertEquals(testString, booklibrary.getBook_ID());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
