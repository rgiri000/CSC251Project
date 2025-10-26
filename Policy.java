public class Policy {
    
    private int policyNumber;
    private String providerName;
    private String policyHolderFirstName;
    private String policyHolderLastName;
    private int policyHolderAge;
    private String policyHolderSmokingStatus; 
    private double policyHolderHeight; 
    private double policyHolderWeight; 

    /**
     * Default constructor that initializes all fields with default values.
     */
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

    /**
     * Constructs a Policy object with the specified details.
     * 
     * @param policyNumber the policy number
     * @param providerName the name of the insurance provider
     * @param firstName the first name of the policyholder
     * @param lastName the last name of the policyholder
     * @param age the age of the policyholder
     * @param smokingStatus the smoking status of the policyholder ("smoker" or "non-smoker")
     * @param height the height of the policyholder in inches
     * @param weight the weight of the policyholder in pounds
     */
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

    /**
     * Gets the policy number.
     * 
     * @return the policy number
     */
    public int getPolicyNumber() { return policyNumber; }

    /**
     * Sets the policy number.
     * 
     * @param policyNumber the policy number to set
     */
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    /**
     * Gets the provider name.
     * 
     * @return the provider name
     */
    public String getProviderName() { return providerName; }

    /**
     * Sets the provider name.
     * 
     * @param providerName the provider name to set
     */
    public void setProviderName(String providerName) { this.providerName = providerName; }

    /**
     * Gets the policyholder's first name.
     * 
     * @return the first name of the policyholder
     */
    public String getPolicyHolderFirstName() { return policyHolderFirstName; }

    /**
     * Sets the policyholder's first name.
     * 
     * @param firstName the first name to set
     */
    public void setPolicyHolderFirstName(String firstName) { this.policyHolderFirstName = firstName; }

    /**
     * Gets the policyholder's last name.
     * 
     * @return the last name of the policyholder
     */
    public String getPolicyHolderLastName() { return policyHolderLastName; }

    /**
     * Sets the policyholder's last name.
     * 
     * @param lastName the last name to set
     */
    public void setPolicyHolderLastName(String lastName) { this.policyHolderLastName = lastName; }

    /**
     * Gets the policyholder's age.
     * 
     * @return the age of the policyholder
     */
    public int getPolicyHolderAge() { return policyHolderAge; }

    /**
     * Sets the policyholder's age.
     * 
     * @param age the age to set
     */
    public void setPolicyHolderAge(int age) { this.policyHolderAge = age; }

    /**
     * Gets the policyholder's smoking status.
     * 
     * @return the smoking status ("smoker" or "non-smoker")
     */
    public String getPolicyHolderSmokingStatus() { return policyHolderSmokingStatus; }

    /**
     * Sets the policyholder's smoking status.
     * 
     * @param smokingStatus the smoking status to set ("smoker" or "non-smoker")
     */
    public void setPolicyHolderSmokingStatus(String smokingStatus) { this.policyHolderSmokingStatus = smokingStatus; }

    /**
     * Gets the policyholder's height.
     * 
     * @return the height of the policyholder in inches
     */
    public double getPolicyHolderHeight() { return policyHolderHeight; }

    /**
     * Sets the policyholder's height.
     * 
     * @param height the height to set in inches
     */
    public void setPolicyHolderHeight(double height) { this.policyHolderHeight = height; }

    /**
     * Gets the policyholder's weight.
     * 
     * @return the weight of the policyholder in pounds
     */
    public double getPolicyHolderWeight() { return policyHolderWeight; }

    /**
     * Sets the policyholder's weight.
     * 
     * @param weight the weight to set in pounds
     */
    public void setPolicyHolderWeight(double weight) { this.policyHolderWeight = weight; }

    /**
     * Calculates and returns the Body Mass Index (BMI) of the policyholder.
     * The formula used is (weight * 703) / (height * height).
     * 
     * @return the BMI value, or 0 if the height is zero
     */
    public double getBMI() {
        if (policyHolderHeight == 0) return 0;
        return (policyHolderWeight * 703) / (policyHolderHeight * policyHolderHeight);
    }

    /**
     * Calculates and returns the total policy price based on the policyholder's age,
     * smoking status, and BMI.
     * 
     * <p>Base price: $600</p>
     * <ul>
     *   <li>Age > 50: +$75</li>
     *   <li>Smoker: +$100</li>
     *   <li>BMI > 35: +($20 × each point over 35)</li>
     * </ul>
     * 
     * @return the total calculated policy price
     */
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