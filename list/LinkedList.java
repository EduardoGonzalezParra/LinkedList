package uaslp.ingenieria.labs.list;

public class LinkedList<G> implements List<G>{

    private Node<G> head;
    private Node<G> tail;
    private int size;


    @Override
    public void add(G data){
        Node<G> node = new Node<>(data);

        node.setPrevious(tail);

        if(tail != null){
            tail.setNext(node);
        }

        if(head == null){
            head = node;
        }

        tail=node;
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public G get(int index){
        Node<G> currentNode = head;
        int currentIndex = 0;

        while(currentNode != null && currentIndex < index){
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode.getData();
    }

    @Override
    public void delete(int index){
        Node<G> currentNode = head;
        int currentIndex = 0;

        if(index < 0  || index >= size){
            throw new IndexOutOfBoundsException();
        }

        size--;

        if(index == 0){
            head = head.getNext();
            head.setPrevious(null);
        }

        if(index == size-1){
            tail = tail.getPrevious();
            tail.setNext(null);
        }

        if(index > 0 && index < size - 1){
            while(currentNode != null && currentIndex < index){
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            currentNode.getPrevious().setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(currentNode.getPrevious());
        }
    }

    @Override
    public ForwardIterator getIterator(){
        return new ForwardIterator();
    }

    @Override
    public ReverseIterator getReverseIterator(){
        return new ReverseIterator();
    }

    @Override
    public void insert(G data, Position position, Iterator<G> it){
        Node<G> newNode = new Node<G>(data);
        Node<G> currentNode = ((ForwardIterator)it).getCurrentNode();

        size++;

        if(position == Position.AFTER){
            newNode.setNext(currentNode.getNext());

            currentNode.setNext(newNode);

            if(newNode.getNext() != null){
                newNode.setPrevious(currentNode);
                newNode.getNext().setPrevious(newNode);
            }else {
                tail = newNode;
            }
        }else if(position == Position.BEFORE){
            newNode.setPrevious(currentNode.getPrevious());
            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);

            if(newNode.getPrevious() != null){
                newNode.getPrevious().setNext(newNode);
            }else {
                head = newNode;
            }
        }

        }

    public class ForwardIterator implements Iterator<G>{
        private Node<G> currentNode;

        public ForwardIterator() {
            this.currentNode = head;
        }

        public ForwardIterator(ForwardIterator iterator){
            currentNode = iterator.currentNode;
        }

        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.getData();

            currentNode = currentNode.getNext();

            return data;
        }

        Node<G> getCurrentNode() {
            return currentNode;
        }
    }

    public class ReverseIterator implements Iterator<G>{
        private Node<G> currentNode;

        public ReverseIterator() {
            this.currentNode = tail;
        }

        public ReverseIterator(ReverseIterator iterator){
            currentNode = iterator.currentNode;
        }

        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.getData();

            currentNode = currentNode.getPrevious();

            return data;
        }
    }

    private static class Node<G> {
        private G data;
        private Node<G> next;
        private Node<G> previous;

        Node(G data){
            this.data = data;
        }

        public G getData() {
            return data;
        }

        public Node<G> getNext() {
            return next;
        }

        public void setNext(Node<G> next) {
            this.next = next;
        }

        public Node<G> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<G> previous) {
            this.previous = previous;
        }

    }
}