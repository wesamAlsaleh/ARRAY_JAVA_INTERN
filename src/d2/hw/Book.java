package d2.hw;

import java.util.Objects;

public class Book {
    private int id;
    private String title;
    private String author;

    // default constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        // safety chack
        if (o == null || getClass() != o.getClass())
            return false; // must check if the this.class and the provided class are the same  `getClass != o.getClass()`

        // convert the object to the class object
        Book book = (Book) o;

        // compare each field with this.book and the provided book
        return id == book.id && Objects.equals(title, book.title) && Objects.equals(author, book.author);

        // @NOTE: without overriding the .equals, similar objects will not be the same because it will compare the locations instead of the objects itself
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author); // hash the fields and return the INTEGER of the current instance of the class

        // @NOTE: according to the .equals(), they must return the same hash code (different objects do not need to return different hash codes)
    }

    @Override
    public String toString() {
        return this.title +  " of " + this.author;
    }
}
