import java.util.GregorianCalendar;

public class PersonWeight {

    private String fullName;
    private int yearOfBirth;
    private double height;
    private double weight;

    PersonWeight() {
        fullName = null;
        yearOfBirth = 0;
        height = 0;
        weight = 0;
    }

    PersonWeight(String fullName, int yearOfBirth, double height, double weight) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.height = height;
        this.weight = weight;
    }

    // getters
    public String getFullName() {
        return fullName;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }

    // setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int computeAge() {
        int currentYear = new GregorianCalendar().get(GregorianCalendar.YEAR);
        return currentYear - yearOfBirth;
    }

    public double computeBMI() {
        double bmi = weight/(Math.pow(height, 2));
        return bmi;
    }

}