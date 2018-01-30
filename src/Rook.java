import java.util.ArrayList;

public class Rook extends ChessPiece {

	public Rook(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(color.equals(Color.WHITE)) {
			return "\u2656";
		}
		else if(color.equals(Color.BLACK)){
			return "\u265C";
		}
		else {
			return null;
		}
	}

	public boolean equals(Object other) {
		if(!(other instanceof Rook)) {
			System.out.println("Not a piece.");
			return false;
		}
		else {
			Rook otherPiece = (Rook) other;
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
