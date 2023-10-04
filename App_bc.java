import java.util.Scanner;

public class App_bc {
    static final Scanner inputScanner = new Scanner(System.in);
    
    
    public static void main(String[] args){
        double num1 = 0;
        double num2 = 0;
        double mathAnswer =0;
        String runAgain = "Y";
        String operation = "";
        String discernInput = "";
        boolean repeatFlag = false;

        while (runAgain.toUpperCase().equals("Y")){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (repeatFlag == true){
                num1 = mathAnswer;
                repeatFlag = false;
                System.out.println("First number will be " + mathAnswer);
                num2 = getDouble("Please type another number:");
                operation = getString("Which operation would you like to perform? %n (A) Addition %n (B) Subtraction %n (C) Multiplication %n (D) Division %n");
                mathAnswer = calcStager(operation, num1, num2);
            } else {
                System.out.println("Please type a number, two numbers separated by a space, or a two-number equation with operator (a + b):");
                discernInput = inputScanner.nextLine();
                String slice[] = discernInput.split(" ");
                if(slice.length == 1){
                    num1 = Double.parseDouble(slice[0]);
                    num2 = getDouble("Please type another number:");
                    operation = getString("Which operation would you like to perform? %n (A) Addition %n (B) Subtraction %n (C) Multiplication %n (D) Division %n");
                    mathAnswer = calcStager(operation, num1, num2);
                } else if(slice.length == 2){
                    num1 = Double.parseDouble(slice[0]);
                    num2 = Double.parseDouble(slice[1]);
                    operation = getString("Which operation would you like to perform? %n (A) Addition %n (B) Subtraction %n (C) Multiplication %n (D) Division %n");
                    mathAnswer = calcStager(operation, num1, num2);
                } else if(slice.length == 3){
                    num1 = Double.parseDouble(slice[0]);
                    num2 = Double.parseDouble(slice[2]);
                    if(slice[1].equals("+")){
                        operation = "A";
                    } else if(slice[1].equals("-")){
                        operation = "B";
                    } else if (slice[1].equals("*")){
                        operation = "C";
                    } else if(slice[1].equals("/")){
                        operation = "D";
                    }
                    mathAnswer = calcStager(operation, num1, num2);
                };
            }
            System.out.println("The result is  " + mathAnswer);
            System.out.println("______________________________");
            System.out.println("______________________________");
            runAgain = getString("Would you like to run again?%n (Y) To continue%n (R) To perform a new operation on result%n ( ) Any other response to quit.%n");
            if(runAgain.toUpperCase().equals("R")){
                runAgain = "Y";
                repeatFlag = true;
            }
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
    private static double calcStager(String operation, double num1, double num2){
        double mathAnswer = 0;
        Calculator calc = new Calculator();
        if(operation.toUpperCase().equals("A")){
                mathAnswer = calc.add(num1,num2);
            }else if(operation.toUpperCase().equals("B")){
                mathAnswer = calc.subtract(num1,num2);
            }else if(operation.toUpperCase().equals("C")){
                mathAnswer = calc.multiply(num1,num2);
            }else if(operation.toUpperCase().equals("D")){
                while(num2 == 0){
                    num2 = getDouble("Can't divide by zero! Choose another divisor:");
                }
                mathAnswer = calc.divide(num1,num2);
            }
        return mathAnswer;
    }
    

}