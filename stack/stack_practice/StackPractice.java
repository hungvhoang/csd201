
import java.util.Scanner;

public class StackPractice {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String choice ="";
        do {
            System.out.println("\tApplication of stack:");
            System.out.println("1. Convert Decimal to Binary.");
            System.out.println("2. Reverse a string.");
            System.out.println("3. Delimeter matching check.");
            System.out.println("4. Quit program.");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine();
            switch(choice){
                case "1": 
                    decToBi();
                    break;
                case "2":
                    reverseString();
                    break;
                case "3":
                    delimeterCheck();
                    break;
                case "4":
                    System.out.println("Program ended. Have a nice day!...");
                    break;
                default:
                    System.out.println("Invalid choice! Enter again.");
                    break;
            }
        } while (!choice.matches("4"));
    }
    
    static void reverseString(){
        System.out.print("Enter a String: ");
        String input = sc.nextLine();
        StackClass s = new StackClass();
        for (int i = 0; i < input.length(); i++) {
            s.push(input.charAt(i));
        }
        String output ="";
        while(!s.isEmpty()){
            output += s.pop();
        }

        System.out.println("The reverse of the string is: "+output);
    } 


    static void decToBi(){
        System.out.print("Enter a number: ");
        int num = Integer.parseInt(sc.nextLine());
        StackClass s = new StackClass();
        System.out.printf("%d convert to Binary is: ",num);
        while(num>0){
            s.push(num%2);
            num /= 2;
        }
        while(!s.isEmpty()){
        System.out.print(s.pop());
        }
        System.out.println("");
    }

    static void delimeterCheck(){
        System.out.print("Enter an expresion: ");
        String expr = sc.nextLine();
        StackClass s = new StackClass();
        boolean valid = true;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            switch(c){
                case '(':
                case '{':
                case '[':
                    s.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if(s.isEmpty()){
                        System.out.println("Mismatch found \""+c+"\" at index "+i+".");
                        valid = false;
                    }
                    else{
                        Object matcher = s.pop();
                        if(c==')' && matcher != (Object)'(' ||c=='}' && matcher != (Object)'{' ||c==']' && matcher != (Object)'['){
                            System.out.println("Mismatch found \" "+c+"\" at index "+i+".");
                            valid = false;
                        }
                        break;
                    }
                default: break;
            }
        }
        if(valid) System.out.println("The expresion is valid.");
    }
}

