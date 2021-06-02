import lab4.linkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTest {

    List<Integer> testData;

    @Before
    public void init() {
        testData = Arrays.asList(600, 1200, 1500, 2100);
    }

    @Test
    public void testPushPop() {
        linkedList<Integer> stack = new linkedList<>();
        stack.addElement(1200);
        stack.addElement(1500);
        assertEquals("1500, 1200, ", stack.toString());
        assertEquals(1500, (int) stack.deleteElement());
        assertEquals("1200, ", stack.toString());
    }

    @Test
    public void testPopIsEmpty() {
        linkedList<Integer> stack = new linkedList<>();
        assertTrue(stack.isEmpty());
        for (Integer value : testData) {
            stack.addElement(value);
        }
        assertFalse(stack.isEmpty());
        for (int i = testData.size(); i > 0; --i) {
            assertEquals(testData.get(i - 1), stack.deleteElement());
        }
    }

    @Test
    public void testPushIsEmpty() {
        linkedList<Integer> stack = new linkedList<>();
        assertTrue(stack.isEmpty());
        for (Integer value : testData) {
            stack.addElement(value);
        }
        assertFalse(stack.isEmpty());
    }
}
