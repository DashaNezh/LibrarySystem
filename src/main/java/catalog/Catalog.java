package catalog;

import book.Book;

public class Catalog {

    // Метод Factory для создания различных критериев поиска книг
    public SearchCriteria createSearchCriteria(String type, Object value) {
        switch (type) {
            case "author":
                if (value instanceof String) {
                    return new AuthorSearchCriteria((String) value);
                } else {
                    throw new IllegalArgumentException("Expected a String for author criteria.");
                }
            case "title":
                if (value instanceof String) {
                    return new TitleSearchCriteria((String) value);
                } else {
                    throw new IllegalArgumentException("Expected a String for title criteria.");
                }
            case "year":
                if (value instanceof Integer) {
                    return new YearSearchCriteria((Integer) value);
                } else {
                    throw new IllegalArgumentException("Expected an Integer for year criteria.");
                }
            default:
                throw new IllegalArgumentException("Invalid search type: " + type);
        }
    }

    // Интерфейс для критериев поиска
    public interface SearchCriteria {
        boolean match(Book book);
    }

    class AuthorSearchCriteria implements SearchCriteria {
        private String author;

        public AuthorSearchCriteria(String author) {
            this.author = author;
        }

        @Override
        public boolean match(Book book) {
            return book.getAuthor() != null && book.getAuthor().equalsIgnoreCase(author);
        }
    }

    class TitleSearchCriteria implements SearchCriteria {
        private String title;

        public TitleSearchCriteria(String title) {
            this.title = title;
        }

        @Override
        public boolean match(Book book) {
            return book.getTitle() != null && book.getTitle().equalsIgnoreCase(title);
        }
    }

    class YearSearchCriteria implements SearchCriteria {
        private int year;

        public YearSearchCriteria(int year) {
            this.year = year;
        }

        @Override
        public boolean match(Book book) {
            return book.getYear() == year;
        }
    }
}
