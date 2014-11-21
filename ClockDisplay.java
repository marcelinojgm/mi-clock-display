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
    //dia
    private NumberDisplay day;
    //mes
    private NumberDisplay month;
    //dia
    private NumberDisplay year;

    //hora actual en 5 caracteres y fecha dd/mm/aa
    private String courentValue;

    /**
     * Constructor fija la hora a 00:00 fecha 01/01/01
     */
    public ClockDisplay()
    {
        hour    = new NumberDisplay(24);
        minute  = new NumberDisplay(60);
        day     = new NumberDisplay(30);
        month   = new NumberDisplay(12);
        year    = new NumberDisplay(99);
        day.setValue(1);
        month.setValue(1);
        year.setValue(1);
        
        updateDisplay();       
    }

    /**
     * constructor que fija por parametros la hora
     */
    public ClockDisplay(int newHour, int newMinute, int newDay, int newMonth, int newYear)
    {
        hour      = new NumberDisplay(24);
        minute    = new NumberDisplay(60);
        day       = new NumberDisplay(30);
        month     = new NumberDisplay(12);
        year      = new NumberDisplay(99);
            
        hour.setValue(newHour);
        minute.setValue(newMinute);
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);
        updateDisplay();
    }

    /**
     * fija la hora a los valores introducidos
     */

    public void setTime(int newHour, int newMinute, int newDay, int newMonth, int newYear)
    {
        hour.setValue(newHour);
        minute.setValue(newMinute);
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);
        updateDisplay();
    }

    /**
     * devuelve en string hora actual en 5 caracteres
     */
    public String getTime()
    {
        return courentValue;
    }

    /**
     * adelanta el relojun min
     */

    public void timeTick()
    {
        minute.increment();
        if (minute.getValue() == 0)
        {
            hour.increment();
        }
        updateDisplay();
    }
   
    /**
     * Devuelve String
     */ 
    private String fecha()
    {
 
     String fechaActual;
     fechaActual = day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + year.getDisplayValue();
     return fechaActual;
    }
    
   
    
    /**
     * actualizar valor courentValue formato am/pm
     */
    private void updateDisplay()
    {
        String fechaActual = fecha();
        if(hour.getValue() < 12)
        {   
             String am = "am";
            if (hour.getValue() == 0)
            {
                courentValue = "12"+ ":" + minute.getDisplayValue() + " " + am + " " + fechaActual;
            }
            else
            {
                courentValue = hour.getDisplayValue() + ":" + minute.getDisplayValue() + " " + am + " " + fechaActual;
            }

        }
        else
        {
            String pm = "pm";
            if (hour.getValue() == 12)
            {
                courentValue = hour.getValue() + ":" + minute.getDisplayValue() + " " + pm + " " + fechaActual;
            }
            else
            { 
                if((hour.getValue()-12) <10 )
                {
                    courentValue = "0" + (hour.getValue()-12) + ":" + minute.getDisplayValue() + " " + pm + " " + fechaActual;
                }
                else
                {
                    courentValue = (hour.getValue()-12) + ":"  + minute.getDisplayValue() + " " + pm + " " + fechaActual;
                }
            }
        }
    }

}