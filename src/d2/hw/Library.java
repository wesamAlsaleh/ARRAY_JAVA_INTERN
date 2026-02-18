package d2.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Library {
    private ArrayList<Book> books;
    private HashSet<Member> members;
    private HashMap<Member, ArrayList<Book>> borrowedBooks;
    private LinkedList<String> announcements;

    // default constructor
    public Library(ArrayList<Book> books, HashSet<Member> members) {
        this.books = books;
        this.members = members;
        this.borrowedBooks = new HashMap<>();
        this.announcements = new LinkedList<>();
    }

    // function to add books in the library
    public void addBook(Book book) {
        books.add(book);
    }

    // function to remove book
    public void removeBook(Book book) {
        books.remove(book);
    }

    // function to get all the books
    public ArrayList<Book> getBooks() {
        return books;
    }

    // function to add a member
    public void addMember(Member member) {
        members.add(member);
    }

    // function to remove member
    public void removeMember(Member member) {
        members.remove(member);
    }

    // function to assign book to a member
    public void assignBorrow(Member member, Book book) {
        if(borrowedBooks.containsKey(member)) {
            borrowedBooks.get(member).add(book);
        } else {
            borrowedBooks.put(member, new ArrayList<>());
            borrowedBooks.get(member).add(book);
        }
    }

    // function to cancel borrowing
    public void cancelBorrow(Member member, Book book) {
        borrowedBooks.get(member).remove(book);
    }

    // function to track member borrowed books
    public void trackBorrow(Member member) {
        borrowedBooks.get(member).forEach(System.out::println);
    }

    // function to add announcement
    public void addAnnouncement(String announcement) {
        announcements.add(announcement);
    }

    // function to remove announcement (FIFO)
    public void removeAnnouncement() {
        announcements.remove();
    }

    // function to remove announcement
    public void removeAnnouncement(String announcement) {
        announcements.remove(announcement);
    }

    // function to get the announcement
    public LinkedList<String> getAnnouncements() {
        // print the announcements
        announcements.forEach(System.out::println);

        // return the announcements queue
        return announcements;
    }
}
