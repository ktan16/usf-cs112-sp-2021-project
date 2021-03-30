package project1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DummyPredictor extends Predictor {

	@Override
	ArrayList<DataPoint> readData(String filename) {
		
		ArrayList<DataPoint> list = new ArrayList<DataPoint>(2);
		
		try {
			Scanner scanner = new Scanner(new File("project.txt"));
			while (scanner.hasNextLine()) {
				
				double f1 = scanner.nextDouble();
				double f2 = scanner.nextDouble();
				String label = scanner.next();
				boolean isTest = scanner.nextBoolean();
				DataPoint point = new DataPoint(f1, f2, label, isTest);
				list.add(point);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		return list;
	}

	@Override
	String test(DataPoint data) {
		if (data.getF1() + data.getF2() == 2.0) {
			return "Good";
		}
		return "Bad";
	}

	@Override
	Double getAccuracy(ArrayList<DataPoint> data) {
		return 3.0;
	}

	@Override
	Double getPrecision(ArrayList<DataPoint> data) {
		return 4.0;
	}

}
