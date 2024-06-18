package UI;
import Model.Order;
import Model.Product;
import Model.OrderLine;
import Controller.OrderController;
import java.util.ArrayList;

/**
 * Write a description of class OrderUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrderMenu{
    Order currentOrder;
    private OrderController oc;
    private StockEmployeeMenu stm;
    public OrderMenu(){
        oc = new OrderController();
        currentOrder = null;
    }

    public void start(){
        boolean exit = false;
        int orderNo = TextInput.inputNumber("Venligst indtast ordre nummer ind");
        currentOrder = searchOrder(orderNo);
        if(currentOrder != null){
            while (!exit){
                displayProducts();
                int choice = enterProductMenu();
                if (choice == 1){
                    //TODO prompt for barcode and amount used
                    int barcode = TextInput.inputNumber("Indtast barkode");
                    if (oc.scanProduct(barcode) != null){
                        int usedQuantity = TextInput.inputNumber("Indtast antal");
                        int newStock = enterProduct(usedQuantity, barcode);
                        System.out.println("Der er nu " + newStock + " tilbage på lageret");
                        boolean underMinStock = oc.checkStockStatus(newStock, oc.scanProduct(barcode));
                        if(underMinStock = true){
                            System.out.println("Bestil venligst flere varer til lageret");
                        }
                    }
                    else{
                        System.out.println("Den indtastede barkode er ikke gyldigt");
                    }
                }
                if (choice == 2){
                    updateStatus();
                    exit = true;
                }
                if (choice == 0){
                    exit = true;
                }
            }
        }
    }

    public Order searchOrder(int OrderNo){
        return oc.searchOrder(OrderNo);
    }

    public int enterProduct(int usedQuantity, int barcode){
        Product product = oc.scanProduct(barcode);
        int newStock =  oc.changeStockOrder(usedQuantity, product, currentOrder);
        return newStock;
    }

    public void updateStatus(){
        ArrayList<OrderLine> products = currentOrder.getProducts();
        boolean productFilled = true;
        int i = 0;
        while (i < products.size() && productFilled == true){
            OrderLine ol = products.get(i);
            if (ol.getFoundQuantity() != ol.getQuantity()){
                productFilled = false;
                
            }
            else{
                productFilled = true;
            }
            i++;
        }

        if (productFilled == true){
            oc.updateStatus("Alle produkter er blevet plukket", currentOrder);
            System.out.println("Ordren er blevet fyldt");
        }
        else{
            System.out.println("Der er produkter på ordren som ikke er færdig");
        }

    }

    public void displayProducts(){
        ArrayList<OrderLine> al= currentOrder.getProducts();
        for(OrderLine ol : al) {
            Product p = ol.getProduct();
            System.out.println("Navn: " + p.getName() + "\t Barkode: " + p.getBarcodeNo() + "\t Mængde: " + ol.getQuantity() + "x" + "\t Mængde fundet: "+ ol.getFoundQuantity());         
        }
    }

    private int enterProductMenu(){
        TextOptions menu = new TextOptions ("\n Indtast Produkt", "Gå tilbage til Hovedmenu");
        menu.addOption("Bestil produkt");
        menu.addOption("Afslut Ordre");
        return menu.prompt();
    }

}
