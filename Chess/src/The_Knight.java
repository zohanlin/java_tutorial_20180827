class ChessBoard{
	
	int[][] a_chessboard;
	Path_Node root;
	Path_Node last_node;
	int cnt = 0;
	
	ChessBoard()
	{
		
	}
	
	ChessBoard(int board_size)
	{
		this.a_chessboard = new int[board_size][board_size];
		System.out.printf("Generate a %d X %d Chessboard.\n", board_size, board_size);
	}
	
	void Knight_run(int start_x, int start_y)
	{
		this.root = new Path_Node();		
		Chess_Path cp = new Chess_Path(start_x, start_y);
		root.add(root, cp);
		this.last_node = root.get_last_node();
		this.cnt++;
		this.a_chessboard[this.last_node.path.y][this.last_node.path.x] = this.cnt;
		
		Knight_up_left();
		Knight_up_left();
		Knight_up_left();
	}
	
	int Knight_up_left()
	{
		if(this.last_node.path.y - 2 >= 0 && this.last_node.path.y <= this.a_chessboard.length &&
		   this.last_node.path.x - 1 >= 0 && this.last_node.path.x <= this.a_chessboard[0].length	)
		{
			Chess_Path cp = new Chess_Path(this.last_node.path.x - 1, this.last_node.path.y - 2);
			cp.UL = 1;
			root.add(root, cp);
			this.last_node = root.get_last_node();
			this.cnt++;
			this.a_chessboard[this.last_node.path.y][this.last_node.path.x] = this.cnt;

			return 1;
		}
		
		return 0;
	}
	
	void Knight_up_right()
	{
		
	}
	
	void Knight_right_up()
	{
		
	}
	
	void Knight_right_down()
	{
		
	}
	
	void Knight_down_right()
	{
		
	}
	
	void Knight_down_left()
	{
		
	}
	
	void Knight_left_down()
	{
		
	}
	
	void Knight_left_up()
	{
		
	}
	
	void show()
	{
		for(int i = 0; i < this.a_chessboard.length; i++)
		{
			for(int j = 0; j < this.a_chessboard[0].length; j++)
			{
				System.out.printf("%3d", this.a_chessboard[i][j]);
			}
			System.out.println();
		}
	}
	
}


class Chess_Path{

	int UL; //up left
	int UR; //up right
	int RU; //right up
	int RD; //right down
	int DR; //down right
	int DU; //down up
	int LD; //left down
	int LU; //left up
	int x, y;
	
	Chess_Path()
	{
		
	}
	
	Chess_Path(int test)
	{
		//for test;
		this.UL = test;
	}
	
	Chess_Path(int x, int y)
	{
		//for test;
		this.x = x;
		this.y = y;
	}
	
	int add_path() //add, but not insert
	{
	
		return 0;
	}
	
	int delete() //delete the last node
	{
		
		return 0;
	}
	

	void show()
	{
		
	}
	
	
	void test_night_path()
	{
		
	}
	
}

//root <-> node <-> node

class Path_Node
{
	
	Chess_Path path;
	Path_Node left;
	Path_Node right; //next node
	
	Path_Node()
	{
		
	}
	
	Path_Node(Chess_Path p)
	{
		this.path = p;
	}
	
	void add(Path_Node root, Chess_Path p)
	{
		Path_Node new_node = new Path_Node(p);
		Path_Node last_node = root;
		
		while(last_node.right != null)
		{
			last_node = last_node.right;
		}
		last_node.right = new_node;
		new_node.left = last_node; 
	}
	
	Path_Node get_last_node()
	{
		Path_Node tmp;
		
		if(this.right==null && this.left==null)
		{
			return null;
		}
		
		tmp = this.right;
		if(tmp != null)
		{
			while(tmp.right!=null)
			{
				tmp = tmp.right;
			}
		}

		
		return tmp;
	}
	
	void show()
	{
		Path_Node last_node = this.right;
		int i = 0;
		while(last_node != null)
		{
			System.out.printf("%d : %d\n", i++,  last_node.path.UL);
			last_node = last_node.right;
		}
	}
	
	
}


public class The_Knight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//test node operation
		System.out.println("Test node operation");
		Path_Node root = new Path_Node();
		for(int i = 0; i < 10; i++)
		{
			Chess_Path cp = new Chess_Path(100-i);
			root.add(root, cp);
		}
		root.show();
		Path_Node lastN;
		lastN = root.get_last_node();
		if(lastN!=null)
		{
			System.out.printf("lastN.path.UL = %d\n", lastN.path.UL);
		}
		else
		{
			System.out.printf("lastN.path.UL is null\n");
		}
		
		System.out.println("Chess");
		
		ChessBoard K_chess = new ChessBoard(8);
		K_chess.show();
		System.out.println("");
		K_chess.Knight_run(5, 5);
		K_chess.show();

	}

}
