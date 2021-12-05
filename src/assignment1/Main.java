package assignment1;

// Assignment 1: Count Total Birds
// by luanvind@amdocs.com
public class Main {
	public static int countTotalBirds(int rowNumber)
	{
		// accepts the number of rows, then calculates total number of birds
		
		// I could to verify if rowNumber >= 0
		// but to simplify I will not.
		
		// corner case for rowNumer equals 1
		if (rowNumber == 1)
		{
			return 1;
		}
		// corner case for rowNumer equals 2
		// so return 1 + 2
		else if(rowNumber == 2)
		{
			return 3;
		}
		
		int numberOfBirds = 3;
		int operator1 = 1;
		int operator2 = 2;
		int res = 0;
		
		for (int i = 3; i <= rowNumber; i++)
		{
			res = operator1 + operator2;
			numberOfBirds += res;
			
			operator1 = operator2;
			operator2 = res;
		}
		
		return numberOfBirds;
	}
	
	public static void main(String[] args)
	{
		// accepts total row number, invokes countTotalBirds
		// then display total number of birds
		
		// as it was not specified and no example was given to
		// the way the input must be inserted
		// just insert the number of rows bellow
		int rowNumber = 3;
		System.out.println(countTotalBirds(rowNumber));
	}
}
