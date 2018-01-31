import java.util.ArrayList;

public abstract class ChessPiece {
	
	protected ChessBoard board;
	protected int row;
	protected int column;
	protected Color color;

	
	public ChessPiece(ChessBoard board, Color color) {
		this.board = board;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	protected int[] coordinateTranslator(String coordinate) {
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
			if (finalCoordinates[0] < 0 || finalCoordinates[0] > 7) {
				finalCoordinates[0] = -1;
			}
		} catch(NumberFormatException e) {
			finalCoordinates[0] = -1;
		}
		return finalCoordinates;
	}
	
	//throws IllegalPositionException
	public void setPosition(String position) throws IllegalPositionException{
		int[] coordinates = coordinateTranslator(position);
		if(coordinates[0] == -1 || coordinates[1] == -1) {
			throw new IllegalPositionException("Error: bad coordinates.");
		}
		else {
			row = coordinates[0];
			column = coordinates[1];
			//System.out.println(row + "," + column);
		}
	}
	
	protected String findCoordinate(int rowVal, int columnVal) {
		String coordinate = "";
		switch(columnVal) {
		case 0:
			coordinate += "a";
			break;
		case 1:
			coordinate += "b";
			break;
		case 2:
			coordinate += "c";
			break;
		case 3:
			coordinate += "d";
			break;
		case 4:
			coordinate += "e";
			break;
		case 5:
			coordinate += "f";
			break;
		case 6:
			coordinate += "g";
			break;
		case 7:
			coordinate += "h";
			break;
		default:
			coordinate = "bad column";
			break;
		}
		if(rowVal <= 7 && rowVal >= 0) {
			coordinate += rowVal + 1;
		} 
		else {
			coordinate += "bad row";
		}
		return coordinate;
	}
	
	public String getPosition() {
		return findCoordinate(row, column);
	}
	
	public void setBoard(ChessBoard board) {
		this.board = board;
	}
	
	abstract public String toString();
	
	abstract public ArrayList<String> legalMoves();
	
}
