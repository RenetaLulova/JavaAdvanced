package RegularExam_21_10_2023;

import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] sea = new String[n][n];
        for (int row = 0; row < n; row++) {
            String inputLine = scanner.nextLine();
            sea[row] = inputLine.split("");
        }

        //finding the ship
        int currRow = 0;
        int currCol = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(sea[row][col].equals("S")){
                    currRow = row;
                    currCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        int couthFishes = 0;
        boolean reachedQuota = false;
        int lastRow = -1;
        int lastCol = -1;

        while (!command.equals("collect the nets")){
            int oldRow=currRow;
            int oldCol=currCol;
            switch (command){
                case "up":
                    currRow--;
                    if(currRow<0){
                        currRow = n-1;
                    }
                    break;
                case "down":
                    currRow++;
                    if(currRow>n-1){
                        currRow=0;
                    }
                    break;
                case "left":
                    currCol--;
                    if(currCol<0){
                        currCol=n-1;
                    }
                    break;
                case "right":
                    currCol++;
                    if(currCol>n-1){
                        currCol=0;
                    }
                    break;
            }
            sea[oldRow][oldCol] = "-";
            if(sea[currRow][currCol].equals("-")){
                sea[currRow][currCol]="S";
                command = scanner.nextLine();
                continue;
            }
            if(sea[currRow][currCol].equals("W")){
                couthFishes = 0;
                lastRow = currRow;
                lastCol = currCol;
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]",lastRow,lastCol);
                return;
            }
            if(sea[currRow][currCol].matches("\\d")){
                couthFishes += Integer.parseInt(sea[currRow][currCol]);
                if(couthFishes>=20 && reachedQuota==false){
                    System.out.println("Success! You managed to reach the quota!");
                    reachedQuota=true;
                }
                sea[currRow][currCol]="S";
            }
            command = scanner.nextLine();
        }
        if(couthFishes<20){
            System.out.print("You didn't catch enough fish and didn't reach the quota! ");
            System.out.printf("You need %d tons of fish more.\n",20-couthFishes);
        }

        if(couthFishes>0){
            System.out.printf("Amount of fish caught: %d tons.\n",couthFishes);
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.printf("%s",sea[row][col]);
            }
            System.out.println();
        }
    }
}
