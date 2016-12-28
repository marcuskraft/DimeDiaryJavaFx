/**
 * Sample Skeleton for 'AllTransactionMessage.fxml' Controller Class
 */

package com.dimediary.view.design.window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dimediary.model.entities.Transaction;
import com.dimediary.view.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AllTransactionWindow {

	private Transaction transaction;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="buttonOnlyThis"
	private Button buttonOnlyThis; // Value injected by FXMLLoader

	@FXML // fx:id="buttonAll"
	private Button buttonAll; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCancel"
	private Button buttonCancel; // Value injected by FXMLLoader

	private MainWindow mainWindow;

	@FXML
	void onAll(final ActionEvent event) {
		final FXMLLoader loader = new FXMLLoader(Main.class.getResource("design/window/TransactionDialog.fxml"));

		final Stage stage = new Stage(StageStyle.DECORATED);
		try {
			stage.setScene(new Scene((Pane) loader.load()));
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final TransactionDialog controller = loader.<TransactionDialog> getController();
		controller.setMainWindow(this.mainWindow);
		controller.setContinuousTransaction(this.transaction.getContinuousTransaction());
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
		this.close();
	}

	@FXML
	void onCancel(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onOnlyThis(final ActionEvent event) {
		final FXMLLoader loader = new FXMLLoader(Main.class.getResource("design/window/TransactionDialog.fxml"));

		final Stage stage = new Stage(StageStyle.DECORATED);
		try {
			stage.setScene(new Scene((Pane) loader.load()));
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final TransactionDialog controller = loader.<TransactionDialog> getController();
		controller.setMainWindow(this.mainWindow);
		controller.setTransaction(this.transaction);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
		this.close();
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.buttonOnlyThis != null : "fx:id=\"buttonOnlyThis\" was not injected: check your FXML file 'AllTransactionMessage.fxml'.";
		assert this.buttonAll != null : "fx:id=\"buttonAll\" was not injected: check your FXML file 'AllTransactionMessage.fxml'.";
		assert this.buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'AllTransactionMessage.fxml'.";

	}

	public void setTransaction(final Transaction transaction) {
		this.transaction = transaction;
		if (transaction == null || transaction.getContinuousTransaction() == null) {
			throw new IllegalStateException("transacion is null or has no continuous transaction!");
		}
	}

	private void close() {
		final Stage stage = (Stage) this.buttonAll.getScene().getWindow();
		stage.close();
	}

	public void setMainWindow(final MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

}
