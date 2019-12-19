/**
 * this class controls login security and validation, the hashing method used is SHA 512 for added security
 * and the password has a salt string added for an added level of security
 * there are three methods within this class signup for adding new admins to the system 
 * validate for checking if the password entered is correct and hash for hashing the password
 * @author Abrahim Djordjevic
 *
 */
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class PasswordHash {
	//variable declaration
	static Map HM = new HashMap();
	public static final String SALT = "08sfe64a#se2";
	
	
	public static void signup(String username, String password) {
		String saltPass = password + SALT;
		String hashPass = Hash(saltPass);
		HM.put(username, hashPass);
	}
	
	public static Boolean validate(String username, String password) {
		Boolean validate = false;
		String saltPass = password + SALT;
		String hashPass = Hash(saltPass);
		String storedPass = (String) HM.get(username);
		
		if(hashPass.equals(storedPass)) {
			validate = true;
		}else {
			validate = false;
		}
		return validate;
	}
	
	public static String Hash(String input) {
		String genPassword = null;
		try {
			MessageDigest MD = MessageDigest.getInstance("SHA-512");
			byte [] bytes = MD.digest(input.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			genPassword = sb.toString();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return genPassword;
	}

}
