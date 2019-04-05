package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtRight;

    @FXML
    private TextArea txtWrong;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	txtRight.clear();
    	txtWrong.clear();
    	String parola = txtParola.getText().trim().replaceAll("[.,\\\\/#!?$%\\\\^&\\\\*;:{}=\\\\-_`~()\\\\[\\\\]\\\"]", "").toLowerCase();
    	Set<String> result = model.getAnagrammi(parola);
    	List<String> lista = new LinkedList<>(result);
		Collections.sort(lista);
    	for(String s : lista) {
    		if(model.isCorrect(s)) {
    			txtRight.appendText(s+"\n");
    		}
    		else txtWrong.appendText(s+"\n");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtRight.clear();
    	txtWrong.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtRight != null : "fx:id=\"txtRight\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}

