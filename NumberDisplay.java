
/**
 * Write a description of class NumberDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    // limite del display
    private int limit;
    private int display;
    

    /**
     * Constructor for objects of class NumberDisplay
     * select limit of display
     * fija valor display a 0
     */
    
    public NumberDisplay(int newLimit )
    {
        display = 0;
        limit = newLimit;
    }
    
    /**
     * fija valor actual del siplay
     */
    public void setValue(int value)
    {
        if (value <= limit)
        {
            display = value;
        }
        else
        {
            System.out.println("dato incorrecto introduce un numero entre 0-"+limit);
        }
    }

   
}
