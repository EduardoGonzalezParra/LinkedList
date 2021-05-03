package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    //Given_When_Then
    @Test
    public void whenANewListIsCreated_ThenListIsEmpty(){
        //Given

        //When
        LinkedList<Integer> list = new LinkedList<>();
        //Then
        assertEquals(0, list.getSize());
    }
}
