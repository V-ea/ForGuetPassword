package ea.util;



import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

/**
 * 封住请求返回的参数
 * @author Legend、
 *
 */

public class Result {
    
	private String cookie;
	private int statusCode;
	private HashMap<String, Header> headerAll;
	private HttpEntity httpEntity;
	
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public HashMap<String, Header> getHeaders() {
		return headerAll;
	}
	
	public void setHeaders(Header[] headers){
		headerAll = new HashMap<String, Header>();
		for (Header header : headers) {
			headerAll.put(header.getName(), header);
		}
	}
	public HttpEntity getHttpEntity() {
		return httpEntity;
	}
	@Override
	public String toString() {
		try {
			String HeaderString ="(";
			Object[] keys=headerAll.keySet().toArray();
			for(Object key : keys)
			{
				String key_=(String)key;
				HeaderString+=key_+":";
				HeaderString+=headerAll.get(key_).getValue();
				HeaderString+=";";
			}
			HeaderString+=");";
			return "Result [cookie=" + cookie + ", statusCode=" + statusCode
					+ ", headerAll=" + HeaderString + ", httpEntity=" + httpEntity.getContent()
					+ "]";
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public void setHttpEntity(HttpEntity httpEntity) {
		this.httpEntity = httpEntity;
	}
}

