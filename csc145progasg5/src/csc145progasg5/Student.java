package csc145progasg5;

import java.util.Random;
import java.util.Scanner;

public class Student {
	Scanner scn = new Scanner(System.in);
	Random rnd = new Random();
	private String studentName;
	private String firstName, lastName;
	private String mNumber;
	private double[] exams = new double[3];
	private double overallGrade;
	private char letterGrade;
	
	public Student  () {}
	
	public Student(String studentName) {
		this.studentName = studentName;
		assignMNumber();
		separateFullName();
	}

	public Student (String mNumber, String studentName, double[] exams) {
		this.mNumber = mNumber;
		this.studentName = studentName;
		this.exams= exams;
		separateFullName();
		calculateAverage();
	}
	
	private void assignMNumber() {
		int tempNumber = rnd.nextInt(100, 50000);
		mNumber = Integer.toString(tempNumber);
		while (mNumber.length() < 8) {
			mNumber = "0" + mNumber;
		}
	}
	
	private void separateFullName() {
		boolean spaceFound = false;
		String first = "", last = "";
		char c;
		for (int i = 0; i < studentName.length(); i++) {
			c = studentName.charAt(i);
			if (c != ' ' && !spaceFound) {
				first += c;
			}
			else if (c == ' ') {
				spaceFound = true;
			}
			else {
				last += c;
			}
		}
		firstName = first;
		lastName = last;
	}
	
	public void enterGrades() {
		for (int i = 0; i < exams.length; i++) {
			System.out.println("Enter grade for exam " + (i + 1));
			exams[i] = Double.parseDouble(scn.nextLine());
		}
		calculateAverage();
	}
	
	private void calculateAverage() {
		for (int i = 0; i < exams.length; i++) {
			overallGrade = overallGrade + exams[i];
		}
		overallGrade = overallGrade / exams.length;
		processLetterGrade();
	}
	
	private void processLetterGrade() {
		if (overallGrade < 60) {
			letterGrade = 'E';
		}
		else if (overallGrade < 70) {
            letterGrade = 'D';
        }
        else if (overallGrade < 80) {
            letterGrade = 'C';
        }
        else if (overallGrade < 90) {
            letterGrade = 'B';
        }
        else {
            letterGrade = 'A';
        }
    }
	
	public void displayStudentRecord() {
		System.out.print("Name: " + lastName + ", " + firstName);
        System.out.print("   M-Number: " + mNumber);
        System.out.printf("   Grade: %.2f%s", overallGrade, "%");
        System.out.println("   Letter Grade: " + letterGrade);     
    }  
	
	public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getMNumber() {
        return mNumber;
    }
    
    public double[] getExams() {
        return exams;
    }
   
    public double getOverallGrade() {
        return overallGrade;
    }
    
    public char getLetterGrade() {
        return letterGrade;
    }
	
	public double[] changeExamGrade(double[] exams) {
		int tempIndex;
		double newGrade;
		System.out.println("Which exam grade would you like to change?");
		tempIndex = scn.nextInt() - 1;
		if (tempIndex < 0 || tempIndex > exams.length) {
			System.out.println("Invalid exam.");
		}
		System.out.println(exams[tempIndex]);
		System.out.println("What would you like the new grade to be?");
		newGrade = scn.nextDouble();
		exams[tempIndex] = newGrade;
		return exams;
	}
}
