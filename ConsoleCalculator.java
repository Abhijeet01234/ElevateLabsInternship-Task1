import java.util.Scanner;

public class ConsoleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Creating object of Scanner class
        boolean isCalculatorRunning = true;
        
        System.out.println("Welcome to Java Console Calculator");
        System.out.println("----------------------------------");
        
        while (isCalculatorRunning) {
            // Display menu of our all Operations
            System.out.println("\nChoose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                sc.next(); // clearing the invalid input
                continue;
            }
            
            if (choice == 5) {
                isCalculatorRunning = false;
                System.out.println("Thank you for using the calculator. Goodbye!");
                continue;
            }
            
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
                continue;
            }
            
            // Getting operands
            double num1, num2;
            try {
                System.out.print("Enter first number: ");
                num1 = sc.nextDouble();
                
                System.out.print("Enter second number: ");
                num2 = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values.");
                sc.next(); // clearing the invalid input
                continue;
            }
            
            // Performing calculation based on user's choice
            double result = 0;
            String operation = "";
            
            switch (choice) {
                case 1:
                    result = num1 + num2;
                    operation = "+";
                    break;
                case 2:
                    result = num1 - num2;
                    operation = "-";
                    break;
                case 3:
                    result = num1 * num2;
                    operation = "*";
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        continue;
                    }
                    result = num1 / num2;
                    operation = "/";
                    break;
            }
            
            // Display result
            System.out.println("----------------------------------"); //Used these dotted line to separate our result in Console
            System.out.printf("\nResult: %.2f %s %.2f = %.2f\n", num1, operation, num2, result);
            System.out.println("----------------------------------");
        }
        sc.close();
    }
}