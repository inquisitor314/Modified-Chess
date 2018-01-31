import static org.junit.Assert.*;
import org.junit.Test;

public class QueenTest {

	@Test
	public void testGetColorWhite() {
		Queen q = new Queen(null, Color.WHITE);
		assertEquals(q.getColor(), Color.WHITE);
	}

	@Test
	public void testGetColorBlack() {
		Queen q = new Queen(null, Color.BLACK);
		assertEquals(q.getColor(), Color.BLACK);
	}

	@Test
	public void testSetPosition() {
		Queen q = new Queen(null, null);
		try {
			q.setPosition("a1");
		} catch (IllegalPositionException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(q.row, 0);
		assertEquals(q.column, 0);
	}

	@Test
	(expected = IllegalPositionException.class)
	public void testSetBadPosition() throws IllegalPositionException {
		Queen q = new Queen(null, null);
		q.setPosition("zeratul");
	}

	@Test
	public void testGetPosition() {
		Queen q = new Queen(null, null);
		try {
			q.setPosition("a1");
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		assertEquals(q.getPosition(), "a1");
	}
	@Test
	public void testBlackToString() {
		Queen q = new Queen(null, Color.BLACK);
		assertEquals(q.toString(), "\u265B");
	}

	@Test
	public void testWhiteToString() {
		Queen q = new Queen(null, Color.WHITE);
		assertEquals(q.toString(), "\u2655");
	}
	
	@Test
	public void testLegalMoves() {
		Queen q = new Queen(null, null);
		assertEquals(q.legalMoves().size(), 0);
	}

}
