import java.util.ArrayList;
import java.util.HashMap;

public class Library {

//    ADVANCED EXTENSION:
    //    Use a hashmap to store the genre of each book as the key
    //    And a count of how many books of that genre as the value

//    HOW TO:
    //        1) Declare the HashMap and import - DONE
    //        2) TDD a method in Book class, to grab the genre (Since genre is private) - DONE
    //        3) In our addBook, we need to add the genre to the HashMap, and add 1 to the count - ALMOST DONE..
    //        4) We want to avoid duplicates in the HashMap, so need another conditional, if exists, add 1 to count, else add and add 1 to count


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
//            Grab the genre of the book
            String genre = newBook.getGenre();
//            if hashmap contains the key 'genre'
            if (genres.containsKey(genre)){
//                Grab the value of that key
                int value = genres.get(genre);
//                set the value to be value + 1
                int newValue = value + 1;
//                update the key with the new value
                genres.replace(genre, newValue);
            }
//            else if the key does not exist, make it, and set the count to 1
            else {
                genres.put(genre, 1);
            }
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
}