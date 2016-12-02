/**
 * Sample Skeleton for 'MainWindow.fxml' Controller Class
 */

package com.dimediary.view.design.window;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

public class MainWindow {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="tabJanuary"
	private Tab tabJanuary; // Value injected by FXMLLoader

	@FXML // fx:id="tableJanuary"
	private TableView<?> tableJanuary; // Value injected by FXMLLoader

	@FXML // fx:id="tabFebruary"
	private Tab tabFebruary; // Value injected by FXMLLoader

	@FXML // fx:id="tableFebruary"
	private TableView<?> tableFebruary; // Value injected by FXMLLoader

	@FXML // fx:id="tabMarch"
	private Tab tabMarch; // Value injected by FXMLLoader

	@FXML // fx:id="tableMarch"
	private TableView<?> tableMarch; // Value injected by FXMLLoader

	@FXML // fx:id="tabAprile"
	private Tab tabAprile; // Value injected by FXMLLoader

	@FXML // fx:id="tableAprile"
	private TableView<?> tableAprile; // Value injected by FXMLLoader

	@FXML // fx:id="tabMay"
	private Tab tabMay; // Value injected by FXMLLoader

	@FXML // fx:id="tableMay"
	private TableView<?> tableMay; // Value injected by FXMLLoader

	@FXML // fx:id="tabJune"
	private Tab tabJune; // Value injected by FXMLLoader

	@FXML // fx:id="tableJune"
	private TableView<?> tableJune; // Value injected by FXMLLoader

	@FXML // fx:id="tabJuly"
	private Tab tabJuly; // Value injected by FXMLLoader

	@FXML // fx:id="tableJuly"
	private TableView<?> tableJuly; // Value injected by FXMLLoader

	@FXML // fx:id="tabAugust"
	private Tab tabAugust; // Value injected by FXMLLoader

	@FXML // fx:id="tableAugust"
	private TableView<?> tableAugust; // Value injected by FXMLLoader

	@FXML // fx:id="tabSeptembre"
	private Tab tabSeptembre; // Value injected by FXMLLoader

	@FXML // fx:id="tableSeptembre"
	private TableView<?> tableSeptembre; // Value injected by FXMLLoader

	@FXML // fx:id="tabOctober"
	private Tab tabOctober; // Value injected by FXMLLoader

	@FXML // fx:id="tableOctober"
	private TableView<?> tableOctober; // Value injected by FXMLLoader

	@FXML // fx:id="tabNovember"
	private Tab tabNovember; // Value injected by FXMLLoader

	@FXML // fx:id="tableNovember"
	private TableView<?> tableNovember; // Value injected by FXMLLoader

	@FXML // fx:id="tabDecember"
	private Tab tabDecember; // Value injected by FXMLLoader

	@FXML // fx:id="tableDecember"
	private TableView<?> tableDecember; // Value injected by FXMLLoader

	@FXML // fx:id="buttonBack"
	private Button buttonBack; // Value injected by FXMLLoader

	@FXML // fx:id="buttonForward"
	private Button buttonForward; // Value injected by FXMLLoader

	@FXML // fx:id="buttonActualMonth"
	private Button buttonActualMonth; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxAccount"
	private ComboBox<?> comboBoxAccount; // Value injected by FXMLLoader

	@FXML // fx:id="SpinnerYear"
	private Spinner<?> SpinnerYear; // Value injected by FXMLLoader

	@FXML // fx:id="buttonAddTransaction"
	private Button buttonAddTransaction; // Value injected by FXMLLoader

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.tabJanuary != null : "fx:id=\"tabJanuary\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableJanuary != null : "fx:id=\"tableJanuary\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabFebruary != null : "fx:id=\"tabFebruary\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableFebruary != null : "fx:id=\"tableFebruary\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabMarch != null : "fx:id=\"tabMarch\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableMarch != null : "fx:id=\"tableMarch\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabAprile != null : "fx:id=\"tabAprile\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableAprile != null : "fx:id=\"tableAprile\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabMay != null : "fx:id=\"tabMay\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableMay != null : "fx:id=\"tableMay\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabJune != null : "fx:id=\"tabJune\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableJune != null : "fx:id=\"tableJune\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabJuly != null : "fx:id=\"tabJuly\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableJuly != null : "fx:id=\"tableJuly\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabAugust != null : "fx:id=\"tabAugust\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableAugust != null : "fx:id=\"tableAugust\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabSeptembre != null : "fx:id=\"tabSeptembre\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableSeptembre != null : "fx:id=\"tableSeptembre\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabOctober != null : "fx:id=\"tabOctober\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableOctober != null : "fx:id=\"tableOctober\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabNovember != null : "fx:id=\"tabNovember\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableNovember != null : "fx:id=\"tableNovember\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabDecember != null : "fx:id=\"tabDecember\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tableDecember != null : "fx:id=\"tableDecember\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.buttonForward != null : "fx:id=\"buttonForward\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.buttonActualMonth != null : "fx:id=\"buttonActualMonth\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.comboBoxAccount != null : "fx:id=\"comboBoxAccount\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.SpinnerYear != null : "fx:id=\"SpinnerYear\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.buttonAddTransaction != null : "fx:id=\"buttonAddTransaction\" was not injected: check your FXML file 'MainWindow.fxml'.";

	}

}
