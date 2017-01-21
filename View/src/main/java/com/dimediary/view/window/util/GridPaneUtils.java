package com.dimediary.view.window.util;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class GridPaneUtils {

	public static Node getGridPaneCell(final GridPane gridPane, final int row, final int column) {
		for (final Node node : gridPane.getChildren()) {
			if (GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}

}
