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
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<StudentResult> studentResults = new ArrayList<>();
    static ArrayList<ClassAverage> classAverageArrayList = new ArrayList<>();
    String inputFile;
    String outputFile;

    public LetterGrader(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public static void main(String[] args) throws FileNotFoundException {
        LetterGrader letterGrader = new LetterGrader(args[0], args[1]);
        letterGrader.readScore();
        letterGrader.calLetterGrade();
        letterGrader.printGrade();
        letterGrader.displayAverage();
    }

    private void displayAverage() {
        calAverage();
    }

    private void calAverage() {
        int i = 0;
        int size = students.size();
        for (int j = 0; j < 7; j++) {
            double average = 0.0;
            double minimum = Double.MAX_VALUE;
            double maximum = Double.MIN_VALUE;

            for (int k = 0; k < size; k++) {
                ArrayList<Double> markList = students.get(k).marks;
                average += markList.get(i);
                maximum = Math.max(maximum, markList.get(i));
                minimum = Math.min(minimum, markList.get(i));

            }
            i++;

            classAverageArrayList.add(new ClassAverage(average / size, (int)minimum, (int)maximum));
        }
        System.out.println("Here is the class Average");
        System.out.printf("              %-10s %-10s %-10s %-6s %-9s %-9s %-9s\n", "Q1", "Q2", "Q3", "Q4", "MidI", "MidII", "Final");
        System.out.print("Average      ");
        for (int j = 0; j < classAverageArrayList.size(); j++) {
            System.out.printf("%-10s", classAverageArrayList.get(j).average);
        }
        System.out.println();
        System.out.print("Minimum      ");
        for (int j = 0; j < classAverageArrayList.size(); j++) {
            System.out.printf("%-10s", classAverageArrayList.get(j).minimum);
        }
        System.out.println();
        System.out.print("Maximum      ");
        for (int j = 0; j < classAverageArrayList.size(); j++) {
            System.out.printf("%-10s", classAverageArrayList.get(j).maximum);
        }
        System.out.println();

    }

    public void readScore() {
        String path = "C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\sep02_21\\";
        File inputFile = new File(path + this.inputFile);
        if (!inputFile.exists()) {
            System.out.println("Input file " + this.inputFile + " does not exist");
            System.exit(2);
        }
        try {
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] studentInfo = line.split(",");
                ArrayList<Double> marks = new ArrayList<>();
                for (int j = 1; j < studentInfo.length; j++) {
                    marks.add(Double.parseDouble(studentInfo[j]));
                }
                Student student = new Student(studentInfo[0], marks);
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading from input file " + inputFile);
        }
    }

    public void calLetterGrade() {
        for (Student student : students) {
            double finalScore = 0.0;
            int i = 0;
            for (i = 0; i < 4; i++) {
                finalScore += student.marks.get(i) * .10;
            }

            finalScore += student.marks.get(4) * .20;
            finalScore += student.marks.get(5) * .15;
            finalScore += student.marks.get(6) * .25;
            String grade = "";
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
            studentResults.add(new StudentResult(student.name, grade));
        }
    }

    public void printGrade() throws FileNotFoundException {
        String pathOutputFile = "C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\sep02_21\\";
        PrintWriter out = new PrintWriter(pathOutputFile + this.outputFile);
        Collections.sort(studentResults, new Comparator<StudentResult>() {
            @Override
            public int compare(StudentResult o1, StudentResult o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        String format = "%-20s %s\n";
        for (StudentResult s : studentResults) {
            out.format(format, s.name, s.grade);
        }
        out.close();

    }

    class Student {
        String name;
        ArrayList<Double> marks;

        public Student(String name, ArrayList<Double> marks) {
            this.name = name;
            this.marks = marks;
        }

    }

    class StudentResult {
        String name;
        String grade;

        public StudentResult(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    class ClassAverage {
        double average;
        int minimum;
        int maximum;

        public ClassAverage(double average, int minimum, int maximum) {
            this.average = average;
            this.minimum = minimum;
            this.maximum = maximum;
        }
    }
}

