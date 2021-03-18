package uaslp.ingenieria.labs;

import uaslp.ingenieria.labs.list.LinkedList;
import uaslp.ingenieria.labs.list.Position;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Float> list2 = new LinkedList<>();
        LinkedList<Character> list3 = new LinkedList<>();
        LinkedList<String> list4 = new LinkedList<>();

        list.add(1);
        list.add(4);
        list.add(3);
        list.add(7);

        list2.add(1.4f);
        list2.add(5.74f);
        list2.add(9.324f);
        list2.add(0.4565f);

        list3.add('1');
        list3.add('A');
        list3.add('g');
        list3.add('+');

        list4.add("Programación");
        list4.add("Orientada");
        list4.add("A...");
        list4.add("Objetos");

        LinkedList<Integer>.Iterator it = list.getIterator();
        LinkedList<Integer>.ReverseIterator it2 = list.getReverseIterator();
        LinkedList<Float>.Iterator itFloat = list2.getIterator();
        LinkedList<Character>.Iterator itChar = list3.getIterator();
        LinkedList<String>.Iterator itString = list4.getIterator();

        System.out.println("El tamaño de la lista es: " + list.getSize());

        System.out.println("-------------------------------------");
        System.out.println("Recorrido inverso:");

        while(it2.hasNext()){
            int element = it2.next();

            System.out.println("Dato: " + element);
        }


        System.out.println("-------------------------------------");
        System.out.println("Recorrido normal:");

        while(it.hasNext()){
            LinkedList<Integer>.Iterator backupIt = list.new Iterator(it);
            int element = it.next();

            if(element == 3){
                list.insert(10, Position.BEFORE, backupIt);
            }

            if(element == 7){
                list.insert(15, Position.AFTER, backupIt);
            }

            System.out.println("Dato: " + element);
        }

        System.out.println("-------------------------------------");
        System.out.println("Lista con datos agregados:");

        it = list.getIterator();

        while(it.hasNext()) {
            int element = it.next();

            System.out.println("Dato: " + element);
        }
        System.out.println("El tamaño de la lista es: " + list.getSize());

        System.out.println("-------------------------------------");
        System.out.println("Lista de flotantes:");

        itFloat = list2.getIterator();

        while(itFloat.hasNext()) {
            float element = itFloat.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("-------------------------------------");
        System.out.println("Lista de caracteres:");

        itChar = list3.getIterator();

        while(itChar.hasNext()) {
            char element = itChar.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("-------------------------------------");
        System.out.println("Lista de strings:");

        itString = list4.getIterator();

        while(itString.hasNext()) {
            String element = itString.next();

            System.out.println("Dato: " + element);
        }

      /*  System.out.println("-------------------------------------");
        System.out.println("Recorrido inverso con datos agregados");

        it2 = list.getReverseIterator();

        while(it2.hasNext()){
            int element = it2.next();

            System.out.println("Dato: " + element);
        }*/
    }
}

//Clases: main, linkedlist, system
//Objetos: list, out
//Métodos: add, getsize, main, println