//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        //Create a project that uses a temporary 5-item array as the data structure to get the top 5 salesmen
        //You have 20 salesmen in the list, with random names and revenues
        //The function TopFive will output a list of the top 5 by revenue


        //steps
        //Create a salesmen constructor that uses an array to store both the name and sales for that particular person
        //create the salesmen
        //Loop through the salesmen to get the top 5 with the highest sales
        //Store those top 5 in a new array

        //creates the Salesman array needed to store the salesmen data
        Salesman[] salesmen = new Salesman[21];

        //the salesmen data
        salesmen[0] = new Salesman("John", 100);
        salesmen[1] = new Salesman("Jane", 150);
        salesmen[2] = new Salesman("Mary", 100);
        salesmen[3] = new Salesman("Joe", 200);
        salesmen[4] = new Salesman("Jack", 175);
        salesmen[5] = new Salesman("Sue", 225);
        salesmen[6] = new Salesman("Jack", 230);
        salesmen[7] = new Salesman("Jill", 345);
        salesmen[8] = new Salesman("Mack", 245);
        salesmen[9] = new Salesman("Mike", 300);
        salesmen[10] = new Salesman("Blade", 375);
        salesmen[11] = new Salesman("Brock", 350);
        salesmen[12] = new Salesman("Hunter", 360);
        salesmen[13] = new Salesman("Harry", 180);
        salesmen[14] = new Salesman("Tanner", 210);
        salesmen[15] = new Salesman("Markus", 220);
        salesmen[16] = new Salesman("Jonny", 330);
        salesmen[17] = new Salesman("James", 400);
        salesmen[18] = new Salesman("Josh", 425);
        salesmen[19] = new Salesman("Malachi", 450);
        salesmen[20] = new Salesman("Alex", 500);

        //call the function in Salesman to find the top5 salesmen
        Salesman[] top = TopFive(salesmen);

        //Last step is to display the results to the screen
        System.out.println("The Top 5 Salesmen by Revenue");
        for(int i = 0; i < top.length; i++)
        {
            System.out.println((i + 1) + ". " + top[i].name + " $" + top[i].revenue);
        }
    }
}