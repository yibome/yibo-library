package net.dev123.mblog.sina;

import net.dev123.mblog.conf.ApiConfigurationBase;

public class SinaApiConfiguration extends ApiConfigurationBase {

	public SinaApiConfiguration() {
		this.setRestBaseURL("https://api.weibo.com/2/");

		initRestURL();
	}

	private void initRestURL() {
		this.setPublicTimelineURL(this.getRestBaseURL() + "statuses/public_timeline.json");
		this.setFriendTimelineURL(this.getRestBaseURL() + "statuses/friends_timeline.json");
		this.setHomeTimelineURL(this.getRestBaseURL() + "statuses/friends_timeline.json");
		this.setUserTimelineURL(this.getRestBaseURL() + "statuses/user_timeline.json");
		this.setMetionsTimelineURL(this.getRestBaseURL() + "statuses/mentions.json");
		this.setRetweetedByMeURL(this.getRestBaseURL() + "statuses/repost_by_me.json");
		this.setRetweetsOfStatusURL(this.getRestBaseURL() + "statuses/repost_timeline.json");
		
		this.setShowOfStatusURL(this.getRestBaseURL() + "statuses/show.json");
		this.setUpdateStatusURL(this.getRestBaseURL() + "statuses/update.json");
		this.setUploadStatusURL(this.getRestBaseURL() + "statuses/upload.json");
		this.setDestroyStatusURL(this.getRestBaseURL() + "statuses/destroy.json");
		this.setRetweetStatusURL(this.getRestBaseURL() + "statuses/repost.json");
		this.setCountsOfCommentAndRetweetURL(this.getRestBaseURL() + "statuses/count.json");
        
		this.setUnreadCountURL("https://rm.api.weibo.com/2/remind/unread_count.json");
        this.setResetUnreadCountURL("https://rm.api.weibo.com/2/remind/set_count.json");

		this.setShowOfUserURL(this.getRestBaseURL() + "users/show.json");
		this.setFriendsURL(this.getRestBaseURL() + "friendships/friends.json");
		this.setFollowsURL(this.getRestBaseURL() + "friendships/followers.json");

		this.setInboxTimelineURL(this.getRestBaseURL() + "direct_messages.json");
		this.setOutboxTimelineURL(this.getRestBaseURL() + "direct_messages/sent.json");
		this.setSendDirectMessageURL(this.getRestBaseURL() + "direct_messages/new.json");
		this.setDestroyDirectMessageURL(this.getRestBaseURL() + "direct_messages/destroy/%1$s.json");

		this.setCreateFriendshipURL(this.getRestBaseURL() + "friendships/create.json");
		this.setDestroyFriendshipURL(this.getRestBaseURL() + "friendships/destroy.json");
		this.setExistFriendshipURL(this.getRestBaseURL() + "friendships/exists.json");
		this.setShowOfFriendshipURL(this.getRestBaseURL() + "friendships/show.json");

		this.setFriendsIDsURL(this.getRestBaseURL() + "friends/ids.json");
		this.setFollowersIDsURL(this.getRestBaseURL() + "followers/ids.json");

		this.setVerifyCredentialsURL(this.getRestBaseURL() + "account/get_uid.json");
		this.setRateLimitStatusURL(this.getRestBaseURL() + "account/rate_limit_status.json");
		this.setUpdateProfileURL(this.getRestBaseURL() + "account/update_profile.json");
		this.setUpdateProfileImageURL(this.getRestBaseURL() + "account/update_profile_image.json");

		this.setFavoritesTimelineURL(this.getRestBaseURL() + "favorites.json");
		this.setFavoritesOfUserURL(this.getRestBaseURL() + "favorites/%1$s.json");
		this.setCreateFavoriteURL(this.getRestBaseURL() + "favorites/create.json");
		this.setDestroyFavoriteURL(this.getRestBaseURL() + "favorites/destroy.json");

		this.setCommentsTimelineURL(this.getRestBaseURL() + "comments/timeline.json");
		this.setCommentsOfStatusURL(this.getRestBaseURL() + "comments/show.json");
		this.setCommentsByMeURL(this.getRestBaseURL() + "comments/by_me.json");
		this.setCommentsToMeURL(this.getRestBaseURL() + "comments/to_me.json");
		this.setCommentStatusURL(this.getRestBaseURL() + "comments/create.json");
		this.setDestroyCommentURL(this.getRestBaseURL() + "comments/destroy.json");
		this.setReplyCommentURL(this.getRestBaseURL() + "comments/reply.json");
		
		this.setSearchUserURL(this.getRestBaseURL() + "users/search.json");
		this.setSearchStatusURL(this.getRestBaseURL() + "statuses/search.json");

		this.setCurrentTrendsURL(this.getRestBaseURL() + "trends/hourly.json");
		this.setDailyTrendsURL(this.getRestBaseURL() + "trends/daily.json");
		this.setWeeklyTrendsURL(this.getRestBaseURL() + "trends/weekly.json");
		this.setUserTrendsURL(this.getRestBaseURL() + "trends.json");
		this.setUserTrendsStatusURL(this.getRestBaseURL() + "trends/statuses.json");

		this.setCreateBlockURL(this.getRestBaseURL() + "blocks/create.json");
		this.setDestroyBlockURL(this.getRestBaseURL() + "blocks/destroy.json");
		this.setBlockingUsersURL(this.getRestBaseURL() + "blocks/blocking.json");
		this.setBlockingUsersIdsURL(this.getRestBaseURL() + "blocks/blocking/ids.json");
		this.setExistsBlockURL(this.getRestBaseURL() + "blocks/exists.json");

		this.setCreateGroupURL(this.getRestBaseURL() + "%1$s/lists.json");
		this.setUpdateGroupURL(this.getRestBaseURL() + "%1$s/lists/%2$s.json");
		this.setGroupListURL(this.getRestBaseURL() + "%1$s/lists.json");
		this.setShowOfGroupURL(this.getRestBaseURL() + "%1$s/lists/%2$s.json");
		this.setDestroyGroupURL(this.getRestBaseURL() + "%1$s/lists/%2$s.json");
		this.setGroupStatusesURL(this.getRestBaseURL() + "%1$s/lists/%2$s/statuses.json");
		this.setGroupMembershipsURL(this.getRestBaseURL() + "%1$s/lists/memberships.json");
		this.setGroupSubscriptionsURL(this.getRestBaseURL() + "%1$s/lists/subscriptions.json");

		this.setGroupMembersURL(this.getRestBaseURL() + "%1$s/%2$s/members.json");
		this.setCreateGroupMemberURL(this.getRestBaseURL() + "%1$s/%2$s/members.json");
		this.setDestroyGroupMemberURL(this.getRestBaseURL() + "%1$s/%2$s/members.json");
		this.setShowGroupMemberURL(this.getRestBaseURL() + "%1$s/%2$s/members/%3$s.json");

		this.setGroupSubscribersURL(this.getRestBaseURL() + "%1$s/%2$s/subscribers.json");
		this.setCreateGroupSubscriberURL(this.getRestBaseURL() + "%1$s/%2$s/subscribers.json");
		this.setDestroyGroupSubscriberURL(this.getRestBaseURL() + "%1$s/%2$s/subscribers.json");
		this.setShowGroupSubscriberURL(this.getRestBaseURL() + "%1$s/%2$s/subscribers/%3$s.json");

		this.setDailyHotRetweetsURL(this.getRestBaseURL() + "statuses/hot/repost_daily.json");
		this.setDailyHotCommentsURL(this.getRestBaseURL() + "statuses/hot/comments_daily.json");
		this.setWeeklyHotRetweetsURL(this.getRestBaseURL() + "statuses/hot/repost_weekly.json");
		this.setWeeklyHotCommentsURL(this.getRestBaseURL() + "statuses/hot/comments_weekly.json");
		
//		this.setGeoLocationKeywordURL(this.getRestBaseURL() + "location/pois/keyword.json");
		this.setGeoLocationByCoordinateURL(this.getRestBaseURL() + "location/geocode/geo_to_address.json");

	}
}
