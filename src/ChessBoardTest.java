import static org.junit.Assert.*;

import org.junit.Test;

public class ChessBoardTest {

	@Test
	(expected = IllegalPositionException.class)
	public void testGetPieceBad() throws IllegalPositionException {
		ChessBoard b = new ChessBoard();
		b.initialize();
		b.getPiece("zeratul");
	}

	@Test
	public void testPlacePieceEmpty() {
		ChessBoard b = new ChessBoard();
		b.initialize();
		Queen q = new Queen(b, Color.BLACK);
		assertTrue(b.placePiece(q, "c4"));
	}
	
	@Test
	public void testPlacePieceBad() {
		ChessBoard b = new ChessBoard();
		b.initialize();
		Queen q = new Queen(b, Color.BLACK);
		assertFalse(b.placePiece(q, "zeratul"));
	}
	
	@Test
	public void testPlacePieceEnemy() {
		ChessBoard b = new ChessBoard();
		b.initialize();
		Queen q = new Queen(b, Color.BLACK);
		assertTrue(b.placePiece(q, "a1"));
	}

	@Test
	public void testPlacePieceFriend() {
		ChessBoard b = new ChessBoard();
		b.initialize();
		Queen q = new Queen(b, Color.BLACK);
		assertFalse(b.placePiece(q, "a8"));
	}
	
	@Test
	(expected = IllegalMoveException.class)
	public void testMoveBad() throws IllegalMoveException {
		ChessBoard b = new ChessBoard();
		b.initialize();
		b.move("zeratul", "kerrigan");
	}

}
