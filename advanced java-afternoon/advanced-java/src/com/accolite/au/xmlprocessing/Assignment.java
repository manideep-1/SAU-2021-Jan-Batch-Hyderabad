package com.accolite.au.xmlprocessing;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Assignment {

	String name;
	
	String statusupdate;
	
	String prg_language;

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getStatusupdate() {
		return statusupdate;
	}
	@XmlElement
	public void setStatusupdate(String statusupdate) {
		this.statusupdate = statusupdate;
	}

	public String getPrg_language() {
		return prg_language;
	}
	@XmlElement
	public void setPrg_language(String prg_language) {
		this.prg_language = prg_language;
	}
	@Override
	public String toString() {
		return "Assignment [name=" + name + ", statusupdate=" + statusupdate + ", prg_language=" + prg_language + "]";
	}
	
//	public String getName() {
//		return name;
//	}
//	@XmlElement
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getReview() {
//		return review;
//	}
//	@XmlElement
//	public void setReview(String review) {
//		this.review = review;
//	}
//	public int getId() {
//		return id;
//	}
//	@XmlAttribute
//	public void setId(int id) {
//		this.id = id;
//	}
//	@Override
//	public String toString() {
//		return "Assignment [name=" + name + ", review=" + review + ", id=" + id + "]";
//	}
}