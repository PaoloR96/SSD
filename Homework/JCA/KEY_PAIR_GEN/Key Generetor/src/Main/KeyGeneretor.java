package Main;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
public class KeyGeneretor {
		public void GenereteKeys() throws NoSuchAlgorithmException {
			
			//Creating KeyPair generator object
		      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
		      
		      //Initializing the KeyPairGenerator
		      keyPairGen.initialize(2048);
		      
		      //Generating the pair of keys
		      KeyPair pair = keyPairGen.generateKeyPair();
		      
		      //Getting the private key from the key pair
		      PrivateKey privKey = pair.getPrivate();   
		      
		      //Getting the public key from the key pair
		      PublicKey publicKey = pair.getPublic(); 
		      //System.out.println("Keys generated");
		      System.out.println("publicKey");
		      System.out.println(publicKey.getEncoded());
		      System.out.println("privKey");
		      System.out.println(privKey.getEncoded());
		      
		}

}
