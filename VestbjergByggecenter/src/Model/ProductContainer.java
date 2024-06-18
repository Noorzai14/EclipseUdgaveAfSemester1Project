package Model;
import java.util.ArrayList;
import Model.Product;

/**
 * Write a description of class ProductContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductContainer {

    private ArrayList<Product> products;
    private static  ProductContainer instance;

    public ProductContainer(){
        products = new ArrayList<>();
    }

    public static ProductContainer getInstance(){
        if(instance == null){
            instance = new ProductContainer();
        }
        return instance;
    }

    public Product getProduct(int barcodeNo){
        Product product = null;
        int i = 0;
        boolean searching = true;
        while (i < products.size() && searching){
            Product p = products.get(i);
            if (p.getBarcodeNo()== barcodeNo){
                product = p;
                searching = false;
            }
            i++;
        }
        return product;
        }
    
        public boolean add (Product product){
        boolean status = false;
        if (product != null){
            products.add(product);
            status = true;
        }
        return status;
    }

    
}
