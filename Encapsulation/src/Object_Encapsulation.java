import java.util.Scanner; 

class A_Tower
{
	int[] tower;
	int cnt;
}


class Tower_Hanoi
{
	private A_Tower tower_left;
	private A_Tower tower_center;
	private A_Tower tower_right;
	
	private boolean tower_is_ok = false; 

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

	//**********************************//
	//move(	n,		src,	tmp,	dst)
	//
	//move(	n-1,	s,		d,		t)
	//move(	1,		s,		t,		d)
	//move(	n-1,	t,		s,		d)
	//	
	/////////////////////////////////////
	//
	//move(	n-1,	s,		d,		t)
	//
	//move(	n-2,	s,		t,		d)
	//move(	1,		s,		d,		t)
	//move(	n-2,	d,		s,		t)
	//**********************************//
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

//header is null node.
class Maze_Path
{
	int L; //y
	int R; //x, (y , x)

	Maze_Path left;
	Maze_Path right;
	
	final int is_traced = 8;
	final int is_path = 6;
	final int is_mouse = 9;
	
	Maze_Path()
	{
		
	}
	
	Maze_Path(int l, int r)
	{
		this.L = l;
		this.R = r;
		this.left = null;
		this.right = null;
	}

	
	void init(Maze_Path header, int l, int r)
	{
		Maze_Path new_path = new Maze_Path(l, r);
		header.right = new_path;
		new_path.left = header;
	}
	
	Maze_Path add(int l, int r)
	{
		Maze_Path new_path = new Maze_Path(l, r);
		Maze_Path tmp = this.right;
		if(tmp == null)
		{
			return null;
		}
		else
		{
			while(tmp.right != null)
			{
				tmp = tmp.right;
			}
			tmp.right = new_path;
			new_path.left = tmp;
		}
		
		return new_path;
	}
	
	void display()
	{
		Maze_Path tmp;
		System.out.printf("(%d , %d)\n",  this.L, this.R);

		tmp = this.right;
		while(tmp != null)
		{
			System.out.printf("(%d , %d)\n",  tmp.L, tmp.R);
			tmp = tmp.right;
		}
	}
	
	void display_inverse()
	{
		Maze_Path tmp;
		System.out.printf("(%d , %d)",  this.L, this.R);

		tmp = this.left;
		while(tmp != null)
		{
			System.out.printf("(%d , %d)",  tmp.L, tmp.R);
			tmp = tmp.left;
		}
		System.out.println();
	}
}

class Maze_turning_point
{
	Maze_turning_point next;
	Maze_Path p;
	
	Maze_turning_point()
	{
		this.next = null;
		this.p = null;
	}
		
	Maze_turning_point(Maze_Path p)
	{
		this.next = null;
		this.p = p;
	}
	
	boolean push(Maze_Path push_p)
	{
		Maze_turning_point new_next;
		
		if(push_p == null)
		{
			System.out.printf("push_p is null\n");
			return false;
		}
		
//		System.out.printf("Ready push (%d , %d)\n",  push_p.L, push_p.R);
		
		new_next = new Maze_turning_point(p);
		new_next.p = push_p;
		new_next.next = this.next;
		this.next = new_next;		
		
		System.out.printf("push (%d , %d)\n",  push_p.L, push_p.R);
		
		return true;	
	}
	
	Maze_Path pop()
	{
		Maze_Path pop_p;
		
		if(this.next == null)
		{
			System.out.printf("pop_p is null\n");
			return null;
		}
		
		pop_p = this.next.p;
//		Maze_turning_point tmp = this.next; //lifetime?
		this.next = this.next.next;
//		tmp.next = null;
		pop_p.right = null;
		
		System.out.printf("pop (%d , %d)\n",  pop_p.L, pop_p.R);
		
		return pop_p;
	}
	
}

class Maze_runner
{
	private int[][] a_maze;
	private Maze_Path run_path; //start point
	private Maze_Path mouse_location;
	private Maze_turning_point turning_point;
	
	Maze_runner()
	{
		this.turning_point = new Maze_turning_point();		
	}
	
	Maze_runner(int[][] maze, int start_l, int start_r)
	{
		this.a_maze = maze;
		this.run_path = new Maze_Path();
		this.run_path.init(this.run_path, start_l, start_r);
		this.mouse_location = this.run_path.right;
		this.turning_point = new Maze_turning_point();
	}
	
	int run(int end_l, int end_r)
	{
		if(this.a_maze.length == 0 && this.a_maze[0].length == 0)
		{
			System.out.println("The Maze is null, the mouse can't escape from the mazw.");
			return -1;
		}
		if(turning_point == null)
		{
			System.out.println("The truning point stack is null.");
			return -1;
		}
		System.out.printf("The Maze size is %d x %d\n", this.a_maze.length, this.a_maze[0].length);
		System.out.printf("Run from (%d , %d)\n", this.mouse_location.L, this.mouse_location.R);
		

//		int i_tmp = 0;
		
		while(this.mouse_location.L != end_l || this.mouse_location.R != end_r)
		{
			display();
		
//			if(i_tmp++ > 20)
//				break;
			
			if(turn_north() || turn_south() || turn_east() || turn_west())
			{
				this.a_maze[this.mouse_location.L][this.mouse_location.R] = this.mouse_location.is_traced;
//				System.out.printf(" ready push mouse_location.left (%d , %d)\n", this.mouse_location.left.L, this.mouse_location.left.R);
				turning_point.push(this.mouse_location.left);
//				System.out.printf("mouse_location (%d , %d), n=%d, s=%d, e=%d, w=%d\n",  mouse_location.L, mouse_location.R, mouse_location.north, mouse_location.south, mouse_location.east, mouse_location.west);
//				System.out.printf("mouse_location.left (%d , %d)\n", this.mouse_location.left.L, this.mouse_location.left.R);
//				this.mouse_location.display_inverse();
				continue;
			}
			
			this.mouse_location = turning_point.pop();
//			System.out.printf("mouse_location (%d , %d)\n", this.mouse_location.L, this.mouse_location.R);
//			System.out.printf("mouse_location.left (%d , %d)\n", this.mouse_location.left.L, this.mouse_location.left.R);
			if(this.mouse_location == null)
			{
				System.out.println("The mouse is lost.");
				break;
			}

		}
		
		if(this.mouse_location.L == end_l && this.mouse_location.R == end_r)
		{
			System.out.println("The mouse has escaped from the maze.");
		}
		

		
//		turn_east();
//		turn_south();
//		turn_south();
//		turn_east();
//		turn_south();
//		turn_south();
//		turn_west();
//		turn_east();//Issue : It should return false, because the original maze donen't be modified.
//		turn_east(); //Issue : It should return false, because the original maze donen't be modified.


		return 1;
	}
	
	boolean turn_north()
	{
		if(this.mouse_location.L >= 1 && this.mouse_location.L <= this.a_maze.length-1)
		{
			if(this.a_maze[this.mouse_location.L-1][this.mouse_location.R] == 0)
			{
				this.mouse_location = run_path.add(this.mouse_location.L - 1, this.mouse_location.R);
				return true;
			}
			else
			{
				return false;
			}
		}		
		return false;
	}
	
	boolean turn_south()
	{
		if(this.mouse_location.L >= 0 && this.mouse_location.L <= this.a_maze[0].length-2)
		{
			if(this.a_maze[this.mouse_location.L+1][this.mouse_location.R] == 0)
			{
				//this.mouse_location.south = this.mouse_location.go_to;
				this.mouse_location = run_path.add(this.mouse_location.L + 1, this.mouse_location.R);
				return true;
			}
			else
			{
				return false;
			}
		}		
		return false;
	}
	
	boolean turn_east()
	{
		if(this.mouse_location.R >= 0 && this.mouse_location.R <= this.a_maze.length-2)
		{
			if(this.a_maze[this.mouse_location.L][this.mouse_location.R+1] == 0)
			{
				this.mouse_location = run_path.add(this.mouse_location.L, this.mouse_location.R + 1);
				return true;
			}
			else
			{
				return false;
			}
		}		
		return false;
	}
	
	boolean turn_west()
	{
		if(this.mouse_location.R >= 1 && this.mouse_location.R <= this.a_maze.length-1)
		{
			if(this.a_maze[this.mouse_location.L][this.mouse_location.R-1] == 0)
			{
				this.mouse_location = run_path.add(this.mouse_location.L, this.mouse_location.R - 1);
				return true;
			}
			else
			{
				return false;
			}
		}		
		return false;
	}
	
	void display()
	{
		Maze_Path tmp = this.run_path.right;
		int[][] tmp_array = new int[this.a_maze.length][this.a_maze[0].length];
		
		for(int i = 0; i < this.a_maze.length; i++)
		{
			for(int j = 0; j < this.a_maze[0].length; j++)
			{
				tmp_array[i][j] = this.a_maze[i][j];
			}
		}
		
		while(tmp != null)
		{
			tmp_array[tmp.L][tmp.R] = tmp.is_path;
			
			if(tmp.right == null)
			{
				tmp_array[tmp.L][tmp.R] = tmp.is_mouse;
			}
			tmp = tmp.right;
		}
		
		
		for(int i = 0; i < tmp_array.length; i++)
		{
			for(int j = 0; j < tmp_array[0].length; j++)
			{
				System.out.printf("%3d", tmp_array[i][j]);
			}
			System.out.println("");
		}
		//System.out.println("");
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
		int tower_num = user_input.nextInt(); //potential issues :�@java.util.InputMismatchException
		
		if(tower_num < 0)
		{
			tower_num = 0;
			System.out.println("The value must be a positive number, setting the number by zero.");
		}
		Tower_Hanoi th = new Tower_Hanoi(tower_num);
		th.display();
		System.out.println("");
		th.play();
		
		
		
//		//for testing stack
//		System.out.println("");
//		System.out.println("Stack test");
//		Maze_Path p1 = new Maze_Path(1,1);
//		Maze_Path p2 = new Maze_Path(1,2);
//		Maze_Path p3 = new Maze_Path(1,3);
//		
//		Maze_turning_point turning_point = new Maze_turning_point();
//
//		turning_point.push(p1);
//		turning_point.push(p2);
//		turning_point.pop();
//		turning_point.push(p3);
//		turning_point.pop();
//		turning_point.pop();
		
		//for testing link list
//		System.out.println("");
//		System.out.println("link list test");
//		Maze_Path p1 = new Maze_Path(1,1);
//		
//		p1.add(1,2,0,0,0,0);
//		p1.add(1,3,0,0,0,0);
//		p1.display();
//		p1.add(1,4,0,0,0,0);
//		p1.display();
		
		System.out.println("");
		System.out.println("A mouse escapes from the maze");
		int[][] maze = { 
//			{2, 2, 2, 2, 2, 2, 2},
//			{0, 0, 0, 0, 0, 0, 2},
//			{2, 0, 2, 0, 2, 0, 2},
//			{2, 0, 0, 2, 0, 2, 2},
//			{2, 2, 0, 2, 0, 2, 2},
//			{2, 0, 0, 0, 0, 0, 2},
//			{2, 2, 2, 2, 2, 0, 2}
			{2, 2, 2, 2, 2, 2, 2},
			{0, 0, 0, 0, 0, 0, 2},
			{2, 0, 2, 0, 2, 0, 0},
			{2, 0, 0, 2, 0, 2, 0},
			{2, 2, 0, 0, 0, 2, 0},
			{2, 0, 0, 0, 0, 2, 0},
			{2, 2, 2, 2, 2, 0, 0}
		};
		Maze_runner mouse = new Maze_runner(maze, 1, 0);
		mouse.run(6,5);
		mouse.display();

	}

}
