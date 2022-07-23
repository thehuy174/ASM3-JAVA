import java.util.*;
public class GradeStudent {
    // declare variable
    public static int weightMid;
    public static int weightFinal;
    public  static double midScore;
    public  static double finalScore;
    public  static double homeScore;
    public static void main(String[] args){
        // control the main flow of the program, call sub functions
        System.out.println();
        begin();
        System.out.println();
        //save the return value of the function midTerm() into a variable midScore
        midScore = midTerm();
        System.out.println();
        //save the return value of the function finalTerm() into a variable finalScore
        finalScore = finalTerm();
        System.out.println();
        //save the return value of the function homework() into a variable homeScore
        homeScore = homework();
        System.out.println();
        report();
    }
    public static void begin(){
        //print to the console screen
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }
    public static double midTerm(){
        //create Scanner object input
        Scanner input = new Scanner(System.in);
        //print to the console screen
        System.out.println("Midterm:");
        System.out.print("Weight (0-100)? ");
        //save data user input to variable weightMid, scoreEarn, scoreShift
        weightMid = input.nextInt();
        System.out.print("Score earned? ");
        int scoreEarn = input.nextInt();
        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        int scoreShift = input.nextInt();
        //check the condition that the user enters yes || no
        if(scoreShift == 1){
            //print to the console screen
            System.out.print("Shift amount = ");
            //save data user input to variable shiftAmount
            int shiftAmount = input.nextInt();
            // declare variable totalPoint
            int totalPoint = (scoreEarn + shiftAmount);
            //check the condition that totalPoint max = 100;
            if(totalPoint > 100){
                totalPoint = 100;
            }
            //print to the console screen totalPoint
            System.out.println("Total points = " + totalPoint + " / 100");
            //calculate score based on weight
            double weightScoreMid = Math.round((((double) (totalPoint)/100)*weightMid)*10.0)/10.0;
            //print to the console screen weightScoreMid
            System.out.println("Weighted score = " + weightScoreMid + " / " + weightMid);
            return weightScoreMid;
        }else {
            //print to the console screen scoreEarn
            System.out.println("Total points = " + (scoreEarn) + " / 100");
            //calculate score based on weight
            double weightScoreMid = Math.round((((double) (scoreEarn)/100)*weightMid)*10.0)/10.0;
            //print to the console screen weightScoreMid
            System.out.println("Weighted score = " + weightScoreMid + " / " + weightMid);
            return weightScoreMid;
        }
    }
    public static double finalTerm(){
        //create Scanner object input
        Scanner input = new Scanner(System.in);
        //print to the console screen
        System.out.println("Final:");
        System.out.print("Weight (0-100)? ");
        //save data user input to variable weightFinal, scoreEarn, scoreShift
        weightFinal = input.nextInt();
        System.out.print("Score earned? ");
        int scoreEarn = input.nextInt();
        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        int scoreShift = input.nextInt();
        //check the condition that the user enters yes || no
        if(scoreShift == 1){
            //print to the console screen
            System.out.print("Shift amount = ");
            //save data user input to variable shiftAmount
            int shiftAmount = input.nextInt();
            // declare variable totalPoint
            int totalPoint = (scoreEarn + shiftAmount);
            //check the condition that totalPoint max = 100;
            if(totalPoint > 100){
                totalPoint = 100;
            }
            //print to the console screen totalPoint
            System.out.println("Total points = " + totalPoint + " / 100");
            //calculate score based on weight
            double weightScoreFinal = Math.round((((double) (totalPoint)/100)*weightFinal)*10.0)/10.0;
            //print to the console screen weightScoreFinal
            System.out.println("Weighted score = " + weightScoreFinal + " / " + weightFinal);
            return weightScoreFinal;
        }else {
            //print to the console screen totalPoint
            System.out.println("Total points = " + scoreEarn + " / 100");
            //calculate score based on weight
            double weightScoreFinal = Math.round((((double) (scoreEarn)/100)*weightFinal)*10.0)/10.0;
            //print to the console screen weightScoreFinal
            System.out.println("Weighted score = " + weightScoreFinal + " / " + weightFinal);
            return weightScoreFinal;
        }
    }
    public static double homework(){
        //create Scanner object input
        Scanner input = new Scanner(System.in);
        //print to the console screen
        System.out.println("Homework:");
        System.out.print("Weight (0-100)? ");
        //save data user input to variable weightHome
        int weightHome = input.nextInt();
        //check condition that weight is always = 100
        do {
            if (weightHome != 100 - (weightFinal + weightMid)) {
                //notify the user to enter the correct weight
                System.out.print("re-enter Weight (" + (100 - (weightFinal + weightMid)) + ")? ");
                weightHome = input.nextInt();
            }else {
                break;
            }
        }while (true);//condition is always true
        //print to the console screen and save data user input to variable asm
        System.out.print("Number of assignments: ");
        int asm = input.nextInt();
        // declare variable
        int[] asmScore = new int[asm];
        int[] asmMax = new int[asm];
        int asmTotal = 0;
        int max = 0;
        //print to the console screen and save data user input to variable asmScore[i], asmMax[i]
        for(int i = 0; i < asm; i++){
            System.out.print("Assignment " + (i+1) + " score and max: ");
            asmScore[i] = input.nextInt();
            asmMax[i] = input.nextInt();
            //total: asmTotal, max
            asmTotal += asmScore[i];
            max += asmMax[i];
        }
        //check condition asmTotal max = 150
        if (asmTotal > 150) {
            asmTotal = 150;
        }
        //print to the console screen and save data user input to variable many
        System.out.print("How many sections did you attend: ");
        int many = input.nextInt();
        // total attendance score
        int sectionPoints = many * 5;
        //check condition asmTotal max = 30
        if(sectionPoints > 30){
            sectionPoints = 30;
        }
        //print to the console screen
        System.out.println("Section points = " + sectionPoints + " / 30");
        //student's total score
        int totalPoint = asmTotal + sectionPoints;
        //maximum total score
        int totalMax = max + 30;
        //print to the console screen totalPoint
        System.out.println("Total points = " + totalPoint + " / " + totalMax);
        //calculate score based on weight
        double weightScoreHome = Math.round(((double)(totalPoint)/(double)(totalMax)*weightHome)*10.0)/10.0;
        //print to the console screen weightScoreHome
        System.out.println("Weighted score = " + weightScoreHome + " / " + weightHome);
        return weightScoreHome;
    }
    public static void report(){
        //The total score achieved by students in 3 subjects is calculated on a scale of 100
        double minGrade = Math.round((midScore)*10.0)/10.0 + Math.round((finalScore)*10.0)/10.0 + Math.round((homeScore)*10.0)/10.0;
        //calculated GPA
        double GPA = 0.0;
        if(minGrade >= 85){
            GPA = 3.0;
        }else if(minGrade >= 75 && minGrade < 85){
            GPA = 2.0;
        }else if(minGrade >= 60 && minGrade < 75){
            GPA = 1.0;
        }else {
            GPA = 0.0;
        }
        //print to the console screen report of students
        System.out.println("----------***********-------------");
        System.out.println("Overall percentage = " + minGrade);
        System.out.println("Your grade will be at least = " + GPA);
    }
}
