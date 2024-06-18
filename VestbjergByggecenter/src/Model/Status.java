package Model;
import java.time.LocalDate;


/**
 * Write a description of class Status here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Status {
    
    private LocalDate date;
    private String description;
    
    public Status(String description){
        date = LocalDate.now();
        this.description = description;
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDate(int year, int month, int day){
        date = LocalDate.of(year,month,day);
    }
    
    public void setDescription(String description){
        this.description = description;
    }
 
}
