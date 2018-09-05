package test.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;



class test {
	
	
	@Test
	void testtt() {
		float a = (float) 1.8799999;
		System.out.println(a);
		System.out.println((float)(Math.round(a*100))/100);
	}
	@Test
	void test() {
		Date dateEnd = new Date();//当前时间
		dateEnd.setHours(24);
		dateEnd.setMinutes(0);
		dateEnd.setSeconds(0);
		Date dateStart = new Date();//今日零点
		dateStart.setDate(dateStart.getDate()-2);
		dateStart.setHours(0);
		dateStart.setMinutes(0);
		dateStart.setSeconds(0);
		long mm = dateEnd.getTime()  - dateStart.getTime();
		System.out.println("共有"+mm/1000/60/60+"小时");
		
		System.out.println(dateEnd);
		
		System.out.println(dateStart);
	}
	
	@Test
	void test1() {
		Properties prop = new Properties();
		String[] DOString = new String[3];
		String[] pHString = new String[4];
		String[] WTString = new String[3];
		try {
			prop.load(new FileInputStream("src/diagnosing.properties"));
			 Enumeration enum1 = prop.propertyNames();//得到配置文件的名字
			         while(enum1.hasMoreElements()) {
			        	 String strKey = (String) enum1.nextElement();
			        	 if(strKey.contains("DOString")) {
			        		 int number = Integer.parseInt(strKey.substring(strKey.length()-1, strKey.length()));
			        		 DOString[number] = new String(prop.getProperty(strKey).getBytes("ISO-8859-1"),"utf-8");
			        	 }else if(strKey.contains("WTString")){
			        		 int number = Integer.parseInt(strKey.substring(strKey.length()-1, strKey.length()));
			        		 WTString[number] = new String(prop.getProperty(strKey).getBytes("ISO-8859-1"),"utf-8");
			        	 }else if(strKey.contains("pHString")) {
			        		 int number = Integer.parseInt(strKey.substring(strKey.length()-1, strKey.length()));
			        		 pHString[number] = new String(prop.getProperty(strKey).getBytes("ISO-8859-1"),"utf-8");
			        	 }			        
			        }
			         for(int i= 0;i<DOString.length;i++) {
			        	 System.out.println(DOString[i]);
			         }
			         for(int j= 0;j<pHString.length;j++) {
			        	 System.out.println(pHString[j]);
			         }
			         for(int k= 0;k<WTString.length;k++) {
			        	 System.out.println(WTString[k]);
			         }
			        
			        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
/*	ResourceBundle resource = ResourceBundle.getBundle("diagnosing");*/
	
	@Test
	void testDia() {
		Properties prop = new Properties();
		ResourceBundle resource = ResourceBundle.getBundle("diagnosing");
		String[] DOString = new String[3];
		String[] pHString = new String[4];
		String[] WTString = new String[3];
		try {
			WTString[0] = new String(resource.getString("WTString0").getBytes("ISO-8859-1"),"utf-8");
			WTString[1] = new String(resource.getString("WTString1").getBytes("ISO-8859-1"),"utf-8");
			WTString[2] = new String(resource.getString("WTString2").getBytes("ISO-8859-1"),"utf-8");
			DOString[0] = new String(resource.getString("DOString0").getBytes("ISO-8859-1"),"utf-8");
			DOString[1] = new String(resource.getString("DOString1").getBytes("ISO-8859-1"),"utf-8");
			DOString[2] = new String(resource.getString("DOString2").getBytes("ISO-8859-1"),"utf-8");
			pHString[0] = new String(resource.getString("pHString0").getBytes("ISO-8859-1"),"utf-8");
			pHString[1] = new String(resource.getString("pHString1").getBytes("ISO-8859-1"),"utf-8");
			pHString[2] = new String(resource.getString("pHString2").getBytes("ISO-8859-1"),"utf-8");
			pHString[3] = new String(resource.getString("pHString3").getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i= 0;i<DOString.length;i++) {
        	 System.out.println(DOString[i]);
         }
         for(int j= 0;j<pHString.length;j++) {
        	 System.out.println(pHString[j]);
         }
         for(int k= 0;k<WTString.length;k++) {
        	 System.out.println(WTString[k]);
         }
	}
	@Test
	void test2() {
		System.out.println("**********");
		Date date = new Date();
		System.out.println(date.getDate());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd");
		String dataFormat1 = sdf1.format(date);
		String dataFormat2  = sdf2.format(date);
		String dates = sdf3.format(date);
		String dataFormatEnd = dataFormat1+"-"+dates+"T"+dataFormat2;
		date.setDate(date.getDate()-2);
		dates = sdf3.format(date);
		String dataFormatStart = dataFormat1+"-"+dates+"T00:00:00";
		System.out.println(dataFormatStart);
		System.out.println(dataFormatEnd);
	}
	@Test
	void test3() {
        String s = "施小🐟自制力🍥" ;
       s= filterEmoji(s);
        
        System.out.println(s);
	}
	public static String filterEmoji(String nick_name) {
	    //nick_name 所获取的用户昵称 
	    if (nick_name == null) {
	        return nick_name;
	    }
	    Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
	            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
	    Matcher emojiMatcher = emoji.matcher(nick_name);
	    if (emojiMatcher.find()) {
	        //将所获取的表情转换为*
	        nick_name = emojiMatcher.replaceAll("*");
	        return nick_name;
	    }
	    return nick_name;
	}
	
	@Test
	void test4() {

		
		Date dateEnd = new Date();//当前时间
		Date dateStart = new Date();//今日零点
		dateStart.setHours(0);
		dateStart.setMinutes(0);
		dateStart.setSeconds(0);
		int min = dateEnd.getHours()*60 + dateEnd.getMinutes();
		System.out.println("开始时间："+dateStart);
		System.out.println("结束时间："+dateEnd);
		System.out.println("相差min为："+min/20);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		for(int i = 0 ; i<(min/20+1) ; i++) {
			Date dateStart1 = new Date();
			dateStart1.setTime(dateStart.getTime());
			dateStart1.setMinutes(dateStart1.getMinutes()-3);
			Date dateEnd1 = new Date();
			dateEnd1.setTime(dateStart.getTime());
			dateEnd1.setMinutes(dateEnd1.getMinutes()+3);
			System.out.println("+++++++++++++++");
			String start = sdf1.format(dateStart1) + "T" + sdf2.format(dateStart1);
			String end = sdf1.format(dateEnd1) + "T" + sdf2.format(dateEnd1);	
			System.out.println("开始时间："+start);
			System.out.println("结束时间："+end);
			dateStart.setMinutes(dateStart.getMinutes()+20);
		}
	}
	@Test
	void test5() {
		/*Date date = new Date();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataFormat2  = sdf2.format(date);
		System.out.println(dataFormat2);
		
		date.setMinutes(date.getMinutes()-60);
		String dataFormat3  = sdf2.format(date);
		System.out.println(dataFormat3);
		
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		String dataFormat4  = sdf2.format(date);
		System.out.println(dataFormat4);*/
		
		Date dateEnd = new Date();//当前时间
		Date dateStart = new Date();//今日零点
		dateStart.setHours(0);
		dateStart.setMinutes(0);
		dateStart.setSeconds(0);
		System.out.println(dateEnd);
		System.out.println(dateStart);
		dateStart.setTime(dateEnd.getTime());
		System.out.println(dateStart);
		/*int min = dateEnd.getHours()*60 + dateEnd.getMinutes();
		System.out.println("相差min为："+min/20);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		for(int i = 0 ; i<min/20 ; i++) {
			Date dataStart1 = new Date();
			dataStart1.setTime(dataStart.getTime());
			Date dateEnd1 = new Date();
			String start = sdf1.format(dataStart) + "T" + sdf2.format(dataStart);
			
			
			dataStart.setMinutes(dataStart.getMinutes()+20);
			String end = sdf1.format(dataStart) + "T" + sdf2.format(dataStart);	

		}*/
		
		/*Date start = new Date();
		start = dataStart;
		start.setHours(1);
		System.out.println(start);
		System.out.println(dataStart);*/
	}
	@Test
	void test6() {
		String text = "KM1:1";
		System.out.println(text);
		String id = text.substring(0,3);
		System.out.println(id);
	}

}
