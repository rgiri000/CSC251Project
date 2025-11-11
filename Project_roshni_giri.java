import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_roshni_giri {

    public static void main(String[] args) throws IOException {

        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()) {

            int policyNumber = inputFile.nextInt();
            inputFile.nextLine();

            String providerName = inputFile.nextLine();
            String firstName = inputFile.nextLine();
            String lastName = inputFile.nextLine();
            int age = inputFile.nextInt();
            inputFile.nextLine();
            String smokingStatus = inputFile.nextLine();
            double height = inputFile.nextDouble();
            double weight = inputFile.nextDouble();
            if (inputFile.hasNextLine()) inputFile.nextLine(); // skip blank line

            // Create PolicyHolder
            PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                                                   smokingStatus, height, weight);

            // Create Policy with PolicyHolder
            Policy policy = new Policy(policyNumber, providerName, holder);

            policies.add(policy);
        }

        inputFile.close();

        // Display all policies using toString()
        for (Policy policy : policies) {
            System.out.println(policy.toString() + "\n");

            String s = policy.getPolicyHolder().getSmokingStatus();
            if (s.equalsIgnoreCase("smoker"))
                smokerCount++;
            else
                nonSmokerCount++;
        }

        // Display counts
        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
