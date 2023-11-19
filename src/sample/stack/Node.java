package sample.stack;

public class Node{
    public String  data;
    public int pos;
    public boolean remove;
    public Node    next;
    public Node(String data) {
        this.data = data;
    }

    public Node(String data, int pos, boolean remove) {
        this.data = data;
        this.pos = pos;
        this.remove = remove;
    }

    @Override
    public String toString() {
        return ""+data+" "+remove+" "+pos;
    }
}
