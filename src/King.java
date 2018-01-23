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
		else {
			return "\u265A";
		}
	}

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		King wk = new King(null, Color.WHITE);
		King bk = new King(null, Color.BLACK);
		System.out.println(wk.toString());
		System.out.println(bk.toString());
	}
}
