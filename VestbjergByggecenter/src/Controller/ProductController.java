package Controller;
import Model.Product;
import Model.ProductContainer;

/**
 * Write a description of class ProductController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductController {
 
    private ProductContainer pc;
    
    public ProductController (){
        pc = ProductContainer.getInstance();
        }
    
    public Product findProduct(int barcode){
        return pc.getProduct(barcode);
    }
}
