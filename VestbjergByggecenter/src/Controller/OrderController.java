package Controller;
import Model.OrderContainer;
import Model.Order;
import Model.Product;
import Model.OrderLine;

import java.util.ArrayList;
/**
 * Write a description of class OrderController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrderController {

    private OrderContainer oc;
    private ProductController pc;

    public OrderController (){
        oc = OrderContainer.getInstance();
        pc = new ProductController();
    }

    public Order searchOrder(int orderNo){
        return oc.findOrder(orderNo);
    }

    public Product scanProduct (int barcode){
        return pc.findProduct(barcode);
    }

    public int changeStockOrder(int usedQuantity, Product product, Order order){
        int newStock = product.getStockAmount() - usedQuantity;
        product.setStock(newStock);
        return changeOrder(product, order, usedQuantity);
    }

    public int changeOrder(Product product, Order order, int usedQuantity){
        int newStock = 0;
        int i = 0;
        boolean searching = true;
        ArrayList<OrderLine> ao = order.getProducts();
        while (i < ao.size() && searching){
            OrderLine ol = ao.get(i);
            if(ol.getProduct() == product){
                newStock = ol.updateFoundQuantity(usedQuantity);
                searching = false;
            }
            i++;
        }
        return newStock;
    }

    public void updateStatus(String description, Order order){
        order.updateStatus(description);
    }

    public boolean checkStockStatus(int newStock, Product product){
        boolean underMinStock;
        if (product.getMinStock() > newStock){
            underMinStock = true;
        }
        else{
            underMinStock = false;
        }
        return underMinStock;
    }
}