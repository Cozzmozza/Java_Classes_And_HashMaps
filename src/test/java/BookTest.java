import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before(){
        book = new Book("The End Of Jeffville", "Jeff Jefferson", "Sci-fi");
    }

    @Test
    public void canGetGenre(){
        assertEquals("Sci-fi", book.getGenre());
    }

}
