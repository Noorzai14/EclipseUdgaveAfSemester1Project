package UI;
import java.util.Scanner;


/**
 * Write a description of class TextImput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextInput {
 
    public TextInput() {
        
}


public static int inputNumber(String question){
    Scanner keyboard = new Scanner(System.in);
    int number = 0;
    printQuestion(question);
    while (!keyboard.hasNextInt()){
        System.out.println("Input skal være et tal - prøv igen");
        keyboard.nextLine();
    }
    number = keyboard.nextInt();
    return number;
}

public static String inputString(String question) {
    Scanner keyboard = new Scanner(System.in);
    printQuestion(question);
    return keyboard.nextLine();
}

private static void printQuestion(String question){
    System.out.print(""+ question + ":");
}
}



