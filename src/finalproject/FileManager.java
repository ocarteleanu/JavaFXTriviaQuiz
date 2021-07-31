package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
	
	static ArrayList<String> objectFirst = new ArrayList<>();
	static ArrayList<String> objectSecond = new ArrayList<>();
	static ArrayList<String> objectThirdGood = new ArrayList<>();
	static ArrayList<String> objectFourth = new ArrayList<>();
	static ArrayList<String> objectFifth = new ArrayList<>();
	static ArrayList<String> objectSixth = new ArrayList<>();
	static String objectToFirst, objectToSecond, objectToThird, objectToFourth, objectToFifth, objectToSixth;
	static Scanner scan;
	
	public static ArrayList<String>  manageFile1() {
		try {
			File file = new File("input.txt");
			scan = new Scanner(file);
			for(int i = 0; i < 10; i++){
				objectToFirst = scan.next();
				objectFirst.add(objectToFirst);
				objectToSecond = scan.next();
				objectSecond.add(objectToSecond);
				objectToThird = scan.next();
				objectThirdGood.add(objectToThird);
				objectToFourth = scan.next();
				objectFourth.add(objectToFourth);
				objectToFifth = scan.next();
				objectFifth.add(objectToFifth);
				objectToSixth = scan.next();
				objectSixth.add(objectToSixth);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectFirst;
	}
	
	public static ArrayList<String>  manageFile2() {
		try {
			File file = new File("input.txt");
			scan = new Scanner(file);
			for(int i = 0; i < 10; i++){
				objectToFirst = scan.next();
				objectFirst.add(objectToFirst);
				objectToSecond = scan.next();
				objectSecond.add(objectToSecond);
				objectToThird = scan.next();
				objectThirdGood.add(objectToThird);
				objectToFourth = scan.next();
				objectFourth.add(objectToFourth);
				objectToFifth = scan.next();
				objectFifth.add(objectToFifth);
				objectToSixth = scan.next();
				objectSixth.add(objectToSixth);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectSecond;
	}
	
	public static ArrayList<String>  manageFile3() {
		try {
			File file = new File("input.txt");
			scan = new Scanner(file);
			for(int i = 0; i < 10; i++){
				objectToFirst = scan.next();
				objectFirst.add(objectToFirst);
				objectToSecond = scan.next();
				objectSecond.add(objectToSecond);
				objectToThird = scan.next();
				objectThirdGood.add(objectToThird);
				objectToFourth = scan.next();
				objectFourth.add(objectToFourth);
				objectToFifth = scan.next();
				objectFifth.add(objectToFifth);
				objectToSixth = scan.next();
				objectSixth.add(objectToSixth);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectThirdGood;
	}
	public static ArrayList<String>  manageFile4() {
		try {
			File file = new File("input.txt");
			scan = new Scanner(file);
			for(int i = 0; i < 10; i++){
				objectToFirst = scan.next();
				objectFirst.add(objectToFirst);
				objectToSecond = scan.next();
				objectSecond.add(objectToSecond);
				objectToThird = scan.next();
				objectThirdGood.add(objectToThird);
				objectToFourth = scan.next();
				objectFourth.add(objectToFourth);
				objectToFifth = scan.next();
				objectFifth.add(objectToFifth);
				objectToSixth = scan.next();
				objectSixth.add(objectToSixth);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectFourth;
	}
	
	public static ArrayList<String>  manageFile5() {
		try {
			File file = new File("input.txt");
			scan = new Scanner(file);
			for(int i = 0; i < 10; i++){
				objectToFirst = scan.next();
				objectFirst.add(objectToFirst);
				objectToSecond = scan.next();
				objectSecond.add(objectToSecond);
				objectToThird = scan.next();
				objectThirdGood.add(objectToThird);
				objectToFourth = scan.next();
				objectFourth.add(objectToFourth);
				objectToFifth = scan.next();
				objectFifth.add(objectToFifth);
				objectToSixth = scan.next();
				objectSixth.add(objectToSixth);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectFifth;
	}
	
	public static ArrayList<String>  manageFile6() {
		try {
			File file = new File("input.txt");
			scan = new Scanner(file);
			for(int i = 0; i < 10; i++){
				objectToFirst = scan.next();
				objectFirst.add(objectToFirst);
				objectToSecond = scan.next();
				objectSecond.add(objectToSecond);
				objectToThird = scan.next();
				objectThirdGood.add(objectToThird);
				objectToFourth = scan.next();
				objectFourth.add(objectToFourth);
				objectToFifth = scan.next();
				objectFifth.add(objectToFifth);
				objectToSixth = scan.next();
				objectSixth.add(objectToSixth);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectSixth;
	}
	
	public static boolean isTheAnswer(String sss, ArrayList<String> someList){
		boolean answer = false;
		for(String w : someList){
			if(sss.equals(w)){
				answer = true;
			}
		}
		return answer;	
	}

}
