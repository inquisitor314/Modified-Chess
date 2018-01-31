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
		ArrayList<String> moves = new ArrayList<String>();
		if(color.equals(Color.WHITE)) {
			String upTwo = findCoordinate(row + 3, column);
			String upOne = findCoordinate(row + 2, column);
			String leftDiag = findCoordinate(row + 2, column - 1);
			String rightDiag = findCoordinate(row + 2, column + 1);
			System.out.println(upTwo + "," + upOne + "," + leftDiag + "," + rightDiag);
			try {
				if(!upTwo.contains("bad")) {
					if(row == 1 && board.getPiece(upTwo) == null) {
						System.out.println("adding upTwo");
						moves.add(upTwo);
					}
				}
				if(!upOne.contains("bad")) {
					if(board.getPiece(upOne) == null) {
						System.out.println("adding upOne");
						moves.add(upOne);
					}
				}
				if(!leftDiag.contains("bad")) {
					if(board.getPiece(leftDiag) != null && board.getPiece(leftDiag).getColor().equals(Color.BLACK)) {
						System.out.println("adding leftDiag");
						moves.add(leftDiag);
					}
				}
				if(!rightDiag.contains("bad")) {
					if(board.getPiece(rightDiag) != null && board.getPiece(rightDiag).getColor().equals(Color.BLACK)) {
						System.out.println("adding rightDiag");
						moves.add(rightDiag);
					}
				}
			} catch (IllegalPositionException e) {
				System.out.println(e.getMessage());
			}
		} else {
			String downTwo = findCoordinate(row - 2, column);
			String downOne = findCoordinate(row - 1, column);
			String leftDiag = findCoordinate(row - 1, column - 1);
			String rightDiag = findCoordinate(row - 1, column + 1);
			System.out.println(downTwo + "," + downOne + "," + leftDiag + "," + rightDiag);
			try {
				if(!downTwo.contains("bad")) {
					if(row == 6 && board.getPiece(downTwo) == null) {
						System.out.println("adding downTwo");
						moves.add(downTwo);
					}
				}
				if(!downOne.contains("bad")) {
					if(board.getPiece(downOne) == null) {
						System.out.println("adding downOne");
						moves.add(downOne);
					}
				}
				if(!leftDiag.contains("bad")) {
					if(board.getPiece(leftDiag) != null && board.getPiece(leftDiag).getColor().equals(Color.WHITE)) {
						System.out.println("adding leftDiag");
						moves.add(leftDiag);
					}
				}
				if(!rightDiag.contains("bad")) {
					if(board.getPiece(rightDiag) != null && board.getPiece(rightDiag).getColor().equals(Color.WHITE)) {
						System.out.println("adding rightDiag");
						moves.add(rightDiag);
					}
				}
			} catch (IllegalPositionException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Legal Moves:");
		for(String s : moves) {
			System.out.println(s);
		}
		return moves;
	}

	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();
		board.initialize();
		try {
			board.getPiece("a2").legalMoves();
		} catch (IllegalPositionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
