package Model;
import Model.Product;

/**
 * Write a description of class OrderLine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrderLine {

    private int quantity;
    private int foundQuantity;
    private Product product;

    public OrderLine(int quantity, Product product){
        this.quantity = quantity;
        this.product = product;
        foundQuantity = 0;
    }
    
    public Product getProduct(){
        return product;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public int getFoundQuantity(){
        return foundQuantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setFoundQuantity(int foundQuantity){
        this.foundQuantity = foundQuantity;
    }
    
    public int updateFoundQuantity(int quantity){
        if (foundQuantity > quantity){
            System.out.println("Du har taget " + (foundQuantity - quantity) + " varer for meget");
        }
        foundQuantity += quantity;
        return foundQuantity;
    }
    
}
