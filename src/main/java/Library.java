import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public int countBooks() {
        return this.books.size();
    }

    public void addBook(Book newBook) {
        this.books.add(newBook);
    }

}