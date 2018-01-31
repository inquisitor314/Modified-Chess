import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class BishopTest {

	@Test
	public void testGetColorWhite() {
		Bishop b = new Bishop(null, Color.WHITE);
		assertEquals(b.getColor(), Color.WHITE);
	}

	@Test
	public void testGetColorBlack() {
		Bishop b = new Bishop(null, Color.BLACK);
		assertEquals(b.getColor(), Color.BLACK);
	}

	@Test
	public void testSetPosition() {
		Bishop b = new Bishop(null, null);
		try {
			b.setPosition("a1");
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(b.row, 0);
		assertEquals(b.column, 0);
	}

	@Test
	(expected = IllegalPositionException.class)
	public void testSetBadPosition() throws IllegalPositionException {
		Bishop b = new Bishop(null, null);
		b.setPosition("zeratul");
	}

	@Test
	public void testGetPosition() {
		Bishop b = new Bishop(null, null);
		try {
			b.setPosition("a1");
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		assertEquals(b.getPosition(), "a1");
	}
	@Test
	public void testBlackToString() {
		Bishop b = new Bishop(null, Color.BLACK);
		assertEquals(b.toString(), "\u265D");
	}

	@Test
	public void testWhiteToString() {
		Bishop b = new Bishop(null, Color.WHITE);
		assertEquals(b.toString(), "\u2657");
	}

	@Test
	public void testLegalMovesEmpty() {
		ChessBoard board = new ChessBoard();
		Bishop b = new Bishop(board, Color.WHITE);
		try {
			b.setPosition("b2");
			ArrayList <String> expectedMoves = new ArrayList<String>();
			expectedMoves.add("a1");
			
			expectedMoves.add("c1");
			
			expectedMoves.add("c3");
			expectedMoves.add("d4");
			expectedMoves.add("e5");
			expectedMoves.add("f6");
			expectedMoves.add("g7");
			expectedMoves.add("h8");
			
			expectedMoves.add("a3");
			ArrayList<String> actualMoves = b.legalMoves();
			Collections.sort(expectedMoves);
			Collections.sort(actualMoves);
			assertEquals(expectedMoves, actualMoves);
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testLegalMovesFriend() {
		ChessBoard board = new ChessBoard();
		Bishop b = new Bishop(board, Color.WHITE);
		Queen q = new Queen(board, Color.WHITE);
		board.placePiece(b, "b2");
		board.placePiece(q, "e5");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("a1");
		
		expectedMoves.add("c1");
		
		expectedMoves.add("c3");
		expectedMoves.add("d4");
		
		expectedMoves.add("a3");
		ArrayList<String> actualMoves = b.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}
	
	@Test
	public void testLegalMovesEnemy() {
		ChessBoard board = new ChessBoard();
		Bishop b = new Bishop(board, Color.WHITE);
		Queen q = new Queen(board, Color.BLACK);
		board.placePiece(b, "b2");
		board.placePiece(q, "e5");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("a1");
		
		expectedMoves.add("c1");
		
		expectedMoves.add("c3");
		expectedMoves.add("d4");
		expectedMoves.add("e5");
		
		expectedMoves.add("a3");
		ArrayList<String> actualMoves = b.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}

}
