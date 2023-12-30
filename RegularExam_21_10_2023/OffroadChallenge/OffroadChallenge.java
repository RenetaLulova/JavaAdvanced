package RegularExam_21_10_2023;

import java.util.ArrayDeque;
import java.util.Scanner;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");
        ArrayDeque<Integer> fuelStack = new ArrayDeque<>();
        for (String s : inputLine) {
            fuelStack.push(Integer.parseInt(s));
        }

        inputLine = scanner.nextLine().split(" ");
        ArrayDeque<Integer> consumpIndexQueue = new ArrayDeque<>();
        for (String s : inputLine) {
            consumpIndexQueue.offer(Integer.parseInt(s));
        }

        inputLine = scanner.nextLine().split(" ");
        ArrayDeque<Integer> neededFuelQueue = new ArrayDeque<>();
        for (String s : inputLine) {
            neededFuelQueue.offer(Integer.parseInt(s));
        }

        int reachedAltitudes = 0;
        boolean notEnoughFuel = false;

        while (!fuelStack.isEmpty() && !consumpIndexQueue.isEmpty() && !neededFuelQueue.isEmpty()){
            int currFuel = fuelStack.peek();
            int currConsIndex = consumpIndexQueue.peek();
            int res = currFuel - currConsIndex;
            if(res>=neededFuelQueue.peek()){
                reachedAltitudes++;
                fuelStack.pop();
                consumpIndexQueue.poll();
                neededFuelQueue.poll();
                    System.out.printf("John has reached: Altitude %d\n",reachedAltitudes);
            }else {
                // not reached
                System.out.printf("John did not reach: Altitude %d\n",reachedAltitudes+1);
                notEnoughFuel = true;
                break;
            }
        }

        if(notEnoughFuel && reachedAltitudes>0){
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: ");
            for (int i = 1; i <= reachedAltitudes; i++) {
                System.out.printf("Altitude %d",i);
                if(i!= reachedAltitudes){
                    System.out.print(", ");
                }
            }
        }

        if(notEnoughFuel && reachedAltitudes==0){
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }

        if(fuelStack.isEmpty() && consumpIndexQueue.isEmpty() && neededFuelQueue.isEmpty()){
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
}
