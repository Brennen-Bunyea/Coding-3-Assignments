public class TopFive
{
    //function to get the top five salesmen
    public static Salesman[] TopFive(Salesman[] salesmen)
    {
        //creates new array to store the top Five salesmen
        Salesman[] topFive = new Salesman[5];

        //walks through the salesmen array
        for(int i = 0; i < salesmen.length; i++)
        {
            Salesman s = salesmen[i];

            //compares the sales for each person to see if they are top five
            for(int j = 0; j < topFive.length; j++)
            {
                //determines if there are any values in the top 5 list, or if it is larger than the values that are already in the list
                if(topFive[i] == null || s.sales > topFive[i].sales)
                {
                    //if the value is now the largest, the other values need to be shifted down in the array
                    //this for loop will shift the values down to the next available opening, but not off the end of the array
                    for(int j = topFive.length - 1; j > i; j--)
                    {
                        topFive[j] = topFive[j -1];
                    }
                    //sets the current value of the top five list to the current salesman
                    topFive[i] = s;
                    break;
                }
            }
        }
        return topFive;
    }
}