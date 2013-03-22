package net.dev123.sns.entity;

import java.util.Date;
import java.util.List;

import net.dev123.entity.BaseUser;
import net.dev123.entity.Education;
import net.dev123.entity.Work;

public class User extends BaseUser implements Profile {

	private static final long serialVersionUID = -6345893237975349030L;

	/** 生日日期*/
	private Date birthday;
	/** 家乡*/
	private String hometown;

	/** 是否是星级用户*/
	private boolean isStar;
	/** 是否是vip用户*/
	private boolean isVip;
	/** vip级别 */
	private int vipLevel;

	/** 用户经过验证的email的信息字符串 */
	private String emailHash;

	/** 头像链接 50*50大小*/
	private String tinyUrl;
	/** 头像链接 100*100大小*/
	private String headUrl;
	/** 头像链接 200*200大小 */
	private String mainUrl;

	/** 工作经历 */
	private List<Work> workHistory;

	/** 教育经历 */
	private List<Education> educationHistory;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public boolean isStar() {
		return isStar;
	}

	public void setStar(boolean isStar) {
		this.isStar = isStar;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getEmailHash() {
		return emailHash;
	}

	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}

	public String getTinyUrl() {
		return tinyUrl;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.profileImageUrl = headUrl;
		this.headUrl = headUrl;
	}

	public String getMainUrl() {
		return mainUrl;
	}

	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getProfileName() {
		return screenName;
	}

	@Override
	public String getMentionTitleName() {
		return screenName;
	}

	@Override
	public String getDisplayName() {
		return screenName;
	}

	public String getGlobalName() {
		return screenName + "@" + serviceProvider.getServiceProviderName();
	}

	public String getUnionName() {
		return screenName + "@" + serviceProvider.getServiceProviderName();
	}

	public String getMentionName() {
		return screenName;
	}

	public String getIdentifyName() {
		return id;
	}

	public List<Work> getWorkHistory() {
		return workHistory;
	}

	public void setWorkHistory(List<Work> workHistory) {
		this.workHistory = workHistory;
	}

	public List<Education> getEducationHistory() {
		return educationHistory;
	}

	public void setEducationHistory(List<Education> educationHistory) {
		this.educationHistory = educationHistory;
	}

	@Override
	public String getProfileId() {
		return id;
	}

	@Override
	public ProfileType getProfileType() {
		return ProfileType.USER;
	}

	@Override
	public String getProfilePicture() {
		return profileImageUrl;
	}

}
