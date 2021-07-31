package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;

public class MyThread implements Runnable {
	Arc myArc1;
	Arc myArc2;
	Arc myArc3;
	Arc myArc4;
	Arc myArc5;
	Text myText = new Text();
	Text object1 = new Text();
	Text object2 = new Text();
	Text btn1, btn2, btn3, btn4;
	Button button1, button2, button3, button4;
	
	
	static String objectOne, objectTwo;

	public MyThread(Arc arc1, Arc arc2, Arc arc3, Arc arc4, Arc arc5, Text theText, Text object1, Text object2, Text btn1,
			Text btn2, Text btn3, Text btn4, Button button1, Button button2, Button button3, Button button4 ) {
		this.myArc1 = arc1;
		this.myArc2 = arc2;
		this.myArc3 = arc3;
		this.myArc4 = arc4;
		this.myArc5 = arc5;
		this.myText = theText;
		this.object1 = object1;	
		this.object2 = object2;
		this.btn1 = btn1;
		this.btn2 = btn2;
		this.btn3 = btn3;
		this.btn4 = btn4;
		this.button1 = button1;
		this.button2 = button2;
		this.button3 = button3;
		this.button4 = button4;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {		
			    MainBoard.report.setDisable(false);
				for(int i = 0; i < 10; i++){
				this.button1.setDisable(false);	
				this.button2.setDisable(false);	
				this.button3.setDisable(false);	
				this.button4.setDisable(false);	
				this.object1.setText(FileManager.manageFile1().get(i));	
				this.object2.setText(FileManager.manageFile2().get(i));	
				if(i == 8){
					this.btn2.setText(FileManager.manageFile3().get(i));
					this.btn1.setText(FileManager.manageFile4().get(i));
					this.btn3.setText(FileManager.manageFile5().get(i));
					this.btn4.setText(FileManager.manageFile6().get(i));
				}else if (i == 4){
					this.btn3.setText(FileManager.manageFile3().get(i));
					this.btn2.setText(FileManager.manageFile4().get(i));
					this.btn1.setText(FileManager.manageFile5().get(i));
					this.btn4.setText(FileManager.manageFile6().get(i));
				}else if (i == 7){
					this.btn4.setText(FileManager.manageFile3().get(i));
					this.btn3.setText(FileManager.manageFile4().get(i));
					this.btn2.setText(FileManager.manageFile5().get(i));
					this.btn1.setText(FileManager.manageFile6().get(i));
				}else{
				this.btn1.setText(FileManager.manageFile3().get(i));
				this.btn2.setText(FileManager.manageFile4().get(i));
				this.btn3.setText(FileManager.manageFile5().get(i));
				this.btn4.setText(FileManager.manageFile6().get(i));
				}
				this.myArc1.setVisible(true);
				this.myArc2.setVisible(true);
				this.myArc3.setVisible(true);
				this.myArc4.setVisible(true);
				this.myArc5.setVisible(true);
				this.myText.setText("5");
				Thread.sleep(1000);
				this.myArc1.setVisible(false);
				this.myText.setText("4");
				Thread.sleep(1000);
				this.myArc2.setVisible(false);
				this.myText.setText("3");
				Thread.sleep(1000);
				this.myArc3.setVisible(false);
				this.myText.setText("2");
				Thread.sleep(1000);
				this.myArc4.setVisible(false);
				this.myText.setText("1");
				Thread.sleep(1000);
				this.myArc5.setVisible(false);
				this.myText.setText("0");
				Thread.sleep(1000);
				this.button1.setDisable(true);
				this.button2.setDisable(true);	
				this.button3.setDisable(true);	
				this.button4.setDisable(true);	
				Thread.sleep(900);
				}
				MainBoard.endGame.setVisible(true);
				
				try {
					GameDatabase.insertPlayer(MainBoard.competitor.getText(), 
							Integer.parseInt(MainBoard.currentPoints.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    String current = "";
		while(!MainBoard.timeStack.isEmpty()){			
			current += MainBoard.timeStack.pop() + "\n";			
		}
		MainBoard.lateralText.setText(current);
	}
	

}
