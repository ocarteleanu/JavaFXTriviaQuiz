package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenericsInput {
	
	public <K extends Number> void passObjectsValues (K obj1, K obj2){
		MainBoard.object1.setText(obj1.toString());
		MainBoard.object2.setText(obj2.toString());
				
	}
	
	public <M extends String> void passObjectsValues (M obj1, M obj2){
		MainBoard.object1.setText(obj1.toString());
		MainBoard.object2.setText(obj2.toString());        
    }
}
