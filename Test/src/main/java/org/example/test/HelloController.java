package org.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    Rundfahrt r1 = new Rundfahrt("Wien Rundfahrt");

    @FXML
    private Label welcomeText;
    @FXML
    private TextField zielOrtField;
    @FXML
    private TextField laengeField;
    @FXML
    private TextField siegerField;
    @FXML
    private TextField stundenField;
    @FXML
    private TextField minutenField;

    @FXML
    protected void addEtappe(ActionEvent event) {
        // Die Werte der Textfelder mit der Methode getText() abrufen
        String zielOrt = zielOrtField.getText();
        float laengeText = Integer.parseInt(laengeField.getText());
        String sieger = siegerField.getText();
        int stundenText = Integer.parseInt(stundenField.getText());
        int minutenText = Integer.parseInt(minutenField.getText());

        Etappe etappe = new Etappe(zielOrt,laengeText,sieger,stundenText,minutenText);
        r1.hinzufuegen(etappe);
        welcomeText.setText("Etappe " +  etappe.getNummer() + " hinzugefügt!");
    }

    @FXML
    protected void onHelloButtonClick(){
        welcomeText.setText(r1.toString());
    }
}
