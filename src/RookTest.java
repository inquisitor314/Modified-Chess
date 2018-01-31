import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class RookTest {

	@Test
	public void testGetColorWhite() {
		Rook r = new Rook(null, Color.WHITE);
		assertEquals(r.getColor(), Color.WHITE);
	}

	@Test
	public void testGetColorBlack() {
		Rook r = new Rook(null, Color.BLACK);
		assertEquals(r.getColor(), Color.BLACK);
	}

	@Test
	public void testSetPosition() {
		Rook r = new Rook(null, null);
		try {
			r.setPosition("a1");
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(r.row, 0);
		assertEquals(r.column, 0);
	}

	@Test
	(expected = IllegalPositionException.class)
	public void testSetBadPosition() throws IllegalPositionException {
		Rook r = new Rook(null, null);
		r.setPosition("zeratul");
	}

	@Test
	public void testGetPosition() {
		Rook r = new Rook(null, null);
		try {
			r.setPosition("a1");
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		assertEquals(r.getPosition(), "a1");
	}
	@Test
	public void testBlackToString() {
		Rook r = new Rook(null, Color.BLACK);
		assertEquals(r.toString(), "\u265C");
	}

	@Test
	public void testWhiteToString() {
		Rook r = new Rook(null, Color.WHITE);
		assertEquals(r.toString(), "\u2656");
	}

	@Test
	public void testLegalMovesEmpty() {
		ChessBoard b = new ChessBoard();
		Rook r = new Rook(b, Color.WHITE);
		try {
			r.setPosition("b2");
			ArrayList <String> expectedMoves = new ArrayList<String>();
			expectedMoves.add("b1");
			expectedMoves.add("b3");
			expectedMoves.add("b4");
			expectedMoves.add("b5");
			expectedMoves.add("b6");
			expectedMoves.add("b7");
			expectedMoves.add("b8");
			expectedMoves.add("a2");
			expectedMoves.add("c2");
			expectedMoves.add("d2");
			expectedMoves.add("e2");
			expectedMoves.add("f2");
			expectedMoves.add("g2");
			expectedMoves.add("h2");
			ArrayList<String> actualMoves = r.legalMoves();
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
		Rook r = new Rook(b, Color.WHITE);
		Queen q = new Queen(b, Color.WHITE);
		b.placePiece(r, "b2");
		b.placePiece(q, "b6");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("b1");
		expectedMoves.add("b3");
		expectedMoves.add("b4");
		expectedMoves.add("b5");

		expectedMoves.add("a2");
		expectedMoves.add("c2");
		expectedMoves.add("d2");
		expectedMoves.add("e2");
		expectedMoves.add("f2");
		expectedMoves.add("g2");
		expectedMoves.add("h2");
		ArrayList<String> actualMoves = r.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}
	
	@Test
	public void testLegalMovesEnemy() {
		ChessBoard b = new ChessBoard();
		Rook r = new Rook(b, Color.WHITE);
		Queen q = new Queen(b, Color.BLACK);
		b.placePiece(r, "b2");
		b.placePiece(q, "b6");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("b1");
		expectedMoves.add("b3");
		expectedMoves.add("b4");
		expectedMoves.add("b5");
		expectedMoves.add("b6");

		expectedMoves.add("a2");
		expectedMoves.add("c2");
		expectedMoves.add("d2");
		expectedMoves.add("e2");
		expectedMoves.add("f2");
		expectedMoves.add("g2");
		expectedMoves.add("h2");

		ArrayList<String> actualMoves = r.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}

}
