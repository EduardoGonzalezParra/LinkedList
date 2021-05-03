package uaslp.ingenieria.labs;

import uaslp.ingenieria.labs.list.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        List<Float> list2 = new LinkedList<>();
        List<Character> list3 = new LinkedList<>();
        List<String> list4 = new LinkedList<>();

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

        Iterator<Integer> it = list.getIterator();
        Iterator<Integer> it2 = list.getReverseIterator();
        Iterator<Float> itFloat = list2.getIterator();
        Iterator<Character> itChar = list3.getIterator();
        Iterator<String> itString = list4.getIterator();

        System.out.println("El tamaño de la lista es: " + list.getSize());

        System.out.println("-------------------------------------");
        System.out.println("Recorrido inverso:");

        while(it2.hasNext()){
            int element = it2.next();

            System.out.println("Dato: " + element);
        }


        System.out.println("-------------------------------------");
        System.out.println("Recorrido normal:");

        //while(it.hasNext()){
        //    LinkedList.ForwardIterator backupIt = list.new ForwardIterator(it);
        //    int element = it.next();
//
        //    if(element == 3){
        //        list.insert(10, Position.BEFORE, backupIt);
        //    }
//
        //    if(element == 7){
        //        list.insert(15, Position.AFTER, backupIt);
        //    }
//
        //    System.out.println("Dato: " + element);
        //}

        //System.out.println("-------------------------------------");
        //System.out.println("Lista con datos agregados:");

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
    }
}

//Clases: main, linkedlist, system
//Objetos: list, out
//Métodos: add, getsize, main, println