import java.util.Scanner;

public class App {
    static final Scanner inputScanner = new Scanner(System.in);
    
    public static void main(String[] args){
        //String inputString = new String();
        //double inputDouble;
        double num1;
        double num2;
        double mathAnswer =0;
        String runAgain = "Y";
        String operation;
        String operationType = "";
        Calculator calc = new Calculator();
        //System.out.println("Testing app");
       /* inputString = getString("Please enter a short text phrase:");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("You typed: " + inputString);
        System.out.println("______________________________");
        System.out.println("______________________________");
        inputDouble = getDouble("Now, please enter a number:");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("You typed: " + inputDouble);
        System.out.flush();
        num1 = getDouble("Please type a number:");
        num2 = getDouble("Please type another number:");
        mathAnswer = calc.add(num1,num2);
        System.out.println("______________________________");
        System.out.printf("You typed the numbers %f and %f", num1, num2); */
        while (runAgain.toUpperCase().equals("Y")){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            num1 = getDouble("Please type a number:");
            num2 = getDouble("Please type another number:");
            operation = getString("Which operation would you like to perform? %n (A) Addition %n (B) Subtraction %n (C) Multiplication %n (D) Division %n");
            if(operation.toUpperCase().equals("A")){
                mathAnswer = calc.add(num1,num2);
                operationType = "sum";
            }else if(operation.toUpperCase().equals("B")){
                mathAnswer = calc.subtract(num1,num2);
                operationType = "difference";
            }else if(operation.toUpperCase().equals("C")){
                mathAnswer = calc.multiply(num1,num2);
                operationType = "product";
            }else if(operation.toUpperCase().equals("D")){
                while(num2 == 0){
                    num2 = getDouble("Can't divide by zero! Choose another divisor:");
                }
                mathAnswer = calc.divide(num1,num2);
                operationType = "quotient";
            }
            System.out.printf("The %s of those numbers is %.2f %n", operationType, mathAnswer);
            /*System.out.println("For numbers " + num1 + " and " + num2 + ":");
            mathAnswer = calc.add(num1,num2);
            System.out.println("Sum: " + mathAnswer);
            mathAnswer = calc.subtract(num1,num2);
            System.out.println("Difference: " + mathAnswer);
            mathAnswer = calc.divide(num1,num2);
            System.out.println("Quotient: " + mathAnswer);
            mathAnswer = calc.multiply(num1,num2);
            System.out.println("Product: " + mathAnswer);*/
            System.out.println("______________________________");
            System.out.println("______________________________");
            runAgain = getString("Would you like to run again?%nY to continue, any other response to quit.%n");
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static String getString(String prompt){
       System.out.printf(prompt);
        String userInput = inputScanner.nextLine();
        return userInput;
    }
    private static double getDouble(String prompt){
        System.out.println(prompt);
        String userInput = inputScanner.nextLine();
        double userDouble = Double.parseDouble(userInput);
        return userDouble;
    } 
    

}