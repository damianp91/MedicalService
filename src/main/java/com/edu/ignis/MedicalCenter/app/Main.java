package com.edu.ignis.MedicalCenter.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Label label = new Label("¡Hello world from JavaFX!");
    Scene scene = new Scene(label, 400, 200);
    stage.setScene(scene);
    stage.setTitle("JavaFX Project:MedicalCenter");
    stage.show();
  }
}
