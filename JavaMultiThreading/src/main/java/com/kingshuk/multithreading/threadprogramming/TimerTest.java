package com.kingshuk.multithreading.threadprogramming;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: Kingshuk
 * Date: 3/24/15
 * Time: 11:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimerTest {



    public static void main(String[] args) {


        Thread thread=new Thread();
        thread.setName("Notification thread");
        Timer timer = new Timer(thread.getName());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 25);
        Date date = calendar.getTime();
        //timer.schedule(new ReminderTask(),date);
        thread.start();


    }


}
