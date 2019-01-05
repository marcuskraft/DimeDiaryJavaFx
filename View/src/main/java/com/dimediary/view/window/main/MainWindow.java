/**
 * Sample Skeleton for 'MainWindow.fxml' Controller Class
 */

package com.dimediary.view.window.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dimediary.view.Main;
import com.dimediary.view.window.bankaccount.BankAccountDialog;
import com.dimediary.view.window.bankaccount.BankaccountCategoryDialog;
import com.dimediary.view.window.category.CategoryDialog;
import com.dimediary.view.window.util.WindowCreater;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Window;

public class MainWindow extends Window {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="menuClose"
	private MenuItem menuClose; // Value injected by FXMLLoader

	@FXML // fx:id="menuCategory"
	private MenuItem menuCategory; // Value injected by FXMLLoader

	@FXML // fx:id="menuAccount"
	private MenuItem menuAccount; // Value injected by FXMLLoader

	@FXML // fx:id="menuAccCategory"
	private MenuItem menuAccCategory; // Value injected by FXMLLoader

	@FXML // fx:id="tabPane"
	private TabPane tabPane; // Value injected by FXMLLoader

	@FXML // fx:id="overviewTab"
	private Tab overviewTab; // Value injected by FXMLLoader

	@FXML // fx:id="diagramTab"
	private Tab diagramTab; // Value injected by FXMLLoader

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.menuClose != null : "fx:id=\"menuClose\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuCategory != null : "fx:id=\"menuCategory\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuAccount != null : "fx:id=\"menuAccount\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuAccCategory != null : "fx:id=\"menuAccCategory\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.overviewTab != null : "fx:id=\"overviewTab\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.diagramTab != null : "fx:id=\"diagramTab\" was not injected: check your FXML file 'MainWindow.fxml'.";

		this.init();

	}

	@FXML
	void onMenuAccount(final ActionEvent event) {
		final WindowCreater<BankAccountDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/AccountDialog.fxml"), "Konten bearbeiten");
	}

	@FXML
	void onMenuCategory(final ActionEvent event) {
		final WindowCreater<CategoryDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/CategoryDialog.fxml"),
				"Kategorien bearbeiten");
	}

	@FXML
	void onMenuClose(final ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void onMenuAccCategory(final ActionEvent event) {
		final WindowCreater<BankaccountCategoryDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/BankaccountCategoryDialog.fxml"),
				"Konto-Kategorien bearbeiten");
	}

	private void init() {
		this.LoadOverviewTab();
		this.LoadDiagramTab();
	}

	private void LoadOverviewTab() {
		final FXMLLoader loader = new FXMLLoader(Main.class.getResource("design/scene/Overview.fxml"));
		Node node;
		try {
			node = loader.load();
		} catch (final IOException e) {
			throw new IllegalStateException("fxml file could not be found", e);
		}
		this.overviewTab.setContent(node);
	}

	private void LoadDiagramTab() {
		final FXMLLoader loader = new FXMLLoader(Main.class.getResource("design/scene/Diagrams.fxml"));
		Node node;
		try {
			node = loader.load();
		} catch (final IOException e) {
			throw new IllegalStateException("fxml file could not be found", e);
		}
		this.diagramTab.setContent(node);
	}

}
