public class TopFive
{
    //function to get the top five salesmen
    public static Salesman[] TopFive(Salesman[] salesmen)
    {
        //creates new array to store the top Five salesmen
        Salesman[] topFive = new Salesman[5];

        //loops through the salesmen array
        for(int i = 0; i < salesmen.length; i++)
        {
            //Takes a salesman from the array
            Salesman currentSalesman = salesmen[i];

            //loops through the top 5 array
            for(int j = 0; j < topFive.length; j++)
            {
                //determines if there are any values in the top 5 list, or if it is larger than the values that are already in the list
                //also checks if there are any open values in the top 5 array
                if(topFive[j] == null || currentSalesman.sales > topFive[j].sales)
                {
                    //if the value is now the largest, the other values need to be shifted down in the array
                    //this for loop will shift the values down to the next available opening
                    for(int b = topFive.length - 1; b > j; b--)
                    {
                        topFive[b] = topFive[b -1];
                    }
                    //sets the current value of the top five list to the current salesman
                    topFive[j] = currentSalesman;
                    break;
                }
            }
        }
        //returns the top 5 array
        return topFive;
    }
}