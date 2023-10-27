package main;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Main {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		
		// TODO Auto-generated method stub
		byte[] Message = " ciao,pippo,napoli,roma,verona ".getBytes(StandardCharsets.UTF_8);
		DES p1= new DES();
		p1.DES_CRIPT(Message);
		p1.DES_DECRIPT();

	}

}