import java.util.ArrayList;

public class Bishop extends ChessPiece {

	public Bishop(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(color.equals(Color.WHITE)) {
			return "\u2657";
		}
		else if(color.equals(Color.BLACK)){
			return "\u265D";
		}
		else {
			return null;
		}
	}
	
	public boolean equals(Object other) {
		if(!(other instanceof Bishop)) {
			System.out.println("Not a piece.");
			return false;
		}
		else {
			Bishop otherPiece = (Bishop) other;
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
