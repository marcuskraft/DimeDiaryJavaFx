/**
 * Sample Skeleton for 'AllTransactionMessage.fxml' Controller Class
 */

package com.dimediary.view.window.transaction;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.Main;
import com.dimediary.view.window.main.MainWindow;
import com.dimediary.view.window.util.IWindowParameterInjection;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AllTransactionWindow implements IWindowParameterInjection {

	private Transaction transaction;

	private LocalDate date;

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
		final WindowParameters parameters = new WindowParameters();
		parameters.put(ContinuousTransaction.class, this.transaction.getContinuousTransaction());
		parameters.put(MainWindow.class, this.mainWindow);
		if (this.date != null) {
			parameters.put(LocalDate.class, this.date);
		}

		final WindowCreater<TransactionDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/TransactionDialog.fxml"),
				"Transaktion erstellen / bearbeiten", parameters);
		this.close();
	}

	@FXML
	void onCancel(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onOnlyThis(final ActionEvent event) {

		final WindowParameters parameters = new WindowParameters();
		parameters.put(Transaction.class, this.transaction);
		parameters.put(MainWindow.class, this.mainWindow);

		final WindowCreater<TransactionDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/TransactionDialog.fxml"),
				"Transaktion erstellen / bearbeiten", parameters);
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

	@Override
	public void inject(final WindowParameters parameters) {
		Object object = parameters.getParameters().get(MainWindow.class);
		if (object == null || !(object instanceof MainWindow)) {
			throw new IllegalArgumentException("mainwindow must be set to create a all transaction dialog");
		}
		this.mainWindow = (MainWindow) object;

		object = parameters.getParameters().get(Transaction.class);
		if (object == null || !(object instanceof Transaction)) {
			throw new IllegalArgumentException("transaction must be set to create a all transaction dialog");
		}
		this.setTransaction((Transaction) object);

		object = parameters.getParameters().get(LocalDate.class);
		if (object != null && object instanceof LocalDate) {
			this.date = (LocalDate) object;
		}
	}

}
