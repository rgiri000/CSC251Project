import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_roshni_giri {
    public static void main(String[] args) throws IOException {

        // Create an ArrayList to hold Policy objects
        ArrayList<Policy> policies = new ArrayList<>();

        // Counters for smoker and non-smoker policies
        int smokerCount = 0;
        int nonSmokerCount = 0;

        // Open the PolicyInformation.txt file
        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        // Read each policy's data until the file ends
        while (inputFile.hasNext()) {
            int policyNumber = inputFile.nextInt();
            inputFile.nextLine(); // move to next line

            String providerName = inputFile.nextLine();
            String firstName = inputFile.nextLine();
            String lastName = inputFile.nextLine();
            int age = inputFile.nextInt();
            inputFile.nextLine(); // move to next line
            String smokingStatus = inputFile.nextLine();
            double height = inputFile.nextDouble();
            double weight = inputFile.nextDouble();

            // Skip blank line if one exists
            if (inputFile.hasNextLine())
                inputFile.nextLine();

            // Create a Policy object using the data
            Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                       age, smokingStatus, height, weight);

            // Add to ArrayList
            policies.add(policy);
        }

        // Close the file
        inputFile.close();

        // Display info for each policy
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getPolicyHolderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getPolicyHolderLastName());
            System.out.println("Policyholder's Age: " + policy.getPolicyHolderAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " +
                               policy.getPolicyHolderSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getPolicyHolderHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getPolicyHolderWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f%n", policy.getBMI());
            System.out.printf("Policy Price: $%.2f%n%n", policy.getPolicyPrice());

            // Count smokers and non-smokers
            if (policy.getPolicyHolderSmokingStatus().equalsIgnoreCase("smoker"))
                smokerCount++;
            else
                nonSmokerCount++;
        }

        // Display totals
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
