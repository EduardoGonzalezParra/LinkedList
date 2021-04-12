package uaslp.ingenieria.labs.list;

public class ArrayList<H> implements List<H>{
    private Object array[];
    int size;

    public ArrayList() {
        this.array = new Object[2];
    }


    @Override
    public void add(H data) {
        if(size < array.length){
            array[size++] = data;
        }else{
            Object arrayAux[] = new Object[array.length*2];
            System.arraycopy(array, 0, arrayAux, 0, array.length);
            array = arrayAux;
            array[size++] = data;
        }
    }

    @Override
    public H get(int index) {
        return (H) array[index];
    }

    @Override
    public void delete(int index) {
        for(int i = index + 1; i < size ; i++ ){
            array[i-1] = array[i];
        }
        size--;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<H> getIterator() {
        return new ForwardIterator();
    }

    @Override
    public Iterator<H> getReverseIterator() {
        return new ReverseIterator();
    }

    @Override
    public void insert(H data, Position position, Iterator<H> it) {

    }

    public class ForwardIterator implements Iterator <H> {

        private int currentPosition;

        public ForwardIterator(){
            this.currentPosition = 0;
        }

        @Override
        public boolean hasNext(){
            return currentPosition < size;
        }

        @Override
        public H next(){
            H data = (H) array[currentPosition];

            currentPosition++;

            return data;
        }

    }

    public class ReverseIterator implements Iterator<H> {

        private int currentPosition;

        public ReverseIterator() {
            this.currentPosition = size-1;
        }

        @Override
        public boolean hasNext(){
            return currentPosition >= 0;
        }

        @Override
        public H next(){
            H data = (H) array[currentPosition];

            currentPosition--;

            return data;
        }
    }
}