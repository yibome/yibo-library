package net.dev123.oauth;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.dev123.commons.ServiceProvider;
import net.dev123.commons.http.HttpMethod;
import net.dev123.commons.http.HttpRequestHelper;
import net.dev123.commons.http.HttpRequestMessage;
import net.dev123.commons.http.auth.NullAuthorization;
import net.dev123.commons.http.auth.OAuth2AuthorizeHelper;
import net.dev123.commons.oauth2.OAuth2.GrantType;
import net.dev123.commons.oauth2.OAuth2AccessToken;
import net.dev123.exception.LibException;
import net.dev123.exception.LibRuntimeException;
import net.dev123.mblog.sina.SinaErrorAdaptor;
import net.dev123.sns.TokenConfig;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class OAuth2AuthorizeHelperTest {

	@Test
	public void testAuthorizationCode() {
		OAuth2AccessToken accessToken = null;
		try {
			OAuth2AuthorizeHelper oauthHelper = new OAuth2AuthorizeHelper(ServiceProvider.Sina);
			String authorzieUrl = oauthHelper.getAuthorizationUrl(GrantType.AUTHORIZATION_CODE, null);
			System.out.println(authorzieUrl);
			BareBonesBrowserLaunch.openURL(authorzieUrl);
			String code = null;
			while (null == code || code.trim().length() == 0) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Please Enter Authorization Code : ");
				code = br.readLine();
			}
			accessToken = oauthHelper.getAccessTokenByAuthorizationCode(code, null);
			//accessToken = oauthHelper.getAccessTokenByRefreshToken(accessToken.getRefreshToken(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(accessToken);
	}

	@Test
	public void testImplicitGrant() {
		OAuth2AccessToken accessToken = null;
		try {
			OAuth2AuthorizeHelper oauthHelper = new OAuth2AuthorizeHelper(TokenConfig.currentProvider);
			String authorzieUrl = oauthHelper.getAuthorizationUrl(GrantType.IMPLICIT, null);
			BareBonesBrowserLaunch.openURL(authorzieUrl);
			String url = null;
			while (null == url || url.trim().length() == 0) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Please Enter implicit Callback : ");
				url = br.readLine();
			}
			accessToken = OAuth2AuthorizeHelper.retrieveAccessTokenFromFragment(url);
			System.out.println(accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(accessToken);
	}
	
	@Test
	public void testImpl() throws LibException {
		HttpRequestMessage httpRequestMessage = new HttpRequestMessage(HttpMethod.POST, AUTHORIZE, new NullAuthorization(ServiceProvider.Sina));
		httpRequestMessage.addParameter("userId", "raise007");
		httpRequestMessage.addParameter("passwd", "cauc24097410");
		httpRequestMessage.addParameter("action", "submit");
		httpRequestMessage.addParameter("display", "wap1.2");
		httpRequestMessage.addParameter("redirect_uri", "http://www.yibo.me/authorize/getAccessToken.do");
		httpRequestMessage.addParameter("client_id", "834484950");
		httpRequestMessage.addParameter("response_type", "token");
		httpRequestMessage.addHeader("Referer", AUTHORIZE);
		
		String response = HttpRequestHelper.execute(httpRequestMessage, new ResponseHandler<String>() {
			public String handleResponse(final HttpResponse response) throws HttpResponseException, IOException {
				StatusLine statusLine = response.getStatusLine();
				HttpEntity entity = response.getEntity();
				String responseString = (entity == null ? null : EntityUtils.toString(entity));

				if (statusLine.getStatusCode() >= 300) {
					LibRuntimeException apiException =  SinaErrorAdaptor.parseError(responseString);
					throw apiException;
				}
				return responseString;
			}
		});
		
		System.out.println(response);
	}

	public static final String AUTHORIZE = "https://api.weibo.com/oauth2/authorize";

    public static final String REDIRECT_URI = "https://api.weibo.com/oauth2/default.html";

}
