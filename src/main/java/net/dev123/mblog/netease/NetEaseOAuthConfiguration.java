package net.dev123.mblog.netease;

import net.dev123.commons.oauth.config.OAuthConfigurationBase;

public class NetEaseOAuthConfiguration extends OAuthConfigurationBase {

	public NetEaseOAuthConfiguration() {
		this.setOAuthConsumerKey("OAuthKey");
		this.setOAuthConsumerSecret("OAuthSecret");
		this.setOAuthCallbackURL("http://www.yibo.me/authorize/getAccessToken.action");

		this.setOAuthAccessTokenURL("http://api.t.163.com/oauth/access_token");
		this.setOAuthAuthorizeURL("http://api.t.163.com/oauth/authenticate");
		this.setOAuthRequestTokenURL("http://api.t.163.com/oauth/request_token");
	}

}
