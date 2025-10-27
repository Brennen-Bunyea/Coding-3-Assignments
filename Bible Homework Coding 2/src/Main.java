public class Main
{
    public static void main(String[] args)
    {
        long totalPopulation = 7_700_000_000L;
        int initialDisciples = 13;
        int lifeSpan = 72;
        int trainingAge = 18;
        int cycleYear = 3;
        //each disciple trains two more
        int newDisciplesCycle = 2;

        int trainingYears = lifeSpan - trainingAge;
        int trainingCycles = trainingYears / cycleYear;

        int totalYears = calculateYears(initialDisciples, totalPopulation, newDisciplesCycle, cycleYear);
        System.out.println("Years needed to convert all humans: " + totalYears + " years");
    }

    //Calculate the years that is needed to reach the total population
    public static int calculateYears(int initial, long total, int newDisciplesCycle, int cycleYears)
    {
        long current = initial;
        int cycles = 0;
        int multiplier = 1 + newDisciplesCycle;
        while (current < total)
        {
            current *= multiplier;
            cycles++;
        }
        return cycles * cycleYears;
    }
}