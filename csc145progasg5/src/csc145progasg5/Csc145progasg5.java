package csc145progasg5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Csc145progasg5 {
	
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		ArrayList<Student> studentRecords = new ArrayList<>();
		Student st;
		String name;
		int numberOfStudents;
		
		System.out.println("How many student records do you wish to record?");
		numberOfStudents = Integer.parseInt(scn.nextLine());
		
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.println("Enter student's name.");
			name = scn.nextLine();
			st = new Student(name);
			st.enterGrades();
			studentRecords.add(st);
		}
		
		openSavedRecords(studentRecords);
		
		int choice = 0;
		while (choice != 6) {
			System.out.println("Enter your choice of 1, 2, 3, 4, 5, or 6.");
            System.out.println("1. Display Student Records");
            System.out.println("2. Display course Average");
            System.out.println("3. Display Records With Given Letter Grade");
            System.out.println("4. Change Name");
            System.out.println("5. Change Exam Grade");
            System.out.println("6. Exit");
            choice = Integer.parseInt(scn.nextLine());
			switch (choice) {
				case 1:
					displayStudentRecords(studentRecords);
					break;
				case 2:
					courseAverage(studentRecords);
					break;
				case 3:
					displayRecordsWithLetterGrade(studentRecords);
					break;
				case 4:
					changeName(studentRecords);
					break;
				case 5:
					changeExamGrade(studentRecords);
					break;
				case 6:
					System.out.println("Exiting ...");
					break;
			}
		}
		
		saveRecords(studentRecords);
	}
	
	static void openSavedRecords(ArrayList<Student> records) throws IOException {
		FileInputStream fileInput = new FileImageInputStream("records.txt");
		Scanner fileScn = new Scanner(fileInput);
		student s;
		string mNum, stName;
		
		while (fileScn.hasNext()) {
			double[] grades = new double[3];
			mNum = fileSCN.next();
			for (int i = 0; i < grades.length; i++) {
				grades[i] = fileSCN.nextDouble();
			}
			stName = fileScn.nextLine();
			stName = stName.substring(1);
			s = new Student(mNum, stName, grades);
			records.add(s);
		}
		
		fileSCN.close();
	}
	
	static void saveRecords (ArrayList<Student> records) throws IOException {
		FileOutputStream fout = new FileOutputStream("records.txt");
		PrintWriter out = new PrintWriter(fout);
		for (int i = 0; i < records.size(); i++) {
			out.print(records.get(i).getMNumber() + " ");
			for (int j = 0; j < records.size(); j++) {
				out.print(records.get(i).getExams()[j] + " ");
			}
			out.println(records.get(i).getStudentName());
		}
		out.close();
	}
	
	static void displayStudentRecords (ArrayList<Student> records) {
		for (int i = 0; i < records.size(); i++) {
			records.get(i).displayStudentRecord();
		}
	}
	
	static void courseAverage (ArrayList<Student> records) {
		double courseTotal = 0;
		double courseAverage = 0;
		for (int i = 0; i < records.size(); i++) {
			courseTotal = courseTotal + records.get(i).getOverallGrade();
		}
		courseAverage = courseTotal/records.size();
		System.out.printf(%.2f\n", courseAverage);
	}
	
	static void displayRecordsWithLetterGrade (ArrayList<Student> records) {
		char c;
		System.out.println("Enter a letter grade.");
		c = scn.nextLine().charAt(0);
		c = Character.toUpperCase(c);
		for (int i = 0; i < records.size(); i++) {
			if (c == records.get(i).getLetterGrade()) {
				System.out.print(records.get(i).getMNumber() + " ");
				System.out.print(records.get(i).getFirstName() + " ");
				System.out.println(records.get(i).getLastName());
			}
		}
	}
	
	static int findRecord (ArrayList<Student> records, String id) {
		int tempIndex = -1;
		for (int i = 0; i < records.size(); i++) {
			if (id.equals(records.get(i).getMNumber())) {
				tempIndex = i;
			}
		}
		return tempIndex;
	}
	
	static void changeName (ArrayList<Student> records) {
		String response = "", s = "";
		int tempIndex;
		System.out.println("What is the M-Number of the student whose name you would like to change?");
		s = scn.nextLine();
		if (tempIndex != -1) {
			System.out.println(Would you like to change the first or last name?");
			System.out.println("Please type \"first\" or \"last\".");
			response = scn.nextLine();
			if (response.equalsIgnoreCase("first")) {
				System.out.println("What would you like to change their first name to?");
				String firstName = scn.nextLine();
				records.get(tempIndex.setFirstName(firstName);
			}
			else if (response.equalsIgnoreCase("last")) {
				System.out.println("What would you like to change their last name to?");
				String lastName = scn.nextLine();
				records.get(tempIndex).setLastName);
			}
			else {
				System.out.println("Invalid input.");
			}
		}
		else {
			System.out.println("Record not found.");
		}
	}
	
	//FIX-ME
	static void changeExamGrade (ArrayList<Student> records) {
		String s = "";
		int tempIndex;
		System.out.println("What is the student's M=Number?");
		s = scn.nextLine();
		tempIndex = findRecord(records, s);
		douuble[] exams = new double[3];
		exams = records.get(tempIndex).getExams();
		if (tempIndex != -1) {
			records.get(tempIndex.changeExamGrade(exams);
		}
		else {
			System.out.println("Record not found.");
		}
	}
}				