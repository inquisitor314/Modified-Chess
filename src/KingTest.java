import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class KingTest {

	@Test
	public void testGetColorWhite() {
		King k = new King(null, Color.WHITE);
		assertEquals(k.getColor(), Color.WHITE);
	}

	@Test
	public void testGetColorBlack() {
		King k = new King(null, Color.BLACK);
		assertEquals(k.getColor(), Color.BLACK);
	}

	@Test
	public void testSetPosition() {
		King k = new King(null, null);
		try {
			k.setPosition("a1");
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(k.row, 0);
		assertEquals(k.column, 0);
	}

	@Test
	(expected = IllegalPositionException.class)
	public void testSetBadPosition() throws IllegalPositionException {
		King k = new King(null, null);
		k.setPosition("zeratul");
	}

	@Test
	public void testGetPosition() {
		King k = new King(null, null);
		try {
			k.setPosition("a1");
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		assertEquals(k.getPosition(), "a1");
	}
	@Test
	public void testBlackToString() {
		King k = new King(null, Color.BLACK);
		assertEquals(k.toString(), "\u265A");
	}

	@Test
	public void testWhiteToString() {
		King k = new King(null, Color.WHITE);
		assertEquals(k.toString(), "\u2654");
	}

	@Test
	public void testLegalMovesEmpty() {
		ChessBoard b = new ChessBoard();
		King k = new King(b, null);
		try {
			k.setPosition("a1");
			ArrayList <String> expectedMoves = new ArrayList<String>();
			expectedMoves.add("a2");
			expectedMoves.add("b2");
			expectedMoves.add("b1");
			ArrayList<String> actualMoves = k.legalMoves();
			Collections.sort(expectedMoves);
			Collections.sort(actualMoves);
			assertEquals(expectedMoves, actualMoves);
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testLegalMovesFriend() {
		ChessBoard b = new ChessBoard();
		King k = new King(b, Color.BLACK);
		Queen q = new Queen(b, Color.BLACK);
		b.placePiece(k, "a1");
		b.placePiece(q, "a2");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("b2");
		expectedMoves.add("b1");
		ArrayList<String> actualMoves = k.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}
	
	@Test
	public void testLegalMovesEnemy() {
		ChessBoard b = new ChessBoard();
		King k = new King(b, Color.BLACK);
		Queen q = new Queen(b, Color.WHITE);
		b.placePiece(k, "a1");
		b.placePiece(q, "a2");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("b2");
		expectedMoves.add("b1");
		expectedMoves.add("a2");
		ArrayList<String> actualMoves = k.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}

}
