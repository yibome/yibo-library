package net.dev123.mblog.sohu;

import static net.dev123.commons.util.ParseUtil.getBoolean;
import static net.dev123.commons.util.ParseUtil.getDate;
import static net.dev123.commons.util.ParseUtil.getInt;
import static net.dev123.commons.util.ParseUtil.getRawString;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.dev123.commons.PagableList;
import net.dev123.commons.ServiceProvider;
import net.dev123.commons.util.ParseUtil;
import net.dev123.entity.Gender;
import net.dev123.exception.ExceptionCode;
import net.dev123.exception.LibException;
import net.dev123.mblog.entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * SohuUserAdaptor
 *
 * @version
 * @author 马庆升
 * @time 2010-8-30 下午03:58:58
 */
public class SohuUserAdaptor {

	/**
	 * 从JSON字符串创建User对象
	 *
	 * @param jsonString
	 *            JSON字符串
	 * @return User对象
	 * @throws LibException
	 */
	public static User createUser(String jsonString) throws LibException {
		try {
			JSONObject json = new JSONObject(jsonString);
			return createUser(json);
		} catch (JSONException e) {
			throw new LibException(ExceptionCode.JSON_PARSE_ERROR);
		}
	}

	/**
	 * 从JSON字符串创建User对象列表
	 *
	 * @param jsonString
	 *            JSON字符串
	 * @return User对象列表
	 * @throws LibException
	 */
	public static PagableList<User> createPagableUserList(String jsonString) throws LibException {
		try {
			if ("[]".equals(jsonString) || "{}".equals(jsonString)) {
				return new PagableList<User>(0, 0, 0);
			}
			JSONObject json = new JSONObject(jsonString);
			JSONArray jsonList = json.getJSONArray("users");
			long nextCursor = 0L;
			long previousCursor = 0L;
			if (!json.isNull("cursor_id")) {
				nextCursor = ParseUtil.getLong("cursor_id", json);
			}
			int size = jsonList.length();
			PagableList<User> userList = new PagableList<User>(size, previousCursor, nextCursor);
			for (int i = 0; i < size; i++) {
				userList.add(createUser(jsonList.getJSONObject(i)));
			}
			return userList;
		} catch (JSONException e) {
			throw new LibException(ExceptionCode.JSON_PARSE_ERROR);
		}
	}

	/**
	 * 从JSON字符串创建User对象列表
	 *
	 * @param jsonString
	 *            JSON字符串
	 * @return User对象列表
	 * @throws LibException
	 */
	public static List<User> createUserList(String jsonString) throws LibException {
		try {
			if ("[]".equals(jsonString) || "{}".equals(jsonString)) {
				return new PagableList<User>(0, 0, 0);
			}
			JSONArray jsonList = new JSONArray(jsonString);
			int size = jsonList.length();
			ArrayList<User> userList = new ArrayList<User>(size);
			for (int i = 0; i < size; i++) {
				userList.add(createUser(jsonList.getJSONObject(i)));
			}
			return userList;
		} catch (JSONException e) {
			throw new LibException(ExceptionCode.JSON_PARSE_ERROR);
		}
	}

	/**
	 * 从JSON对象创建User对象，包级别访问权限控制
	 *
	 * @param json
	 *            JSON对象
	 * @return User对象
	 * @throws LibException
	 */
	static User createUser(JSONObject json) throws LibException {
		try {
			User user = new User();
			user.setId(getRawString("id", json));
			user.setName(getRawString("name", json));
			user.setScreenName(getRawString("screen_name", json));
			user.setLocation(getRawString("location", json));
			user.setDescription(getRawString("description", json));
			user.setContributorsEnabled(getBoolean("contributors_enabled", json));
			user.setProfileImageUrl(getRawString("profile_image_url", json));
			user.setUrl(getRawString("url", json));
			user.setProtected(getBoolean("protected", json));
			user.setGeoEnabled(getBoolean("geo_enabled", json));
			user.setVerified(getBoolean("verified", json));
			user.setFollowersCount(getInt("followers_count", json));
			user.setFriendsCount(getInt("friends_count", json));
			user.setCreatedAt(getDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy"));
			user.setFavouritesCount(json.getInt("favourites_count"));
			user.setStatusesCount(getInt("statuses_count", json));
			user.setFollowing(getBoolean("following", json));
			user.setGender(Gender.UNKNOW);
			if (!json.isNull("gender")) {
				String gender = getRawString("gender", json);
				if ("1".equals(gender)) {
					user.setGender(Gender.MALE);
				} else if ("0".equals(gender)) {
					user.setGender(Gender.FEMALE);
				} else {
					user.setGender(Gender.UNKNOW);
				}
			}
			if (!json.isNull("status")) {
				JSONObject statusJSON = json.getJSONObject("status");
				user.setStatus(SohuStatusAdaptor.createStatus(statusJSON));
			}

			user.setServiceProvider(ServiceProvider.Sohu);
			return user;
		} catch (JSONException e) {
			throw new LibException(ExceptionCode.JSON_PARSE_ERROR);
		} catch (ParseException e) {
			throw new LibException(ExceptionCode.DATE_PARSE_ERROR);
		}
	}
}
