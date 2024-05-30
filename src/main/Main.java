package main;
import java.util.Scanner;

//import javax.swing.*;

public class Main {
	
	static Scanner scanner;
	static int choice = -1;
	
	public static void main(String[] args) {	
		
//		 Login.showLoginBox();
		
		scanner = new Scanner(System.in);
		
		while (choice!=1) {
//			Menu.printMenuItems();
			Menu.promptUser();
		}
		
		scanner.close();
		
	}	
}
