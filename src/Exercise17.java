/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Robert Uriarte
 */
import java.util.Scanner;
public class Exercise17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your gender? Please enter Male or Female, exactly as written here. : ");
        String gender = scan.nextLine();
        System.out.print("What is your weight in lbs? : ");
        double weight = valid_number(scan);
        System.out.print("What is the amount of alcohol in ounces you have consumed? : ");
        double alc_consumed = valid_number(scan);
        System.out.print("How many hours has it been since your last drink? : ");
        double hours = valid_number(scan);


        System.out.printf("Your BAC is %.2f\n", BAC(weight,alc_consumed,hours,gender));
        if(BAC(weight,alc_consumed,hours,gender) >= 0.08){
            System.out.print("It is not legal for you to drive.");
        }
        else{
            System.out.print("It is legal for you to drive.");
        }

    }
    public static double valid_number(Scanner scan){
        int x = 0;
        while (x == 0) {
            if (scan.hasNextDouble()) {
                double num = scan.nextDouble();
                x = 1;
                return num;
            }
            else{
                System.out.print("Please enter a valid number, try again \nEnter: ");
            }
            scan.nextLine();
        }
        return 1;
    }

    public static double BAC(double weight, double alc_consumption, double hours, String gender){
        if(gender.compareTo("Male") == 0){
            double BAC = (alc_consumption/5.14) / (weight*0.73) - (0.015*hours);
            return BAC;
        }
        else{
            double BAC2 = (alc_consumption/5.14) / (weight*0.66) - (0.015*hours);
            return BAC2;
        }
    }
}

