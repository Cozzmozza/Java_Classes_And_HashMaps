import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private int capacity;

    public Library(int capacity) {
        books = new ArrayList<Book>();
        this.capacity = capacity;
    }

    public int countBooks() {
        return this.books.size();
    }

    public void addBook(Book newBook) {
        int remainingCapacity = this.capacity - countBooks();
        if (remainingCapacity >= 1){
            this.books.add(newBook);
        }
    }

}