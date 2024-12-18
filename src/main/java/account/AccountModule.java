package account;

public interface AccountModule {
    void authenticate();
    void authorize();
}

class RealAccountModule implements AccountModule {
    @Override
    public void authenticate() {
        // Реализация аутентификации пользователя
        System.out.println("Аутентификация пользователя через базу данных...");
        // Пример проверки пользователя
        boolean isAuthenticated = true; // Имитация успешной аутентификации
        if (isAuthenticated) {
            System.out.println("Пользователь успешно аутентифицирован.");
        } else {
            System.out.println("Ошибка аутентификации.");
        }
    }

    @Override
    public void authorize() {
        // Реализация авторизации пользователя
        System.out.println("Авторизация ролей и прав пользователя...");
        // Пример проверки прав доступа (логика может быть сложнее)
        boolean isAuthorized = true; // Имитация успешной авторизации
        if (isAuthorized) {
            System.out.println("Пользователь успешно авторизован.");
        } else {
            System.out.println("Ошибка авторизации.");
        }
    }
}

class AccountModuleProxy implements AccountModule {
    private RealAccountModule realAccountModule;

    @Override
    public void authenticate() {
        System.out.println("Прокси: Проверка прав доступа перед аутентификацией...");
        if (realAccountModule == null) {
            realAccountModule = new RealAccountModule();
        }
        // Дополнительная проверка
        if (hasAccess()) {
            realAccountModule.authenticate();
        } else {
            System.out.println("Прокси: Доступ к аутентификации запрещён.");
        }
    }

    @Override
    public void authorize() {
        System.out.println("Прокси: Проверка прав доступа перед авторизацией...");
        if (realAccountModule == null) {
            realAccountModule = new RealAccountModule();
        }
        // Дополнительная проверка
        if (hasAccess()) {
            realAccountModule.authorize();
        } else {
            System.out.println("Прокси: Доступ к авторизации запрещён.");
        }
    }

    private boolean hasAccess() {
        // Пример проверки прав доступа (логика может быть сложной)
        System.out.println("Прокси: Проверка прав доступа пользователя...");
        return true; // Имитация успешной проверки прав
    }
}
