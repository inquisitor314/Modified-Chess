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
		ArrayList<String> moves = new ArrayList<String>();
		try {
			for(int i = 1; i < 8; i++) {
				String upToAdd = findCoordinate(row + i, column);
				if(!upToAdd.contains("bad")) {
					if(board.getPiece(upToAdd) == null) {
						System.out.println("Adding empty space at " + upToAdd);
						moves.add(upToAdd);
					}
					else if(board.getPiece(upToAdd).getColor().equals(getColor())) {
						break;
					}
					else if(!board.getPiece(upToAdd).getColor().equals(getColor())) {
						System.out.println("Adding enemy space at " + upToAdd);
						moves.add(upToAdd);
						break;
					}
				}
			}
			for(int i = 1; i < 8; i++) {
				String downToAdd = findCoordinate(row - i, column);
				if(!downToAdd.contains("bad")) {
					if(board.getPiece(downToAdd) == null) {
						System.out.println("Adding empty space at " + downToAdd);
						moves.add(downToAdd);
					}
					else if(board.getPiece(downToAdd).getColor().equals(getColor())) {
						break;
					}
					else if(!board.getPiece(downToAdd).getColor().equals(getColor())) {
						System.out.println("Adding enemy space at " + downToAdd);
						moves.add(downToAdd);
						break;
					}
				}
			}
			for(int i = 1; i < 8; i++) {
				String leftToAdd = findCoordinate(row, column - i);
				if(!leftToAdd.contains("bad")) {
					if(board.getPiece(leftToAdd) == null) {
						System.out.println("Adding empty space at " + leftToAdd);
						moves.add(leftToAdd);
					}
					else if(board.getPiece(leftToAdd).getColor().equals(getColor())) {
						break;
					}
					else if(!board.getPiece(leftToAdd).getColor().equals(getColor())) {
						System.out.println("Adding enemy space at " + leftToAdd);
						moves.add(leftToAdd);
						break;
					}
				}
			}
			for(int i = 1; i < 8; i++) {
				String rightToAdd = findCoordinate(row, column + i);
				if(!rightToAdd.contains("bad")) {
					if(board.getPiece(rightToAdd) == null) {
						System.out.println("Adding empty space at " + rightToAdd);
						moves.add(rightToAdd);
					}
					else if(board.getPiece(rightToAdd).getColor().equals(getColor())) {
						break;
					}
					else if(!board.getPiece(rightToAdd).getColor().equals(getColor())) {
						System.out.println("Adding enemy space at " + rightToAdd);
						moves.add(rightToAdd);
						break;
					}
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

}
