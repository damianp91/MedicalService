package com.edu.ignis.MedicalCenter.view;

import com.edu.ignis.MedicalCenter.model.Specialty;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateAppointmentView extends VBox {

  public CreateAppointmentView(Stage stage) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label("Generate Appointment");
    title.setMaxWidth(Double.MAX_VALUE);
    title.setAlignment(Pos.CENTER);
    title.setStyle("-fx-font-weight: bold;"  +
      "-fx-font-size: 18px;" +
      "-fx-font-family: System;" +
      "-fx-text-fill: darkblue;"
    );
    Label lbName = new Label("Name patient: ");
    TextField fieldName = new TextField();
    Label lbSpecialty = new Label("Specialty: ");
    ComboBox<Specialty> fieldSpecialty = new ComboBox<>();
    fieldSpecialty.getItems().addAll(Specialty.values());

    Button btnSave = new Button("Save");
    Button btnClean = new Button("Clean");
    Button btnBack = new Button("Back");

    btnBack.setOnAction(e -> {
      MenuView menu = new MenuView(stage);
      stage.setScene(new Scene(menu, 400, 400));
    });
    
    HBox box = new HBox(10, btnClean, btnSave, btnBack);
    box.setAlignment(Pos.CENTER);

    getChildren().addAll(title, lbName, fieldName, lbSpecialty, fieldSpecialty, box);
  }
}
