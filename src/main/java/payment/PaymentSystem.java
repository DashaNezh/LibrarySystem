package payment;

public interface PaymentSystem {
    void thePaymentProcess(double amount);
}

class OnlinePayment implements PaymentSystem {
    @Override
    public void thePaymentProcess(double amount) {
        // Реализация для онлайн-платежей
        System.out.println("Обработка онлайн-платежа на сумму " + amount);
        // Пример логики обработки платежа
        if (amount > 0) {
            System.out.println("Онлайн-платёж на сумму " + amount + " успешно обработан.");
        } else {
            System.out.println("Некорректная сумма для онлайн-платежа.");
        }
    }
}

class TerminalPayment implements PaymentSystem {
    @Override
    public void thePaymentProcess(double amount) {
        // Реализация для терминальных платежей
        System.out.println("Обработка терминального платежа на сумму " + amount);
        // Пример логики обработки платежа
        if (amount > 0) {
            System.out.println("Терминальный платёж на сумму " + amount + " успешно обработан.");
        } else {
            System.out.println("Некорректная сумма для терминального платежа.");
        }
    }
}

class PaymentAdapter {
    private PaymentSystem paymentSystem;

    public PaymentAdapter(String type) {
        if (type.equalsIgnoreCase("online")) {
            this.paymentSystem = new OnlinePayment();
        } else if (type.equalsIgnoreCase("terminal")) {
            this.paymentSystem = new TerminalPayment();
        } else {
            throw new IllegalArgumentException("Неподдерживаемый тип платежа: " + type);
        }
    }

    public void pay(double amount) {
        if (paymentSystem != null) {
            paymentSystem.thePaymentProcess(amount);
        } else {
            System.out.println("Платёжная система не доступна.");
        }
    }
}
