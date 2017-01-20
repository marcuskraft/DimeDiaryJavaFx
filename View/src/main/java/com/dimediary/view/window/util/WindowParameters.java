package com.dimediary.view.window.util;

import java.util.HashMap;
import java.util.Map;

public class WindowParameters {

	private final Map<Class<?>, Object> parameters;

	public WindowParameters() {
		this.parameters = new HashMap<>();
	}

	public void put(final Class<?> c, final Object object) {
		this.parameters.put(c, object);
	}

	public Map<Class<?>, Object> getParameters() {
		return this.parameters;
	}

}
