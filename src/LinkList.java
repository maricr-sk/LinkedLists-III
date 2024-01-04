public class LinkList {

    private Node front;

    public static void main(String [] args){
        LinkList list = new LinkList();
        System.out.println(list);
        list.add(1);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.add(1);
        System.out.println();

        list.add(0,2);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.add(2);
        System.out.println();

        list.add(list.size(), 3);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.add(3);
        System.out.println();

        list.remove(7);
        System.out.println(list);

    }

    static class Node{
        Integer data;
        Node next;

        public Node(int i){
            data = i;
            next = null;
        }

        public String toString(){ return data + ""; }
    }

    public LinkList(){
        super(); //Object
        front = null;
    }

    public int size(){
        int size = 0;
        Node temp = front;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public boolean isEmpty(){ return front == null; }

    public int get(int index){
        Node n = front;

        if(index >= size()){
          try{ throw new Exception(); }
          catch(Exception e){ System.out.println("index out of bounds"); }
        }

        for(int i = 0; i < index; i++){ n = n.next; }
        return n.data;
    }

    public boolean contains(Integer a){ return indexOf(a) != -1; }

    public void add(Integer data) {
        try{ add(size(), data); }

        catch (Exception e){ System.out.println("Error"); }
    }

    public boolean add(Integer index, Integer n) {
        return add(index, new Node(n));
    }

    private boolean add(int index, Node n){
        if(index > size() || index < 0){ return false; }
        Node current = front;

        if(index == 0){
            front = n;
            front.next = current;
            return true;
        }
        for(int i = 0;  i < index -1; i++){ current = current.next; }

        Node temp = current.next;
        current.next = n;
        current.next.next = temp;
        return true;
    }

    public int indexOf(Integer n){
        Node temp = front;
        int a = 0;
        while(temp != null){
            if(temp.data == n) return a;
            a++;
            temp = temp.next;
        }
        return -1;
    }

    public int index(Integer n){
        Node temp = front;
        int a = 0;
        while(temp != null && temp.data != n){
             a++;
             temp = temp.next;
        }
        if(temp != null && temp.data == n) return a;
        return -1;
    }

    public boolean remove(Integer r){
        Node temp = front;
        if(front.data == r){
            front = front.next;
            return true;
        }
        while(temp.next != null){
            Node t = temp.next;
            if(t.data == r) {
                temp.next = t.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean removeAll(Integer r){
        Node temp = front;
        if(front.data == r){ //first case
            front = front.next;
        }

        temp = front;
        boolean check = true;
        int a = 0;
        int indexe = -1;

        while(temp != null){ // second case
            if(temp.data == r){
                a++;
            }
            else{
                indexe = a;
            }
            temp = temp.next;
        }

        if(a == size()-1){ //third case
            //multiple items match in front of list
            //entire list is full of that item
            //multiple at end
            //multiple in middle
            front = null;
            return true;
        }
        temp = front;
        if(indexe > 0){
            for(int i = 0; i < indexe; i++){
                temp = temp.next;
            }
            front = temp.next;
        }
        while(contains(r)){
            Node t = temp.next;
            if(t.data == r) {
                temp.next = t.next;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override public String toString(){
        String a = "[";
        Node n = front;
        while(n != null){
            a += n;
            if(n.next != null){ a += ", "; }
            n = n.next;
        }
        return a + "]";
    }
    
}