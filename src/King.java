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
		ArrayList<String> moves = new ArrayList<String>();
		String upOne = findCoordinate(row + 1, column);
		String leftUpDiag = findCoordinate(row + 1, column - 1);
		String rightUpDiag = findCoordinate(row + 1, column + 1);
		String downOne = findCoordinate(row - 1, column);
		String leftDownDiag = findCoordinate(row - 1, column - 1);
		String rightDownDiag = findCoordinate(row - 1, column + 1);
		String leftOne = findCoordinate(row, column - 1);
		String rightOne = findCoordinate(row, column + 1);
		try {
			if(!upOne.contains("bad")) {
				if(board.getPiece(upOne) == null || !board.getPiece(upOne).getColor().equals(getColor())) {
					System.out.println("adding upOne");
					moves.add(upOne);
				}
			}
			if(!leftUpDiag.contains("bad")) {
				if(board.getPiece(leftUpDiag) == null || !board.getPiece(leftUpDiag).getColor().equals(getColor())) {
					System.out.println("adding leftUpDiag");
					moves.add(leftUpDiag);
				}
			}
			if(!rightUpDiag.contains("bad")) {
				if(board.getPiece(rightUpDiag) == null || !board.getPiece(rightUpDiag).getColor().equals(getColor())) {
					System.out.println("adding rightUpDiag");
					moves.add(rightUpDiag);
				}
			}
			if(!downOne.contains("bad")) {
				if(board.getPiece(downOne) == null || !board.getPiece(downOne).getColor().equals(getColor())) {
					System.out.println("adding downOne");
					moves.add(downOne);
				}
			}
			if(!leftDownDiag.contains("bad")) {
				if(board.getPiece(leftDownDiag) == null || !board.getPiece(leftDownDiag).getColor().equals(getColor())) {
					System.out.println("adding leftDownDiag");
					moves.add(leftDownDiag);
				}
			}
			if(!rightDownDiag.contains("bad")) {
				if(board.getPiece(rightDownDiag) == null || !board.getPiece(rightDownDiag).getColor().equals(getColor())) {
					System.out.println("adding rightDownDiag");
					moves.add(rightDownDiag);
				}
			}
			if(!leftOne.contains("bad")) {
				if(board.getPiece(leftOne) == null || !board.getPiece(leftOne).getColor().equals(getColor())) {
					System.out.println("adding leftOne");
					moves.add(leftOne);
				}
			}
			if(!rightOne.contains("bad")) {
				if(board.getPiece(rightOne) == null || !board.getPiece(rightOne).getColor().equals(getColor())) {
					System.out.println("adding rightOne");
					moves.add(rightOne);
				}
			}
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Legal Moves:");
		for(String s : moves) {
			System.out.println(s);
		}
		return moves;
	}

	public static void main(String[] args) {
		Knight k = new Knight(null, Color.BLACK);
		try {
			k.setPosition("a1");
			k.setPosition("a4");
			//k.setPosition("a9");
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(k.getPosition());

	}
}
