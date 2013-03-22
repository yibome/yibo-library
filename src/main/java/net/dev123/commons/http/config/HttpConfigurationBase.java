package net.dev123.commons.http.config;

/**
 * HttpConfigurationBase
 *
 * @version
 * @author 马庆升
 * @time 2010-7-29 下午02:50:29
 */
public class HttpConfigurationBase implements HttpConfiguration, java.io.Serializable {

	private String userAgent;

	private boolean useGzip;
	private boolean useProxy;
	private String httpProxyHost;
	private String httpProxyUser;
	private String httpProxyPassword;
	private int httpProxyPort;
	private int httpConnectionTimeout;
	private int httpReadTimeout;
	private int httpRetryCount;
	private int httpRetryIntervalSeconds;
	private int connectionPoolSize;

	// hidden portion
	private String clientVersion;
	private String clientURL;


	private static final long serialVersionUID = -6610497517837844232L;
	public HttpConfigurationBase() {
		setHttpProxyPort(-1);
		setHttpConnectionTimeout(10000);
		setHttpReadTimeout(120000);
		setHttpRetryCount(0);
		setHttpRetryIntervalSeconds(5);

		setUseGzip(true);

		setClientURL("YiBo");
		setUserAgent("YiBo");

	}

	public final String getUserAgent() {
		return this.userAgent;
	}

	protected final void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}


	// methods for HttpClientConfiguration

	public final String getHttpProxyHost() {
		return httpProxyHost;
	}

	protected final void setHttpProxyHost(String proxyHost) {
		this.httpProxyHost = proxyHost;
	}

	public final String getHttpProxyUser() {
		return httpProxyUser;
	}

	protected final void setHttpProxyUser(String proxyUser) {
		this.httpProxyUser = proxyUser;
	}

	public final String getHttpProxyPassword() {
		return httpProxyPassword;
	}

	protected final void setHttpProxyPassword(String proxyPassword) {
		this.httpProxyPassword = proxyPassword;
	}

	public final int getHttpProxyPort() {
		return httpProxyPort;
	}

	protected final void setHttpProxyPort(int proxyPort) {
		this.httpProxyPort = proxyPort;
	}

	public final int getHttpConnectionTimeout() {
		return httpConnectionTimeout;
	}

	protected final void setHttpConnectionTimeout(int connectionTimeout) {
		this.httpConnectionTimeout = connectionTimeout;
	}

	public final int getHttpReadTimeout() {
		return httpReadTimeout;
	}

	protected final void setHttpReadTimeout(int readTimeout) {
		this.httpReadTimeout = readTimeout;
	}

	public final int getHttpRetryCount() {
		return httpRetryCount;
	}

	protected final void setHttpRetryCount(int retryCount) {
		this.httpRetryCount = retryCount;
	}

	public final int getHttpRetryIntervalSeconds() {
		return httpRetryIntervalSeconds;
	}

	protected final void setHttpRetryIntervalSeconds(int retryIntervalSeconds) {
		this.httpRetryIntervalSeconds = retryIntervalSeconds;
	}

	public final int getConnectionPoolSize() {
		return connectionPoolSize;
	}

	protected final void setConnectionPoolSize(int connectionPoolSize) {
		this.connectionPoolSize = connectionPoolSize;
	}

	public final String getClientVersion() {
		return clientVersion;
	}

	protected final void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public final String getClientURL() {
		return clientURL;
	}

	protected final void setClientURL(String clientURL) {
		this.clientURL = clientURL;
	}


	public final boolean isUseGzip() {
		return useGzip;
	}

	protected final void setUseGzip(boolean useGzip) {
		this.useGzip = useGzip;
	}

	public final boolean isUseProxy() {
		return this.useProxy;
	}

	protected final void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

}
