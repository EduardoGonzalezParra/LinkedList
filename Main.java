package uaslp.ingenieria.labs;

import uaslp.ingenieria.labs.list.Iterator;
import uaslp.ingenieria.labs.list.LinkedList;
import uaslp.ingenieria.labs.list.Position;
import uaslp.ingenieria.labs.list.ReverseIterator;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(4);
        list.add(3);
        list.add(7);

        System.out.println("El tamaño de la lista es: " + list.getSize());

        Iterator it = list.getIterator();
        ReverseIterator it2 = list.getReverseIterator();

        System.out.println("-------------------------------------");
        System.out.println("Recorrido inverso");

        while(it2.hasNext()){
            int element = it2.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("-------------------------------------");
        System.out.println("Recorrido normal");

        while(it.hasNext()){
            Iterator backupIt = new Iterator(it);
            int element = it.next();

            if(element == 1){
                list.insert(10, Position.BEFORE, backupIt);
            }

            if(element == 7){
                list.insert(15, Position.AFTER, backupIt);
            }

            System.out.println("Dato: " + element);
        }


        System.out.println("-------------------------------------");
        System.out.println("Lista con datos agregados");

        it = list.getIterator();

        while(it.hasNext()) {
            int element = it.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("-------------------------------------");
        System.out.println("Recorrido inverso con datos agregados");

        it2 = list.getReverseIterator();

        while(it2.hasNext()){
            int element = it2.next();

            System.out.println("Dato: " + element);
        }
    }
}

//Clases: main, linkedlist, system
//Objetos: list, out
//Métodos: add, getsize, main, println