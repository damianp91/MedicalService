package com.edu.ignis.MedicalCenter.app;

import com.edu.ignis.MedicalCenter.view.MenuView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    MenuView menu = new MenuView(primaryStage);
    Scene scene = new Scene(menu, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("MedicalCenter");
    primaryStage.show();
  }
}
