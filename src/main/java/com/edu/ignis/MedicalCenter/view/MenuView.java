package com.edu.ignis.MedicalCenter.view;

import com.edu.ignis.MedicalCenter.model.Appointment;
import com.edu.ignis.MedicalCenter.model.Patient;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuView extends VBox {

  public MenuView(Stage stage) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));
    setAlignment(Pos.CENTER);
    int sizeButton = 160;

    Label title = new Label("MedicalCenter");
    title.setStyle("-fx-font-weight: bold;"  +
      "-fx-font-size: 18px;" +
      "-fx-font-family: System;" +
      "-fx-text-fill: darkblue;"
    );
    Button btnRegister = new Button("Register patient");
    btnRegister.setPrefWidth(sizeButton);
    Button btnCreate = new Button("Create appointment");
    btnCreate.setPrefWidth(sizeButton);
    Button btnExit = new Button("Exit");
    btnExit.setPrefWidth(sizeButton);

    btnRegister.setOnAction(e -> {
      RegisterPatientView register = new RegisterPatientView(stage);
     stage.setScene(new Scene(register, 400, 600));
    });

    btnCreate.setOnAction(e -> {
      CreateAppointmentView createAptm = new CreateAppointmentView(stage);
      stage.setScene(new Scene(createAptm, 400, 600));
    });

    btnExit.setOnAction(e -> {

    });

    getChildren().addAll(title, btnRegister, btnCreate, btnExit);
  }
}
