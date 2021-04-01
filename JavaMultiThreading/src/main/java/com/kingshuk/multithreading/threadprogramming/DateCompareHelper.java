package com.kingshuk.multithreading.threadprogramming;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: co21321
 * Date: 3/25/15
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateCompareHelper {

    public boolean dateCompare() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 17);
        calendar1.set(Calendar.MINUTE,41);
        //calendar1.set(Calendar.SECOND, 00);
        Date date1 = calendar1.getTime();
        Date date = calendar.getTime();
        String format = "MM/dd/yyyy HH mm ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        System.out.println("Current time is: "+dateFormat.format(date));    //Current date printing
        System.out.println("The RAFT Job timing is: "+dateFormat.format(date1));   //Set date Printing
        System.out.println(calendar.compareTo(calendar1));

        return calendar.compareTo(calendar1) >= 0;
    }
}
