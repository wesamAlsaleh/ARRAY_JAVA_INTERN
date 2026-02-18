package d2.hw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // library books
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(4, "The Catcher in the Rye", "J.D. Salinger"));
        books.add(new Book(5, "The Hobbit", "J.R.R. Tolkien"));
        books.add(new Book(6, "Fahrenheit 451", "Ray Bradbury"));
        books.add(new Book(7, "Brave New World", "Aldous Huxley"));
        books.add(new Book(8, "Moby Dick", "Herman Melville"));
        books.add(new Book(9, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(10, "The Old Man and the Sea", "Ernest Hemingway"));

        // library members
        HashSet<Member> members = new HashSet<>();
        members.add(new Member(1, "Alice Johnson"));
        members.add(new Member(2, "Bob Smith"));
        members.add(new Member(3, "Charlie Davis"));
        members.add(new Member(4, "Diana Prince"));
        members.add(new Member(5, "Ethan Hunt"));
        members.add(new Member(6, "Fiona Gallagher"));
        members.add(new Member(7, "George Miller"));
        members.add(new Member(8, "Hannah Abbott"));
        members.add(new Member(9, "Ian Wright"));
        members.add(new Member(10, "Julia Roberts"));
        members.add(new Member(11, "Kevin Hart"));
        members.add(new Member(12, "Laura Palmer"));
        members.add(new Member(13, "Mike Wazowski"));
        members.add(new Member(14, "Nina Simone"));
        members.add(new Member(15, "Oscar Isaac"));

        // create a books system
        var library = new Library(books, members);

        // test member 1
        library.assignBorrow(new Member(15, "Oscar Isaac"), books.get(0));
        library.assignBorrow(new Member(15, "Oscar Isaac"), books.get(1));
        library.trackBorrow(new Member(15, "Oscar Isaac"));

        System.out.println(" ");

        // test member 2
        library.assignBorrow(new Member(5, "Ethan Hunt"), books.get(6));
        library.assignBorrow(new Member(5, "Ethan Hunt"), books.get(7));
        library.trackBorrow(new Member(5, "Ethan Hunt"));

        System.out.println(" ");

        library.addAnnouncement("This is announcement one");

        library.addBook(new Book(16, "The Da Vinci Code", "Dan Brown"));

        library.addAnnouncement("This is announcement two, new book added to the system");

        library.getAnnouncements(); // will print them

        var booksInTheSystem = library.getBooks();
        System.out.println(booksInTheSystem);

        System.out.println(" ");

        library.removeAnnouncement();

        library.getAnnouncements(); // will print them

        library.removeAnnouncement("This is announcement two, new book added to the system");

        System.out.print("after deleting: ");
        library.getAnnouncements(); // will print them

        System.out.println(" ");

        System.out.println("delete a book: ");
        library.cancelBorrow(new Member(5, "Ethan Hunt"), books.get(7));
        library.trackBorrow(new Member(5, "Ethan Hunt"));

    }
}
