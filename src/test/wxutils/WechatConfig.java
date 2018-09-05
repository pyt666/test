package test.wxutils;

public class WechatConfig {
	private String access_token;//用于调用公众平台API
	private String expires_in;//设置access_token的有效期，7200秒(即120分钟即2小时)以内	
	//开发者可以使用 AppID 和 AppSecret 调用本接口来获取 access_token
	private String AppID = "wx2df4d1448e6d2df3";
	private String AppSecret = "78c7eb48609eb23706bcd089916b16cc";
	//获取access_token接口地址
	//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	//grant_type=client_credential,赋权类型
	private String getAccess_token="https://api.weixin.qq.com/cgi-bin/token";
	public String getAccess_token() {
		String grant_type = "client_credential";
		
		
		
		return "1";
	}
	

}
