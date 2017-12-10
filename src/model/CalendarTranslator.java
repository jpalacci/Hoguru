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

}
