package report;

import book.Book;
import loan.Loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Интерфейс для стратегии формирования отчетов
public interface ReportStrategy {
    void generateReport(List<Loan> loans);
}

// Реализация отчета по популярности
class PopularityReport implements ReportStrategy {
    @Override
    public void generateReport(List<Loan> loans) {
        System.out.println("Генерация отчёта по популярности...");
        Map<Book, Integer> bookPopularity = new HashMap<>();

        for (Loan loan : loans) {
            Book book = loan.getBook();
            bookPopularity.put(book, bookPopularity.getOrDefault(book, 0) + 1);
        }

        bookPopularity.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey().getTitle() + ": " + entry.getValue() + " заимов"));
    }
}

// Реализация отчета по дате
class DateReport implements ReportStrategy {
    @Override
    public void generateReport(List<Loan> loans) {
        System.out.println("Генерация отчёта по датам...");
        loans.stream()
                .sorted((l1, l2) -> l1.getDueDate().compareTo(l2.getDueDate()))
                .forEach(loan -> System.out.println(
                        "Книга: " + loan.getBook().getTitle() + ", Дата выдачи: " + loan.getDueDate()));
    }
}

// Класс для использования стратегии
class Report {
    private ReportStrategy reportStrategy;

    public void setReportStrategy(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    public void generateReport(List<Loan> loans) {
        if (reportStrategy != null) {
            reportStrategy.generateReport(loans);
        } else {
            System.out.println("Стратегия для отчёта не задана.");
        }
    }
}
