/**
 * Sample Skeleton for 'Food.fxml' Controller Class
 */

package it.polito.tdp.food;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.food.model.Congiunta;
import it.polito.tdp.food.model.Food;
import it.polito.tdp.food.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FoodController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPorzioni"
    private TextField txtPorzioni; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalisi"
    private Button btnAnalisi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalorie"
    private Button btnCalorie; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="boxFood"
    private ComboBox<Food> boxFood; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	int porzioni; 
    	
    	try {
    		porzioni = Integer.parseInt(txtPorzioni.getText());
    	}catch(NumberFormatException nfe) {
    		txtResult.appendText("Fomato numero porzioni errato!\n");
    		return;
    	}
    	
    	model.creaGrafo(porzioni);
    	
    	boxFood.getItems().addAll(model.getGrafo().vertexSet());
    	
    	txtResult.appendText("#Vertici: "+model.getGrafo().vertexSet().size()+"\n");
    	txtResult.appendText("#Archi: "+model.getGrafo().edgeSet().size()+"\n");
    	
    }
    
    @FXML
    void doCalorie(ActionEvent event) {
    	
    	if(boxFood.getValue() == null) {
    		txtResult.appendText("Devi selezionare un cibo!\n");
    		return;
    	}
    	
    	List<Congiunta> result = model.getCongiunta(boxFood.getValue());
    	
    	if(result.size() >= 5) {
    		for(int i = 0; i<5; i++) {
    			txtResult.appendText(result.get(i).toString()+"\n");
    		}
    	} else {
    		for(int i = 0; i<result.size(); i++) {
    			txtResult.appendText(result.get(i).toString()+"\n");
    		}
    	}
    	
    }

    @FXML
    void doSimula(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Simulazione...");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPorzioni != null : "fx:id=\"txtPorzioni\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnAnalisi != null : "fx:id=\"btnAnalisi\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCalorie != null : "fx:id=\"btnCalorie\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Food.fxml'.";
        assert boxFood != null : "fx:id=\"boxFood\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Food.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
