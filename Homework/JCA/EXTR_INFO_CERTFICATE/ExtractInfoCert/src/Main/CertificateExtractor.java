package Main;
import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
public class CertificateExtractor {
		public void CertificateExtractor() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
			KeyStore keyStore = KeyStore.getInstance("JKS"); 
			// keystore password is required to access keystore
            char[] pass = ("paolo").toCharArray();
            InputStream is= new FileInputStream("C:\\Users\\Utente\\Desktop\\Ssd\\Pratica\\JCA\\EXTR_INFO_CERTFICATE\\ExtractInfoCert\\certificato\\SSD.pem");
            // initializing keystore object
            keyStore.load(is, pass);
            
            X509Certificate cert= (X509Certificate)keyStore.getCertificate("SSD_CERTIFICATE");
            //System.out.println("Certificate version : "+ cert.getVersion());
            System.out.println("Certificate Info : "+ cert.toString());
            
			
		}
}
