package net.dev123.mblog.fanfou;

import net.dev123.commons.oauth.config.OAuthConfigurationBase;

public class FanfouOAuthConfiguration extends OAuthConfigurationBase {

	public FanfouOAuthConfiguration() {
		this.setOAuthConsumerKey("OAuthKey");
		this.setOAuthConsumerSecret("OAuthSecret");
		this.setOAuthCallbackURL("http://www.yibo.me/authorize/getAccessToken.action");

		this.setOAuthAccessTokenURL("http://fanfou.com/oauth/access_token");
		this.setOAuthAuthorizeURL("http://fanfou.com/oauth/authenticate");
		this.setOAuthRequestTokenURL("http://fanfou.com/oauth/request_token");
	}

}
