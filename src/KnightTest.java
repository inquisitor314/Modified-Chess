import static org.junit.Assert.*;
import org.junit.Test;

public class KnightTest {

	@Test
	public void testGetColorWhite() {
		Knight k = new Knight(null, Color.WHITE);
		assertEquals(k.getColor(), Color.WHITE);
	}

	@Test
	public void testGetColorBlack() {
		Knight k = new Knight(null, Color.BLACK);
		assertEquals(k.getColor(), Color.BLACK);
	}

	@Test
	public void testSetPosition() {
		Knight k = new Knight(null, null);
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
		Knight k = new Knight(null, null);
		k.setPosition("zeratul");
	}

	@Test
	public void testGetPosition() {
		Knight k = new Knight(null, null);
		try {
			k.setPosition("a1");
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
		assertEquals(k.getPosition(), "a1");
	}
	
	@Test
	public void testBlackToString() {
		Knight k = new Knight(null, Color.BLACK);
		assertEquals(k.toString(), "\u265E");
	}

	@Test
	public void testWhiteToString() {
		Knight k = new Knight(null, Color.WHITE);
		assertEquals(k.toString(), "\u2658");
	}
	
	@Test
	public void testLegalMoves() {
		Knight k = new Knight(null, null);
		assertEquals(k.legalMoves().size(), 0);
	}

}
