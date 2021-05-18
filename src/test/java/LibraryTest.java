import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book newBook;

    @Before
    public void before(){
        library = new Library();
        newBook = new Book("The End Of Jeffville", "Jeff Jefferson", "Sci-fi");
    }

    @Test
    public void canCountBooks(){
        assertEquals(0, library.countBooks());
    }
    
    @Test
    public void canAddNewBook(){
        library.addBook(newBook);
        assertEquals(1, library.countBooks());
    }
}
