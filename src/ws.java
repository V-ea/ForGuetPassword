

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.cookie.Cookie;
import org.apache.http.util.EntityUtils;
import ea.util.*;
/**
 * 百度贴吧的发帖及其回贴
 * @author Legend、
 *
 */
public class ws {
	
	static Map<String, String> parameters = new HashMap<String, String>();
	static Map<String, String> headers = new HashMap<String, String>();

	/*     */public static String[] getRegex(String regx, String u, int i) {
		/* 82 */Pattern p = Pattern.compile(regx);
		/* 83 */Matcher m = p.matcher(u);
		/* 84 */int c = 0;
		/* 85 */while (m.find())
		/*     */{
			/* 88 */c++;
			/*     */}
		/* 90 */String[] ret = new String[c];
		/* 91 */m = p.matcher(u);
		/* 92 */c = 0;
		/* 93 */while (m.find())
		/*     */{
			/* 95 */ret[c] = m.group(i);
			/* 96 */c++;
			/*     */}
		/* 98 */return ret;
		/*     */}
	public static void getValidNum() throws ClientProtocolException, IOException
	{
		headers.put("Referer", "http://net.guet.edu.cn/ipmanager/index0.jsp");
		headers.put("Origin", "http://net.guet.edu.cn");
		headers.put("Cache-Control", "max-age=0");
		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9;image/webp,*/*;q=0.8");
		headers.put("Accept-Encoding", "gzip,deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8");
		headers.put("Cache-Control", "max-age=0");
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.111 Safari/537.36");
		
		Result result = SendRequest.sendGet(
		"http://net.guet.edu.cn/ipmanager/index0.jsp", null, parameters,
		"utf-8");
		headers.put("Cookie", result.getCookie());
		String content=EntityUtils.toString(result.getHttpEntity());
		//content=new String(content.getBytes("ISO-8859-1"),"gbk");
		while(result.getStatusCode()==502)
		{
			result = SendRequest.sendGet(
					"http://net.guet.edu.cn/ipmanager/index0.jsp", null,
					parameters, "utf-8");
			headers.put("Cookie", result.getCookie());
			content=EntityUtils.toString(result.getHttpEntity());
		}
		String[] retStrings = getRegex("/ipmanager/servlet/randomnum\\?t=[0-9]{13}", content,0);
		System.out.println(retStrings[0]);
		VerificationcCode.showGetVerificationcCode("http://net.guet.edu.cn"+retStrings[0], headers, "E:\\temp.gif");
	}
	//登陆
	public static  boolean testAccount(String name, String password,String valid) throws ClientProtocolException, IOException {
		
		
		
		parameters.put("validnum", valid);
		parameters.put("passwd", password);
		parameters.put("userid", name);
		Result result2 = SendRequest.sendPost(
				"http://net.guet.edu.cn/ipmanager/home.jsp", headers, parameters,
				"gbk");
		String content = EntityUtils.toString(result2.getHttpEntity());

		if (result2.getStatusCode() != 200) {

			if (result2.getStatusCode() == 502) {
				return testAccount(name, password, valid);
			}
			return false;
		}
		return true;
	}

}
