import java.util.ArrayList;

public class Knight extends ChessPiece {

	public Knight(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(color.equals(Color.WHITE)) {
			return "\u2658";
		}
		else if(color.equals(Color.BLACK)){
			return "\u265E";
		}
		else {
			return null;
		}
	}

	public boolean equals(Object other) {
		if(!(other instanceof Knight)) {
			System.out.println("Not a piece.");
			return false;
		}
		else {
			Knight otherPiece = (Knight) other;
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
