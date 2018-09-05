package test.wxutils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
	Timer timer;
    
    public Reminder(int sec){
    	long start = System.currentTimeMillis();  
        timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){
            	long end = System.currentTimeMillis();
            	System.out.println("等待时长："+(end-start)/1000+"s");
                System.out.println("Time's up!");
                System.out.println(new Date());
                timer.cancel();
            }
        }, sec*1000);
    }
}
