import java.util.ArrayList;

public class Borrower {

//    A borrower can take a book from the Library, and move it to the Borrowers collection
//    A borrower needs an ArrayList
//    A borrow has no max capacity

    private ArrayList<Book> books;

    public Borrower(){
        books = new ArrayList<Book>();
    }

    public int countBooks() {
        return books.size();
    }

    public void checkoutBook(Library library, Book book) {
//        Pass in the library, and the book to check out
//        I did this instead of the remove by index method, since book are not all the same. We want a specific book removed
//        remove the book from the library
        library.removeBook(book);
//        Add the book to the borrowers booklist
        books.add(book);
    }
}
