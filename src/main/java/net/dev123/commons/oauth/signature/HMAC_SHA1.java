package net.dev123.commons.oauth.signature;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import net.dev123.commons.Constants;
import net.dev123.commons.oauth.OAuth;
import net.dev123.commons.oauth.OAuthException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HMAC-SHA1 签名方法.
 */
class HMAC_SHA1 extends OAuthSignatureMethod {

	private static final Logger logger = LoggerFactory.getLogger(HMAC_SHA1.class.getSimpleName());

	private static final String ENCODING = OAuth.ENCODING;

	private static final String MAC_NAME = "HmacSHA1";

	private SecretKey key = null;

	@Override
	protected String getSignature(String baseString) throws OAuthException {
		try {
			String signature = base64Encode(computeSignature(baseString));
			return signature;
		} catch (GeneralSecurityException e) {
			throw new OAuthException(e);
		} catch (UnsupportedEncodingException e) {
			throw new OAuthException(e);
		}
	}

	@Override
	protected boolean isValid(String signature, String baseString) throws OAuthException {
		try {
			byte[] expected = computeSignature(baseString);
			byte[] actual = decodeBase64(signature);
			return equals(expected, actual);
		} catch (GeneralSecurityException e) {
			throw new OAuthException(e);
		} catch (UnsupportedEncodingException e) {
			throw new OAuthException(e);
		}
	}

	private byte[] computeSignature(String baseString) throws GeneralSecurityException, UnsupportedEncodingException {
		SecretKey key = null;
		synchronized (this) {
			if (this.key == null) {
				String keyString = OAuth.percentEncode(getConsumerSecret()) + '&'
						+ OAuth.percentEncode(getTokenSecret());
				if (Constants.DEBUG) {
					logger.debug("OAuth KeyString {}", keyString);
				}
				byte[] keyBytes = keyString.getBytes(ENCODING);
				this.key = new SecretKeySpec(keyBytes, MAC_NAME);
			}
			key = this.key;
		}
		Mac mac = Mac.getInstance(MAC_NAME);
		mac.init(key);
		byte[] text = baseString.getBytes(ENCODING);
		return mac.doFinal(text);
	}

	@Override
	public void setConsumerSecret(String consumerSecret) {
		synchronized (this) {
			key = null;
		}
		super.setConsumerSecret(consumerSecret);
	}

	@Override
	public void setTokenSecret(String tokenSecret) {
		synchronized (this) {
			key = null;
		}
		super.setTokenSecret(tokenSecret);
	}

}
