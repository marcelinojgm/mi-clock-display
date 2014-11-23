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
    //año
    private NumberDisplay year;

    //hh:mm am DD/MM/AA
    private String courentValue;

    /**
     * Constructor fija la hora a 00:00 fecha 01/01/01
     */
    public ClockDisplay()
    {
        hour   = new NumberDisplay(24);
        minute = new NumberDisplay(60);
        day    = new NumberDisplay(31);
        month  = new NumberDisplay(13);
        year   = new NumberDisplay(100);

        day.setValue(1);
        month.setValue(1);
        year.setValue(0);

        updateDisplay();       
    }

    /**
     * constructor que fija por parametros la hora
     */
    public ClockDisplay(int newHour, int newMinute, int newDay, int newMonth, int newYear)
    {
        hour   = new NumberDisplay(24);
        minute = new NumberDisplay(60);
        day    = new NumberDisplay(31);
        month  = new NumberDisplay(13);
        year   = new NumberDisplay(100);

        hour.setValue(newHour);
        minute.setValue(newMinute);
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);

        updateDisplay();
    }

    /**
     * fija la hora y fecha en los valores introducidos
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
     * Fija la fecha en los valores introducidos
     */
    public void setDate(int newDay, int newMonth, int newYear)
    {
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);

        updateDisplay();
    }

    /**
     * fija la hora en los valores introducidos
     */

    public void setHour(int newHour, int newMinute)
    {
        hour.setValue(newHour);
        minute.setValue(newMinute);

        updateDisplay();
    }

    
    /**
     * devuelve en tring contenido en contenido en corentValue 
     */
    public String getTime()
    {
        return courentValue;
    }

      /**
     * adelanta el reloj un min
     */

    public void timeTick()
    {
        //cambio de minuto
        minute.increment();
        
        //cambio de hora
        if (minute.getValue() == 0)
        {
            hour.increment();
            
            //cambio de dia
            if (hour.getValue() == 0)
            {
                day.increment();
                
                //cambio de mes
                if (day.getValue() == 0)
                {   
                    day.setValue(1);
                    month.increment();
                    
                    //cambio de año
                    if (month.getValue() == 0)
                    {
                        month.setValue(1);
                        year.increment();
                    }
                }
            }
        }
        updateDisplay();
    }

    /**
     * Devuelve String con la hora y fecha
     */
    private void updateDisplay()
    {
        int valueHour    = hour.getValue();
        String newMinute = minute.getDisplayValue();
        String newHour; 
        String amPm;

        // formato si es por la mañana
        if(valueHour < 12)
        {   
            amPm = "am";

            if (valueHour == 0)
            {
                newHour = "12";
            }
            else
            {
                newHour = hour.getDisplayValue();
            }

        }

        //formato si es por la tarde
        else
        {
            amPm = "pm";

            if (valueHour == 12)
            {
                newHour = "12";
            }
            else if((valueHour - 12) < 10 )
            {
                newHour = "0" + (valueHour - 12);
            }
            else
            {
                newHour = "" + (valueHour - 12);
            }

        }

        // hh:mm am DD/MM/YY
        courentValue = newHour + ":" + newMinute + " " + amPm + " " + day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + year.getDisplayValue();;
    }

}