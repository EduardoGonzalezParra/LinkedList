package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void whenANewListIsCreated_thenListIsEmpty(){
        //Given

        //When
        ArrayList<Integer> list = new ArrayList<>();
        //Then
        assertEquals(0, list.getSize());
    }

    @Test
    public void givenANewArray_whenAddElement_thenListSizeIsOne(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        //When
        list.add(1);
        
        //Then
        assertEquals(1, list.getSize());
        assertEquals(1, list.get(0));
    }

    @Test
    public void givenAnExistentArrayWith1Element_whenAddElement_thenListSizeIsTwo(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        //When
        list.add(4);

        //Then
        assertEquals(2, list.getSize(), "Tamaño no es 2");

        assertEquals(1, list.get(0));
        assertEquals(4, list.get(1));
    }

    @Test
    public void givenAnExistentArrayWithoutCapacity_whenAddElement_thenSizeAndCapacityIncrements(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(5);

        //When
        list.add(4);

        //Then
        assertEquals(3, list.getSize(), "Tamaño no es 2");

        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(4, list.get(2));
    }

    @Test
    public void givenAListWith3Elements_whenIterator_thenAllElementsAreAccesible(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(5);
        list.add(4);

        //When
        Iterator<Integer> it = list.getIterator();

        //Then
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(5, it.next());
        assertTrue(it.hasNext());
        assertEquals(4, it.next());

        assertFalse(it.hasNext());
    }

    @Test
    public void givenAListWith3Elements_whenReverseIterator_thenAllElementsAreAccesible(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(5);
        list.add(4);

        //When
        Iterator<Integer> it = list.getReverseIterator();

        //Then
        assertTrue(it.hasNext());
        assertEquals(4, it.next());
        assertTrue(it.hasNext());
        assertEquals(5, it.next());
        assertTrue(it.hasNext());
        assertEquals(1, it.next());

        assertFalse(it.hasNext());
    }

    @Test
    public void givenAnExistentArrayWith2Elements_whenDeleteElementHead_thenSizeDecrements() {
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(5);

        //When
        list.delete(0);

        //Then
        assertEquals(1, list.getSize());

        assertEquals(5, list.get(0));
    }

    @Test
    public void givenAnExistentArrayWith5Elements_whenDeleteElementInTheMiddle_thenSizeDecrements(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        //When
        list.delete(2);

        //Then
        assertEquals(4, list.getSize());

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(40, list.get(2));
        assertEquals(50, list.get(3));
    }

    @Test
    public void givenAnExistentArrayWith5Elements_whenDeleteElementTail_thenSizeDecrements() {
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        //When
        list.delete(4);

        //Then
        assertEquals(4, list.getSize());

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
    }

    @Test
    public void givenAnExistentArrayWith5Elements_whenDeleteElementAtIndexOutOfBound_thenIndexOutOfBoundExceptionIsThrown(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        //Then Ejecución/Validación
        assertThrows(MyIndexOutOfBoundException.class, ()-> {
           list.delete(5);
        });

        assertEquals(5, list.getSize());

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
        assertEquals(50, list.get(4));
    }

}
