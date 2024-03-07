package HW4.myException;


/** Попытка создать счет с отрицательным начальным балансом
 *  должна вызывать исключение IllegalArgumentException с
 *  соответствующим сообщением */
public class IllegalArgumentException  extends PersonException{

    public IllegalArgumentException(String message) {
        super(message);

    }

    @Override
    public String getContext() {
        return "Некорректное значение начального баланса";
    }
}
