package HW3;

import my_lesson3.BaseHuman;

public abstract class BaseClass {
    BaseClass bc;
    protected String name;
    protected String lastName;
    protected int age;
    protected double position;// должность(коэффициент зарплаты)
    private double sulary;


    public BaseClass(String lastName, String name, int age) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSulary() {
        return sulary;
    }

    public void setSulary(bc.customSalary()) {
        double resSylary = customSalary(position);
        resSylary = sulary;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }


    public BaseClass(double position) {
        this("name", "lastName", 22, position);
    }

    public BaseClass(String name, String lastName, int age, double position) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.position = position;

    }


    private void updateAge(int age) {
        if (age < 18) {
            throw new RuntimeException("Некорректный возраст работника!!!");
        }
        this.age = age;
    }

    private void updateName(String name) {
        if (name == null && name.length() < 3) {
            throw new RuntimeException("Некорректное имя работника!!!");
        }
        this.name = name;
    }



    public abstract void printInfo();

    public double customSalary(double position){
        double salary = 20.8 * 8 * position;

        return salary;
    };

    @Override
    public String toString() {
        return "BaseClass{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", sulary=" + sulary +
                '}';
    }
}