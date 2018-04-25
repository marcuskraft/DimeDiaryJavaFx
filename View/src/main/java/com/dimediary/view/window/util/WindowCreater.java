package com.dimediary.view.window.util;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowCreater<T extends IWindowParameterInjection> {

	public void createWindow(final URL url, final String title, final WindowParameters parameters) {
		final FXMLLoader loader = new FXMLLoader(url);

		final Stage stage = new Stage(StageStyle.DECORATED);
		try {
			stage.setScene(new Scene((Pane) loader.load()));
		} catch (final IOException e) {
			throw new IllegalStateException("fxml file could not be found", e);
		}

		if (parameters != null) {
			final T controller = loader.<T> getController();
			controller.inject(parameters);
		}

		stage.setTitle(title);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}

	public void createWindow(final URL url, final String title) {
		this.createWindow(url, title, null);
	}

}
