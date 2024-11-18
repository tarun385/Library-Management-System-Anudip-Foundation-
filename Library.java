package libraryManagement;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books = new ArrayList<>();
    private List<Book> issuedBooks = new ArrayList<>();

    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

   
    public void issueBook(String bookId) throws Exception {
        Book bookToIssue = findBook(bookId, books);
        if (bookToIssue == null) {
            throw new Exception("Book with ID " + bookId + " not found in the library.");
        }
        books.remove(bookToIssue);
        issuedBooks.add(bookToIssue);
        System.out.println("Book issued: " + bookToIssue.getTitle());
    }

   
    public void returnBook(String bookId) throws Exception {
        Book bookToReturn = findBook(bookId, issuedBooks);
        if (bookToReturn == null) {
            throw new Exception("Book with ID " + bookId + " was not issued.");
        }
        issuedBooks.remove(bookToReturn);
        books.add(bookToReturn);
        System.out.println("Book returned: " + bookToReturn.getTitle());
    }

    
    public void displayAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }


    private Book findBook(String bookId, List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
}
