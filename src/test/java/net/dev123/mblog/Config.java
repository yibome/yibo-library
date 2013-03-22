package net.dev123.mblog;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.dev123.commons.ServiceProvider;
import net.dev123.commons.http.auth.Authorization;
import net.dev123.commons.http.auth.OAuth2Authorization;
import net.dev123.commons.http.auth.OAuthAuthorization;
import net.dev123.commons.oauth2.OAuth2AccessToken;
import net.dev123.commons.util.EncryptUtil;

public class Config {
    public static final byte[] KEY_BYTES  = { 0x6f, 0x68, 0x6d, 0x79, 0x67, 0x6f, 0x64, 0x21 };

    public static Map<ServiceProvider, Authorization > oauthMap;
    public static final ServiceProvider currentProvider = ServiceProvider.Sina;

    public static String userName = "yibo.m9@gmail.com"; //"yibo.m9@gmail.com";
    public static String password = "yibo2011"; //"yibo2011";
    //来自测试帐号:yibo.m9@gmail.com
    public static final String[][] oauths = {
    	{"", ""},
    	//新浪;
    	{"sd8kykRAs8Th+Q9+3woQFYVbJLrOWoZty7duVLlKRjC7YQIy9zSatQ==", "fSBF/Ti3BwNVTh5PRIJlin5cGJxyo5HNLWQaCiMo2m+7YQIy9zSatQ=="},
    	//搜狐
    	{"aUGClc6OSX7T5aQA5SBLs6R2ivMgfr+GaOifF7ulTUq7YQIy9zSatQ==", "JsVd2rarf24VEbbDOUqztq+zhxIfPkJQzb1H2hujiWK7YQIy9zSatQ=="},
    	//网易:token, secret
    	{"R7gtoZRwGf9wKa1CdPZ1OV6w4KzSFQkqy7hn7aOD/fK7YQIy9zSatQ==", "mHau6hgZHOmqWVJGOKSf0qm21AZA3ZM0lIf5JkVJxBS7YQIy9zSatQ=="},
    	 //腾讯
    	{"a6xCAwy4yLm0WM4cD6e78xetz+nH42Nz/yGd12RmbTW7YQIy9zSatQ==", "k5ebdWtAPHmema0noBiBqrLVKz/wpjv7S5wrlhazZFm7YQIy9zSatQ=="},
    	//twitter
    	{"vkW9vzj0eehuOkcW8Yrxc8pEMs68CsmteNQNXXfnsc4m+5JMibfLXTulZrp7Jj0KDLCvvxPO/kM=", "wNakG7TEzlvCsnCBZaOUW4aLWr9njqCHCGcXniOF7ipZ0fAMTmkMo7HXEFnS+odZ"},
    	//饭否
    	{"hkcsnrezYEYOky/bkp3Hrkom8ugwKE6aJSrT9OToB5vd+xiDDjeAtLthAjL3NJq1", "ZVvJvoOk0QaqJk28TEFG7lxte0khHHM6AKQiJMOAWzi7YQIy9zSatQ=="}
    };

	static {
		oauthMap = new HashMap<ServiceProvider, Authorization >();

	    for (int i = 1; i < oauths.length; i++) {
	    	ServiceProvider sp = getServiceProvider(i);
	    	OAuthAuthorization oauth = null;
			oauth = new OAuthAuthorization(
				EncryptUtil.desDecrypt(oauths[i][0], KEY_BYTES),
				EncryptUtil.desDecrypt(oauths[i][1], KEY_BYTES),
				sp
			);

			oauthMap.put(sp, oauth);
	    }
	    
	    Date expires = new Date(System.currentTimeMillis() + 604799 * 1000);
	    Authorization oauth2Auth = new OAuth2Authorization(new OAuth2AccessToken("2.00tsrVOC0ge6Tu971ff0e93dF_s5FD", expires), ServiceProvider.Sina);
	    oauthMap.put(ServiceProvider.Sina, oauth2Auth);
	}

	public static ServiceProvider getServiceProvider(int providerNo) {
		ServiceProvider[] providers = ServiceProvider.values();
		ServiceProvider sp = null;
		for (ServiceProvider temp : providers) {
			if (temp.getServiceProviderNo() == providerNo) {
				sp = temp;
				break;
			}
		}

		return sp;
	}

	public static MicroBlog getMicroBlog(ServiceProvider sp) {
		MicroBlog mBlog = null;
		if (sp == null) {
			return mBlog;
		}
		Authorization oauth = oauthMap.get(sp);
		mBlog = MicroBlogFactory.getInstance(oauth);
		return mBlog;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < oauths.length; i++) {
	    	ServiceProvider sp = getServiceProvider(i);
			Authorization oauth = null;
			oauth = new OAuthAuthorization(
				EncryptUtil.desDecrypt(oauths[i][0], KEY_BYTES),
				EncryptUtil.desDecrypt(oauths[i][1], KEY_BYTES),
				sp
			);
			System.out.println(sp + ": " + oauth.getAuthToken() + " : " + oauth.getAuthSecret());
	    }
	}

}
