package test.wxutils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



public class HighlimitTrigger {
	Timer timer;
	
    
    public HighlimitTrigger(int sec,final String device_sn,final String text,final String publicOpenID){
        timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){            	
                //关闭增氧机
            	/*int results = CMDUtils.sendStrCmd(device_sn,text);							
				if(results==0) {
					WechatSendMessageUtils.sendWechatOnOffMessages("高限增氧结束，关闭增氧机成功", publicOpenID,device_sn);
				}else {//打开
					WechatSendMessageUtils.sendWechatOnOffMessages("高限增氧结束，关闭增氧机失败", publicOpenID, device_sn);
				}*/
            	System.out.println(device_sn+"命令："+text+"，发送给"+publicOpenID);
                timer.cancel();
            }
        }, sec*1000);
    }
}
