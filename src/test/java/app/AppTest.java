package app;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest 
{
    @Test
    public void testConcreteUser() {
        Service service = new Service();
        assertEquals("1 Victor Sokolov", service.getConcreteUser(1));
    }

    @Test
    public void testListOfAccounts() {
        Service service = new Service();
        List<String> listFromDB = service.getListOfAccounts();

        List<String> expectedList = new ArrayList<String>();
        expectedList.add("1 500 1");
        expectedList.add("2 1500 2");
        expectedList.add("3 300 3");
        expectedList.add("4 700 4");
        expectedList.add("5 690 5");
        expectedList.add("6 1230 6");
        expectedList.add("7 999 7");
        expectedList.add("8 435 8");
        expectedList.add("9 5000 9");
        expectedList.add("10 2635 10");

        assertEquals(expectedList,listFromDB);
    }
}
