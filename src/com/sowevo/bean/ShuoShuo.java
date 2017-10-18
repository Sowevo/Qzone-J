package com.sowevo.bean;
/**
 * 说说对象
 * @author dqqsw
 *
 */
public class ShuoShuo {
	/*
	 * 说说ID
	 */
	private String id;
	/*
	 * 用户ID
	 */
	private String uid;
	/*
	 * 发送时间
	 */
	private String sendTime;
	/*
	 * 内容
	 */
	private String content;
	/*
	 * 转发的内容
	 */
	private String forward;
	/*
	 * 附带的图片,可以有多个
	 */
	private String imgs;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	@Override
	public String toString() {
		return "ShuoShuo [id=" + id + ", uid=" + uid + ", sendTime=" + sendTime + ", content=" + content + ", forward="
				+ forward + ", imgs=" + imgs + "]";
	}
}
