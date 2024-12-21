package history;

import java.util.ArrayList;
import java.util.List;

public class ActionHistory {
    private final List<String> actions = new ArrayList<>();
    private final List<HistoryMemento> historySnapshots = new ArrayList<>();

    // Добавление действия в историю
    public void addAction(String action) {
        actions.add(action);
        System.out.println("Действие добавлено: " + action);
    }

    // Получение всей истории
    public List<String> getActions() {
        System.out.println("**ИСТОРИЯ ДЕЙСТВИЙ**");
        return actions; // Защита от модификации
    }

    // Создание снапшота текущего состояния (Memento)
    public HistoryMemento saveTheState() {
        HistoryMemento memento = new HistoryMemento(new ArrayList<>(actions));
        historySnapshots.add(memento);
        System.out.println("Состояние сохранено с количеством действий: " + actions.size());
        return memento;
    }

    // Восстановление состояния из снапшота
    public void restoreTheState(HistoryMemento memento) {
        if (memento != null) {
            actions.clear();
            actions.addAll(memento.getSavedActions());
            System.out.println("Состояние восстановлено с количеством действий: " + actions.size());
        }
    }

    // Вложенный класс Memento для сохранения состояния
    public static class HistoryMemento {
        private final List<String> savedActions;

        public HistoryMemento(List<String> actions) {
            this.savedActions = actions;
        }

        private List<String> getSavedActions() {
            return savedActions;
        }
    }
}
