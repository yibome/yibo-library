package net.dev123.mblog.sohu;

import net.dev123.commons.oauth.config.OAuthConfigurationBase;

public class SohuOAuthConfiguration extends OAuthConfigurationBase {

	public SohuOAuthConfiguration() {
		this.setOAuthConsumerKey("OAuthKey");
		this.setOAuthConsumerSecret("OAuthSecret");
		this.setOAuthCallbackURL("http://www.yibo.me/authorize/getAccessToken.action");

		this.setOAuthAccessTokenURL("http://api.t.sohu.com/oauth/access_token");
		this.setOAuthAuthorizeURL("http://api.t.sohu.com/oauth/authorize");
		this.setOAuthRequestTokenURL("http://api.t.sohu.com/oauth/request_token");
	}

}
