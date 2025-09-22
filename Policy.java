public class Policy {
    
    private int policyNumber;
    private String providerName;
    private String policyHolderFirstName;
    private String policyHolderLastName;
    private int policyHolderAge;
    private String policyHolderSmokingStatus; 
    private double policyHolderHeight; 
    private double policyHolderWeight; 

    // default values
    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyHolderFirstName = "";
        policyHolderLastName = "";
        policyHolderAge = 0;
        policyHolderSmokingStatus = "non-smoker";
        policyHolderHeight = 0.0;
        policyHolderWeight = 0.0;
    }

    // Constructor with arguments
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolderFirstName = firstName;
        this.policyHolderLastName = lastName;
        this.policyHolderAge = age;
        this.policyHolderSmokingStatus = smokingStatus;
        this.policyHolderHeight = height;
        this.policyHolderWeight = weight;
    }

    // Getters and Setters
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public String getPolicyHolderFirstName() { return policyHolderFirstName; }
    public void setPolicyHolderFirstName(String firstName) { this.policyHolderFirstName = firstName; }

    public String getPolicyHolderLastName() { return policyHolderLastName; }
    public void setPolicyHolderLastName(String lastName) { this.policyHolderLastName = lastName; }

    public int getPolicyHolderAge() { return policyHolderAge; }
    public void setPolicyHolderAge(int age) { this.policyHolderAge = age; }

    public String getPolicyHolderSmokingStatus() { return policyHolderSmokingStatus; }
    public void setPolicyHolderSmokingStatus(String smokingStatus) { this.policyHolderSmokingStatus = smokingStatus; }

    public double getPolicyHolderHeight() { return policyHolderHeight; }
    public void setPolicyHolderHeight(double height) { this.policyHolderHeight = height; }

    public double getPolicyHolderWeight() { return policyHolderWeight; }
    public void setPolicyHolderWeight(double weight) { this.policyHolderWeight = weight; }

    // Method to calculate BMI
    public double getBMI() {
        if (policyHolderHeight == 0) return 0;
        return (policyHolderWeight * 703) / (policyHolderHeight * policyHolderHeight);
    }

    // Method to calculate policy price
    public double getPolicyPrice() {
        double price = 600.0;

        if (policyHolderAge > 50) {
            price += 75.0;
        }

        if (policyHolderSmokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        double bmi = getBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }
}
