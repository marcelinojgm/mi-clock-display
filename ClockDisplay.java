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
     * devuelve en String contenido en contenido en corentValue 
     */
    public String getTime()
    {
        return courentValue;
    }

    /**
     * adelanta la fecha un dia
     */
    private void tickDate()
    {
        day.increment();
        
        if (day.getValue() == 0)
        {   
            day.setValue(1);
            month.increment();
            
            if (month.getValue() == 0)
            {
                month.setValue(1);
                year.increment();
            }
        }
        newDate();
    }

    /**
     * adelanta el reloj un min
     */

    public void timeTick()
    {
        minute.increment();
        
        if (minute.getValue() == 0)
        {
            hour.increment();
            
            if (hour.getValue() == 0)
            {
                tickDate();
            }
        }
        updateDisplay();
    }

    /**
     * Devuelve String con la fecha en formato dd/mm/aa
     */ 
    private String newDate()
    {
        String newDate;
        newDate = day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + year.getDisplayValue();
        return newDate;
    }

    
    /**
     * actualizar valor courentValue formato hh:mm am dd/mm/aa
     */
    private void updateDisplay()
    {
        int valueHour    = hour.getValue();
        String newMinute = minute.getDisplayValue();
        String newDate   = newDate();
        
        // formato si es por la mañana
        if(valueHour < 12)
        {   
            String am = "am";
           
            if (valueHour == 0)
            {
                courentValue = "12" + ":" + newMinute + " " + am + " " + newDate();
            }
            else
            {
                courentValue = hour.getDisplayValue() + ":" + newMinute + " " + am + " " + newDate;
            }

        }
        
        //formato si es por la tarde
        else
        {
            String pm = "pm";
            
            if (valueHour == 12)
            {
                courentValue = valueHour + ":" + newMinute + " " + pm + " " + newDate;
            }
            else
            { 
                if((valueHour - 12) < 10 )
                {
                    courentValue = "0" + (valueHour - 12) + ":" + newMinute + " " + pm + " " + newDate;
                }
                else
                {
                    courentValue = (valueHour - 12) + ":"  + newMinute + " " + pm + " " + newDate;
                }
            }
        }
    }

}