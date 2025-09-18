import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //function 1
        //allows the user to add the sentence they want
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your sentence here: ");
        //takes the users input and adds it into a string
        String sentence = sc.nextLine();
        //checks the string for unique characters
        boolean result = Unique(sentence);
        if(!result)
        {
            System.out.println("There was a repeated character.");
        }
        else
        {
            System.out.println("There was no repeated characters.");
        }

        //function 2
        System.out.println("Enter a word to count: ");
        String target = sc.nextLine();
        int occurrences = wordOccurrences(sentence, target);
        System.out.println("The word count is " + occurrences);

    }

    //Function 1: Implement an algorithm to determine if a string has all unique characters.
    public static boolean Unique(String str)
    {
        //makes sure all characters in the string are lowercase
        str.toLowerCase();

        //create an Array List to store the characters seen
        ArrayList<Character> uniqueList = new ArrayList<Character>();

        //loops through each character in the string
        for (int i = 0; i < str.length(); i++)
        {
            char currChar = str.charAt(i);
            if(uniqueList.contains(currChar))
            {
                //duplicate is found
                return false;
            }
            //otherwise, add it to the list of characters
            uniqueList.add(currChar);
        }
        //no duplicates found
        return true;
    }

    //Function 2: Implement a function to return the times of occurrence of a word in a string.
    public static int wordOccurrences(String sentence, String target)
    {
        //making sure everything is lowercase
        sentence = sentence.toLowerCase();
        target = target.toLowerCase();

        int count = 0;
        StringBuilder currWord = new StringBuilder();

        //split the sentence into words using anything that isn't a character
        for(int i = 0; i < sentence.length(); i++)
        {
            char c = sentence.charAt(i);

            //if c is a letter, build current word
            if(c >= 'a' && c <= 'z')
            {
                //build the word
                currWord.append(c);
            }
            else
            {
                if(!currWord.isEmpty())
                {
                    if(currWord.toString().equals(target))
                    {
                        count++;
                    }
                    //reset for the next word
                    currWord.setLength(0);
                }
            }
        }
        //handles the last word if the sentence happens to end with a character
        if(!currWord.isEmpty() && currWord.toString().equals(target))
        {
            count++;
        }
        return count;
    }
}