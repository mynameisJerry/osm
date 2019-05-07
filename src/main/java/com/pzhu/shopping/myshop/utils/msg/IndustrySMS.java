package com.pzhu.shopping.myshop.utils.msg;



import com.pzhu.shopping.myshop.utils.CodeUtil;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS {
	private static String operation = "/industrySMS/sendSMS";
	private static String accountSid = Config.ACCOUNT_SID;
	/**
	 * 验证码通知短信
	 */
	public static String execute(String to) {
	    String code=  CodeUtil.sms();
		String smsContent = "【小米商城】您的验证码为"+code+"，请于{2}分钟内正确输入，如非本人操作，请忽略此短信。";
		String tmpSmsContent = null;
		String templateid = "1510341760";
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      e.printStackTrace();
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&templateid=" + templateid + "&param="+code
	        + HttpUtil.createCommonParam();
	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
		return code;
	}
}
