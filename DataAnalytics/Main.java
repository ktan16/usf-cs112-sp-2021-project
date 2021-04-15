package project2;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InputMismatchException {
		
		System.out.println("Enter an odd number for k: ");
		Scanner scanner = new Scanner(System.in);
//		Integer inputK = scanner.nextInt();
		if (scanner.hasNextInt()) {
			
			int inputK = scanner.nextInt();
			
			if (inputK%2 != 0) {
				KNNPredictor k = new KNNPredictor(inputK);
				
				ArrayList<DataPoint> list = k.readData("titanic.csv");
			
				//Accuracy and precision changes with each run due to random test and train, or because f1 = pclass f2 = survived
				System.out.println("Accuracy: " + k.getAccuracy(list));
				System.out.println("Precision: " + k.getPrecision(list));

				JFrame frame = new JFrame("Accuracy and Precision");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				Container contentPane = frame.getContentPane();
				
				JLabel accuracy = new JLabel("Accuracy: " + k.getAccuracy(list));
				contentPane.add(accuracy);
				JLabel precision = new JLabel("Precision: " + k.getPrecision(list));
				contentPane.add(precision);
				
				frame.setVisible(true);
				frame.setLayout(new GridLayout(2,1));
				frame.setSize(400,400);
			} else {
				System.out.println("Error: Please enter an odd integer.");
			}
			
		} else {
			System.out.println("Error: Please enter an odd integer.");
		}
		
//		KNNPredictor k = new KNNPredictor(5);
//		
//		ArrayList<DataPoint> list = k.readData("titanic.csv");
//	
//		System.out.println("Accuracy: " + k.getAccuracy(list));
//		System.out.println("Precision: " + k.getPrecision(list));
//
//		JFrame frame = new JFrame("Accuracy and Precision");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		Container contentPane = frame.getContentPane();
//		
//		JLabel accuracy = new JLabel("Accuracy: " + k.getAccuracy(list));
//		contentPane.add(accuracy);
//		JLabel precision = new JLabel("Precision: " + k.getPrecision(list));
//		contentPane.add(precision);
//		
//		frame.setVisible(true);
//		frame.setLayout(new GridLayout(2,1));
//		frame.setSize(400,400);
		
		
	}

}
