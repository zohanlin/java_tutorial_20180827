import java.util.Scanner; 

class poker
{
	char color;
	int number;
	
	poker(char color, int number)
	{
		this.color = color;
		this.number = number;
	}
}

public class Object_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Object Test.");
		
		//Scanner user_input = new Scanner(System.in);		
		//System.out.println("user input :");
		//System.out.println(user_input.nextInt());//Exception in thread "main" java.util.InputMismatchException: For input string: "9999999999999999999"
		//System.out.println(user_input.next());//
		
////////////////////////////// Fibonacci Number //////////////////////////////
		long fn_2 = 0, fn_1 = 1, fn = 0;
		int cnt_max = 0;
		Scanner fn_input = new Scanner(System.in);
		cnt_max = fn_input.nextInt();
		
		for(int i = 0; i < cnt_max; i++)
		{
			if(i==0)
			{
				fn = 0;
				System.out.println(fn);
				continue;
			}
			if(i==1)
			{
				fn = 1;
				System.out.println(fn);
				continue;
			}
			fn = fn_1 + fn_2;
			fn_2 = fn_1;
			fn_1 = fn;	
			System.out.println(fn);		
		}
		
		
		
////////////////////////////// Shuffle cards //////////////////////////////		
		poker[] Pokers = new poker[52];
		
		//Create a deck of cards
		for(int i = 0; i < 52; i++)
		{
			if(i < 13)
			{				
				Pokers[i] = new poker('®ç', i%13+1);
				continue;
			}
			if(i >= 13 && i < 26)
			{
				Pokers[i] = new poker('¤ß', i%13+1);
				continue;
			}
			if(i >= 26 && i < 39)
			{
				Pokers[i] = new poker('¿j', i%13+1);
				continue;
			}

			Pokers[i] = new poker('±ö', i%13+1);

		}
		for(int i = 0; i < 52; i++)
		{
			System.out.printf("%c %d%n",  Pokers[i].color, Pokers[i].number);
		}
		
		//Shuffle cards
		poker poker_tmp;
		int ran_num = 0;
		//int switch_buff = 13; //funny result, only change flower(color)
		int switch_buff = 5;
		for(int i = 0; i < 52; i++)
		{
			ran_num = (int)(Math.random()*52);
			poker_tmp = Pokers[ran_num];
			Pokers[ran_num] = Pokers[(ran_num+switch_buff)%52];
			Pokers[(ran_num+switch_buff)%52] = poker_tmp;
			//System.out.printf("%d%n", (int)(Math.random()*52));//0~51
			//System.out.printf("%d%n", (int)(Math.random()*52+1));//1~52
			//System.out.printf("%c %d%n",  Pokers[i].color, Pokers[i].number);
		}
		for(int i = 0; i < 52; i++)
		{
			System.out.printf("%c %d%n",  Pokers[i].color, Pokers[i].number);
		}
		
		

	}

}
