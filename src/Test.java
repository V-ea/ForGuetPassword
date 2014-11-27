import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import ea.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			VerificationcCode.showGetVerificationcCode("https://ssl.captcha.qq.com/getimage?aid=501004106&r=0.42116209026426077&uin=390270720", null, "E:\\123.jpg");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
