package org.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    org.example.test.Rundfahrt r1 = new org.example.test.Rundfahrt("Wien Rundfahrt");
    org.example.test.Etappe e1 = new org.example.test.Etappe("Wien",100,"Jakob",3,40);
    org.example.test.Etappe e2 = new Etappe("Wien",200,"Jakob",2,12);


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(r1.toString());
    }

    @FXML
    protected void addEtappe(){
        r1.hinzufuegen(e1);
        r1.hinzufuegen(e2);
    }
}
