package UI;
import Model.*;

/**
 * Write a description of class TryMe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TryMe {
    
    public static TryMe tryMe = new TryMe();
    public static OrderContainer oc;
    public static ProductContainer pc;
    
    public static void generateData(){
        oc = OrderContainer.getInstance();
        pc = ProductContainer.getInstance();
        
        Product p1 = new Product (500, 2000, 1000, "Søm", 109.95);
        Product p2 = new Product (100, 400, 200, "Træ plade", 199.95);
        Product p3 = new Product (400, 1600, 800, "Skruer", 99.95);
        Product p4 = new Product (100, 200, 150, "Cement", 499.95);
        
        pc.add(p1);
        pc.add(p2);
        pc.add(p3);
        pc.add(p4);
        
        Order o1 = new Order("Order Has Been made");
        oc.add(o1);
        System.out.println("Order nummer er " + o1.getOrderNo());
        
        o1.addProduct(25, p1);
        o1.addProduct(150, p2);
        
    }
}
