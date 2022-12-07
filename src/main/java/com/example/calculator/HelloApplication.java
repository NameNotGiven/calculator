package com.example.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text tNumber1 = new Text("Number A:");
        Text tNumber2 = new Text("Number B:");
        Text tResult = new Text("Ans:");
        TextField tfNumber1 = new TextField();
        TextField tfNumber2 = new TextField();
        TextField tfResult = new TextField();
        tfResult.setEditable(false);

        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        Button btMultiply = new Button("*");
        Button btDivide = new Button("/");

        GridPane calcnum = new GridPane();
        calcnum.setAlignment(Pos.BOTTOM_CENTER);
        calcnum.setPadding(new Insets(10));
        calcnum.setHgap(10);
        calcnum.setVgap(10);
        calcnum.add(tNumber1, 0, 0);
        calcnum.add(tfNumber1, 1, 0);
        calcnum.add(tNumber2, 0, 1);
        calcnum.add(tfNumber2, 1, 1);

        GridPane calcfuncs = new GridPane();
        calcfuncs.setAlignment(Pos.BOTTOM_CENTER);
        calcfuncs.setPadding(new Insets(10));
        calcfuncs.setHgap(10);
        calcfuncs.setVgap(10);
        calcfuncs.add(btAdd, 0, 0);
        calcfuncs.add(btSubtract, 1, 0);
        calcfuncs.add(btMultiply, 0, 1);
        calcfuncs.add(btDivide, 1, 1);


        HBox calcans = new HBox(10);
        calcans.setAlignment(Pos.TOP_CENTER);
        calcans.setPadding(new Insets(10));
        calcans.getChildren().addAll(tResult, tfResult);
/*
        TilePane calcBottom = new TilePane();
        calcBottom.setHgap(10);
        calcBottom.setVgap(10);
        calcBottom.setPrefColumns(2);
        calcBottom.setPrefRows(2);
        calcBottom.setPadding(new Insets(10, 10, 10, 10));
        calcBottom.setAlignment(Pos.BOTTOM_CENTER);
        calcBottom.setPadding(new Insets(10));
*/

        BorderPane pane = new BorderPane();
        pane.setCenter(calcnum);
        pane.setTop(calcans);
        pane.setBottom(calcfuncs);

        btAdd.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a + b));
        });

        btSubtract.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a - b));
        });

        btMultiply.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a * b));
        });

        btDivide.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(b == 0 ? "can't divide by 0 dummy" : String.valueOf(a / b));
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("javafx calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private static double getDoubleFromTextField(TextField t) {
        return Double.parseDouble(t.getText());
    }

    public static void main(String[] args) {
        launch(args);
    }
}