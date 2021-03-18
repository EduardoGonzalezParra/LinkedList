package uaslp.ingenieria.labs.list;

//se podría hacer con herencia de Iterator también
public class ReverseIterator {
    private Node currentNode;

    public ReverseIterator(Node currentNode) {
        this.currentNode = currentNode;
    }

    public ReverseIterator(ReverseIterator iterator){
        currentNode = iterator.currentNode;
    }

    public boolean hasNext(){
        return currentNode != null;
    }

    public int next(){
        int data = currentNode.getData();

        currentNode = currentNode.getPrevious();

        return data;
    }
}
