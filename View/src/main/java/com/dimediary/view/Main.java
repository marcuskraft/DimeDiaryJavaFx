package com.dimediary.view;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dimediary.util.utils.DBUtils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private final static Logger log = LogManager.getLogger(DBUtils.class);

	public static void main(final String[] args) {
		try {
			Application.launch(args);
		} catch (final Exception e) {
			DBUtils.getInstance().close();
			Main.log.error(e);
		}
	}

	@Override
	public void start(final Stage stage) throws Exception {
		stage.setMaximized(true);
		final URL resource = this.getClass().getResource("design/window/MainWindow.fxml");

		Parent root;
		try {
			root = FXMLLoader.load(resource);
		} catch (final Exception e) {
			log.error(e);
			e.printStackTrace();
			throw e;
		}

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
