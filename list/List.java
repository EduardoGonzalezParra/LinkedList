package uaslp.ingenieria.labs.list;

public interface List<T> {

    void add(T data);

    int getSize();

    T get(int index) throws MyIndexOutOfBoundException;

    void delete(int index) throws MyIndexOutOfBoundException;

    Iterator<T> getIterator();

    void insert(T data, Position position, Iterator<T> it);

    Iterator getReverseIterator();
}
