package com.cn.hjh.module.mina.message;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

/**
 * 消息的父类
 *
 */
public class MessageVO implements Serializable,Cloneable{
	
	//手机的id 
	public static final int ADDRESS_PHONE = 1;
	//家庭的id
	public static final int ADDRESS_FAMILY = 0;

	//login status
	public static final  int STAUTS_LOGIN = 1;

	//
	public static final int STATUS_CONTROLLER = 2;
	//
	public static final int STATUS_RESPONSE =3;

	//from where
	protected String from;
	//to where
	protected String to;
	//device
	protected int device;
	//message的属性是什么
	protected int messageStatus;

	
	public String toJson(){
		return new Gson().toJson(this)+"\n";
	}
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getDevice() {
		return device;
	}
	public void setDevice(int device) {
		this.device = device;
	}
	public int getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(int messageStatus) {
		this.messageStatus = messageStatus;
	}
}
