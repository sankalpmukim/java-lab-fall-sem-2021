public class Execution {
    public static void main(String[] args) {
        int[][] mainArr = { { 1, 2, 2, 1, 1, 1 }, { 2, 1, 2, 2, 2, 1 }, { 2, 1, 1, 2, 1, 1 }, { 2, 2, 1, 1, 1, 2 },
                { 1, 2, 2, 1, 1, 1 }, { 2, 1, 1, 1, 2, 2 } };

        // This code works for any nXn 2D array with no change
        // We can calculate for digits other than 1 and 2 with minimal change
        // counting 1s
        int oneCount = 0;
        CountHorizontal oddsHorizontalOnes = new CountHorizontal(mainArr, true, 1); // Thread 1
        CountHorizontal evensHorizontalOnes = new CountHorizontal(mainArr, false, 1); // Thread 2
        CountVertical oddsVerticalOnes = new CountVertical(mainArr, true, 1); // Thread 3
        CountVertical evensVerticalOnes = new CountVertical(mainArr, false, 1); // Thread 4

        oddsHorizontalOnes.start();
        evensHorizontalOnes.start();
        oddsVerticalOnes.start();
        evensVerticalOnes.start();

        while (oddsHorizontalOnes.notFinished || evensHorizontalOnes.notFinished || oddsVerticalOnes.notFinished
                || evensVerticalOnes.notFinished) {
            try {
                oddsHorizontalOnes.join();
                oddsVerticalOnes.join();
                evensHorizontalOnes.join();
                evensVerticalOnes.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        oneCount += oddsHorizontalOnes.count;
        oneCount += oddsVerticalOnes.count;
        oneCount += evensHorizontalOnes.count;
        oneCount += evensVerticalOnes.count;

        System.out.println("Count of triplets for Team 1:\t" + oneCount);

        // counting 2s
        int twoCount = 0;
        CountHorizontal oddsHorizontalTwos = new CountHorizontal(mainArr, true, 2);
        CountHorizontal evensHorizontalTwos = new CountHorizontal(mainArr, false, 2);
        CountVertical oddsVerticalTwos = new CountVertical(mainArr, true, 2);
        CountVertical evensVerticalTwos = new CountVertical(mainArr, false, 2);

        oddsHorizontalTwos.start();
        evensHorizontalTwos.start();
        oddsVerticalTwos.start();
        evensVerticalTwos.start();

        while (oddsHorizontalTwos.notFinished || evensHorizontalTwos.notFinished || oddsVerticalTwos.notFinished
                || evensVerticalTwos.notFinished) {
            try {
                oddsHorizontalTwos.join();
                oddsVerticalTwos.join();
                evensHorizontalTwos.join();
                evensVerticalTwos.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        twoCount += oddsHorizontalTwos.count;
        twoCount += oddsVerticalTwos.count;
        twoCount += evensHorizontalTwos.count;
        twoCount += evensVerticalTwos.count;

        System.out.println("Count of triplets for Team 2:\t" + twoCount);

        int winningTeam = oneCount > twoCount ? 1 : 2;
        System.out.println("Therefore, the winning team is: Team " + winningTeam);
    }
}
