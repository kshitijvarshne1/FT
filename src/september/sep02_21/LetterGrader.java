/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 04-Sep-21
 *   Time: 11:30 AM
 *   File: Exercise5.java
 */

package september.sep02_21;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class LetterGrader {
    //create arraylist of type Student for storing the Student data
    static ArrayList<Student> students = new ArrayList<>();
    //create arraylist of type StudentResult for storing the student result
    static ArrayList<StudentResult> studentResults = new ArrayList<>();
    //create arraylist of type ClassAverage for storing the class average
    static ArrayList<ClassAverage> classAverageArrayList = new ArrayList<>();
    // create a variable for input file name
    String inputFile;
    // create a variable for output file name
    String outputFile;

    // create a constructor for the class LetterGrader
    // initialise the instance variable of LetterGrader class
    public LetterGrader(String inputFile, String outputFile) {
        // initialise the instance variable
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    // main method for execution the program
    public static void main(String[] args) throws FileNotFoundException {
        // call the object and call the constructor and provide the name of input and output file to the LetterGrader class
        LetterGrader letterGrader = new LetterGrader(args[0], args[1]);
        // call the method readScore
        letterGrader.readScore();
        // call the method calLetterGrade
        letterGrader.calLetterGrade();
        // call the method printGrade
        letterGrader.printGrade();
        // call the method displayAverage
        letterGrader.displayAverage();
    }

    // This method call the method calAverage to calculate the average of marks
    private void displayAverage() {
        calAverage();
    }

    // This method used to calculate the average of the ,arks
    private void calAverage() {
        int i = 0;
        // take the size of student arraylist
        int size = students.size();
        // traverse the Student data
        for (int j = 0; j < 7; j++) {
            // declare and initialise and 3 variable to find average , maximum and minimum
            double average = 0.0;
            double minimum = Double.MAX_VALUE;
            double maximum = Double.MIN_VALUE;
            // traverse the data column wise to get every row marks
            for (int k = 0; k < size; k++) {
                // get the list of k column
                ArrayList<Double> markList = students.get(k).marks;
                average += markList.get(i);
                maximum = Math.max(maximum, markList.get(i));
                minimum = Math.min(minimum, markList.get(i));

            }
            i++;
            // add the object of class average to the classAverageArrayList arraylist
            classAverageArrayList.add(new ClassAverage(average / size, (int)minimum, (int)maximum));
        }
        System.out.println("Here is the class Average");
        System.out.printf("              %-10s %-10s %-10s %-6s %-9s %-9s %-9s\n", "Q1", "Q2", "Q3", "Q4", "MidI", "MidII", "Final");
        System.out.print("Average      ");
        // print the average
        for (int j = 0; j < classAverageArrayList.size(); j++) {
            System.out.printf("%-10s", classAverageArrayList.get(j).average);
        }
        System.out.println();
        System.out.print("Minimum      ");
        // print the minimum
        for (int j = 0; j < classAverageArrayList.size(); j++) {
            System.out.printf("%-10s", classAverageArrayList.get(j).minimum);
        }
        System.out.println();
        System.out.print("Maximum      ");
        // print the maximum
        for (int j = 0; j < classAverageArrayList.size(); j++) {
            System.out.printf("%-10s", classAverageArrayList.get(j).maximum);
        }
        System.out.println();
    }

    // method to read data from the file
    public void readScore() {
        String path = "C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\sep02_21\\";
        // add path and file Name to inputFile obejct
        File inputFile = new File(path + this.inputFile);
        if (!inputFile.exists()) {
            // if not exist then simply exit the program and print then error
            System.out.println("Input file " + this.inputFile + " does not exist");
            System.exit(2);
        }
        try {
            // input the data from the file
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                // split the string by comma
                String[] studentInfo = line.split(",");
                ArrayList<Double> marks = new ArrayList<>();
                for (int j = 1; j < studentInfo.length; j++) {
                    marks.add(Double.parseDouble(studentInfo[j]));
                }
                // create the object of Student class
                Student student = new Student(studentInfo[0], marks);
                // add the student object in the arraylist of students
                students.add(student);
            }
            // Catch the exception if occur
        } catch (IOException e) {
            System.out.println("Error reading from input file " + inputFile);
        }
    }
    // This method to calculate the grade of student
    public void calLetterGrade() {
        // traverse the students arraylist
        for (Student student : students) {
            double finalScore = 0.0;
            int i = 0;
            // sum-up the final score
            for (i = 0; i < 4; i++) {
                finalScore += student.marks.get(i) * .10;
            }
            // multiply the grade points according to credit of subject
            finalScore += student.marks.get(4) * .20;
            finalScore += student.marks.get(5) * .15;
            finalScore += student.marks.get(6) * .25;
            String grade = "";
            // get the score according to final score
            finalScore = (int) finalScore;
            if (finalScore >= 90.00) {
                grade = "A";
            } else if (finalScore >= 80.00 && finalScore <= 89.00) {
                grade = "B";
            } else if (finalScore >= 70.00 && finalScore <= 79.00) {
                grade = "C";
            } else if (finalScore >= 60.00 && finalScore <= 69.00) {
                grade = "D";
            } else {
                grade = "F";
            }
            // add the name and grade of the student to studentResults
            studentResults.add(new StudentResult(student.name, grade));
        }
    }

    // This method to print the Student data
    public void printGrade() throws FileNotFoundException {
        String pathOutputFile = "C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\sep02_21\\";
        // add path to pathOutputFile
        PrintWriter out = new PrintWriter(pathOutputFile + this.outputFile);
        // create the object of PrintWriter
        // Just sort the studentResults according to name -> lexicographically
        Collections.sort(studentResults, new Comparator<StudentResult>() {
            @Override
            public int compare(StudentResult o1, StudentResult o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        // print the name and grade with format
        String format = "%-20s %s\n";
        for (StudentResult s : studentResults) {
            out.format(format, s.name, s.grade);
        }
        out.close();

    }

    // create a class Student
    class Student {
        // instance variable
        String name;
        ArrayList<Double> marks;

        // constructor
        public Student(String name, ArrayList<Double> marks) {
            this.name = name;
            this.marks = marks;
        }

    }
    // create StudentResult class
    class StudentResult {
        // instance variable
        String name;
        String grade;
        // constructor
        public StudentResult(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }
    }
    // create StudentResult class
    class ClassAverage {
        // instance variable
        double average;
        int minimum;
        int maximum;
        // constructor
        public ClassAverage(double average, int minimum, int maximum) {
            this.average = average;
            this.minimum = minimum;
            this.maximum = maximum;
        }
    }
}

