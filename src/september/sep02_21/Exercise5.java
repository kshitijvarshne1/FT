/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 04-Sep-21
 *   Time: 11:30 AM
 *   File: Exercise5.java
 */

package september.sep02_21;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        processCLArgument(args);
        processInputOutputFile(args);
    }

    public static void processCLArgument(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage : java Exercise5 inputFile outputFile");
            System.exit(1);
        } else {
            System.out.println("Input will be read From: " + args[0] + "\nOutput will be written into: " + args[1]);
            System.out.println();
        }
    }
    public static void processInputOutputFile(String[] args){
        String path ="C:\\Users\\kshitij varshney\\IdeaProjects\\FT\\src\\september\\sep02_21\\";
        File inputFile = new File(path+args[0]);
        if(!inputFile.exists()){
            System.out.println("Input file "+args[0] +" does not exist");
            System.exit(2);
        }
        //Output File
        File outputFile = new File(path+args[1]);
        try{
            Scanner input = new Scanner(inputFile);
            PrintWriter output = new PrintWriter(outputFile);
            int i=1;
            while (input.hasNextLine()){
                String line = input.nextLine();
                System.out.println("Student # "+i+" "+line);
                String [] studentInfo= line.split(",");
                output.println("Student # "+i++ +" "+" is:\" "+studentInfo[0]+"\" whose raw scores are :");
                for(int j=1;j<studentInfo.length;j++){
                    output.print(studentInfo[j]+":  ");
                }
                output.println();
            }
            input.close();
            output.close();

        }

        catch (IOException e){
            System.out.println("Error reading from input file "+args[0]);
        }
    }
}

