package com.sowevo.bean;
/**
 * ˵˵����
 * @author dqqsw
 *
 */
public class ShuoShuo {
	/*
	 * ˵˵ID
	 */
	private String id;
	/*
	 * �û�ID
	 */
	private String uid;
	/*
	 * ����ʱ��
	 */
	private String sendTime;
	/*
	 * ����
	 */
	private String content;
	/*
	 * ת��������
	 */
	private String forward;
	/*
	 * ������ͼƬ,�����ж��
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
