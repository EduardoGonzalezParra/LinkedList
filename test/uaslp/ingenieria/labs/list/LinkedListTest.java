package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    //Given_When_Then
    @Test
    public void whenANewListIsCreated_ThenListIsEmpty(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();

        //When
        int size = list.getSize();

        //Then
        assertEquals(size, 0);
    }

    @Test
    public void givenANewList_whenAddElement_thenListSizeIsOne(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();

        //When
        list.add(1);

        //Then
        assertEquals(1, list.getSize());
        assertEquals(1, list.get(0));
    }

    @Test
    public void givenAnExistentListWith1Element_whenAddElement_thenListSizeIsTwo(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        //When
        list.add(4);

        //Then
        assertEquals(2, list.getSize(), "Tamaño no es 2");

        assertEquals(1, list.get(0));
        assertEquals(4, list.get(1));
    }

    @Test
    public void givenAListWith3Elements_whenIterator_thenAllElementsAreAccesible(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();

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
        LinkedList<Integer> list = new LinkedList<>();

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
    public void givenAnEmptyList_WhenDelete_thenThrowException(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();

        //When
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.delete(0));
    }

    @Test
    public void givenAnExistentListWith4Elements_whenDeleteElementHead_thenSizeDecrements(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //When
        list.delete(0);

        //Then
        assertEquals(3, list.getSize());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
    }

    @Test
    public void givenAnExistentListWith5Elements_whenDeleteElementInTheMiddle_thenSizeDecrements(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();

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
    public void givenAnExistentListWith5Elements_whenDeleteElementTail_thenSizeDecrements(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();

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
    public void givenAnExistentListWith5Elements_whenDeleteElementAtIndexOutOfBound_thenIndexOutOfBoundExceptionIsThrown(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        //Then Ejecución/Validación
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            list.delete(5);
        });

        assertEquals(5, list.getSize());

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
        assertEquals(50, list.get(4));
    }

    @Test
    public void givenAListWithOneElement_whenInsertElementAfter_thenListSizeIs2(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        Iterator<Integer> it = list.getIterator();

        //When
        list.insert(5, Position.AFTER, it);

        //Then
        assertEquals(2, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
    }

    @Test
    public void givenAListWithTwoElement_whenInsertElementAfterBetween_thenListSizeIs3(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.getIterator();

        //When
        list.insert(5, Position.AFTER, it);

        //Then
        assertEquals(3, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    public void givenAListWithOneElement_whenInsertElementBefore_thenListSizeIs2(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        Iterator<Integer> it = list.getIterator();

        //When
        list.insert(5, Position.BEFORE, it);

        //Then
        assertEquals(2, list.getSize());
        assertEquals(1, list.get(1));
        assertEquals(5, list.get(0));
    }

    @Test
    public void givenAListWithTwoElement_whenInsertElementBeforeBetween_thenListSizeIs3(){
        //Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.getIterator();
        it.next();

        //When
        list.insert(5, Position.BEFORE, it);

        //Then
        assertEquals(3, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(2, list.get(2));
    }
}
