package net.dev123.mblog.twitter;

import net.dev123.commons.oauth.config.OAuthConfigurationBase;

public class TwitterOAuthConfiguration extends OAuthConfigurationBase {

	public TwitterOAuthConfiguration() {
		this.setOAuthConsumerKey("OAuthKey");
		this.setOAuthConsumerSecret("OAuthSecret");
		this.setOAuthCallbackURL("http://www.yibo.me/authorize/getAccessToken.action");

		this.setOAuthAccessTokenURL("https://api.twitter.com/oauth/access_token");
		this.setOAuthAuthorizeURL("https://api.twitter.com/oauth/authorize");
		this.setOAuthRequestTokenURL("https://api.twitter.com/oauth/request_token");
	}

}
