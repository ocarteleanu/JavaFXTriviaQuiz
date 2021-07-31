package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class MainBoard extends Application {
	static Arc arc1, arc2, arc3, arc4, arc5;
	static Text timer, names, points, object1, pluss, object2, op1, op2, op3, op4, currentPoints, list, endGame, 
	lateralText, pointsList;
	static Scanner scan;
	static String objectOne, objectTwo;	
	static Button option1, option2, option3, option4, report;
	static TextField competitor;
	static int j = 0;
	static Player player;
	static ArrayList<Player> sortedList = new ArrayList<>();
	static ArrayList<Player> preSortedList = new ArrayList<>();
	static Timestamp timestamp;
	static Date date;
	static Stack<String> timeStack = new Stack<>();
	static Stack<Player> listStack = new Stack<>();
	static StringBuilder sb;
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);	
	}	*/

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox firstBox = new VBox();
		HBox secondBox = new HBox();
		VBox thirdBox = new VBox();
		HBox fourthBox = new HBox();
		VBox fifthBox = new VBox();
		Pane paneOnTop = new Pane();
		Pane paneInTheMiddle = new Pane();
		Pane paneOnBottom = new Pane();
		Pane lateral = new Pane();
		Pane controlPane = new Pane();
		
		paneOnTop.setStyle("-fx-background-color: #" + "ffe6cc;");
		paneOnTop.setPrefSize(650, 350);
		paneInTheMiddle.setStyle("-fx-background-color: #" + "b3f0ff;");
		paneInTheMiddle.setPrefSize(650, 70);
		paneOnBottom.setStyle("-fx-background-color: #" + "ffe6cc;");
		paneOnBottom.setPrefSize(650, 120);
		lateral.setStyle("-fx-background-color: #" + "ffff00;");
		lateral.setPrefSize(200, 550);
		controlPane.setPrefSize(900, 250);
		
		arc1 = new Arc();
		arc2 = new Arc();
		arc3 = new Arc();
		arc4 = new Arc();
		arc5 = new Arc();
		
		arc1.setCenterX(560.0f); 
		arc1.setCenterY(100.0f); 
		arc1.setRadiusX(60.0f); 
		arc1.setRadiusY(60.0f); 
		arc1.setStartAngle(0.0f); 
		arc1.setLength(72.0f); 
		arc1.setType(ArcType.ROUND);
		arc1.setFill(Color.rgb(255, 179, 179));
		arc1.setVisible(false);
		
		arc2.setCenterX(560.0f); 
		arc2.setCenterY(100.0f); 
		arc2.setRadiusX(60.0f); 
		arc2.setRadiusY(60.0f); 
		arc2.setStartAngle(72.0f); 
		arc2.setLength(72.0f); 
		arc2.setType(ArcType.ROUND);
		arc2.setFill(Color.rgb(255, 153, 153));
		arc2.setVisible(false);
		
		arc3.setCenterX(560.0f); 
		arc3.setCenterY(100.0f); 
		arc3.setRadiusX(60.0f); 
		arc3.setRadiusY(60.0f); 
		arc3.setStartAngle(144.0f); 
		arc3.setLength(72.0f); 
		arc3.setType(ArcType.ROUND);
		arc3.setFill(Color.rgb(255, 128, 128));
		arc3.setVisible(false);
		
		arc4.setCenterX(560.0f); 
		arc4.setCenterY(100.0f); 
		arc4.setRadiusX(60.0f); 
		arc4.setRadiusY(60.0f); 
		arc4.setStartAngle(216.0f); 
		arc4.setLength(72.0f); 
		arc4.setType(ArcType.ROUND);
		arc4.setFill(Color.rgb(255, 102, 102));
		arc4.setVisible(false);
		
		arc5.setCenterX(560.0f); 
		arc5.setCenterY(100.0f); 
		arc5.setRadiusX(60.0f); 
		arc5.setRadiusY(60.0f); 
		arc5.setStartAngle(288.0f); 
		arc5.setLength(72.0f); 
		arc5.setType(ArcType.ROUND);
		arc5.setFill(Color.rgb(255, 77, 77));
		arc5.setVisible(false);
		
		Circle circle = new Circle();
		circle.setFill(null);
		circle.setCenterX(560.0f);
		circle.setCenterY(100.0f);
		circle.setRadius(60.0f);
		circle.setStroke(Color.DARKGREY);
		timer = new Text();
		timer.setLayoutX(550.0);
		timer.setLayoutY(35.0);
		timer.setText("5");
		timer.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
		timer.setFill(Color.STEELBLUE);
		names = new Text();
		names.setLayoutX(50.0);
		names.setLayoutY(25.0);
		names.setText("Name");
		names.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		names.setFill(Color.STEELBLUE);
		points = new Text();
		points.setLayoutX(300.0);
		points.setLayoutY(25.0);
		points.setText("Total points");
		points.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		points.setFill(Color.STEELBLUE);
		object1 = new Text();
		object1.setLayoutX(120.0);
		object1.setLayoutY(35.0);
		object1.setText("Total points");
		object1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		object1.setFill(Color.STEELBLUE);
		pluss = new Text();
		pluss.setLayoutX(330.0);
		pluss.setLayoutY(35.0);
		pluss.setText("Total points");
		pluss.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		pluss.setFill(Color.STEELBLUE);
		object2 = new Text();
		object2.setLayoutX(430.0);
		object2.setLayoutY(35.0);
		object2.setText("Total points");
		object2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		object2.setFill(Color.STEELBLUE);
		object1.setText(objectOne);
		object2.setText(objectTwo);
		pluss.setText("+");
	
		option1 = new Button("Option 1");
		option2 = new Button("Option 2");
		option3 = new Button("Option 3");
		option4 = new Button("Option 4");
		report = new Button("Generate Report");
		
		option1.setStyle("-fx-base: yellow;");
		option1.setLayoutX(50.0);
		option1.setLayoutY(25.0);
			
		option2.setStyle("-fx-base: yellow;");
		option2.setLayoutX(200.0);
		option2.setLayoutY(25.0);
		
		option3.setStyle("-fx-base: yellow;");
		option3.setLayoutX(350.0);
		option3.setLayoutY(25.0);
	
		option4.setStyle("-fx-base: yellow;");
		option4.setLayoutX(500.0);
		option4.setLayoutY(25.0);
		
		report.setStyle("-fx-base: orange;");
		report.setLayoutX(250.0);
		report.setLayoutY(100.0);
		
		op1 = new Text();
		op1.setText("Option 1");
		op1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
		op1.setLayoutX(60.0);
		op1.setLayoutY(70.0);
		
		op2 = new Text();
		op2.setText("Option 2");
		op2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
		op2.setLayoutX(210.0);
		op2.setLayoutY(70.0);
		
		op3 = new Text();
		op3.setText("Option 3");
		op3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
		op3.setLayoutX(360.0);
		op3.setLayoutY(70.0);
		
		op4 = new Text();
		op4.setText("Option 4");
		op4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
		op4.setLayoutX(510.0);
		op4.setLayoutY(70.0);
			
		currentPoints = new Text();		
		currentPoints.setText("0");
		currentPoints.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
		currentPoints.setFill(Color.STEELBLUE);
		currentPoints.setLayoutX(700);
		currentPoints.setLayoutY(70);
		
		list = new Text();
		list.setText("");
		list.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 15));
		list.setFill(Color.STEELBLUE);
		list.setLayoutX(50);
		list.setLayoutY(50);
		
		pointsList = new Text();
		pointsList.setText("");
		pointsList.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 15));
		pointsList.setFill(Color.STEELBLUE);
		pointsList.setLayoutX(320);
		pointsList.setLayoutY(50);
		
		endGame = new Text();
		endGame.setText("End Game!");
		endGame.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
		endGame.setFill(Color.RED);
		endGame.setLayoutX(500.0);
		endGame.setLayoutY(200.0);
		endGame.setVisible(false);
		
		lateralText = new Text();
		lateralText.setLayoutX(10);
		lateralText.setLayoutY(20);
		
		competitor = new TextField();		
		competitor.setPrefSize(600.0, 40.0);
		competitor.setLayoutX(50);
		competitor.setLayoutY(30);
		competitor.setPromptText("Enter your name and press <Enter>");
		competitor.setFont(Font.font("verdana", 30));
		competitor.setEditable(true);
		competitor.requestFocus();
		
				
		paneOnTop.getChildren().addAll(arc1, arc2, arc3, arc4, arc5, timer, circle, names, points, list, pointsList,
				endGame);
		paneInTheMiddle.getChildren().addAll(object1, pluss, object2);
		paneOnBottom.getChildren().addAll(option1, option2, option3, option4, op1, op2, op3, op4);
		lateral.getChildren().addAll(lateralText);
		fifthBox.setPadding(new Insets(0, 25, 0, 25));
		fifthBox.getChildren().add(lateral);
		controlPane.getChildren().addAll(currentPoints, report, competitor);
		fourthBox.getChildren().addAll(controlPane);
		thirdBox.getChildren().addAll(paneOnTop, paneInTheMiddle, paneOnBottom);
		secondBox.getChildren().addAll(thirdBox, fifthBox);
		firstBox.getChildren().addAll(secondBox, fourthBox);
		
		 option1.setOnAction(new EventHandler<ActionEvent>() {
			 
		       	@Override
		           public void handle(ActionEvent event) {	
		       		if(FileManager.isTheAnswer(op1.getText(), FileManager.objectThirdGood)){
		       			j++;
		       			currentPoints.setText("" + j);
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 1 + " point";
		       			timeStack.push(temp);
		       		}else {
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 0 + " points";
		       			timeStack.push(temp);
		       		}
		       	   } 
		      });	
		 
		 option2.setOnAction(new EventHandler<ActionEvent>() {
			 
		       	@Override
		           public void handle(ActionEvent event) {	
		       		if(object2.getText().equals("4") || object2.getText().equals("4.0")){
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 0 + " points";
		       			timeStack.push(temp);
		       		}else{
		       		if(FileManager.isTheAnswer(op2.getText(), FileManager.objectThirdGood)){
		       			j++;
		       			currentPoints.setText("" + j);
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 1 + " point";
		       			timeStack.push(temp);
		       		}else {
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 0 + " points";
		       			timeStack.push(temp);
		       		}
		       	   } 
		       	}
		      });	
		 
		 option3.setOnAction(new EventHandler<ActionEvent>() {
			 
		       	@Override
		           public void handle(ActionEvent event) {	
		       		if(FileManager.isTheAnswer(op3.getText(), FileManager.objectThirdGood)){
		       			j++;
		       			currentPoints.setText("" + j);
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 1 + " point";
		       			timeStack.push(temp);
		       		}else {
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 0 + " points";
		       			timeStack.push(temp);
		       		}
		       	   } 
		      });	
		 
		 option4.setOnAction(new EventHandler<ActionEvent>() {
			 
		       	@Override
		           public void handle(ActionEvent event) {	
		       		if(FileManager.isTheAnswer(op4.getText(), FileManager.objectThirdGood)){
		       			j++;
		       			currentPoints.setText("" + j);
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 1 + " point";
		       			timeStack.push(temp);
		       		}else {
		       			option1.setDisable(true);
		       			option2.setDisable(true);
		       			option3.setDisable(true);
		       			option4.setDisable(true);
		       			date = new Date();
		       			timestamp = new Timestamp(date.getTime());
		       			String temp = timestamp.toString() + "\nQuestion " + j + "  " + 0 + " points";
		       			timeStack.push(temp);
		       		}
		       	   } 
		      });	
		
		 report.setOnAction(new EventHandler<ActionEvent>() {
			 
		       	@Override
		           public void handle(ActionEvent event) {	
		       			String playersList = "";
		       			String playersPoints = "";
		       			
		       			try {
		       				preSortedList = GameDatabase.findAllPeople();
		       				for(Player play : preSortedList){
		       				listStack.push(play);
		       				}
		       				if(listStack.size() >= 10){
		       				for(int k = 0; k< 10; k++){
		       					sortedList.add(listStack.pop());
		       				}
		       				}
							Collections.sort(sortedList, new ScoreComparator());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		       			try{
		       			for(Player pl : sortedList){	
		       				playersList += pl.getName() + "\n";
		       				playersPoints += pl.getPoint() + "\n";
		       			}
		       			}catch(Exception e){
		       				e.getMessage();
		       			}		       		
		       			list.setText(playersList);
		       			pointsList.setText(playersPoints);
		       			report.setDisable(true);
		       	   } 
		      });
		 
		Scene mainScene = new Scene(firstBox, 900, 650);
		mainScene.setFill(Color.ALICEBLUE);
		primaryStage.setScene(mainScene);
		mainScene.setOnKeyPressed((final KeyEvent keyEvent) -> {
	        if (keyEvent.getCode() == KeyCode.ENTER) {
	        	competitor.setEditable(false);
	        	MyThread myThread = new MyThread(arc1, arc2, arc3, arc4, arc5, timer, object1, object2, 
	    				op1, op2, op3, op4, option1, option2, option3, option4);
	    		Thread countDown = new Thread(myThread);
	    		countDown.start();	
	        }
	        });
		
		primaryStage.setTitle("Questions challenge");
		primaryStage.show();
					
	}	
	
	public static int maxLength(ArrayList<Player> thatList){
		int maxL = 1;
		for(int r = 0; r < thatList.size(); r++){
			if(thatList.get(r).getName().length() > maxL){
				maxL = thatList.get(r).getName().length();
			}
		}
		return maxL;
	}

}
