package net.dev123.sns.qqzone;

import java.io.IOException;

import net.dev123.commons.Constants;
import net.dev123.commons.ServiceProvider;
import net.dev123.exception.ExceptionCode;
import net.dev123.exception.LibRuntimeException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class QQZoneResponseHandler implements ResponseHandler<String> {

	private static final Logger logger = LoggerFactory.getLogger(QQZoneResponseHandler.class.getSimpleName());
	private static final String CALLBACK_RESPONSE_REGEX = "callback\\( (.*) \\);";

	public String handleResponse(final HttpResponse response) throws HttpResponseException, IOException {
		StatusLine statusLine = response.getStatusLine();
		HttpEntity entity = response.getEntity();
		String responseString = (entity == null ? null : EntityUtils.toString(entity, "UTF-8"));

		if (Constants.DEBUG) {
			logger.debug("QQZoneResponseHandler : {}", responseString);
		}

		if (responseString != null) {
			responseString = responseString.trim();
			if (responseString.matches(CALLBACK_RESPONSE_REGEX)) {
				responseString = responseString.replaceAll(CALLBACK_RESPONSE_REGEX, "$1");
			}
			if (responseString.contains("error_code")
				&& responseString.startsWith("{")) {
				try {
					JSONObject json = new JSONObject(responseString);
					if (json.has("error_code")) {
						// 明确是异常响应，而不是包含了error_code的文本
						int errorCode = json.getInt("error_code");
						String errorDesc = json.getString("error");
						String requestPath = json.getString("request");
						throw new LibRuntimeException(
							errorCode, requestPath,	errorDesc, ServiceProvider.QQZone);
					}
				} catch (JSONException e) {
					throw new LibRuntimeException(ExceptionCode.JSON_PARSE_ERROR, e, ServiceProvider.QQZone);
				}
			}
		}

		int statusCode = statusLine.getStatusCode();
		if (statusCode >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}

		return responseString;
	}
}
