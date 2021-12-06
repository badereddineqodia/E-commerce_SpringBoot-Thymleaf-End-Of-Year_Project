package com.example.demo.metier;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component; 

// Java program to calculate MD5 hash value 

@Component
public class MD5Hash  implements HASH{ 
	@Override
	public  String getMd5(String input) 
	{ 
		try { 

			// Static getInstance method is called with hashing MD5 
			MessageDigest md = MessageDigest.getInstance("MD5"); 

			// digest() method is called to calculate message digest 
			// of an input digest() return array of byte 
			
			byte[] messageDigest = md.digest(input.getBytes()); 

			// Convert byte array into signum representation 
			
			BigInteger no = new BigInteger(1, messageDigest); 

			// Convert message digest into hex value 
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		} 

		// For specifying wrong message digest algorithms 
		    catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	} 


} 
