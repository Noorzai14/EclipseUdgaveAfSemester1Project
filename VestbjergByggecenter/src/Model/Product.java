 package Model;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product {
    private static int nextBarcodeNo = 1;
    private int minStock;
    private int maxStock;
    private int stockAmount;
    private String name;
    private double price;
    private int barcodeNo;
    
    
    public Product(int minStock, int maxStock, int stockAmount, String name, double price){
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.stockAmount = stockAmount;
        this.name = name;
        this.price = price;
        barcodeNo = Product.nextBarcodeNo++;
    }
    
    public int getMinStock(){
        return minStock;
    }
    
    public int getMaxStock(){
        return maxStock;
    }
    
    public int getStockAmount(){
        return stockAmount;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getBarcodeNo(){
        return barcodeNo;
    }
    
    public void setMinStock(int minStock){
        this.minStock = minStock;
    }
    
    public void setMaxStock(int maxStock){
        this.maxStock = maxStock;   
    }
    
    public void setStock(int stockAmount){
        this.stockAmount = stockAmount;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    
}
