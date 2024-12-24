import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        System.out.println("Welcome to the Enhanced Temperature Conversion Program!");

        while (continueConversion) {
            try {
                // Display menu options
                System.out.println("\nChoose a conversion option:");
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Celsius to Kelvin");
                System.out.println("3. Fahrenheit to Celsius");
                System.out.println("4. Fahrenheit to Kelvin");
                System.out.println("5. Kelvin to Celsius");
                System.out.println("6. Kelvin to Fahrenheit");

                System.out.print("Enter your choice (1-6): ");
                int choice = scanner.nextInt();

                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                    continue;
                }

                System.out.print("Enter the temperature to convert: ");
                double inputTemperature = scanner.nextDouble();

                double result = performConversion(choice, inputTemperature);
                displayResult(choice, inputTemperature, result);

                // Ask if the user wants to continue
                System.out.print("\nDo you want to perform another conversion? (yes/no): ");
                String response = scanner.next();
                continueConversion = response.equalsIgnoreCase("yes");
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please try again.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        System.out.println("Thank you for using the Enhanced Temperature Conversion Program!");
        scanner.close();
    }

    // Perform the chosen conversion
    public static double performConversion(int choice, double temperature) {
        switch (choice) {
            case 1: // Celsius to Fahrenheit
                return (temperature * 9 / 5) + 32;
            case 2: // Celsius to Kelvin
                return temperature + 273.15;
            case 3: // Fahrenheit to Celsius
                return (temperature - 32) * 5 / 9;
            case 4: // Fahrenheit to Kelvin
                return (temperature - 32) * 5 / 9 + 273.15;
            case 5: // Kelvin to Celsius
                return temperature - 273.15;
            case 6: // Kelvin to Fahrenheit
                return (temperature - 273.15) * 9 / 5 + 32;
            default:
                return Double.NaN; // This should never occur
        }
    }

    // Display the conversion result
    public static void displayResult(int choice, double inputTemperature, double result) {
        String fromUnit = "", toUnit = "";

        switch (choice) {
            case 1:
                fromUnit = "Celsius";
                toUnit = "Fahrenheit";
                break;
            case 2:
                fromUnit = "Celsius";
                toUnit = "Kelvin";
                break;
            case 3:
                fromUnit = "Fahrenheit";
                toUnit = "Celsius";
                break;
            case 4:
                fromUnit = "Fahrenheit";
                toUnit = "Kelvin";
                break;
            case 5:
                fromUnit = "Kelvin";
                toUnit = "Celsius";
                break;
            case 6:
                fromUnit = "Kelvin";
                toUnit = "Fahrenheit";
                break;
        }

        System.out.printf("%.2f %s = %.2f %s\n", inputTemperature, fromUnit, result, toUnit);
    }
}