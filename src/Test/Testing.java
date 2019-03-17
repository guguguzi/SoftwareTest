package Test;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Triangle.Triangle;

@RunWith(Parameterized.class)
public class Testing {
	Triangle triangle = null;
	int x;
	Boolean tof;
	public Testing(int x, Boolean tof){
		this.x = x;
		this.tof = tof;
	}
	
	@Before
	public void setUp() throws Exception {
		triangle = new Triangle();
	}
	
	@Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {0, true},
                {83, true},
                {79,false},
                {-1, false},
                {100, false},
                {9, false},
                {63, true}
        });
    }


	@Test
	public void testCaculate() {
		assertEquals(this.tof, triangle.caculate(x));
	}

}
