public class Policy {

    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;   // Aggregation

    private static int policyCount = 0;  // Static field

    /** Full constructor */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;

        // Defensive copy to avoid privacy leaks
        this.policyHolder = new PolicyHolder(policyHolder);

        policyCount++;
    }

    // Getters
    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }

    /** Returns a COPY of the policyholder for security */
    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(policyHolder);
    }

    /** Static getter */
    public static int getPolicyCount() {
        return policyCount;
    }

    /** Calculate Policy Price */
    public double getPolicyPrice() {
        double price = 600.0;

        if (policyHolder.getAge() > 50)
            price += 75.0;

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
            price += 100.0;

        double bmi = policyHolder.getBMI();
        if (bmi > 35)
            price += (bmi - 35) * 20;

        return price;
    }

    /** toString that also CALLS PolicyHolder toString */
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\n" + policyHolder.toString() +
               String.format("\nPolicy Price: $%.2f", getPolicyPrice());
    }
}
