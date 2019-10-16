package com.starry.bean;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2019
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年10月16日下午4:04:32
 * 
 * @Description TODO 
 *	便签实体 Bean
 */
public class NoteBean {
	private String id;
	private String name;
	private String content;
	private String owner;
	@Override
	public String toString() {
		return "NoteBean [id=" + id + ", name=" + name + ", content=" + content + ", owner=" + owner + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
