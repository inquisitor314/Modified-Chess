
public class ChessBoard {

	private ChessPiece[][] board;
	
	public ChessBoard() {
		board = new ChessPiece[8][8];
	}
	
	public void initialize() {
		
	}
	
	//throws IllegalPositionException
	public ChessPiece getPiece(String position) {
		return null;
	}
	
	public boolean placePiece(ChessPiece piece, String position) {
		return false;
	}
	
	//throws IllegalMoveException
	public void move(String fromPosition, String toPosition) {
		
	}
	
	public String toString() {
		return null;
	}
	
	public static void main(String[] args) {
	    ChessBoard board = new ChessBoard();
	    board.initialize();
	    System.out.println(board);
	    board.move("c2", "c4");
	    System.out.println(board);
	}
	
}
