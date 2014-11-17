/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    //horas
    private NumberDisplay hour;
    //minutos
    private NumberDisplay minute;
     
    //hora actual en 5 caracteres
    private String courentValue;
    

    /**
     * Constructor fija la hora a 00:00
     */
    public ClockDisplay()
    {
      hour      = new NumberDisplay(24);
      minute    = new NumberDisplay(60);
      courentValue = hour.getDisplayValue()+":"+minute.getDisplayValue();
        
    }
    /**
     * constructor que fija por parametros la hora
     */
    public ClockDisplay(int newHour, int newMinute)
    {
      hour      = new NumberDisplay(24);
      minute    = new NumberDisplay(60);
      hour.setValue(newHour);
      minute.setValue(newMinute);
      courentValue = hour.getDisplayValue()+":"+minute.getDisplayValue();
    }
    /**
     * fija la hora a los valores introducidos
     */
    
    public void setTime(int newHour, int newMinute)
    {
      hour.setValue(newHour);
      minute.setValue(newMinute);
      courentValue = hour.getDisplayValue()+":"+minute.getDisplayValue();
    }
    
     /**
     * devuelve en string hora actual en 5 caracteres
     */
    public String getTime()
    {
        return courentValue;
    }
}