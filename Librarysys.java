import java.util.Scanner;

// Class for User
class User {
   String username;
    String password;

    // Login details
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate user
    public boolean validate(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}

// Class for Book
class Book {
    String title;
    String author;
    int id;
    boolean isIssued;

    // Book details
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // Method to issue book
    public void issueBook() {
        if (!this.isIssued) {
            this.isIssued = true;
        }
    }

    // Method to return book
    public void returnBook() {
        this.isIssued = false;
    }
}

// Class for Library
class Library {
    // Array to hold books
    Book[] books;

    // Library details
    public Library(Book[] books) {
        this.books = books;
    }

    //Method to issue book
    public void issueBook(String title, String author) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equals(title) && books[i].author.equals(author)) {
                if (books[i].isIssued) {
                    System.out.println("Sorry, this book is already issued.");
                } else {
                    System.out.println("You've successfully issued the book.");
                    books[i].issueBook();
                }
                return;
            }
        }
        System.out.println("This book does not exist in our library.");
    }

    // Method to return book
    public void returnBook(String title, String author) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equals(title) && books[i].author.equals(author)) {
                books[i].returnBook();
                System.out.println("You've successfully returned the book.");
                return;
            }
        }
        System.out.println("This book does not exist in our library.");
    }
}

public class Librarysys {
    public static void main(String[] args) {
        // Create a user
        User user = new User("admin", "password");
    
        // Create books
        Book[] books = {new Book(1, "Book1", "Author1"), new Book(2, "Book2", "Author2")};
    
        // Create a library
        Library library = new Library(books);
    
        
        Scanner scanner = new Scanner(System.in);
    
        // Login interface
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
    
    if (user.validate(username, password)) {
        System.out.println("Login successful!");

        // Menu for library management
        while (true) {
            System.out.println("1. Issue book\n2. Return book\n3. Exit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.println("Enter the title of the book you want to issue:");
                    String title = scanner.nextLine();
                    System.out.println("Enter the author of the book you want to issue:");
                    String author = scanner.nextLine();
                    library.issueBook(title, author);
                    break;
                    case 2:
                    System.out.println("Enter the title of the book you want to return:");
                    title = scanner.nextLine();
                    System.out.println("Enter the author of the book you want to return:");
                    author = scanner.nextLine();
                    library.returnBook(title, author);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    } else {
        System.out.println("Login failed!");
    }

    scanner.close();
    }
}