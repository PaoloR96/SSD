package Main;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.X509Certificate;
import java.sql.Date;

import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;
public class SelfSignedCertificate {
	 	private static final String CERTIFICATE_ALIAS = "SSD_CERTIFICATE";
	    private static final String CERTIFICATE_ALGORITHM = "RSA";
	    private static final String CERTIFICATE_DN = "CN=cn, O=o, L=L, ST=il, C= c";
	    private static final String CERTIFICATE_NAME = "SSD.pem";
	    private static final int CERTIFICATE_BITS = 1024;
	    static {
	        // adds the Bouncy castle provider to java security
	        Security.addProvider(new BouncyCastleProvider());
	    }
	
	    public X509Certificate createCertificate() throws Exception{
		 
	    		X509Certificate cert = null;
	    		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(CERTIFICATE_ALGORITHM);
	    		keyPairGenerator.initialize(CERTIFICATE_BITS, new SecureRandom());
	    		KeyPair keyPair = keyPairGenerator.generateKeyPair();
	    		
	            // GENERATE THE X509 CERTIFICATE
	            X509V3CertificateGenerator v3CertGen =  new X509V3CertificateGenerator();
	            v3CertGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
	            v3CertGen.setIssuerDN(new X509Principal(CERTIFICATE_DN));
	            v3CertGen.setNotBefore(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24));
	            v3CertGen.setNotAfter(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 365*10)));
	            v3CertGen.setSubjectDN(new X509Principal(CERTIFICATE_DN));
	            v3CertGen.setPublicKey(keyPair.getPublic());
	            v3CertGen.setSignatureAlgorithm("SHA256WithRSAEncryption");
	            cert = v3CertGen.generateX509Certificate(keyPair.getPrivate());
	            saveCert(cert,keyPair.getPrivate());
	    		return cert;
		 
	 }
	    
	     private void saveCert(X509Certificate cert, PrivateKey key) throws Exception {
	        KeyStore keyStore = KeyStore.getInstance("JKS");    
	        keyStore.load(null, null);
	        keyStore.setKeyEntry(CERTIFICATE_ALIAS, key, "paolo".toCharArray(),  new java.security.cert.Certificate[]{cert});
	        File file = new File(".", CERTIFICATE_NAME);
	        keyStore.store( new FileOutputStream(file), "paolo".toCharArray() );
	    }
	

}
