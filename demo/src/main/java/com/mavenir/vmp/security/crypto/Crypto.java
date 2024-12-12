package com.mavenir.vmp.security.crypto;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.base.Throwables;
import com.google.common.io.BaseEncoding;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import java.util.List;

/**
 * Service for encrypting and decrypting confidential information.
 *
 * Service support multiple versions of decryption methods and can be used to decrypt strings
 * encrypted with the older versions.
 *
 * Encryption on the other hand is always performed by using the latest version of the service.
 *
 */
@Service
public class Crypto {

	/**
	 * Current service version.
	 */
	private static final String VERSION = "1";

	/**
	 * Character for separating different segment of encrypted string.
	 */
	private static final char SEPARATOR = '|';

	/**
	 * Encryption algorithm.
	 */
	private static final String ALGORITHM = "AES";

	/**
	 * Encryption transformation.
	 */
	private static final String TRANSFORMATION = ALGORITHM + "/GCM/NoPadding";

	/**
	 * Encoding for transforming between raw bytes and text.
	 */
	private static final BaseEncoding ENCODING = BaseEncoding.base64().omitPadding();

	/** Security provider. */
	private final Provider provider;

	/**
	 * Encryption key.
	 */
	private final Key key;

	public Crypto() {
		byte[] material = {126, 16, 106, -69, -73, 7, -25, 13, -37, 33, -57, 64, -115, -23, -83, -70};
		this.provider = new BouncyCastleProvider();
		this.key = new SecretKeySpec(material, ALGORITHM);
	}

	/**
	 * Returns encrypted string.
	 *
	 * @param string string to encrypt
	 */
	public String encrypt(String string) {
		try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION, provider);
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] cipherbytes = cipher.doFinal(string.getBytes(Charsets.UTF_8));
			byte[] iv = cipher.getIV();

			return VERSION + SEPARATOR + ENCODING.encode(iv) + SEPARATOR + ENCODING.encode(cipherbytes);
		} catch (GeneralSecurityException e) {
			throw Throwables.propagate(e);
		}
	}

	/**
	 * Returns decrypted string.
	 *
	 * @param string string to decrypt
	 */
	public String decrypt(String string) {
		List<String> parts = Splitter.on(SEPARATOR).limit(2).splitToList(string);
		String version = parts.get(0);
		String data = parts.get(1);

		if (version.equals("0")) {
			return decryptV0(data);
		} else if (version.equals("1")) {
			return decryptV1(data);
		} else {
			throw new IllegalArgumentException("Unsupported version: " + version);
		}
	}

	/**
	 * Returns decrypted version 0 string.
	 *
	 * Version 0 is a dummy encryption that returns unmodified strings. It is only suitable for
	 * development and testing environments.
	 *
	 * @param string version 0 string to decrypt
	 */
	private String decryptV0(String string) {
		return string;
	}

	/**
	 * Returns decrypted version 0 string.
	 *
	 * Version 1 uses real encryption and is suitable for production environments.
	 *
	 * @param string version 1 string to decrypt
	 */
	private String decryptV1(String string) {
		List<String> parts = Splitter.on(SEPARATOR).splitToList(string);
		byte[] iv = ENCODING.decode(parts.get(0));
		byte[] cipherbytes = ENCODING.decode(parts.get(1));

		try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION, provider);
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
			return new String(cipher.doFinal(cipherbytes), Charsets.UTF_8);
		} catch (GeneralSecurityException e) {
			throw Throwables.propagate(e);
		}
	}

}
