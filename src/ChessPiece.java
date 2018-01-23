import java.util.ArrayList;

public abstract class ChessPiece {
	
	protected ChessBoard board;
	protected int row;
	protected int column;
	protected Color color;

	
	public ChessPiece(ChessBoard board, Color color) {
		this.board = board;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getPosition() {
		return null;
	}
	
	//throws IllegalPositionException
	public void setPosition(String position) {
		
	}
	
	abstract public String toString();
	
	abstract public ArrayList<String> legalMoves();
	
}
