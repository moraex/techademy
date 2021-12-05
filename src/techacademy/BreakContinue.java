package techacademy;

public class BreakContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 10;
		
		for (int i = 0; i <= limit; i++)
		{
			if(i == 5)
			{
				continue;
			}
			System.out.println(i);
		}

	}

}
