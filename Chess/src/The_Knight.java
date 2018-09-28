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


public class The_Knight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Chess");
		
		ChessBoard K_chess = new ChessBoard(8);
		K_chess.show();

	}

}
