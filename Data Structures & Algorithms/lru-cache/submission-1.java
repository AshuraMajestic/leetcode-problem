class LRUCache {
    class Node{
        int key,val;
        Node prev,next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    private HashMap<Integer,Node> map;
    private int size;
    private Node head,tail;
    public LRUCache(int capacity) {
        this.size=capacity;
        this.map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
     if(!map.containsKey(key)){
        return -1;
     }   
     Node node=map.get(key);
     removeNode(node);
     addToTail(node);
     return node.val;
    }
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void addToTail(Node node){
        node.prev=tail.prev;
        node.next=tail;
        tail.prev=node;
        node.prev.next=node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            removeNode(node);
            addToTail(node);
        }else{
            if(map.size()==size){
                Node lru=head.next;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node node=new Node(key,value);
            map.put(key,node);
            addToTail(node);
        }
    }
}
