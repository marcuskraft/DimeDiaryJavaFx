package com.dimediary.view;

import java.io.File;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import com.dimediary.services.database.DatabaseService;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private final static Logger log = LogManager.getLogger(Main.class);

	public static void main(final String[] args) {
		try {
			final File file = new File("..\\", "log4j2.xml");
			// System.setProperty("log4j.configuration", string);
			final LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
			context.setConfigLocation(file.toURI());
			Application.launch(args);
		} catch (final Exception e) {
			DatabaseService.getInstance().close();
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
			Main.log.error(e);
			e.printStackTrace();
			throw e;
		}

		final Scene scene = new Scene(root);

		stage.setTitle("DimeDiary");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() {
		DatabaseService.getInstance().close();
	}

}
