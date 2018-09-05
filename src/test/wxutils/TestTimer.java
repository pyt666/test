package test.wxutils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    
    public static void main(String args[]){
    	System.out.println(new Date());
        System.out.println("About to schedule task.");             
        System.out.println("Task scheduled.");
        new HighlimitTrigger(1,"testDev","KM1:1","123456");
    }
}
