package net.dev123.mblog.twitter;

import static net.dev123.commons.util.ParseUtil.getBoolean;
import static net.dev123.commons.util.ParseUtil.getRawString;
import static net.dev123.commons.util.ParseUtil.getUnescapedString;
import net.dev123.exception.ExceptionCode;
import net.dev123.exception.LibException;
import net.dev123.mblog.entity.Relationship;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * SinaRelationshipAdaptor
 *
 * @version
 * @author 马庆升
 * @time 2010-8-31 上午01:36:37
 */
public class TwitterRelationshipAdaptor {

	/**
	 * 从JSON字符串创建Relationship对象
	 *
	 * @param responseString
	 *            JSON字符串
	 * @return Relationship对象
	 * @throws LibException
	 */
	public static Relationship createRelationship(String responseString) throws LibException {
		try {
			JSONObject json = new JSONObject(responseString);
			return createRelationship(json.getJSONObject("relationship"));
		} catch (JSONException e) {
			throw new LibException(ExceptionCode.JSON_PARSE_ERROR, e);
		}
	}

	/**
	 * 从JSON对象创建Relationship对象，包级别访问控制
	 *
	 * @param json
	 *            JSON对象
	 * @return Relationship对象
	 * @throws LibException
	 */
	static Relationship createRelationship(JSONObject json) throws LibException {
		try {
			Relationship relationship = new Relationship();
			JSONObject sourceJson = json.getJSONObject("source");
			JSONObject targetJson = json.getJSONObject("target");
			relationship.setSourceUserId(getRawString("id_str", sourceJson));
			relationship.setTargetUserId(getRawString("id_str", targetJson));
			relationship.setSourceScreenName(getUnescapedString("screen_name", sourceJson));
			relationship.setTargetScreenName(getUnescapedString("screen_name", targetJson));
			relationship.setFollowing(getBoolean("following", sourceJson));
			relationship.setFollowed(getBoolean("followed_by", sourceJson));
			relationship.setSourceNotificationsEnabled(getBoolean("notifications_enabled", sourceJson));
			return relationship;
		} catch (JSONException e) {
			throw new LibException(ExceptionCode.JSON_PARSE_ERROR, e);
		}
	}

}
