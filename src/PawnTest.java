import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class PawnTest {

	@Test
	public void testGetColorWhite() {
		Pawn p = new Pawn(null, Color.WHITE);
		assertEquals(p.getColor(), Color.WHITE);
	}

	@Test
	public void testGetColorBlack() {
		Pawn p = new Pawn(null, Color.BLACK);
		assertEquals(p.getColor(), Color.BLACK);
	}

	@Test
	public void testSetPosition() {
		Pawn p = new Pawn(null, null);
		try {
			p.setPosition("a1");
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(p.row, 0);
		assertEquals(p.column, 0);
	}

	@Test
	(expected = IllegalPositionException.class)
	public void testSetBadPosition() throws IllegalPositionException {
		Pawn p = new Pawn(null, null);
		p.setPosition("zeratul");
	}

	@Test
	public void testGetPosition() {
		Pawn p = new Pawn(null, null);
		try {
			p.setPosition("a1");
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		assertEquals(p.getPosition(), "a1");
	}
	@Test
	public void testBlackToString() {
		Pawn p = new Pawn(null, Color.BLACK);
		assertEquals(p.toString(), "\u265F");
	}

	@Test
	public void testWhiteToString() {
		Pawn p = new Pawn(null, Color.WHITE);
		assertEquals(p.toString(), "\u2659");
	}

	@Test
	public void testWhiteLegalMovesEmpty() {
		ChessBoard b = new ChessBoard();
		Pawn p = new Pawn(b, Color.WHITE);
		try {
			p.setPosition("a2");
			ArrayList <String> expectedMoves = new ArrayList<String>();
			expectedMoves.add("a3");
			expectedMoves.add("a4");
			ArrayList<String> actualMoves = p.legalMoves();
			Collections.sort(expectedMoves);
			Collections.sort(actualMoves);
			assertEquals(expectedMoves, actualMoves);
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBlackLegalMovesEmpty() {
		ChessBoard b = new ChessBoard();
		Pawn p = new Pawn(b, Color.BLACK);
		try {
			p.setPosition("a7");
			ArrayList <String> expectedMoves = new ArrayList<String>();
			expectedMoves.add("a6");
			expectedMoves.add("a5");
			ArrayList<String> actualMoves = p.legalMoves();
			Collections.sort(expectedMoves);
			Collections.sort(actualMoves);
			assertEquals(expectedMoves, actualMoves);
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testWhiteLegalMovesFriend() {
		ChessBoard b = new ChessBoard();
		Pawn p = new Pawn(b, Color.WHITE);
		Queen q = new Queen(b, Color.WHITE);
		b.placePiece(p, "a2");
		b.placePiece(q, "a4");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("a3");
		ArrayList<String> actualMoves = p.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}
	
	@Test
	public void testBlackLegalMovesFriend() {
		ChessBoard b = new ChessBoard();
		Pawn p = new Pawn(b, Color.BLACK);
		Queen q = new Queen(b, Color.BLACK);
		b.placePiece(p, "a7");
		b.placePiece(q, "a5");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("a6");
		ArrayList<String> actualMoves = p.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}
	
	@Test
	public void testWhiteLegalMovesEnemy() {
		ChessBoard b = new ChessBoard();
		Pawn p = new Pawn(b, Color.WHITE);
		Queen q = new Queen(b, Color.BLACK);
		b.placePiece(p, "a2");
		b.placePiece(q, "b3");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("a3");
		expectedMoves.add("a4");
		expectedMoves.add("b3");
		ArrayList<String> actualMoves = p.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}
	
	@Test
	public void testBlackLegalMovesEnemy() {
		ChessBoard b = new ChessBoard();
		Pawn p = new Pawn(b, Color.BLACK);
		Queen q = new Queen(b, Color.WHITE);
		b.placePiece(p, "a7");
		b.placePiece(q, "b6");
		ArrayList <String> expectedMoves = new ArrayList<String>();
		expectedMoves.add("a6");
		expectedMoves.add("a5");
		expectedMoves.add("b6");
		ArrayList<String> actualMoves = p.legalMoves();
		Collections.sort(expectedMoves);
		Collections.sort(actualMoves);
		assertEquals(expectedMoves, actualMoves);
	}

}
