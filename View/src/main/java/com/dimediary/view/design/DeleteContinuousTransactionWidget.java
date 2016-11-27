package com.dimediary.view.design;

import java.util.Date;

import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.view.Main;
import com.dimediary.view.design.ui.UiDeleteContinuousTransactionWidget;
import com.dimediary.view.utils.QTUtils;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QDialog;

public class DeleteContinuousTransactionWidget extends UiDeleteContinuousTransactionWidget {

	private final QDialog dialog;

	private final ContinuousTransaction continuousTransaction;
	private final ContinuousTransactionWidget continuousTransactionWidget;

	public DeleteContinuousTransactionWidget(final ContinuousTransactionWidget continuousTransactionWidget,
			final ContinuousTransaction continuousTransaction) {

		this.continuousTransaction = continuousTransaction;
		this.continuousTransactionWidget = continuousTransactionWidget;

		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.dateEdit.setDate(QTUtils.dateToQDate(new Date()));
		this.radioButtonFrom.setChecked(true);

		this.buttonBox.accepted.connect(this, "onOK()");
		this.buttonBox.rejected.connect(this.dialog, "close()");

		this.dialog.exec();
	}

	public void onOK() {
		final QCursor cursor = new QCursor();
		cursor.setShape(Qt.CursorShape.WaitCursor);
		this.dialog.setCursor(cursor);

		if (this.radioButtonFrom.isChecked()) {
			this.continuousTransactionWidget.deleteContinuousTransaction(this.continuousTransaction,
					QTUtils.qDateToDate(this.dateEdit.date()));
		} else {
			this.continuousTransactionWidget.deleteAllContinuousTransactions(this.continuousTransaction);
		}

		cursor.setShape(Qt.CursorShape.ArrowCursor);
		this.dialog.setCursor(cursor);

		this.dialog.close();
		Main.getTransactionDialog().getDialog().close();
	}

}
