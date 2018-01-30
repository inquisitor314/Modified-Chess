import java.util.ArrayList;

public class Pawn extends ChessPiece {

	public Pawn(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(color.equals(Color.WHITE)) {
			return "\u2659";
		}
		else if(color.equals(Color.BLACK)){
			return "\u265F";
		}
		else {
			return null;
		}
	}
	
	public boolean equals(Object other) {
		if(!(other instanceof Pawn)) {
			System.out.println("Not a piece.");
			return false;
		}
		else {
			Pawn otherPiece = (Pawn) other;
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
