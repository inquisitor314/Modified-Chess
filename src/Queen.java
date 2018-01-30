import java.util.ArrayList;

public class Queen extends ChessPiece {

	public Queen(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(color.equals(Color.WHITE)) {
			return "\u2655";
		}
		else if(color.equals(Color.BLACK)){
			return "\u265B";
		}
		else {
			return null;
		}
	}

	public boolean equals(Object other) {
		if(!(other instanceof Queen)) {
			System.out.println("Not a piece.");
			return false;
		}
		else {
			Queen otherPiece = (Queen) other;
			if(otherPiece.toString().equals(this.toString())) {
				return true;
			}
			return false;
		}
	}
	
	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
