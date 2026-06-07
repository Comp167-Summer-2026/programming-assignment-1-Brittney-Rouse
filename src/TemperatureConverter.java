import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        double temperatureChange = 0.0;

        if (unit.equalsIgnoreCase("C")) {
            //converts the entered temperature to Fahrenheit
            temperatureChange = (temperature * 9 / 5) + 32;
            System.out.printf("%.2f", temperature);
            System.out.print("C is equal to ");
            System.out.printf("%.2f", temperatureChange);
            System.out.println("F");
            System.out.println();
        }
        if (unit.equalsIgnoreCase("F")) {
            //converts the entered temperature to Celsius
            temperatureChange = (temperature - 32) * 5 / 9;
            System.out.printf("%.2f", temperature);
            System.out.print("F is equal to ");
            System.out.printf("%.2f", temperatureChange);
            System.out.println("C");
            System.out.println();
        }

        return temperatureChange;
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        boolean working = true;

        while (working) {
            System.out.print("Please enter a temperature, as a number (or 'stop' to stop the program): ");
            userInput = scnr.nextLine();

            if (userInput.equalsIgnoreCase("stop")) {
                //stops the program without an error
                working = false;
                System.out.println("Program successfully stopped.");
            }
            else if (!userInput.matches("-?\\d+(\\.\\d+)?")) {
                //makes the user enter another input (and gives the cause of the error - the input was not a number)
                System.out.println("Error: Not a number.");
                System.out.println();
            }

            else {
                double temperature = Double.parseDouble(userInput);
                boolean workingUnit = false;

                while (!workingUnit) {
                    //goes to the String if a number was input
                    System.out.print("Celsius or Fahrenheit? (Please enter 'C' or 'F'): ");
                    String unit = scnr.nextLine();

                    if ((unit.equalsIgnoreCase("C")) || (unit.equalsIgnoreCase("F"))) {
                        //if the user entered C or F, the program converts the temperature accordingly
                        convertTemperature(temperature, unit);
                        workingUnit = true;
                    }
                    else {
                        //the user did not enter C or F, so they are asked to try again
                        System.out.println("Invalid input. Please enter either 'C' or 'F'.");
                        System.out.println();
                    }

                }
            }
        }
    }
}
