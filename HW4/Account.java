package HW4;

import HW4.myException.IllegalArgumentException;
import HW4.myException.InsufficientFundsException;

import java.util.Scanner;

/**
 * Урок 4. Обработка исключений
 * 1. Создать программу управления банковским счетом (Account).
 * Программа должна позволять пользователю вводить начальный баланс счета,
 * сумму депозита и сумму снятия средств. При этом она должна обрабатывать
 * следующие исключительные ситуации:
 * Попытка создать счет с отрицательным начальным балансом должна вызывать
 * исключение IllegalArgumentException с соответствующим сообщением.
 * Попытка внести депозит с отрицательной суммой должна вызывать исключение
 * IllegalArgumentException с соответствующим сообщением.
 * Попытка снять средства, сумма которых превышает текущий баланс, должна
 * вызывать исключение InsufficientFundsException с сообщением о
 * недостаточных средствах и текущим балансом.
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции
 * try-catch, выводя соответствующие сообщения об ошибках.
 */

public class Account {
    private double balance;

    private double beginBalance;
    public int num;
    private double value;
    double valueOut;

    public Account() {

    }

    public Account(double balance, double beginBalance) {
        this.balance = balance;
        this.beginBalance = beginBalance;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод приветствия клиента
     */
    public void helloClient() {
        System.out.println();
        System.out.println("Здравствуйте. ");
        System.out.print("1. Ввести начальный баланс счета\n" +
                "2. Введите сумму депозита\n" +
                "3. Сумму для снятия средств\n" +
                "4. Выберите для выхода\n" +
                "Введите цифру нужной операции:");
        Scanner in = new Scanner(System.in);
        int numb = in.nextInt();
////        while (num != 4)
//        account.helloClient(num);
//        in.close();
        while (numb > 0 & numb < 5) {
            switch (numb) {
                case 1 -> initialAccountBalance(value);
                case 2 -> inputManyBalance();
                case 3 -> outMoneyBalance();
                case 4 -> exitProgram();
            }
        }

    }

    /**
     * Метод начального баланса счета
     */

    public double initialAccountBalance(double value) {
        System.out.println("Введите вашу сумму: ");
        try (Scanner in2 = new Scanner(System.in)) {
            value = (double) in2.nextInt();

            if (value < 0) {
                throw new IllegalArgumentException("Баланс не может быть отрицательным!!!");
            }
//
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
        this.balance = value;
        System.out.println("Деньги зачислены.");
        System.out.println("Ваш баланс: " + value);
        this.helloClient();
        return value;
    }



    /**
     * Метод снятия средств со счёта
     */
    public double outMoneyBalance() {
        System.out.println("Ваш баланс: " + balance);
        System.out.println("Введите сумму для снятия:");
        try (Scanner inOut = new Scanner(System.in)) {
            value = (double) inOut.nextInt();
            if (balance > value) {
                valueOut = balance - value;
                if (valueOut > 0) {
                    System.out.println("Операция успешно выполнена.");
                    System.out.println("Ваш баланс: " + valueOut);
                    this.balance = valueOut;
                } else throw new InsufficientFundsException("Недостаточно средств для вывода");
            }
        } catch (InsufficientFundsException e) {
            throw new RuntimeException(e);
        }
        this.helloClient();
        return balance;
    }


    /**
     * Метод ввода депозита на баланс
     */
    public double inputManyBalance() {
        System.out.println("Ваш Баланс равен: " + balance);
        System.out.println("Введите сумму депозита: ");
        try (Scanner inMany = new Scanner(System.in)) {


            double valueMany = (double) inMany.nextInt();
            if (valueMany > 0) {
                double many = getBalance() + valueMany;
                System.out.println("Ваш Баланс равен: " + many);
                this.balance = many;
            } else throw new IllegalArgumentException("некорректный ввод");
        } catch (IllegalArgumentException ex) {
                ex.getContext();
        }
        this.helloClient();
        return balance;
    }

    /**
     * Метод выхода из программы
     */
    public void exitProgram() {
        System.out.println("Всего доброго!!!");
        System.exit(1);
    }

}
