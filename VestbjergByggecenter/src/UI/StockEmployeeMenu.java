package UI;


/**
 * Write a description of class MainMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StockEmployeeMenu {
 
    private OrderMenu orderMenu;
    
public StockEmployeeMenu(){
    orderMenu = new OrderMenu();
}

public void start(){
    boolean exit = false;
    while (!exit){
        int choice = writeMenu();
        if(choice == 1){
            System.out.println (" Denne er endnu ikke implementeret");
        }
        else if(choice == 2){
            orderMenu.start();
        }
        else if(choice == 3){
            System.out.println(" Denne er endnu ikke implementeret");
        }
        else if(choice == 4){
            System.out.println(" Denne er endnu ikke implementeret");
        }
        else if(choice == 5){
            TryMe.generateData();
            System.out.println("Data lavet");
        }
        else if (choice == 0){
            writeEnd();
            exit = true;
        }
        else{
            System.out.println("Vælg venligst en af valgmulighederne");
        }
    }
}

private int writeMenu(){
    TextOptions menu = new TextOptions ("\n  ***Lagermenu***" , "Afslut programmet");
    menu.addOption("Bestil Produkt");
    menu.addOption("Udfyld Ordrer");
    menu.addOption("Opfyld Lager");
    menu.addOption("Pluk Order");
    menu.addOption("Opret data");
    return menu.prompt();
}

private void writeEnd(){
    System.out.println(" Tak for denne gang ");
}
    
}
