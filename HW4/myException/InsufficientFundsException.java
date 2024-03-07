package HW4.myException;


/** Попытка снять средства, сумма которых превышает текущий
 * баланс, должна вызывать исключение InsufficientFundsException
 * с сообщением о недостаточных средствах и текущим балансом. */
public class InsufficientFundsException extends PersonException{
    public InsufficientFundsException(String message) {
        super(message);
    }

    @Override
    public String getContext() {
        return "Недостаточно средств на счёте для вывода";
    }
}
