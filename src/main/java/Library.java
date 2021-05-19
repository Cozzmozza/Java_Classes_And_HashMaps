import java.util.ArrayList;
import java.util.HashMap;

public class Library {

//    ADVANCED EXTENSION:
    //    Use a hashmap to store the genre of each book as the key
    //    And a count of how many books of that genre as the value

//    HOW TO:
    //        1) Declare the HashMap and import - DONE
    //        2) TDD a method in Book class, to grab the genre (Since genre is private) - DONE
    //        3) In our addBook, we need to add the genre to the HashMap, and add 1 to the count - DONE
    //        4) We need to avoid duplicates in the HashMap for the count so need another conditional, if exists, add 1 to count, else add and add 1 to count - DONE
    //        5) And do the opposite for removing a book


    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> genres;

    public Library(int capacity) {
        books = new ArrayList<Book>();
        this.capacity = capacity;
        this.genres = new HashMap<String, Integer>();
    }

    public int countBooks() {
        return this.books.size();
    }

    public void addBook(Book newBook) {
        int remainingCapacity = this.capacity - countBooks();
        if (remainingCapacity >= 1){
            this.books.add(newBook);
            addGenre(newBook);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

//    New function that will return the genre count, for a given book genre property
    public int getGenreCount(Book book) {
        String genre = book.getGenre();
        return genres.get(genre);
    }

    public void addGenre(Book newBook){
//        Grab the genre of the book
        String genre = newBook.getGenre();
//            if hashmap contains the key 'genre'
        if (genres.containsKey(genre)){
//                Grab the value of that key
            Integer value = genres.get(genre);
//                set the value to be value + 1
            Integer newValue = value + 1;
//                update the key with the new value
            genres.replace(genre, newValue);
        }
//            else if the key does not exist, make it, and set the count to 1
        else {
            Integer initialCount = 1;
            genres.put(genre, initialCount);
        }

    }

    public void removeGenre(Book book) {
        String genre = book.getGenre();
//        We are assuming the genre is in the genre list already, and we don't need to check if its there first
//        Grab the value of the genre key assuming it exists
        Integer value = genres.get(genre);
//        Remove one from the value
        Integer newValue = value - 1;
        System.out.println(newValue); // This is printing 0 okay...
//        if newValue = 0, no more genres in stock, remove the key value pair from the hashmap
        if (newValue == 0){
//            genres.remove(genre);
            genres.replace(genre, newValue);
        }
//        else just remove one from the genre stock by giving the genre the new value
        else {
            genres.replace(genre, newValue);
        }
    }
//    THIS is currently NOT working
//    It DOES work if newValue > 0, i.e. if we have 2 genres, and remove one of them
//    But if newValue is now equal to 0, it doesn't even get to the if statements before throwing an error
//    (We know it doesn't get to the if, because I changed the fn to return booleans at the conditionals, and it didn't return any during the test)
//    Error is 'NullPointerException'
//    I've then tried converting all 'int' in addGenre and removeGenre, to 'Integer', still same error
//    When the newValue is 0, this prints okay
//    Is it something to do with genres.remove(genre) afterall?
//    Is this just removing the value/setting it to null, then we are trying to read it, and its null?

//    YES! THAT'S IT WORKING..ish
        // So.... the test was getting a count from something that didn't exist. That was the error.
        // So the test really wants to check the entry doesn't exist in the count
}