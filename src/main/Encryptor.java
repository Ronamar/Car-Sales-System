package main;

public class Encryptor {

	
	public static String Encrypt(String source){
		
		int hash = 7;
		for (int i = 0; i < source.length(); i++) {
		    hash = hash*31 + source.charAt(i);
		}
		
		return Integer.toString(hash);
		
	}
	
}
