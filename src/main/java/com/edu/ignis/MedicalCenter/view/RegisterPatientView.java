package com.edu.ignis.MedicalCenter.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterPatientView extends VBox {

  public RegisterPatientView(Stage stage) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label("Register patient");
    title.setAlignment(Pos.CENTER);
    title.setMaxWidth(Double.MAX_VALUE);
    title.setStyle("-fx-font-weight: bold;"  +
      "-fx-font-size: 18px;" +
      "-fx-font-family: System;" +
      "-fx-text-fill: darkblue;"
    );
    Label lbName = new Label("Name: ");
    TextField fieldName = new TextField();
    Label lbLastName = new Label("Last name: ");
    TextField fieldLastName = new TextField();
    Label lbDni = new Label("DNI: ");
    TextField fieldDni = new TextField();
    Label lbBirth = new Label("Birh date: ");
    TextField fieldBirth = new TextField();
    Label lbInsurance = new Label("Insurance: ");
    TextField fieldInsurance = new TextField();


    Button btnSave = new Button("Save");
    Button btnClean = new Button("Clean");
    Button btnBack = new Button("Back");

    btnBack.setOnAction(e -> {
      MenuView menu = new MenuView(stage);
      stage.setScene(new Scene(menu, 400, 400));
    });


    HBox box = new HBox(10, btnClean, btnSave, btnBack);
    box.setAlignment(Pos.CENTER);

    getChildren().addAll(title, lbName, fieldName, lbLastName, fieldLastName, lbDni,
      fieldDni, lbBirth, fieldBirth, lbInsurance, fieldInsurance, box
    );
  }
}
