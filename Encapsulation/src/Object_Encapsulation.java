import java.util.Scanner; 

class A_Tower
{
	int[] tower;
	int cnt;
}


class Tower_Hanoi
{
	A_Tower tower_left;
	A_Tower tower_center;
	A_Tower tower_right;
	
	boolean tower_is_ok = false; 

	Tower_Hanoi()
	{

	}

	Tower_Hanoi(int num)
	{
		this.tower_left = new A_Tower();
		this.tower_center = new A_Tower();
		this.tower_right = new A_Tower();

		this.tower_left.tower = new int[num];
		this.tower_left.cnt = 0;
		this.tower_center.tower = new int[num];//default value is zero.
		this.tower_center.cnt = 0;
		this.tower_right.tower = new int[num];//default value is zero.
		this.tower_right.cnt = 0;
		
		for(int i = 0; i < num; i++)
		{
			this.tower_left.tower[i] = i+1;
			this.tower_left.cnt++;
		}
	}
	
	void display()
	{
		for(int i = 0; i < this.tower_left.tower.length; i++)
		{
			System.out.printf("%5d, %5d, %5d%n", this.tower_left.tower[i], this.tower_center.tower[i], this.tower_right.tower[i]);			
		}
		System.out.println("cnt:");
		System.out.printf("%5d, %5d, %5d%n", this.tower_left.cnt, this.tower_center.cnt, this.tower_right.cnt);
		System.out.println("");
	}	

	void move(int num, A_Tower src, A_Tower tmp, A_Tower dst)
	{
		if(num == 0)
		{
			System.out.println("Nothing to do.");
		}
		else if(num==1)
		{
			push(dst, pop(src));
			display();
			check();
		}
		else if(num >= 2)
		{
			move(num-1, src, dst, tmp);
			move(1, src, tmp, dst);
			move(num-1, tmp, src, dst);
		}
		else
		{
			System.out.println("Wrong number, it must be a positive number.");
		}
	}
	
	int pop(A_Tower t)
	{
		int v = 0;
		if(t.cnt < 1 || t.cnt > t.tower.length)
		{
			System.out.println("No element to pop");
			return -1;
		}
		
		v = t.tower[t.tower.length - t.cnt];
		t.tower[t.tower.length - t.cnt] = 0;
		t.cnt--;
		
		return v;
	}
	
	int push(A_Tower t, int v)
	{
		if(t.cnt == t.tower.length)
		{
			System.out.println("No space to push");
			return -1;
		}
		if(v <= 0)
		{
			System.out.println("The value must be a positive number");
			return -1;
		}
		
		t.tower[t.tower.length - t.cnt - 1] = v;
		t.cnt++;
		
		return 0;
	}
	
	
	
	void play()
	{
		move(this.tower_left.cnt, this.tower_left, this.tower_center, this.tower_right);
	}
	
	void check()
	{
		for(int i = 1; i < this.tower_left.tower.length; i++)
		{
			if(this.tower_left.tower[i-1] <= this.tower_left.tower[i]
					|| this.tower_center.tower[i-1] <= this.tower_center.tower[i]
					|| this.tower_right.tower[i-1] <= this.tower_right.tower[i])
			{
				//System.out.println("Towers are ok.");
				this.tower_is_ok = true;
			}
			else
			{
				//System.out.println("Towers are't ok!!!");
				this.tower_is_ok = false;
			}
		}
		
		
		if(this.tower_is_ok)
		{
			System.out.println("Towers are ok.");
		}
		else
		{
			System.out.println("Towers are't ok!!!");
		}
	}
}


public class Object_Encapsulation {

	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Encapsulate Object.");
		
		System.out.println("");
		System.out.println("Tower of Hanoi");
		System.out.println("Please enter a number to create a Tower of Hanoi : ");
		Scanner user_input = new Scanner(System.in);
		int tower_num = user_input.nextInt(); //potential issues :¡@java.util.InputMismatchException
		
		Tower_Hanoi th = new Tower_Hanoi(tower_num);
		th.display();
		System.out.println("");
		th.play();

	}

}
