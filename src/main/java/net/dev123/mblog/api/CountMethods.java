package net.dev123.mblog.api;

import java.util.List;

import net.dev123.exception.LibException;
import net.dev123.mblog.entity.ResponseCount;
import net.dev123.mblog.entity.Status;
import net.dev123.mblog.entity.UnreadCount;
import net.dev123.mblog.entity.UnreadType;

public interface CountMethods {

	/**
	 * 获取指定微博的转发数和评论数
	 *
	 * @param status
	 *            微博消息对象
	 * @return ResponseCount对象
	 * @throws LibException
	 */
	ResponseCount getResponseCount(Status status) throws LibException;

	/**
	 * 批量获取N条微博的转发数和评论数
	 *
	 * @param statusList
	 *            微博消息列表
	 * @return ResponseCount列表
	 * @throws LibException
	 */
	List<ResponseCount> getResponseCountList(List<Status> statusList) throws LibException;

	/**
	 * 获取未读消息的数量,包括@提到我的，评论，私信，粉丝
	 *
	 */
	UnreadCount getUnreadCount() throws LibException;

	/**
	 * 重置未读消息计数值
	 * @param unreadType 需要清零的计数类别，1、评论数；2、@提到我的；3、私信数；4、粉丝数
	 * @throws LibException
	 */
	boolean resetUnreadCount(UnreadType unreadType) throws LibException;
}
