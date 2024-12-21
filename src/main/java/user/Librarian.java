package user;

// Библиотекарь - может брать неограниченное количество книг
public class Librarian extends User {

    public Librarian(String name) {
        super(name, Integer.MAX_VALUE);  // Библиотекарь может брать любое количество книг
    }

    @Override
    public boolean canBorrowABook() {
        return true;  // Библиотекарь всегда может брать книгу
    }
}