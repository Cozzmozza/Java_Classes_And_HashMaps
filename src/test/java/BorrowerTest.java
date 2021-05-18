import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Library library;
    private Book book;
    private Borrower borrower;

    @Before
    public void before(){
        library = new Library(3);
        book = new Book("The End Of Jeffville", "Jeff Jefferson", "Sci-fi");
        borrower = new Borrower();
    }

    @Test
    public void canCountBooks(){
        assertEquals(0, borrower.countBooks());
    }

    @Test
    public void canCheckoutBook(){
//        Add a new book to library
        library.addBook(book);
//        Get the borrower to check out the book
        borrower.checkoutBook(library, book);
//        Check the borrower has one new book in their ArrayList
        assertEquals(1, borrower.countBooks());
//        Check the library book count is 0
        assertEquals(0, library.countBooks());
    }

}
