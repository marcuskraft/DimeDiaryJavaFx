package com.dimediary.ui2jui.util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mapping {

	private String cpp;
	private String java;
	private String importString;

	@XmlElement
	public String getImportString() {
		return this.importString;
	}

	public void setImportString(final String importString) {
		this.importString = importString;
	}

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
