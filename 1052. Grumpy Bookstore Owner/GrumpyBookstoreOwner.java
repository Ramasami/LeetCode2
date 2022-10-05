public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int nonGrumpy = 0;
        int grumpyInRange = 0;
        int n = customers.length;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 0)
                nonGrumpy += customers[i];
            else
                grumpyInRange += customers[i];
        }
        int maxGrumpy = grumpyInRange;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 0)
                nonGrumpy += customers[i];
            else
                grumpyInRange += customers[i];
            if (grumpy[i - minutes] == 1) {
                grumpyInRange -= customers[i - minutes];
            }
            maxGrumpy = Math.max(maxGrumpy, grumpyInRange);
        }
        return nonGrumpy + maxGrumpy;

    }
}