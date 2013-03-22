package net.dev123.mblog.netease;

import java.io.IOException;

import net.dev123.commons.Constants;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NetEaseResponseHandler 网易Http响应处理类
 *
 * @version
 * @author 马庆升
 * @time 2010-8-30 下午02:32:40
 */
class NetEaseResponseHandler implements ResponseHandler<String> {

	private static final Logger logger = LoggerFactory.getLogger(NetEaseResponseHandler.class.getSimpleName());

	public String handleResponse(final HttpResponse response) throws HttpResponseException, IOException {
		StatusLine statusLine = response.getStatusLine();
		HttpEntity entity = response.getEntity();
		String responseString = (entity == null ? null : EntityUtils.toString(entity));

		if (Constants.DEBUG) {
			logger.debug("NetEaseResponseHandler : {}", responseString);
		}

		if (statusLine.getStatusCode() >= 300) {
			throw  NetEaseErrorAdaptor.parseError(responseString);
		}

		return responseString;
	}
}
