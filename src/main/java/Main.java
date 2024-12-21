import book.*;
import library.Library;
import loan.Loan;
import user.*;
import notifical.NotificationService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем библиотеку
        Library library = Library.getInstance();

        // Создаем книги
        EBook ebook = new EBook("Преступление и наказание", "Фёдор Достоевский", 2.0, "EPUB");
        PrintedBook printedBook = new PrintedBook("Война и мир", "Лев Толстой", "Полка Б1");
        Magazine magazine = new Magazine("Наука и жизнь", "Редакция журнала", 11, "Ноябрь 2024");
        EBook ebookWithMetadata = new EBook("Мастер и Маргарита", "Михаил Булгаков", 3.5, "PDF");

        // Добавляем книги в библиотеку
        library.addBook(ebook);
        library.addBook(printedBook);
        library.addBook(magazine);
        library.addBook(ebookWithMetadata);

        // Создаем пользователей
        User student = new Student("Студент: Иван Петров");
        User professor = new Professor("Преподаватель: Анна Иванова");
        User librarian = new Librarian("Библиотекарь: Сергей Николаевич");

        List<User> users = new ArrayList<>();
        users.add(student);
        users.add(professor);
        users.add(librarian);

        // Регистрируем пользователей в библиотеке
        library.userRegistration(student);
        library.userRegistration(professor);
        library.userRegistration(librarian);

        // Создаем систему уведомлений
        NotificationService notificationService = new NotificationService();

        // Подписываем пользователей на уведомления
        notificationService.addAFollower(student);
        notificationService.addAFollower(professor);
        notificationService.addAFollower(librarian);

        // Пользователи берут книги
        Loan studentLoan = library.issueABook(student, ebook);  // Студент берет книгу
        Loan professorLoan = library.issueABook(professor, printedBook);  // Профессор берет книгу
        Loan librarianLoan = library.issueABook(librarian, magazine);  // Библиотекарь берет журнал

        // Возврат книги
        library.returnBook(studentLoan);  // Студент возвращает книгу
        library.returnBook(professorLoan);  // Профессор возвращает книгу

        // Отправка уведомлений
        notificationService.notifyFollowers("*** Уведомление: книги должны быть возвращены вовремя! ***");

        // История событий пользователей
        users.forEach(user -> {
            // Выводим историю действий
            System.out.println("История действий пользователя " + user.getName() + ":");
            user.getActionHistory().getActions().forEach(System.out::println);

            // Сохраняем историю
            user.saveActionHistory();
        });
    }
}