package datastructure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomArrayListTest {
    
    @Test
    public void addTest() {
        CustomArrayList list = new CustomArrayList();
        list.addLast("a");
        list.addLast("b");
        list.addLast("d");
        list.add(2, "c");
        
        CustomArrayList list2 = new CustomArrayList();
        list2.addLast("a");
        list2.addLast("b");
        list2.addLast("c");
        list2.addLast("d");
        
        assertEquals(list, list2);
    }
    @Test
    public void removeTest() {
        CustomArrayList list = new CustomArrayList();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.remove(1);
        
        CustomArrayList list2 = new CustomArrayList();
        list2.addLast("a");
        list2.addLast("c");
        
        assertEquals(list, list2);
    }

}
