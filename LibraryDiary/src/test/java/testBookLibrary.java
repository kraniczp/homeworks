import com.mycompany.librarydiary.BookLibrary;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class testBookLibrary {
    private final String testString = "Axcf123";
    private BookLibrary booklibrary;
    
    public testBookLibrary() {
    }
    
    @Before
    public void init() {
        this.booklibrary = new BookLibrary(testString,testString);
    }

    @Test
    public void testBooks(){
        assertEquals(testString, booklibrary.getrentTicket());
        assertEquals(testString, booklibrary.getbookID());
    }
}

