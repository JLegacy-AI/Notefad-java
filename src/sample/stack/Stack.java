package sample.stack;

public class Stack {
    Node head;
    public void push(String data){
        push(new Node(data));
        display();
    }
    public void push(Node h){
        if(h.pos==-1)
            return;

        if( head==null){
            head = h;
        }else{
            h.next = head;
            head = h;
        }
    }
    public Node pop(){
        if(head==null)
            return null;

        Node temp =  new Node(head.data);
        temp.pos = head.pos;
        temp.remove = head.remove;
        head = head.next;
        return temp;
    }
    public Node peek(){
        return new Node(head.data);
    }
    public void display(){
        Node h = head;
        while(h!=null){
            System.out.println(h);
            h= h.next;
        }
    }
}
