package command;

import library.Library;
import loan.Loan;

public class ReturnBookCommand implements Command {
    private Library library;
    private Loan loan;

    public ReturnBookCommand(Library library, Loan loan) {
        this.library = library;
        this.loan = loan;
    }

    @Override
    public void execute() {
        loan.setReturned(true);
        library.notifyObserver("Книга возвращена пользователем: " + loan.getUser().getName(), loan.getUser());
        loan.getUser().addAction("Книга возвращена пользователем: " + loan.getUser().getName());
    }
}