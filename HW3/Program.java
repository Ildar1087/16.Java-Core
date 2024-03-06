package HW3;

public class Program {
    public static void main(String[] args) {

        BaseClass[] workings = {
                Freelancer.createFreelancer( "Bogomolov","Faric", 32, 0.1),
                Freelancer.createFreelancer( "Ivanov","Timur", 45, 0.8),
                Freelancer.createFreelancer( "Petrov","Iman", 23, 0.2),
                Worker.createWorker( "Petrenikov","Alex", 41, 0.4),
                Worker.createWorker( "Vasileeva","Lena", 18, 0.1),
                Worker.createWorker( "Aveldayukov","Daniil", 32, 0.7)
        };

        for (BaseClass work : workings) {
            System.out.println(work);
        }
    }
}
