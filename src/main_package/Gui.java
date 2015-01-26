package main_package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.security.*;

public class Gui extends Application {

   Encode encode = null;

    @Override
    public void start(Stage primaryStage)  throws UnsupportedEncodingException{
        TextField tf_input = new TextField("Enter the input value here");
        TextField tf_hash_value = new TextField("Hash Value");
        Button hash_button = new Button("Press for Hash Value");

        try{
            encode = new Encode();
        }
        catch(final NoSuchAlgorithmException e) {
           e.printStackTrace();
        }





        hash_button.setOnAction(e -> {

        	   tf_hash_value.setText(getAnswer(tf_input.getText()));

        }
        );




        VBox root = new VBox(30);
        root.getChildren().add(tf_input);
        root.getChildren().add(tf_hash_value);
        root.getChildren().add(hash_button);
        primaryStage.setScene(new Scene(root, 700, 250));
	primaryStage.show();
    }

            	public String getAnswer(String s){

        	    encode.setInput(s);
        	    String h = null;
        	try{
        	 h = encode.getHashAsHex();
        	}
        	catch(final UnsupportedEncodingException ab) {
        	   ab.printStackTrace();
        	}
        	return h;
        	}

    public static void main(String[] args){
        launch(args);
    }
}
