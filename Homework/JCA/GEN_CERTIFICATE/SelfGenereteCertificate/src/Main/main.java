package Main;

import java.security.cert.X509Certificate;

public class main {

	public static void main(String[] args) throws Exception {
		 SelfSignedCertificate signedCertificate = new SelfSignedCertificate();
		 signedCertificate.createCertificate(); 

	}

}
