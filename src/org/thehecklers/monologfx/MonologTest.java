/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thehecklers.monologfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mark
 */
public class MonologTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("_Test Dialogs");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                MonologFXButton mlb = MonologFXButtonBuilder.create()
//                        .defaultButton(true)
//                        .icon("dialog_apply.png")
//                        .type(MonologFXButton.Type.OK)
//                        .build();

                MonologFXButton mlb = new MonologFXButton();
                mlb.setDefaultButton(true);
                mlb.setType(MonologFXButton.Type.OK);
                
//                MonologFXButton mlb2 = MonologFXButtonBuilder.create()
//                        .cancelButton(true)
//                        .icon("dialog_cancel.png")
//                        .type(MonologFXButton.Type.CANCEL)
//                        .build();

                MonologFXButton mlb2 = new MonologFXButton();
                mlb2.setDefaultButton(true);
                mlb2.setType(MonologFXButton.Type.CANCEL);

//                MonologFX mono = MonologFXBuilder.create()
//                        .modal(true)
//                        .message("Welcome to MonologFX! Please feel free to try it out and share your thoughts.")
//                        .titleText("Important Announcement")
//                        .button(mlb)
//                        .button(mlb2)
//                        .buttonAlignment(MonologFX.ButtonAlignment.CENTER)
//                        .build();

                MonologFX mono = new MonologFX();
                mono.setModal(true);
                mono.setMessage("Welcome to MonologFX! Let's do this.");
                mono.setTitleText("Important Announcement");
                mono.addButton(mlb);
                mono.addButton(mlb2);
                mono.setDisplayTime(5);
                MonologFXButton.Type retval = mono.show();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("MonologFX Test Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
