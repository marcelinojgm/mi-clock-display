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
        hour          = new NumberDisplay(24);
        minute        = new NumberDisplay(60);
        updateDisplay();       
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
        updateDisplay();
    }

    /**
     * fija la hora a los valores introducidos
     */

    public void setTime(int newHour, int newMinute)
    {
        hour.setValue(newHour);
        minute.setValue(newMinute);
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
     * actualizar valor courentValue formato am/pm
     */
    private void updateDisplay()
    {
        if(hour.getValue() < 12)
        {
            if (hour.getValue() == 0)
            {
                courentValue = "12"+ ":" + minute.getDisplayValue() + " am";
            }
            else
            {
                courentValue = hour.getDisplayValue() + ":" + minute.getDisplayValue() + " am";
            }

        }
        else
        {
            if (hour.getValue() == 12)
            {
                courentValue = hour.getValue() + ":" + minute.getDisplayValue() + " pm";
            }
            else
            { 
                if((hour.getValue()-12) <10 )
                {
                    courentValue = "0" + (hour.getValue()-12) + ":" + minute.getDisplayValue() + " pm";
                }
                else
                {
                    courentValue = (hour.getValue()-12) + ":"  + minute.getDisplayValue() + " pm";
                }
            }
        }
    }

}