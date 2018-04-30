package com.dimediary.view.window.transaction;

import java.time.LocalDate;

import com.dimediary.model.entities.Transaction;
import com.dimediary.util.utils.DBUtils;
import com.dimediary.view.Main;
import com.dimediary.view.window.main.MainWindow;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.event.EventHandler;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class TransactionButtonFactory {

	public static final DataFormat KEY_TRANSACTION = new DataFormat("transaction");

	public static TransactionButton createTransactionButton(final String text, final Transaction transaction,
			final MainWindow mainWindow) {
		final TransactionButton transactionButton = new TransactionButton(text, transaction);

		transactionButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
				if (event.getClickCount() > 1) {
					final WindowParameters parameters = new WindowParameters();
					parameters.put(MainWindow.class, mainWindow);
					parameters.put(Transaction.class, transaction);
					if (transaction.getContinuousTransaction() != null) {
						parameters.put(LocalDate.class, transaction.getDate());
						final WindowCreater<AllTransactionWindow> windowCreater = new WindowCreater<>();
						windowCreater.createWindow(Main.class.getResource("design/window/AllTransactionMessage.fxml"),
								"Dauertransaktion", parameters);
					} else {
						final WindowCreater<TransactionDialog> windowCreater = new WindowCreater<>();
						windowCreater.createWindow(Main.class.getResource("design/window/TransactionDialog.fxml"),
								"Transaktion erstellen / bearbeiten", parameters);
					}
				}
			}
		});

		transactionButton.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(final KeyEvent event) {

				switch (event.getCode()) {
				case DELETE:
					final Transaction transaction = transactionButton.getTransaction();
					if (transaction != null) {
						if (transaction.getContinuousTransaction() != null) {
							TransactionButtonFactory.deleteContinuousTransaction(transaction);
						} else {
							DBUtils.getInstance().delete(transaction);
						}
					}
					if (mainWindow != null) {
						mainWindow.refresh();
					}
					event.consume();
					break;
				case C: // TODO either implement the paste logic or delete this
						// here
					if (event.isControlDown()) {
						final Clipboard clipboard = Clipboard.getSystemClipboard();
						final ClipboardContent clipboardContent = new ClipboardContent();
						final DataFormat dataFormat = TransactionButtonFactory.KEY_TRANSACTION;
						clipboardContent.put(dataFormat, transactionButton.getTransaction());
						clipboard.setContent(clipboardContent);
					}
					break;
				default:
					break;
				}

			}
		});

		transactionButton.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
				final Dragboard db;
				if (event.isControlDown()) {
					db = transactionButton.startDragAndDrop(TransferMode.COPY);
				} else {
					db = transactionButton.startDragAndDrop(TransferMode.MOVE);
				}

				final ClipboardContent content = new ClipboardContent();
				content.put(TransactionButtonFactory.KEY_TRANSACTION, transaction);

				db.setContent(content);

				event.consume();
			}
		});

		return transactionButton;
	}

	private static void deleteContinuousTransaction(final Transaction transaction) {
		// TODO Auto-generated method stub

	}

}
