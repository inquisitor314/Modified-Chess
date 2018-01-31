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
		ArrayList<String> moves = new ArrayList<String>();
		try {
			for(int i = 1; i < 8; i++) {
				String upLeftToAdd = findCoordinate(row + i, column - i);
				if(!upLeftToAdd.contains("bad")) {
					if(board.getPiece(upLeftToAdd) == null) {
						System.out.println("Adding empty space at " + upLeftToAdd);
						moves.add(upLeftToAdd);
					}
					else if(board.getPiece(upLeftToAdd).getColor().equals(getColor())) {
						break;
					}
					else if(!board.getPiece(upLeftToAdd).getColor().equals(getColor())) {
						System.out.println("Adding enemy space at " + upLeftToAdd);
						moves.add(upLeftToAdd);
						break;
					}
				}
			}
			for(int i = 1; i < 8; i++) {
				String downLeftToAdd = findCoordinate(row - i, column - i);
				if(!downLeftToAdd.contains("bad")) {
					if(board.getPiece(downLeftToAdd) == null) {
						System.out.println("Adding empty space at " + downLeftToAdd);
						moves.add(downLeftToAdd);
					}
					else if(board.getPiece(downLeftToAdd).getColor().equals(getColor())) {
						break;
					}
					else if(!board.getPiece(downLeftToAdd).getColor().equals(getColor())) {
						System.out.println("Adding enemy space at " + downLeftToAdd);
						moves.add(downLeftToAdd);
						break;
					}
				}
			}
			for(int i = 1; i < 8; i++) {
				String upRightToAdd = findCoordinate(row + i, column + i);
				if(!upRightToAdd.contains("bad")) {
					if(board.getPiece(upRightToAdd) == null) {
						System.out.println("Adding empty space at " + upRightToAdd);
						moves.add(upRightToAdd);
					}
					else if(board.getPiece(upRightToAdd).getColor().equals(getColor())) {
						break;
					}
					else if(!board.getPiece(upRightToAdd).getColor().equals(getColor())) {
						System.out.println("Adding enemy space at " + upRightToAdd);
						moves.add(upRightToAdd);
						break;
					}
				}
			}
			for(int i = 1; i < 8; i++) {
				String downRightToAdd = findCoordinate(row - i, column + i);
				if(!downRightToAdd.contains("bad")) {
					if(board.getPiece(downRightToAdd) == null) {
						System.out.println("Adding empty space at " + downRightToAdd);
						moves.add(downRightToAdd);
					}
					else if(board.getPiece(downRightToAdd).getColor().equals(getColor())) {
						break;
					}
					else if(!board.getPiece(downRightToAdd).getColor().equals(getColor())) {
						System.out.println("Adding enemy space at " + downRightToAdd);
						moves.add(downRightToAdd);
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
