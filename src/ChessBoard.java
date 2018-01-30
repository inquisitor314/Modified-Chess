
public class ChessBoard {

	private ChessPiece[][] board;

	public ChessBoard() {
		board = new ChessPiece[8][8];
	}

	public void initialize() {
		placePiece(new Rook(this, Color.WHITE), "a1");
		placePiece(new Knight(this, Color.WHITE), "b1");
		placePiece(new Bishop(this, Color.WHITE), "c1");
		placePiece(new Queen(this, Color.WHITE), "d1");
		placePiece(new King(this, Color.WHITE), "e1");
		placePiece(new Bishop(this, Color.WHITE), "f1");
		placePiece(new Knight(this, Color.WHITE), "g1");
		placePiece(new Rook(this, Color.WHITE), "h1");	
		placePiece(new Pawn(this, Color.WHITE), "a2");
		placePiece(new Pawn(this, Color.WHITE), "b2");
		placePiece(new Pawn(this, Color.WHITE), "c2");
		placePiece(new Pawn(this, Color.WHITE), "d2");
		placePiece(new Pawn(this, Color.WHITE), "e2");
		placePiece(new Pawn(this, Color.WHITE), "f2");
		placePiece(new Pawn(this, Color.WHITE), "g2");
		placePiece(new Pawn(this, Color.WHITE), "h2");

		placePiece(new Rook(this, Color.BLACK), "a8");
		placePiece(new Knight(this, Color.BLACK), "b8");
		placePiece(new Bishop(this, Color.BLACK), "c8");
		placePiece(new Queen(this, Color.BLACK), "d8");
		placePiece(new King(this, Color.BLACK), "e8");
		placePiece(new Bishop(this, Color.BLACK), "f8");
		placePiece(new Knight(this, Color.BLACK), "g8");
		placePiece(new Rook(this, Color.BLACK), "h8");	
		placePiece(new Pawn(this, Color.BLACK), "a7");
		placePiece(new Pawn(this, Color.BLACK), "b7");
		placePiece(new Pawn(this, Color.BLACK), "c7");
		placePiece(new Pawn(this, Color.BLACK), "d7");
		placePiece(new Pawn(this, Color.BLACK), "e7");
		placePiece(new Pawn(this, Color.BLACK), "f7");
		placePiece(new Pawn(this, Color.BLACK), "g7");
		placePiece(new Pawn(this, Color.BLACK), "h7");
	}

	//throws IllegalPositionException
	public ChessPiece getPiece(String position) throws IllegalPositionException{
		int[] coordinates = coordinateTranslator(position);
		if(coordinates[0] == -1 || coordinates[1] == -1) {
			throw new IllegalPositionException("Error: invalid coordinates - " + position + ".");
		}
		else {
			return board[coordinates[0]][coordinates[1]];
		}
	}

	public boolean placePiece(ChessPiece piece, String position) {
		int[] coordinates = coordinateTranslator(position);
		if(coordinates[0] == -1 || coordinates[1] == -1) {
			System.out.println("Invalid coordinates");
			return false;
		}
		try {
			if(getPiece(position) == null) {
				//System.out.println("Empty space");
				board[coordinates[0]][coordinates[1]] = piece;
				return true;
			}
			else if(!getPiece(position).getColor().equals(piece.getColor())) {
				System.out.println("Taking piece");
				getPiece(position).setBoard(null);
				board[coordinates[0]][coordinates[1]] = piece;
				return true;
			}
			else {
				System.out.println("Same color piece, cannot move");
				return false;
			}
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	//throws IllegalMoveException
	public void move(String fromPosition, String toPosition) throws IllegalMoveException{
		int[] fromCoordinates = coordinateTranslator(fromPosition);
		int[] toCoordinates = coordinateTranslator(toPosition);
		if(fromCoordinates[0] == -1 || fromCoordinates[1] == -1) {
			throw new IllegalMoveException("Error: invalid source coordinates.");
		}
		if(toCoordinates[0] == -1 || toCoordinates[1] == -1) {
			throw new IllegalMoveException("Error: invalid destination coordinates.");
		}
		try {
			if(getPiece(fromPosition) == null) {
				throw new IllegalMoveException("Error: no piece to move.");
			}
			if(!placePiece(getPiece(fromPosition), toPosition)) {
				throw new IllegalMoveException("Error: bad move.");
			}
			else {
				board[fromCoordinates[0]][fromCoordinates[1]] = null;
				System.out.println("Piece moved successfully.");
			}
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
	}

	public ChessPiece[][] getBoard() {
		return board;
	}

	public boolean equals(Object other) {
		if(!(other instanceof ChessBoard)) {
			System.out.println("Not a board.");
			return false;
		}
		else {
			ChessBoard otherBoard = (ChessBoard) other;
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					//System.out.println(i + "," + j);
					//System.out.println(otherBoard.getBoard()[i][j] + "," + board[i][j]);
					if(otherBoard.getBoard()[i][j] == null && board[i][j] == null) {

					}
					else if(otherBoard.getBoard()[i][j] == null && board[i][j] != null) {
						System.out.println("Board doesn't match at " + i + "," + j);
						return false;
					}
					else if(otherBoard.getBoard()[i][j] != null && board[i][j] == null) {
						System.out.println("Board doesn't match at " + i + "," + j);
						return false;
					}
					else if(!otherBoard.getBoard()[i][j].equals(board[i][j])) {
						System.out.println("Board doesn't match at " + i + "," + j);
						return false;
					}
				}
			}
			return true;
		}
	}

	public int[] coordinateTranslator(String coordinate) {
		int[] finalCoordinates = new int[2];
		String[] pieces = coordinate.split("");
		if(pieces.length != 2) {
			finalCoordinates[0] = -1;
			finalCoordinates[1] = -1;
			return finalCoordinates;
		}
		switch(pieces[0]) {
		case "a":
			finalCoordinates[1] = 0;
			break;
		case "b":
			finalCoordinates[1] = 1;
			break;
		case "c":
			finalCoordinates[1] = 2;
			break;
		case "d":
			finalCoordinates[1] = 3;
			break;
		case "e":
			finalCoordinates[1] = 4;
			break;
		case "f":
			finalCoordinates[1] = 5;
			break;
		case "g":
			finalCoordinates[1] = 6;
			break;
		case "h":
			finalCoordinates[1] = 7;
			break;
		default:
			finalCoordinates[1] = -1;
			break;
		}
		try {
			finalCoordinates[0] = Integer.parseInt(pieces[1]) - 1;
		} catch(NumberFormatException e) {
			finalCoordinates[0] = -1;
		}
		return finalCoordinates;
	}

	public String toString(){
		String chess="";
		String upperLeft = "\u250C";
		String upperRight = "\u2510";
		String horizontalLine = "\u2500";
		String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
		String verticalLine = "\u2502";
		String upperT = "\u252C";
		String bottomLeft = "\u2514";
		String bottomRight = "\u2518";
		String bottomT = "\u2534";
		String plus = "\u253C";
		String leftT = "\u251C";
		String rightT = "\u2524";

		String topLine = upperLeft;
		for (int i = 0; i<7; i++){
			topLine += horizontal3 + upperT;
		}
		topLine += horizontal3 + upperRight;

		String bottomLine = bottomLeft;
		for (int i = 0; i<7; i++){
			bottomLine += horizontal3 + bottomT;
		}
		bottomLine += horizontal3 + bottomRight;
		chess+=topLine + "\n";

		for (int row = 7; row >=0; row--){
			String midLine = "";
			for (int col = 0; col < 8; col++){
				if(board[row][col]==null) {
					midLine += verticalLine + " \u3000 ";
				} else {midLine += verticalLine + " "+board[row][col]+" ";}
			}
			midLine += verticalLine;
			String midLine2 = leftT;
			for (int i = 0; i<7; i++){
				midLine2 += horizontal3 + plus;
			}
			midLine2 += horizontal3 + rightT;
			chess+=midLine+ "\n";
			if(row>=1)
				chess+=midLine2+ "\n";
		}

		chess+=bottomLine;
		return chess;
	}

	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();
		board.initialize();
		//		ChessBoard board2 = new ChessBoard();
		//		board2.initialize();
		//		try {
		//			System.out.println(board.getPiece("a2"));
		//		} catch (IllegalPositionException e) {
		//			System.out.println(e.getMessage());
		//		}
				try {
					board.move("c4", "a8");
				} catch (IllegalMoveException e) {
					System.out.println(e.getMessage());
				}
		//      Knight k = new Knight(board, Color.WHITE);
		//		board.placePiece(k, "d4");
		//		System.out.println(board.equals(board2));
		//		System.out.println(board);
		//		board.move("c2", "c4");
		//		int[] coordinates = board.coordinateTranslator("a5");
		//		System.out.println("coordinates: " + coordinates[0] + "," + coordinates[1]);
		System.out.println(board);
	}

}
