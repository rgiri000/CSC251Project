public class PolicyHolder {

    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;   // "smoker" or "non-smoker"
    private double height;          // inches
    private double weight;          // pounds

    /** No-arg constructor */
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /** Full constructor */
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /** Copy constructor (for defensive copying) */
    public PolicyHolder(PolicyHolder other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.smokingStatus = other.smokingStatus;
        this.height = other.height;
        this.weight = other.weight;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    /** Calculate BMI */
    public double getBMI() {
        if (height == 0) return 0;
        return (weight * 703) / (height * height);
    }

    /** toString method for PolicyHolder info */
    public String toString() {
        return  "Policyholder's First Name: " + firstName +
                "\nPolicyholder's Last Name: " + lastName +
                "\nPolicyholder's Age: " + age +
                "\nPolicyholder's Smoking Status (Y/N): " + smokingStatus +
                "\nPolicyholder's Height: " + height + " inches" +
                "\nPolicyholder's Weight: " + weight + " pounds" +
                String.format("\nPolicyholder's BMI: %.2f", getBMI());
    }
}
