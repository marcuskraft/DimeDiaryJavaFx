package com.dimediary.view.window.transaction;

import com.dimediary.model.entities.Transaction;
import com.dimediary.view.Main;
import com.dimediary.view.window.main.MainWindow;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TransactionButtonFactory {

	public static TransactionButton createTransactionButton(final String text, final Transaction transaction,
			final MainWindow mainWindow) {
		final TransactionButton transactionButton = new TransactionButton(text, transaction);

		transactionButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent event) {

				final WindowParameters parameters = new WindowParameters();
				parameters.put(MainWindow.class, mainWindow);
				parameters.put(Transaction.class, transaction);
				if (transaction.getContinuousTransaction() != null) {
					final WindowCreater<AllTransactionWindow> windowCreater = new WindowCreater<>();
					windowCreater.createWindow(Main.class.getResource("design/window/AllTransactionMessage.fxml"),
							"Dauertransaktion", parameters);
				} else {
					final WindowCreater<TransactionDialog> windowCreater = new WindowCreater<>();
					windowCreater.createWindow(Main.class.getResource("design/window/TransactionDialog.fxml"),
							"Transaktion erstellen / bearbeiten", parameters);
				}

			}
		});

		return transactionButton;
	}

}
