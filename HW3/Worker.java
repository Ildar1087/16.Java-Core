package HW3;
/**Для работников с фиксированной оплатой
 * «среднемесячная заработная плата = фиксированная месячная оплата». */
public class Worker extends BaseClass implements Workman{

    double salary;


    public Worker(String name, String lastName, int age, double position) {
        super(name, lastName, age, position);

    }

    public static Worker createWorker(String lastName, String name, int age, double position){
        if(lastName == null || lastName.length() < 3){
            throw new RuntimeException("Некорректная фамилия работника!!!");
        }
        if(name == null && name.length() < 3) {
            throw new RuntimeException("Некорректное имя работника!!!");
        }
        if(age < 18){
            throw new RuntimeException("Некорректный возраст работника!!!");
        }
        if(position  <0){
            throw new RuntimeException("Некорректная должность работника!!!");
        }

        return new Worker(lastName, name, age, position);
    }


    @Override
    public void printInfo() {

    }



    @Override
    public double customSalary(double position) {
        int workDay = 5;
        int valueWeek = 4;
        salary = position * (double) workDay * (double) valueWeek;
        System.out.println(salary);
        return salary;
    }

    public void setSalary(double salary) {

        double result = customSalary(position);
        result = salary;
    }
}
