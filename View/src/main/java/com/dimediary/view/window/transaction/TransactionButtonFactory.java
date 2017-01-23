package com.dimediary.view.window.transaction;

import com.dimediary.model.entities.Transaction;
import com.dimediary.view.Main;
import com.dimediary.view.window.main.MainWindow;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

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

		transactionButton.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
				/* allow any transfer mode */
				final Dragboard db = transactionButton.startDragAndDrop(TransferMode.MOVE);

				/* put a string on dragboard */
				final ClipboardContent content = new ClipboardContent();
				content.putString(transaction.getId().toString());

				db.setContent(content);

				event.consume();
			}
		});

		return transactionButton;
	}

}
