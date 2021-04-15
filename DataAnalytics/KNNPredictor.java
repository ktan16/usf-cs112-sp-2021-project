package project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class KNNPredictor extends Predictor {
	
	private int pSurvived = 0;
	private int pDied = 1;
	private int k;
	private ArrayList<DataPoint> copiedList;
	
	public KNNPredictor(int k) {
		this.k = k;
	}
	
	// Helper function to split the line by commas and
	// return the values as a List of String
	private List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
				}
			}
		return values;
	}

	ArrayList<DataPoint> readData(String filename) {
		ArrayList<DataPoint> list = new ArrayList<DataPoint>();
		
		try {
			Scanner scanner = new Scanner(new File("titanic.csv"));
			while(scanner.hasNextLine()) {
				List<String> records = getRecordFromLine(scanner.nextLine());
				// TODO: Select the columns from the records and create a DataPoint object
				// TODO: Store the DataPoint object in a collection}}
				
				Random rand = new Random();
				double randNum = rand.nextDouble();
				
				if(!records.get(5).isEmpty() && records.size() == 7) {
					if (randNum < 0.9) {
						if (records.get(1).equals("1")) { //survived and train point, using pclass and age as f1 f2
							pSurvived++;
							double f1 = Double.parseDouble(records.get(0));
							double f2 = Double.parseDouble(records.get(5));
							DataPoint point = new DataPoint(f1, f2, records.get(1), false);
							list.add(point);
						} else { //died and train point
							pDied ++;
							double f1 = Double.parseDouble(records.get(0));
							double f2 = Double.parseDouble(records.get(5));
							String label = records.get(1);
							DataPoint point = new DataPoint(f1, f2, records.get(1), false);
							list.add(point);
						}
						
					} else {
						if (records.get(1).equals("1")) { //survived and test point
							
							double f1 = Double.parseDouble(records.get(0));
							double f2 = Double.parseDouble(records.get(5));
							DataPoint point = new DataPoint(f1, f2, records.get(1), true);
							list.add(point);
						} else { //died and test point
							
							double f1 = Double.parseDouble(records.get(0));
							double f2 = Double.parseDouble(records.get(5));
							DataPoint point = new DataPoint(f1, f2, records.get(1), true);
							list.add(point);
						}
					}
				}
			}
			System.out.println("Number of training points (survived): " + pSurvived);
			System.out.println("Number of training points (died): " + pDied);
		}  catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		copiedList = new ArrayList<DataPoint>(list);
		Collections.copy(copiedList, list);
//		System.out.println(copiedList);
		return list;
	}
	
	private double getDistance(DataPoint p1, DataPoint p2) {
		double x1 = p1.getF1();
		double y1 = p1.getF2();
		
		double x2 = p2.getF1();
		double y2 = p2.getF2();
		 
		return Math.sqrt( ((x2 - x1) * (x2 - x1)) + ((y2-y1) * (y2-y1)) );
	}

	String test(DataPoint data) {
		int totalTrain = pSurvived + pDied;
//		System.out.println(totalTrain);
//		ArrayList<DataPoint> list = readData("titanic.csv");
		int survived = 0;
		int died = 0;
		Double [][] arr = new Double[totalTrain][2];
		if(data.getIsTest()) {
			
			
			
			for (int i = 0; i < totalTrain; i++) {
				arr[i][0] = getDistance(data, copiedList.get(i));
				arr[i][1] = Double.parseDouble(copiedList.get(i).getLabel());
				
//				for (int k = i; k < arr.length; k++) {
//					if (k==0) {
//						arr[i][k] = getDistance(data, stuff.get(i));
//					} 
//					if (k==1) {
//						arr[i][k] = Double.parseDouble(stuff.get(i).getLabel());
//					}
//				}
			}
			
			
//			for (int r = 0; r < totalTrain; r++) {
//				for (int c = 0; c < 2; c++) {
//					
//					
//					System.out.println("arr[" + r + "][" + c + "] = " + arr[r][c]);
//					
//				}
//			}
			
			
			java.util.Arrays.sort(arr, new java.util.Comparator<Double[]>() {
				public int compare(Double[]a,Double[]b) {
					return a[0].compareTo(b[0]);
					}
				});
			
			for (int i = 0; i<k; i++) {
				if (arr[i][1] == 1.0) {
					survived++;
				} else {
					died++;
				}
			}
			
			
			if (survived > died) {
				return "1";
				
			} else {
				
				return "0";
			}
			
		} else {
			return "DataPoint is not a test point";
		}
	}

	Double getAccuracy(ArrayList<DataPoint> data) {
		double truePositive = 0;
		double falsePositive = 0;
		double trueNegative = 0;
		double falseNegative = 0;
		
		for (int i = 0; i<data.size(); i++) {
			
			String label = test(data.get(i));
//			System.out.println(data.get(i).getLabel());
//			System.out.println(label);
			if (label.equals("1") && data.get(i).getLabel().equals("1")) {
				truePositive++;
			} else if (label.equals("1") && data.get(i).getLabel().equals("0")) {
				falsePositive++;
			} else if (label.equals("0") && data.get(i).getLabel().equals("0")) {
				trueNegative++;
			} else if (label.equals("0") && data.get(i).getLabel().equals("1")) {
				falseNegative++;
			}
		}
		
		return ((truePositive + trueNegative) / (truePositive + trueNegative + falsePositive + falseNegative))*100;
	}

	Double getPrecision(ArrayList<DataPoint> data) {
		double truePositive = 0;
		double falsePositive = 0;
		double trueNegative = 0;
		double falseNegative = 0;
		
		for (int i = 0; i<data.size(); i++) {
			
			String label = test(data.get(i));
			
			if (label.equals("1") && data.get(i).getLabel().equals("1")) {
				truePositive++;
			} else if (label.equals("1") && data.get(i).getLabel().equals("0")) {
				falsePositive++;
			} else if (label.equals("0") && data.get(i).getLabel().equals("0")) {
				trueNegative++;
			} else if (label.equals("0") && data.get(i).getLabel().equals("1")) {
				falseNegative++;
			}
		}
		return (truePositive / (truePositive + falseNegative))*100;
	}

}
