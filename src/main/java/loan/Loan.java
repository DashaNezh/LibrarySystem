package loan;

import user.User;
import book.Book;

import java.util.Date;

public class Loan {
    private User user;
    private Book book;

    private Date dueDate;
    private boolean isReturned;
    private LoanState currentState;

    public Loan(User user, Book book) {
        this.user = user;
        this.book = book;
        this.isReturned = false;
        this.currentState = new LoanIssued(); // начальное состояние
    }

    public void setState(LoanState state) {
        this.currentState = state;
    }

    public void returnBook() {
        currentState.handle(this);
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public LoanState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(LoanState currentState) {
        this.currentState = currentState;
    }
}

interface LoanState {
    void handle(Loan loan);
}

class LoanIssued implements LoanState {
    @Override
    public void handle(Loan loan) {
        loan.setReturned(true); // меняем состояние на возвращённое
        loan.setCurrentState(new LoanReturned());
        System.out.println("Книга возвращена. Состояние обновлено на 'Возвращено'.");
    }
}

class LoanOverdue implements LoanState {
    @Override
    public void handle(Loan loan) {
        // Логика для просроченной книги
        System.out.println("Книга просрочена. Пожалуйста, верните её как можно скорее.");
        loan.setCurrentState(new LoanReturned()); // Обновление состояния после возврата
    }
}

class LoanReturned implements LoanState {
    @Override
    public void handle(Loan loan) {
        System.out.println("Книга уже была возвращена. Никаких действий не требуется.");
    }
}
