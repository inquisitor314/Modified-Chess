import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;

@RunWith(Suite.class)
@SuiteClasses({ BishopTest.class, ChessBoardTest.class, ChessPieceTest.class, KingTest.class, KnightTest.class,
		PawnTest.class, QueenTest.class, RookTest.class })
public class ChessSuite {

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(ChessSuite.class);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
