package model;

import java.util.Calendar;

public class CalendarTranslator {

    public static String calendarToString(Calendar c)
    {
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int day = c.get(Calendar.DAY_OF_MONTH);

            char hyphen = '-';

            StringBuilder sb = new StringBuilder();
            sb.append(year);
            sb.append(hyphen);
            sb.append(month);
            sb.append(hyphen);
            sb.append(day);

            return sb.toString();

    }
    
    public static Calendar stringToCalendar(String s)
    {
           Calendar c = Calendar.getInstance();
           int date, month, year;
           try{
        	   date = Integer.parseInt(s.substring(0,2));
        	   month = Integer.parseInt(s.substring(3,5));
        	   year = Integer.parseInt(s.substring(6,10));
           }catch(Exception e1){
        	   return null;
           }
           c.set(year, month, date);
           return c;
    }

}
