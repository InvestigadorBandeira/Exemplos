package br.com.sistema.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;

public class PWSec {

    private static SecretKey skey;
    private static KeySpec ks;
    private static PBEParameterSpec ps;
    private static final String algorithm = "PBEWithMD5AndDES";
    private static Base64 codec = new Base64();

    static {
	try {
	    SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
	    ps = new PBEParameterSpec(new byte[] { 3, 1, 4, 1, 5, 9, 2, 6 }, 20);

	    // esta é a chave que você quer manter secreta. "EAlGeEen3/m8/YkO"
	    // Obviamente quando você for implantar na sua empresa, use alguma
	    // outra coisa - por exemplo,
	    // "05Bc5hswRWpwp1sew+MSoHcj28rQ0MK8". Nao use caracteres especiais
	    // (como ç) para nao dar problemas.
	    ks = new PBEKeySpec("EAlGeEen3/m8/YkO".toCharArray());

	    skey = skf.generateSecret(ks);
	} catch (java.security.NoSuchAlgorithmException ex) {
	    ex.printStackTrace();
	} catch (java.security.spec.InvalidKeySpecException ex) {
	    ex.printStackTrace();
	}
    }

    public static final String encrypt(final String text)
	    throws NoSuchAlgorithmException, NoSuchPaddingException,
	    InvalidKeyException, InvalidAlgorithmParameterException,
	    IllegalBlockSizeException, BadPaddingException, EncoderException {

	Cipher cipher;
	cipher = Cipher.getInstance(algorithm);
	cipher.init(Cipher.ENCRYPT_MODE, skey, ps);
	return codec.encodeToString(cipher.doFinal(text.getBytes()));
    }

    public static final String decrypt(final String text)
	    throws NoSuchAlgorithmException, NoSuchPaddingException,
	    InvalidKeyException, InvalidAlgorithmParameterException {
	final Cipher cipher = Cipher.getInstance(algorithm);
	cipher.init(Cipher.DECRYPT_MODE, skey, ps);
	String ret = null;
	try {
	    ret = new String(cipher.doFinal(codec.decode(text)));
	} catch (IllegalBlockSizeException | BadPaddingException ex) {
	    // ex.printStackTrace();
	}

	return ret;
    }
}
