package com.edu.ignis.MedicalCenter.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateAppointmentView extends VBox {

  public CreateAppointmentView(Stage stage) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));
    
    Label title = new Label("Generate Appointment");
    title.setStyle("-fx-font-weight: bold;"  +
      "-fx-font-size: 18px;" + 
      "-fx-font-family: System;" +
      "-fx-text-fill: darkblue;"
    );
    Label lbName = new Label("Name: ");
    TextField fieldName = new TextField();
  }
}
