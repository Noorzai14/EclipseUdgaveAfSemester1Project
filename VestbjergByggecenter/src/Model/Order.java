package Model;
import java.time.LocalDate;
import Model.Status;
import java.util.ArrayList;

/**
 * Write a description of class Order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Order {
    public static int nextOrderNo = 1;
    
    public int orderNo;
    public LocalDate orderDate;
    public double totalPrice;
    public Status latestStatus;
    public ArrayList<Status> allStatus;
    public ArrayList<OrderLine> orderLine;
    // public double discountPercentage;
    
    
    public Order (String description){
        allStatus = new ArrayList<>();
        orderLine = new ArrayList<>();
        orderNo = Order.nextOrderNo++;
        orderDate = LocalDate.now();
        latestStatus = new Status(description);
        allStatus.add(latestStatus);
    }
    
    public int getOrderNo(){
        return orderNo;
    }
    
    public LocalDate getOrderDate(){
        return orderDate;
    }
    
    public double getTotalPrice(){
        return totalPrice; 
    }
    
    // public double getDiscountPercentage(){
        // return discountPercentage; 
    // }
    
    public void setOrderDate(int year, int month, int day){
        orderDate = LocalDate.of(year,month,day);
    }
    
    public Status getLatestStatus(){
        return latestStatus;
    }
    
    public ArrayList getAllStatus(){
        return allStatus;
    }
    
    public void updateStatus(String description){
        latestStatus = new Status(description);
        allStatus.add(latestStatus);
    }
    
    public ArrayList getProducts(){
        return orderLine;
    }
    
    public void addProduct(int quantity, Product product){
        orderLine.add(new OrderLine(quantity, product));
    }
    
    
}
