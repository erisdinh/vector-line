////////////////////////////////////////////////////////////////////////////////
// TestLine.java
// =============
// A testing class for Line and Line3D classes
// 
// AUTHOR: Quynh Dinh
// CREATED: 5/2/2018
// UPDATED: 23/2/2018
////////////////////////////////////////////////////////////////////////////////
package quynh;

import java.util.Scanner;

public class TestLine {

    static Scanner input = new Scanner(System.in);
    static Line line1 = new Line();
    static Line line2 = new Line();
    static Line3D line3D1 = new Line3D();
    static Line3D line3D2 = new Line3D();

    public static void main(String[] args) {
        char another;
        // Perform the program at least once
        do {
            int choice = startProgram();

            if (choice == 1) {
                // Form 2 lines in 2D
                formLine2D();

                System.out.println();

                // print the intersected point 
                if (line1.isIntersected(line2)) {
                    Vector2 point = line1.intersect(line2);
                    System.out.println("Intersect Point: " + point);
                } else {
                    System.out.println("Not intersected");
                }

                // debugging 
                System.out.println(line1);
                System.out.println(line2);
            } else {
                // Form 2 lines in 3D
                formLine3D();
                
                System.out.println();

                // print the intersected point
                if (line3D1.isIntersected(line3D2)) {
                    Vector3 point = line3D1.intersect(line3D2);
                    System.out.println("Intersect Point: " + point);
                } else {
                    System.out.println("Not intersected");
                }

                // debugging 
                System.out.println(line3D1);
                System.out.println(line3D2);
            }

            // Clean the input
            input.nextLine();
            System.out.println();

            // Ask the user whether they want to start the program or not
            System.out.print("Do you want to start again? (Y/N) ");
            another = input.nextLine().toLowerCase().charAt(0);

        } while (another == 'y');
    }

    public static int startProgram() {
        int choice = 0;
        boolean validAnswer = false;
        do {
            try {
                System.out.print("Which dimension do you want to start?\n"
                        + "1. 2D\n"
                        + "2. 3D\n"
                        + "Enter a number (1, 2): ");
                choice = input.nextInt();
                validAnswer = true;
                if (choice <= 0 || choice > 2) {
                    validAnswer = false;
                    System.out.println("Please enter a valid number.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
            }
        } while (validAnswer == false);
        return choice;
    }

    public static void formLine2D() {

        boolean validAnswer = false;
        int choice = 0;

        // Use for-loop to ask user to enter 2 lines
        for (int i = 1; i < 3; i++) {
            
            System.out.println();
            
            System.out.println("Line " + i + ":");

            // Ask the user the formula of the line they want to enter
            // If they does not enter a valid answer, ask again
            do {

                // Use try-catch to catch the exception
                // If the user does not enter a valid value
                try {
                    System.out.print("What form of the line do you want to enter?\n"
                            + "1. Point and Direction\n"
                            + "2. Slope and Intercept\n"
                            + "3. Point and Point\n"
                            + "Enter a number (1, 2, 3): ");
                    choice = input.nextInt();
                    validAnswer = true;
                    if (choice <= 0 || choice > 3) {
                        validAnswer = false;
                        System.out.println("Please enter a valid number.");
                    }

                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    input.nextLine();
                }
            } while (validAnswer == false);

            float xPoint = 0, yPoint = 0;
            float xDirection = 0, yDirection = 0;
            float slope = 0, intercept = 0;
            float xPoint1 = 0, yPoint1 = 0;
            float xPoint2 = 0, yPoint2 = 0;

            Vector2 point = new Vector2();
            Vector2 direction = new Vector2();

            // Ask again if the user does not enter a valid value
            do {
                try {
                    switch (choice) {

                        // If the user choose the form that has point and direction
                        // Ask the user to enter the values of the point and the direction
                        case 1:
                            System.out.print("Enter x-Point: ");
                            xPoint = input.nextFloat();
                            System.out.print("Enter y-Point: ");
                            yPoint = input.nextFloat();
                            System.out.print("Enter x-Direction: ");
                            xDirection = input.nextFloat();
                            System.out.print("Enter y-Direction: ");
                            yDirection = input.nextFloat();

                            point.set(xPoint, yPoint);
                            direction.set(xDirection, yDirection);
                            break;

                        // If the user choose the form that has slope and intercept
                        // Ask the user to enter the slope and intercept
                        case 2:
                            System.out.print("Enter the slope: ");
                            slope = input.nextFloat();
                            System.out.print("Enter the intercept: ");
                            intercept = input.nextFloat();
                            break;

                        // If the user choose the form that goes through 2 points
                        // Ask the user to enter the coordinates of these 2 points
                        case 3:
                            System.out.print("Enter x Point #1: ");
                            xPoint1 = input.nextFloat();
                            System.out.print("Enter y Point #1: ");
                            yPoint1 = input.nextFloat();
                            System.out.print("Enter x Point #2: ");
                            xPoint2 = input.nextFloat();
                            System.out.print("Enter y Point #2: ");
                            yPoint2 = input.nextFloat();
                            break;
                    }
                    validAnswer = true;
                } catch (Exception e) {
                    validAnswer = false;
                    System.out.println("Please enter a valid value");
                    input.nextLine();
                }
            } while (validAnswer == false);

            // Set 2 lines
            // if i = 1, set the first line, else it is the second line
            if (i == 1) {
                switch (choice) {
                    case 1:
                        line1.set(point, direction);
                        break;
                    case 2:
                        line1.set(slope, intercept);
                        break;
                    case 3:
                        line1.set(xPoint1, yPoint1, xPoint2, yPoint2);
                        break;
                }
            } else {
                switch (choice) {
                    case 1:
                        line2.set(point, direction);
                        break;
                    case 2:
                        line2.set(slope, intercept);
                        break;
                    case 3:
                        line2.set(xPoint1, yPoint1, xPoint2, yPoint2);
                        break;
                }
            }
        }
    }

    public static void formLine3D() {

        boolean validAnswer = false;
        int choice = 0;

        // Use for-loop to ask user to enter 2 lines
        for (int i = 1; i < 3; i++) {
            
            System.out.println();
            
            System.out.println("Line " + i + ":");

            // Ask the user the formula of the line they want to enter
            // If they does not enter a valid answer, ask again
            do {

                // Use try-catch to catch the exception
                // If the user does not enter a valid value
                try {
                    System.out.print("What form of the line do you want to enter?\n"
                            + "1. Point and Direction\n"
                            + "2. Point and Point\n"
                            + "Enter a number (1, 2): ");
                    choice = input.nextInt();
                    validAnswer = true;
                    if (choice <= 0 || choice > 2) {
                        validAnswer = false;
                        System.out.println("Please enter a valid number.");
                    }

                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    input.nextLine();
                }
            } while (validAnswer == false);

            float xPoint = 0, yPoint = 0, zPoint = 0;
            float xDirection = 0, yDirection = 0, zDirection = 0;
            float xPoint1 = 0, yPoint1 = 0, zPoint1 = 0;
            float xPoint2 = 0, yPoint2 = 0, zPoint2 = 0;

            Vector3 point = new Vector3();
            Vector3 direction = new Vector3();

            // Ask again if the user does not enter a valid value
            do {
                try {
                    switch (choice) {

                        // If the user choose the form that has point and direction
                        // Ask the user to enter the values of the point and the direction
                        case 1:
                            System.out.print("Enter x-Point: ");
                            xPoint = input.nextFloat();
                            System.out.print("Enter y-Point: ");
                            yPoint = input.nextFloat();
                            System.out.print("Enter z-Point: ");
                            zPoint = input.nextFloat();
                            System.out.print("Enter x-Direction: ");
                            xDirection = input.nextFloat();
                            System.out.print("Enter y-Direction: ");
                            yDirection = input.nextFloat();
                            System.out.print("Enter z-Direction: ");
                            zDirection = input.nextFloat();

                            point.set(xPoint, yPoint, zPoint);
                            direction.set(xDirection, yDirection, zDirection);
                            break;

                        // If the user choose the form that goes through 2 points
                        // Ask the user to enter the coordinates of these 2 points
                        case 2:
                            System.out.print("Enter x Point #1: ");
                            xPoint1 = input.nextFloat();
                            System.out.print("Enter y Point #1: ");
                            yPoint1 = input.nextFloat();
                            System.out.print("Enter z Point #1: ");
                            zPoint1 = input.nextFloat();
                            System.out.print("Enter x Point #2: ");
                            xPoint2 = input.nextFloat();
                            System.out.print("Enter y Point #2: ");
                            yPoint2 = input.nextFloat();
                            System.out.print("Enter z Point #2: ");
                            zPoint2 = input.nextFloat();
                            break;
                    }
                    validAnswer = true;
                } catch (Exception e) {
                    validAnswer = false;
                    System.out.println("Please enter a valid value");
                    input.nextLine();
                }
            } while (validAnswer == false);

            // Set 2 lines
            // if i = 1, set the first line, else it is the second line
            if (i == 1) {
                switch (choice) {
                    case 1:
                        line3D1.set(point, direction);
                        break;
                    case 2:
                        line3D1.set(xPoint1, yPoint1, zPoint1, xPoint2, yPoint2, zPoint2);
                        break;
                }
            } else {
                switch (choice) {
                    case 1:
                        line3D2.set(point, direction);
                        break;
                    case 2:
                        line3D2.set(xPoint1, yPoint1, zPoint1, xPoint2, yPoint2, zPoint2);
                        break;
                }
            }
        }
    }
}
