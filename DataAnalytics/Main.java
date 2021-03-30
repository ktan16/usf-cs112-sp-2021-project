package project1;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;


public class Main {

	public static void main(String[] args) {
		
		DummyPredictor dummy = new DummyPredictor();
		
		ArrayList<DataPoint> list = dummy.readData("project.txt");
		
//		System.out.println(list);
		DataPoint trainPoint = list.get(0);
		DataPoint testPoint = list.get(1);
		
		System.out.println(dummy.test(testPoint));
		System.out.println(dummy.getAccuracy(list));
		System.out.println(dummy.getPrecision(list));		
		
		JFrame frame = new JFrame("Accuracy and Precision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = frame.getContentPane();
		
		JLabel accuracy = new JLabel("Accuracy: " + dummy.getAccuracy(list));
		contentPane.add(accuracy);
		JLabel precision = new JLabel("Precision: " + dummy.getPrecision(list));
		contentPane.add(precision);
		
		frame.setVisible(true);
		frame.setLayout(new GridLayout(2,1));
		frame.setSize(400,400);

		
		
//		Scanner scanner = new Scanner(new File("project.txt"));
//		
//		DataPoint trainPoint = new DataPoint(scanner.nextDouble(), scanner.nextDouble(), scanner.next(), scanner.nextBoolean());
//		System.out.println(trainPoint);
//		
//		DataPoint testPoint = new DataPoint(scanner.nextDouble(), scanner.nextDouble(), scanner.next(), scanner.nextBoolean());
//		System.out.println(testPoint);
//		
//		DummyPredictor dummy = new DummyPredictor();
//		
//		System.out.println(dummy.test(testPoint));
//		dummy.readData("project.txt");
		
		
//		Random rand = new Random();
//		
//		Double trainF1 = rand.nextDouble();
//		Double trainF2 = rand.nextDouble();
//		Double testF1 = rand.nextDouble() + 2;
//		Double testF2 = rand.nextDouble();
//		
//		System.out.println(trainF1);
//		System.out.println(trainF2);
//		System.out.println(testF1);
//		System.out.println(testF2);
//		
//		DataPoint trainPoint = new DataPoint(trainF1, trainF2, "Bad", false);
//		DataPoint testPoint = new DataPoint(testF1, testF2, "Good", true);
//		
//		System.out.println(trainPoint);
//		System.out.println(testPoint);
		

	}

}
