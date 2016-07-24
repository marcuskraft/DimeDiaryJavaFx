package com.dimediary.ui2jui.util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mapping {

	private String cpp;
	private String java;

	@XmlElement
	public String getCpp() {
		return this.cpp;
	}

	@XmlElement
	public String getJava() {
		return this.java;
	}

	public void setCpp(final String cpp) {
		this.cpp = cpp;
	}

	public void setJava(final String java) {
		this.java = java;
	}

}
