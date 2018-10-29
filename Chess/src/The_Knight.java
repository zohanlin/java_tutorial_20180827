class ChessBoard{
	
	int[][] a_chessboard;
	
	ChessBoard()
	{
		
	}
	
	ChessBoard(int board_size)
	{
		this.a_chessboard = new int[board_size][board_size];
		System.out.printf("Generate a %d X %d Chessboard.\n", board_size, board_size);
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
	
	Chess_Path()
	{
		
	}
	

	
	Chess_Path(int test)
	{
		//for test;
		this.UL = test;
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
		
		
		System.out.println("Chess");
		
		ChessBoard K_chess = new ChessBoard(8);
		K_chess.show();

	}

}
