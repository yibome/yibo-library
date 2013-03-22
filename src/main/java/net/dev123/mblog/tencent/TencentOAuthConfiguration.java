package net.dev123.mblog.tencent;

import net.dev123.commons.oauth.OAuthParameterStyle;
import net.dev123.commons.oauth.config.OAuthConfigurationBase;

public class TencentOAuthConfiguration extends OAuthConfigurationBase {

	public TencentOAuthConfiguration() {
		this.setOAuthConsumerKey("OAuthKey");
		this.setOAuthConsumerSecret("OAuthSecret");
		this.setOAuthCallbackURL("http://www.yibo.me/authorize/getAccessToken.action");

		this.setOAuthAccessTokenURL("http://open.t.qq.com/cgi-bin/access_token");
		this.setOAuthAuthorizeURL("http://open.t.qq.com/cgi-bin/authorize");
		this.setOAuthRequestTokenURL("http://open.t.qq.com/cgi-bin/request_token");

		this.setOAuthParameterStyle(OAuthParameterStyle.QUERY_STRING.toString());
	}

}
