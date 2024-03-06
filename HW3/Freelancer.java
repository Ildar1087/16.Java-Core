package HW3;

/**
 * Для «повременщиков» формула для расчета такова:
 * «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»
 */
public class Freelancer extends BaseClass implements Workman {
    Freelancer flr;

    double salary;


    public Freelancer(String name, String lastName, int age, double position) {
        super(name, lastName, age, position);

    }

    public static Freelancer createFreelancer(String lastName, String name, int age, double position) {
        if (lastName == null || lastName.length() < 3) {
            throw new RuntimeException("Некорректная фамилия работника!!!");
        }
        if (name == null && name.length() < 3) {
            throw new RuntimeException("Некорректное имя работника!!!");
        }
        if (age < 18) {
            throw new RuntimeException("Некорректный возраст работника!!!");
        }
        if (position < 0) {
            throw new RuntimeException("Некорректная должность работника!!!");
        }
        return new Freelancer(lastName, name, age, position);
    }

    public double getSalary() {
        return salary;
    }


    @Override
    public void printInfo() {
        System.out.println(this);
    }


    @Override
    public double customSalary(double position) {
        salary = 20.8 * 8 * position;

        return salary;
    }

    public void setSalary(double salary) {
        double res = customSalary(position);
        res = salary;
    }
}


