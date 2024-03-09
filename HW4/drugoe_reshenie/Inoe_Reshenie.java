package HW4.drugoe_reshenie;

public class Inoe_Reshenie {
    /**
     * Базовый класс "Банковский счет"
     */
    public abstract class BankAccount {

        /**
         * Текущий баланс счета в условных единицах
         */
        protected double balance;

        public BankAccount(double initialBalance) {
            // Защита состояния при первичной инициализации объекта счета
            if (initialBalance < 0) {
                throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
            }
            this.balance = initialBalance;
        }

        /**
         * Изменить текущий баланс счета
         * @param amount Сумма средств к зачислению
         */
        public void deposit(double amount) {
            // Защита состояния при изменении текущего баланса счета
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма депозита должна быть положительной");
            }
            balance += amount;
        }

        /**
         * Снятие средств
         * @param amount Сумма средств к снятию
         * @throws InsufficientFundsException Сумма снятия должна быть положительной/недостаточно средств на счете
         */
        public void withdraw(double amount) throws InsufficientFundsException {
            // Защита состояния при изменении текущего баланса счета
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма снятия должна быть положительной");
            }

            if (amount > balance) {
                throw new InsufficientFundsException("Недостаточно средств на счете", balance);
            }

            balance -= amount;
        }

        /**
         * Получить текущий баланс счета
         * @return Текущий баланс счета
         */
        public double getBalance() {
            return balance;
        }
    }
   // А вот и классы наследники, обратите внимание, я запрещаю вам снимать средства с кредитного счета:

    /**
     * Дебетовый счет
     */
    public class DebitAccount extends BankAccount {
        public DebitAccount(double initialBalance) {
            super(initialBalance);
        }

        @Override
        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма снятия должна быть положительной");
            }

            if (amount > balance) {
                throw new InsufficientFundsException("Недостаточно средств на счете", balance);
            }

            balance -= amount;
        }
    }

    /**
     * Кредитный счет
     */
    public class CreditAccount extends BankAccount {
        public CreditAccount(double initialBalance) {
            super(initialBalance);
        }

        /**
         * Для примера. Мы запрещаем снимать средства с кредитных счетов, вы можете только
         * внести новые средства для погашения кредита
         * @param amount сумма средств к снятию
         */
        @Override
        public void withdraw(double amount) {
            throw new IllegalArgumentException("Запрещено снимать средства с кредитного счета");
        }
    }
   // А вот и мой собственный простейших тип исключения:

    public class InsufficientFundsException extends Exception {
        private double balance;

        public InsufficientFundsException(String message, double balance) {
            super(message);
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }
    }
    //И, по итогу, я спроектировал класс транзакции для осуществления перевода средств с одного счета на другой:

    /**
     * Транзакция
     */
    public class Transaction {

        /**
         * Выполнить перевод средств между счетами
         * @param fromAccount Счет списания
         * @param toAccount Счет зачисления
         * @param amount Сумма перевода
         * @throws TransactionException Недостаточно средств на счете для проведения транзакции
         */
        public static void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) throws TransactionException {
            try {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println("Транзакция успешно завершена.");
            } catch (InsufficientFundsException e) {
                throw new TransactionException("Недостаточно средств на счете для проведения транзакции.", e);
            }
        }
    }
   // Как видите, максимально простой и лаконичный пример, не забуду описать тип исключения TransactionException:

    public class TransactionException extends Exception {
        public TransactionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
   // По итогу протестирую работу моего приложения:

    public static void main(String[] args) {
        try {

            // Создание счетов
            BankAccount creditAccount = new CreditAccount(1000);
            BankAccount debitAccount = new DebitAccount(500);

            // Проведение транзакции
            Transaction.transfer(debitAccount, creditAccount, 200);

            // Вывод баланса после транзакции
            System.out.println("Баланс кредитного счета: " + creditAccount.getBalance());
            System.out.println("Баланс дебетового счета: " + debitAccount.getBalance());

        } catch (TransactionException e) {
            System.out.println("Ошибка транзакции: " + e.getMessage());
        }
    }
}
