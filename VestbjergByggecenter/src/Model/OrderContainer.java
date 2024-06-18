package Model;

import java.util.ArrayList;
import Model.Order;

/**
 * Write a description of class OrderContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrderContainer {
 
    private ArrayList<Order> orders;
    private static OrderContainer instance;
    
    private OrderContainer(){
        orders = new ArrayList<>();
            
    }
    
    public static OrderContainer getInstance(){
        if(instance == null){
            instance = new OrderContainer();
        }
        return instance;
    }
    
    public Order findOrder(int orderNo){
        Order order = null;
        int i = 0;
        boolean searching = true;
        while (i < orders.size() && searching){
            Order o = orders.get(i);
            if(o.getOrderNo() == orderNo){
                order = o;
                searching = false;
            }
            i++;
        }
        return order;
    }
    
    public void add(Order order){
        orders.add(order);
    }
}
