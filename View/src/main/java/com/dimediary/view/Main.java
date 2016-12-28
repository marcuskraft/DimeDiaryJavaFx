package com.dimediary.view;

import com.dimediary.util.utils.DBUtils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(final String[] args) {
		Application.launch(args);
	}

	public static void initialize() {

	}

	@Override
	public void start(final Stage stage) throws Exception {
		stage.setMaximized(true);
		final Parent root = FXMLLoader.load(this.getClass().getResource("design/window/MainWindow.fxml"));

		final Scene scene = new Scene(root);

		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() {
		DBUtils.getInstance().close();
	}

}
