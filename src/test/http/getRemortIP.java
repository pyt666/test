package test.http;


public class getRemortIP {
	public String getRemortIP(HttpServletRequest request) {  
		  if (request.getHeader("x-forwarded-for") == null) {  
		   return request.getRemoteAddr();  
		  }  
		  return request.getHeader("x-forwarded-for");  
		 } 
}
