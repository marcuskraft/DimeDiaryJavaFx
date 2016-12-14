package com.dimediary.view.design.window;

import java.io.IOException;

import com.dimediary.model.entities.Transaction;
import com.dimediary.view.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TransactionButtonFactory {

	public static TransactionButton createTransactionButton(final String text, final Transaction transaction,
			final MainWindow mainWindow) {
		final TransactionButton transactionButton = new TransactionButton(text, transaction);

		transactionButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent event) {
				final FXMLLoader loader = new FXMLLoader(
						Main.class.getResource("design/window/TransactionDialog.fxml"));

				final Stage stage = new Stage(StageStyle.DECORATED);
				try {
					stage.setScene(new Scene((Pane) loader.load()));
				} catch (final IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				final TransactionDialog controller = loader.<TransactionDialog> getController();
				controller.setTransaction(transaction);
				controller.setMainWindow(mainWindow);
				stage.initModality(Modality.WINDOW_MODAL);
				stage.show();

			}
		});

		return transactionButton;
	}

}
