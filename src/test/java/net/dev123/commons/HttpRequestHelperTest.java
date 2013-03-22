package net.dev123.commons;

import net.dev123.commons.http.HttpRequestHelper;
import net.dev123.commons.util.EncryptUtil;
import net.dev123.commons.util.StringUtil;
import net.dev123.exception.LibException;

import org.junit.Test;

public class HttpRequestHelperTest {

	@Test
	public void testGetRedirectUrl() throws LibException, InterruptedException {
		String[] tinyUrls = {
//				"http://t.cn/SPS3OY",
//				"http://t.cn/SPoMrj",
//				"http://t.cn/SPKkgD",
//				"http://t.cn/SvBeWz",
//				"http://url.cn/0461YX",
//				"http://url.cn/3GWIU5",
//				"http://url.cn/021cSo",
//				"http://t.cn/SP9GlF",
//				"http://t.cn/SP6bN2",
//				"http://t.cn/asZB7q",
//				"http://t.cn/akpezq",
//				"http://t.cn/SP9wpM",
//				"http://t.cn/SPp5G5",
//				"http://t.cn/aFxZmU",
//				"http://t.cn/SPad6z",
//				"http://t.cn/Svdt2K",
//				"http://t.cn/aQSYRO",
				"http://url.cn/14smzN?type=1&from=19&u=weiwei5297&s=3&f=1&skey=",
				"http://url.cn/40tYij?type=1&from=19&u=weiwei5297&s=1077&f=1&skey=",
				"http://url.cn/40JavY?type=1&from=19&u=weiwei5297&s=1010&f=1&skey=",
				"http://url.cn/0FMzBj?type=1&from=19&u=weiwei5297&s=1077&f=1&skey=",
				"http://url.cn/1JJZyk?type=1&from=19&u=weiwei5297&s=1010&f=1&skey=",
				"http://url.cn/3ORFid?type=1&from=19&u=weiwei5297&s=3&f=1&skey=",
				"http://url.cn/04L4cb?type=1&from=19&u=weiwei5297&s=1010&f=1&skey=",
				"http://url.cn/2cWNEk?type=1&from=19&u=weiwei5297&s=3&f=1&skey=",
				"http://url.cn/1nwhig?type=1&from=19&u=weiwei5297&s=1010&f=1&skey=",
				"http://url.cn/0ehMgB?type=1&from=19&u=weiwei5297&s=1010&f=1&skey="

		};

		for (int i = 0; i < tinyUrls.length; i++ ) {
			Thread.sleep(500);
			long start = System.currentTimeMillis();
			System.out.println("start:" + start);
			System.out.println(i + " " + HttpRequestHelper.getRedirectUrl(tinyUrls[i]));
			System.out.println("spend: " + (System.currentTimeMillis() - start));
		}
	}
	
	@Test
	public void testEncrypt() {
		String[] accounts = {
				"1	1	6qeLHb+ySTMrXcsd+bSKSbWj3KSeG6cUIZ7bt84bI727YQIy9zSatQ==	Eei5xtCWatDi6xQL1XLaBEaCkLRp4H2seshb9obHZ7q7YQIy9zSatQ==	1	-1	NULL	YiBoClient	YiBo微博客户竿4	d793a554c70746e5bf2c8c18f91845d5	e7d311a073b653c0ef4bdd63183820ea	0	0	1312862361000	NULL	NULL",
				"2	2	KWJVmxn/C9VREmqBi1pqgoHPgkk2uee2cKhBvSz5+2a7YQIy9zSatQ==	p8BWmtq94Zo5uh7YIvXssZc4Cf0L/Nx8LXqENpRpxq27YQIy9zSatQ==	1	-1	NULL	1257818535	NeoCN	1	3105114937	985e8f106a5db148d1a96abfabcd9043	0	1	1315061212000	NULL	NULL",
				"3	3	8k1jUHFrXUHUgK58xPA+s0hj17MTb/WhJnW3qLPbT392O2rCBXd8Rbv6knx3H28KGV9LLPK739Y=	6CqfLQc8ekDxPwTwwJpZYqE3WMJvuQtvqKhev+3E8g/S4czFD/nMvo6KqhGJ8jDx	1	-1	NULL	11423042	蜗牛	5	ZOsdd8r8cJYbdjQn05LA	11rw00tM5hTwce2mlSXXKhnScFIG90brdZSwwVO2E	0	0	1315668584000	NULL	NULL",
				"4	4	JNOiZSsIkdnhwBtp/9Jipet8vLXE8RFclbjYeJZeyWa7YQIy9zSatQ==	t746M7tuinajixOXx1F3Hf8IlWgZmAjACXf1Npifyty7YQIy9zSatQ==	1	-1	NULL	isnail	蜗牛	4	d793a554c70746e5bf2c8c18f91845d5	e7d311a073b653c0ef4bdd63183820ea	0	0	1315722308000	NULL	NULL",
				"5	5	yFDggP9yDy804YVY0NsdKWVz3uAlFRozosZbGRP+ii7Wm7NNwYVXuQ==	PoXSjG14lw7ThB2pZiYVfxDPBDHsQAQZIW7T1oqDi1S7YQIy9zSatQ==	1	-1	NULL	~Zx0MOA-f77o	NeoCN	6	942fbd3fcc8d4574a0e7d4659b63d17c	f2165e725b32c32a94c6f6fa2282252c	0	0	1319191240000	NULL	NULL",
				"7	7	mdj8C8Ha83wx38SXTjuNb9GCRZHa0srV0v+vQN21Dp9OPvQYis8zo9X7vSNxCDmLm7gWGULDFtu7YQIy9zSatQ==	VgW0DDnoawXIgFYhqQa8sphGJUkF/P098482T9EiBMhkXxZbz2ZNBLFE51JpAxStm7gWGULDFtu7YQIy9zSatQ==	1	-1	NULL	1807622870	YiBo微博客户竿1	3105114937	985e8f106a5db148d1a96abfabcd9043	0	0	1320288852000	NULL	NULL",
				"8	8	JnviyA6naWWocnoaZzP7aDlP7MBeZRm9eok5HNwR9A5ozyrfI1EWPbthAjL3NJq1	JnviyA6naWUI1x3hSEQOrJE+xYXpxiwXEXGQgnN/4WWWhnLP8Q7aI7thAjL3NJq1	2	1327126976849	basic create_records	6215376	满天飿22	1982098675974e1bc64db341904c8cdc	9635f53c8d6b0673523a5508a954c39a	0	0	1324534989277	NULL	NULL",
				"9	9	Fam/xib9zwdDpEXyhzU/9taJYmTkGvdoBOLxuIBqUVIl7v4BTgItLC38DS+YbmtLlb/5R8cXI0yRXiJxnOkyn/ExyGFDer/X	bX8pbDr4FI76eYWV+5HSjPcN0Ir7vdeK78imW4WvkmVgn6EoIxEWMO+yXhc2558PJkxCgtxT4nM=	2	1327723338486	read_user_message write_guestbook send_request read_user_blog read_user_album read_user_checkin read_user_status send_message read_user_notification read_user_share send_invitation photo_upload publish_comment publish_blog read_user_comment create_album read_user_guestbook publish_share read_user_like_history operate_like read_user_feed read_user_photo read_user_invitation status_update publish_checkin publish_feed	61355457	蜗牛	21	525209e407784e1099679ab7a6723438	e4266569bcea4bdcb4aa00ce222d48df	0	0	1325130172716	NULL	NULL" 
		};
		for (String s : accounts) {
			String[] ss = s.split("\\t");
			for(int i = 0 ;i < ss.length; i++) {
				if (i == 2 || i ==3) {
					ss[i] = EncryptUtil.desDecrypt(ss[i], Constants.KEY_BYTES);
				}
			}
			System.out.println(StringUtil.join(ss, "\t"));
		}
	}

//	@Test
//	public void testUrl() {
//		String source = "\u003Ca href=\"http:\/\/www.dev123.net\" rel=\"nofollow\"\u003EYiBo.Android\u7248\u003C\\/a\u003E";
//		System.out.println(ParseUtil.escapeAngleBrackets(ParseUtil.escapeAngleBrackets(source)));
//	}

}
