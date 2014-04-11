package jail;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class driver {

	public static void main(String[] args) {
		boolean runAgain = true;
		do {
			int numberOfTestRuns = 0;
			int average = 0;
			int numberOfDays = 0;
			int numberOfTrials = 0;
			int max = 0;
			int min = 0;

			Scanner scnr = new Scanner(System.in);
			System.out
					.println("Please enter how many trials you would like to run?");
			numberOfTrials = scnr.nextInt();

			do {
				int tillFree = 0;
				enviroment room = new enviroment();

				Vector<prisoner> prisoners = new Vector<prisoner>();

				for (int i = 0; i < 101; i++) {
					prisoners.add(new prisoner(i));
				}
				Random randomGenerator = new Random();
				prisoners.get(0).setLeader(true);

				boolean finished = false;
				do {
					int randomInt = randomGenerator.nextInt(100);
					prisoner tempPrisoner = prisoners.get(randomInt);
					if (room.isLightSwitchOn()
							&& tempPrisoner.isLeader() == true) {
						room.turnOff();
						tillFree++;
					} else if (tempPrisoner.isLeader() == false
							&& tempPrisoner.isTurnedLightOnBefore() == false
							&& room.isLightSwitchOn() == false) {

						room.turnOn();
					}
					if (tillFree == 100) {
						finished = true;
					}
					numberOfDays++;
				} while (finished == false);

				// System.out.println("Set free in " + numberOfDays + " days.");
				numberOfTestRuns++;
				average += numberOfDays;
				if (numberOfDays > max) {
					max = numberOfDays;
				} else if (numberOfDays < min) {
					min = numberOfDays;
				}

				// Set min to number of days on the first trial so it doesn't
				// always = 0.
				if (numberOfTestRuns == 1) {
					min = numberOfDays;
				}

				// Reset numberOfDays
				numberOfDays = 0;
			} while (numberOfTestRuns < numberOfTrials);
			average = average / numberOfTrials;
			System.out
					.println("After running "
							+ numberOfTrials
							+ " trials the average amount of days it took to escape was: "
							+ average);
			System.out.println("The max amount of days it took was: " + max);
			System.out.println("The min amount of days it took was: " + min);

			System.out.println("Would you like to try again? 1=yes 2=no");

			if (scnr.nextInt() == 2) {
				runAgain = false;
			}
		} while (runAgain);
		System.out.println("GoodBye");
	}
}
