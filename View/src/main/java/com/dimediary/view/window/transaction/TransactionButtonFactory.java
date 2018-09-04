package com.dimediary.view.window.transaction;

import java.time.LocalDate;

import com.dimediary.model.entities.Transaction;
import com.dimediary.services.ContinuousTransactionService;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.view.Main;
import com.dimediary.view.window.main.MainWindow;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class TransactionButtonFactory {

	public static final DataFormat KEY_TRANSACTION = new DataFormat("transaction");

	public static TransactionButton createTransactionButton(final String text, final Transaction transaction,
			final MainWindow mainWindow) {
		final TransactionButton transactionButton = new TransactionButton(text, transaction);

		final ContextMenu contextMenu = new ContextMenu();

		final MenuItem delete = new MenuItem("L�schen");
		delete.setOnAction(event -> TransactionButtonFactory.deleteTransaction(mainWindow, transactionButton));

		final MenuItem open = new MenuItem("�ffnen");
		open.setOnAction(event -> TransactionButtonFactory.openTransaction(transaction, mainWindow));

		final MenuItem copy = new MenuItem("Kopieren");
		copy.setOnAction(
				event -> TransactionButtonFactory.doCopyOrMoveTransaction(transaction, transactionButton, true));

		final MenuItem move = new MenuItem("Ausschneiden");
		move.setOnAction(
				event -> TransactionButtonFactory.doCopyOrMoveTransaction(transaction, transactionButton, false));

		contextMenu.getItems().add(open);
		// contextMenu.getItems().add(copy);
		// contextMenu.getItems().add(move);
		contextMenu.getItems().add(delete);

		transactionButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
				if (event.getClickCount() > 1) {
					TransactionButtonFactory.openTransaction(transaction, mainWindow);
				}

				if (event.getButton() == MouseButton.SECONDARY) {
					contextMenu.show(transactionButton, event.getSceneX(), event.getSceneY());
				}
			}

		});

		transactionButton.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(final KeyEvent event) {

				switch (event.getCode()) {
				case DELETE:
					TransactionButtonFactory.deleteTransaction(mainWindow, transactionButton);
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
				final boolean copy = event.isControlDown();
				TransactionButtonFactory.doCopyOrMoveTransaction(transaction, transactionButton, copy);
				event.consume();
			}

		});

		return transactionButton;
	}

	private static void openTransaction(final Transaction transaction, final MainWindow mainWindow) {
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

	private static void doCopyOrMoveTransaction(final Transaction transaction,
			final TransactionButton transactionButton, final boolean copy) {
		final Dragboard db;
		if (copy) {
			db = transactionButton.startDragAndDrop(TransferMode.COPY);
		} else {
			db = transactionButton.startDragAndDrop(TransferMode.MOVE);
		}

		final ClipboardContent content = new ClipboardContent();
		content.put(TransactionButtonFactory.KEY_TRANSACTION, transaction);

		db.setContent(content);
	}

	private static void deleteTransaction(final MainWindow mainWindow, final TransactionButton transactionButton) {
		final Transaction transaction = transactionButton.getTransaction();
		if (transaction != null) {
			if (transaction.getContinuousTransaction() != null) {
				TransactionButtonFactory.deleteContinuousTransaction(transaction);
			} else {
				TransactionButtonFactory.deleteSingeTransaction(transaction);
			}
		}
		if (mainWindow != null) {
			mainWindow.refresh();
		}

	}

	private static void deleteSingeTransaction(final Transaction transaction) {
		final Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Transaktion l�schen?");
		alert.setContentText("Sicher, dass Sie diese Transaktion l�schen wollen?");
		if (alert.showAndWait().get() == ButtonType.OK) {
			DatabaseService.getInstance().delete(transaction);
		}
	}

	private static void deleteContinuousTransaction(final Transaction transaction) {
		final Alert alert = new Alert(AlertType.CONFIRMATION,
				"Diese Transaktion wiederholt sich. Sollen alle zugeh�rigen Transaktionen gel�sch werden?",
				ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.setHeaderText(null);
		alert.setTitle("Sich wiederholende Transaktion l�schen?");

		final ButtonType pressedButton = alert.showAndWait().get();

		if (pressedButton == ButtonType.YES) {
			DatabaseService.getInstance().deleteAllContinuousTransactions(transaction.getContinuousTransaction());
		} else if (pressedButton == ButtonType.NO) {
			final boolean ownTransaction = DatabaseService.getInstance().beginTransaction();

			try {
				ContinuousTransactionService.splitContinuousTransaction(transaction);
			} catch (final Exception e) {
				DatabaseService.getInstance().rollbackTransaction();
			}

			if (ownTransaction) {
				DatabaseService.getInstance().commitTransaction();
			}
		}

	}

}
