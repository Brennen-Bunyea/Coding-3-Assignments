public class Main
{
    public static void main(String[] args)
    {
        long totalPopulation = 7_700_000_000L;
        int initialDisciples = 13;
        int cycleYear = 3;
        //each disciple trains two more
        int newDisciplesCycle = 2;

        int convertYears = calculateYears(initialDisciples, totalPopulation, newDisciplesCycle, cycleYear);
        System.out.println("Years needed to convert all humans: " + convertYears + " years");

        int targetYears = 50;
        double newDisciples = calculateDisciples(initialDisciples, totalPopulation, targetYears, cycleYear);
        System.out.println("Each disciple must train " + Math.round(newDisciples * 100.0) / 100.0 + " disciples every 3 years to finish in 50 years");

    }

    //Calculate the years that is needed to reach the total population
    public static int calculateYears(int initial, long total, int newDisciplesCycle, int cycleYears)
    {
        long current = initial;
        int cycles = 0;
        int multiplier =  1 + newDisciplesCycle;

        while (current < total)
        {
            current *= multiplier;
            cycles++;
        }
        return cycles * cycleYears;
    }

    //Calculates the number of disciples trained per cycle to finish in 50 years
    public static double calculateDisciples(double initial, double total, double targetYears, int cycleYear)
    {
        double cycles = targetYears / cycleYear;
        double ratio = total / initial;

        double base = Math.pow(ratio, 1.0 / cycles);
        double r = base - 1;
        return r;
    }
}