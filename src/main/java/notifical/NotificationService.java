package notifical;

import user.User;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<Observer> followers = new ArrayList<>();

    // Метод для подписки пользователя на уведомления
    public void addAFollower(User user) {
        followers.add(user);
    }

    // Метод для отписки пользователя
    public void removeAFollower(User user) {
        followers.remove(user);
    }

    public static void notifyFollowersAboutThis(String message, Observer observer){
        observer.update(message);
    }

    // Метод для отправки уведомлений
    public void notifyFollowers(String message) {
        for (Observer subscriber : followers) {
            // Отправляем уведомление всем подписчикам
            subscriber.update(message);
        }
    }
}