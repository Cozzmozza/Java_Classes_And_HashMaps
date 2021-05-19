import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book newBook;

    @Before
    public void before(){
        library = new Library(3);
        newBook = new Book("The End Of Jeffville", "Jeff Jefferson", "Sci-fi");
    }

    @Test
    public void canCountBooks(){
        assertEquals(0, library.countBooks());
    }

    @Test
    public void canAddBook(){
        library.addBook(newBook);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void cannotAddBookIfStockIsFull(){
        library.addBook(newBook);
        library.addBook(newBook);
        library.addBook(newBook);
        library.addBook(newBook);
        assertEquals(3, library.countBooks());
    }

    @Test
    public void canRemoveBook(){
        library.addBook(newBook);
        library.removeBook(newBook);
        assertEquals(0, library.countBooks());
    }

    @Test
    public void canAddGenreEntryToGenreHashMap(){
        library.addGenre(newBook);
        assertEquals(1, library.getGenreCount(newBook));
    }

    @Test
    public void addNewBookCallsAddGenreMethod(){
        library.addBook(newBook);
        assertEquals(1, library.getGenreCount(newBook));
    }


//    The following test is failing. The addGenre is fine, but removeGenre is not working
    @Test
    public void canRemoveGenreEntryFromGenreHashMap(){
        library.addGenre(newBook);
        library.addGenre(newBook);
        library.removeGenre(newBook);
        assertEquals(1, library.getGenreCount(newBook));
//        Changed the method temporarily to return a boolean depending on outcome, for debugging only
//        assertEquals(true, library.removeGenre(newBook));
    }
}
