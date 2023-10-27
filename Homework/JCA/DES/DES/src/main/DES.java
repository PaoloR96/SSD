package main;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class DES {
	
	private  Cipher myCipher;
	private byte[] myEncryptedBytes;
	private SecretKey myDesKey;
	
	
	
	
	public void DES_CRIPT(byte[] myMessage) throws NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException  {
		//Generating Key
        KeyGenerator Mygenerator = KeyGenerator.getInstance("DES");
        myDesKey = Mygenerator.generateKey();
        
      //initializing crypto algorithm
        myCipher = Cipher.getInstance("DES");

        //setting encryption mode
        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        myEncryptedBytes=myCipher.doFinal(myMessage);
        
        
        String encrypteddata=new String(myEncryptedBytes);
        
        System.out.println("Encrypted - "+ encrypteddata);
		
		
		
		
	}
	
	
	
	public void DES_DECRIPT() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
		
		 //setting decryption mode
        myCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] myDecryptedBytes=myCipher.doFinal(myEncryptedBytes);
        String decrypteddata=new String(myDecryptedBytes);
        System.out.println("Decrypted Message - "+ decrypteddata);
		
		
		
		
	}

}
