import java.util.ArrayList;

public class King extends ChessPiece {

	public King(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(color.equals(Color.WHITE)) {
			return "\u2654";
		}
		else if(color.equals(Color.BLACK)){
			return "\u265A";
		}
		else {
			return null;
		}
	}

	public boolean equals(Object other) {
		if(!(other instanceof King)) {
			System.out.println("Not a piece.");
			return false;
		}
		else {
			King otherPiece = (King) other;
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
