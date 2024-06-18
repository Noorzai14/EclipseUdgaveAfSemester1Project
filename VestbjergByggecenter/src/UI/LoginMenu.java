package UI;


/**
 * Write a description of class LoginMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoginMenu {
 
    private StockEmployeeMenu sem;
    
    public void Start(){
         TextInput LoginMenu = new TextInput();
         String name = LoginMenu.inputString("Indtast dit navn");
         String ID = LoginMenu.inputString("Indtast dit medarbejder ID");
         
    }
    
}
