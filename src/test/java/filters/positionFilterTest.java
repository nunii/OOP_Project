package test.java.filters;

import static org.junit.Assert.*;
import org.junit.Test;

import main.java.data_classes.Position;
import main.java.filters.positionFilter;



public class positionFilterTest {

	@Test
	public void testTest() {
		Position p1 = new Position("32.00828529","34.81321819","48");
		Position p2 = new Position(p1);
		double r = 3569.545;
		positionFilter pf = new positionFilter(p1,r);
		if(!pf.test(p2))
			fail("Test method of positionFilter wrong");
	}

}
