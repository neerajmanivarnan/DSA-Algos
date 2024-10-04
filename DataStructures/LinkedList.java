


public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.size = 0;
    }

    private class Node{
        private int val;
        private Node next;

        Node(int val){
            this.val = val;
        }

        Node(int val,Node next){
            this.val = val;
            this.next = next;
        }

    }


    public void insert(int val){
        if(this.head == null){
            Node newNode = new Node(val);
            head = newNode;
            tail = head;
            size++;
        }else{
            Node newNode = new Node(val);
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void insertFirst(int val){
        if(this.head == null){
            Node newNode = new Node(val);
            head = newNode;
            tail = head;
            size++;
        }else{
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public int search(int key){
        Node current = head;
        int index = 0;
        while(current!=null){
            if(current.val == key){
                return index;
            }else{
                index++;
                current=current.next;
            }
        }

        return -1;
    }

    public int deleteLast(){
        Node current = head;

        if(head == tail){
            head=null;
            return -1;
        }

        while(current.next !=tail){
            current = current.next;            
        }

        int value = tail.val;
        current.next = null;
        tail = current;
        return value;
    }

    public void deleteAfterKey(int key){
        Node current = head;
        // Node prev=null;
        

        while(current!=null){
            if(current.val == key){
                if(current.next==null){
                    current=current.next;
                    continue;
                }
                current.next = current.next.next;
            }
            
            current  = current.next;
            // prev = current;
        }

        
    }

    public String recursiveDisplay(Node node){
        
        if(node.next == null){
            String num = node.val+"";
            return num;
        }

        String newNum = recursiveDisplay(node.next)+  node.val  +"";
        return newNum;

    }

    public int addNumbers(Node l1,Node l2){
        String num1 = recursiveDisplay(l1);
        String num2 = recursiveDisplay(l2);

        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        return result;

    }


    public void display(){
        Node current = head;
        while(current!=null){
            System.out.println(current.val);
            current = current.next;
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(2);
        list.insert(4);
        list.insert(3);
        
        LinkedList list2 = new LinkedList();
        list2.insert(5);
        list2.insert(6);
        list2.insert(4);
       
       System.out.println(list.addNumbers(list.head,list2.head));

    }

    
}
