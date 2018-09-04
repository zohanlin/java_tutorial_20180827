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
		
		System.out.println("Input a number to generate a Fibonacci Number : ");
		cnt_max = fn_input.nextInt(); //potential issues :¡@java.util.InputMismatchException
		
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
		
//		fn_input.close(); //make user_in.nextInt() has the issue java.util.NoSuchElementException
		
		
////////////////////////////// Shuffle cards //////////////////////////////		
		System.out.println();
		poker[] Pokers = new poker[52];
		
		//Create a deck of cards
		System.out.println("Create a deck of cards");
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
//		for(int i = 0; i < 52; i++)
//		{
//			//System.out.printf("%c %d%n",  Pokers[i].color, Pokers[i].number);
//		}
		for(int i = 0; i < 13; i++)
		{
			System.out.printf("%c %d\t%c %d\t%c %d\t%c %d%n"
					,  Pokers[i].color, Pokers[i].number
					,  Pokers[i+13].color, Pokers[i+13].number
					,  Pokers[i+26].color, Pokers[i+26].number
					,  Pokers[i+39].color, Pokers[i+39].number);
		}
		
		//Shuffle cards
		System.out.println();
		System.out.println("Shuffle cards");
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
//		for(int i = 0; i < 52; i++)
//		{
//			System.out.printf("%c %d%n",  Pokers[i].color, Pokers[i].number);
//		}
		for(int i = 0; i < 13; i++)
		{
			System.out.printf("%c %d\t%c %d\t%c %d\t%c %d%n"
					,  Pokers[i].color, Pokers[i].number
					,  Pokers[i+13].color, Pokers[i+13].number
					,  Pokers[i+26].color, Pokers[i+26].number
					,  Pokers[i+39].color, Pokers[i+39].number);
		}
		
		
////////////////////////////// sort & find a number which user chooses //////////////////////////////
		System.out.println();
		System.out.println("Sort Smallest to Largest & Find a number which user chooses");
		int[] number = {70, 80, 31, 37, 10, 1, 48, 60, 33, 80};
		int sort_tmp = 0;

		System.out.println("Before sort");
		for(int i = 0; i < number.length; i++)
		{
			System.out.printf("%3d,", number[i]);
		}
		System.out.println();
		
		//Sort Smallest to Largest
		for(int i = 0; i < number.length; i++)
		{
			sort_tmp = number[i];
			for(int j = i + 1; j < number.length; j++)
		{
				if(sort_tmp > number[j])
				{
					number[i] = number[j];
					number[j] = sort_tmp;
					sort_tmp = number[i];
				}
			}
		}

		System.out.println("After sorted");
		for(int i = 0; i < number.length; i++)
		{
			System.out.printf("%3d,", number[i]);
		}
		System.out.println();
		
		int user_wanted = 0;
		boolean find_number = false;
		Scanner user_in = new Scanner(System.in);//potential issues :¡@java.util.InputMismatchException
		System.out.println();
		System.out.printf("Please input number : ");
		user_wanted = user_in.nextInt();
		System.out.println();
		System.out.printf("Try to find the number : %d%n", user_wanted);
		
		if(user_wanted > number[number.length - 1] || user_wanted < number[0])
		{
			System.out.println(-1);
			System.out.println("Out of range");
		}
		else
		{
			for(int i = 0; i < number.length; i++)
			{
				if(user_wanted == number[i])
				{
					System.out.printf("Index = %d%n", i);
					find_number = true;
					continue;
		}
		
			}
			if(find_number == false)
			{
				System.out.println(-1);
			}
		}
		

		user_in.close();
	}

}
