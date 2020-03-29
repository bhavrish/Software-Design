import java.util.Scanner;

public class TestPersonWeight {

    public static String classifyBMI(double BMI) {
        if (BMI < 18.5)
            return "Underweight";
        else if (BMI < 25)
            return "Normal Weight";
        else if (BMI < 30)
            return "Overweight";
        else
            return "Obese";
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // instance 1
        PersonWeight p1 = new PersonWeight();
        System.out.printf("%s", "Enter person's name: ");
        String fullName = input.nextLine();
        System.out.printf("%s", "Enter person's year of birth: ");
        int dateOfBirth = input.nextInt();
        System.out.printf("%s", "Enter person's height in meters: ");
        double height = input.nextDouble();
        System.out.printf("%s", "Enter person's weight in kilograms: ");
        double weight = input.nextDouble();
        p1.setFullName(fullName);
        p1.setYearOfBirth(dateOfBirth);
        p1.setHeight(height);
        p1.setWeight(weight);
        System.out.printf("%16s%s%n", "Full name: ", p1.getFullName());
        System.out.printf("%16s%d%n", "Age: ", p1.computeAge());
        System.out.printf("%16s%.2f%n", "Height: ", p1.getHeight());
        System.out.printf("%16s%.2f%n", "Weight: ", p1.getWeight());
        System.out.printf("%16s%s%n%n", "Classification: ", classifyBMI(p1.computeBMI()));

        // instance 2
        input.nextLine();
        System.out.printf("%s", "Enter person's name: ");
        String fullName2 = input.nextLine();
        System.out.printf("%s", "Enter person's year of birth: ");
        int dateOfBirth2 = input.nextInt();
        System.out.printf("%s", "Enter person's height in meters: ");
        double height2 = input.nextDouble();
        System.out.printf("%s", "Enter person's weight in kilograms: ");
        double weight2 = input.nextDouble();
        PersonWeight p2 = new PersonWeight(fullName2, dateOfBirth2, height2, weight2);
        System.out.printf("%16s%s%n", "Full name: ", p2.getFullName());
        System.out.printf("%16s%d%n", "Age: ", p2.computeAge());
        System.out.printf("%16s%.2f%n", "Height: ", p2.getHeight());
        System.out.printf("%16s%.2f%n", "Weight: ", p2.getWeight());
        System.out.printf("%16s%s%n", "Classification: ", classifyBMI(p2.computeBMI()));

    }

}