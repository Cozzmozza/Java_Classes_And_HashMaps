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

    @Test
    public void canRemoveGenreEntryFromGenreHashMapWithTwoGenreCounts(){
        library.addGenre(newBook);
        library.addGenre(newBook);
        library.removeGenre(newBook);
        assertEquals(1, library.getGenreCount(newBook));
    }


//    The following test is failing, due to a NullPointerException, with our new count value being 0
    @Test
    public void canRemoveGenreEntryFromGenreHashMapWitOneGenreCount(){
        library.addGenre(newBook);
        library.removeGenre(newBook);
        assertEquals(true, library.checkRemoved(newBook));
//        We need to change this test, as it can't check for a genreCount for a null entry
    }
}
