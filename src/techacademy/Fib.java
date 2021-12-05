package techacademy;

public class Fib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int op1 = 0;
		int op2 = 1;
		int res = 0;
		
		for (int i = 0; i <= 9; i++)
		{
			res = op1 + op2;
			System.out.println(res);
			
			op1 = op2;
			op2 = res;
		}

	}

}
