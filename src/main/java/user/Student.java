package user;

// Студент - может взять ограниченное количество книг
public class Student extends User {

    public Student(String name) {
        super(name, 2);  // Студент может взять максимум 2 книги
    }

    @Override
    public boolean canBorrowABook() {
        // Студент может брать книги, если не превысил лимит
        return booksBorrowed < maxBooks;
    }
}