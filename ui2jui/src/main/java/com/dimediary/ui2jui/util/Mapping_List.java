package com.dimediary.ui2jui.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mapping_List {

	private List<Mapping> mappings = new ArrayList<Mapping>();

	@XmlElement(name = "Mapping")
	public List<Mapping> getMappings() {
		return this.mappings;
	}

	public void setMappings(final List<Mapping> mappings) {
		this.mappings = mappings;
	}
}
