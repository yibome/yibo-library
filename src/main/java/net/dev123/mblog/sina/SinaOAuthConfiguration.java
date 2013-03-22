package net.dev123.mblog.sina;

import net.dev123.commons.oauth.config.OAuthConfigurationBase;

public class SinaOAuthConfiguration extends OAuthConfigurationBase {

	public SinaOAuthConfiguration() {
		this.setOAuthConsumerKey("OAuthKey");
		this.setOAuthConsumerSecret("OAuthSecret");
		this.setOAuthCallbackURL("http://www.yibo.me/authorize/getAccessToken.do");

		//this.setOAuthRequestTokenURL("http://api.t.sina.com.cn/oauth/request_token");
		this.setOAuthAuthorizeURL("https://api.weibo.com/oauth2/authorize?display=mobile");
		this.setOAuthAccessTokenURL("https://api.weibo.com/oauth2/access_token");
	}

}
