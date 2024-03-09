package LinkedList;

public class Node1 {
    int data;
    Node1 next;
    Node1 prev;

    public Node1(int data,Node1 next,Node1 prev)
    {

        this.data=data;
        this.next =next;
        this.prev=prev;
    }

    public Node1(int data)
    {
        this.data=data;
        this.next =null;
        this.prev=null;
    }



    static Node1 convertTodoublLL(int arr[]){

        Node1 head=new Node1(arr[0]);
        Node1 prev=head;

        for(int i=1;i< arr.length;i++)
        {
            Node1 temp=new Node1(arr[i],null,prev);
            prev.next=temp; // pointing to new created node
            prev=temp; // incrementating pointer

        }
       return head;
    }
    public static void print(Node1 head)
    {
        while(head!=null) {
            System.out.print(head.data+ " ");
            head=head.next;
        }
        System.out.println();
    }

    private static Node1 deleteHeadof2DLL(Node1 head){

        if(head== null || head.next==null)
        {
            return null;
        }
        // preserve the head
        Node1 prev=head;
        // moving actucal head to next
        head=head.next;
        // making prev null of new head
        head.prev=null;
        // making prev next to null to cut the link with new 2DLL
        prev.next=null;
        
        return head;
    }

    private static Node1 deleteTailof2DLL(Node1 head){

        if(head == null || head.next==null)
            return  null;

        Node1 temp=head; // retore the head
        while(temp.next!=null)  // check till end that end.next is null
        {
            temp=temp.next;
        }
        // if yes tail.next=null then restore another object for reference as tail
        Node1 tail=temp.prev;
        temp.prev=null; // make tail's prev null to cut off the list
        tail.next=null; // make prev next to null to cut off last element from LL.

    return head;
    }

    static Node1 deleteKthelement(Node1 head,int k)
    {
        //preserve the head
        Node1 temp=head;
        int count=0;
        while(temp!=null)
        {
            count++;
            // to check the count and stop the temp at k'th node
            if(k==count){
                break;
            }
            //if counter doesnt match go ahead
            temp=temp.next;
        }
        //preserve the previous and next element of kth element
        Node1 back=temp.prev;
        Node1 front=temp.next;
        if(back==null && front==null ){
            return null;
        } else if (back==null) {
            //if it is head use head remove method or its tail use tailremove method
            return deleteHeadof2DLL(head);
        } else if (front==null) {
            return deleteTailof2DLL(head);
        }

        //point previous element next to kth next elenent and point kth next-elment's prev to its previous ele.
        back.next=front;
        front.prev=back;

        // point the kth element's next and prev to null
        temp.next=null;
        temp.prev=null;


        return head;
    }
     //in this method head node cant be deleted
     // because it will be infinite loop to delete the head
    //that's Node=!head
  static  void deleteNode(Node1 temp)
    {
                               //in this temp=!head

        Node1 front=temp.next;
        Node1 back=temp.prev;  //calculate back and front ele considering temp is in middle
        if(front==null)
        {
           back.next=null;  // edge case check that temp's next i.e front is null then
           temp.prev=null;
           return;
        }

        back.next=front;  //normal if temp is the node which is to be deleted then...
        front.prev=back;

        temp.next= temp.prev= null;


    }

    static Node1 insertAfter(Node1 head,int val,int ele){

        Node1 temp=head;
        if(head==null)
            return null;
        int count=0;
        while(temp!=null)
        {
            count++;
            if(val==count)
                break;

            temp=temp.next;
        }
        Node1 abc=new Node1(ele,temp.prev,temp.next);

        return head;
    }

    static Node1 insertBeforeHead(Node1 head, int val)
    {
        Node1 newNode=new Node1(val,head,null);
        head.prev=newNode;
        return newNode;
    }

    static Node1 insertBeforeTail(Node1 head, int val)
    {
        Node1 temp=head;
        if(head.next==null)
            return insertBeforeHead(head,val);

        while(temp.next!=null)
        {
            temp=temp.next;
        }
        Node1 back=temp.prev;
        Node1 newNode=new Node1(val,temp,back);
        back.next=newNode;
        temp.prev=newNode;
        return head;

    }

    static Node1 insertBeforeKthElement(Node1 head, int k,int val)
    {

        if(k==1)
            insertBeforeHead(head,val);
        Node1 temp=head;
        int count=0;
        while (temp!=null)
        {
            count++;
            if(k==count)
                break;
            temp=temp.next;
        }
        Node1 back=temp.prev;
        //Node1 front=temp.next;
        Node1 newNode=new Node1(val,temp,back);
        back.next=newNode;
        temp.prev=newNode;
        return head;
    }
    static Node1 insertAfterHead(Node1 head, int val)
    {
        Node1 front=head.next;
        Node1 newNode=new Node1(val,head.next,head);
        head.next=newNode;
        front.prev=newNode;


        return head;
    }


    static Node1 insertAfterKthElement(Node1 head, int k,int val)
    {

        if(k==1)
            insertBeforeHead(head,val);
        Node1 temp=head;
        int count=0;
        while (temp!=null)
        {
            count++;
            if(k==count)
                break;
            temp=temp.next;
        }
        Node1 back=temp.prev;
        //Node1 front=temp.next;
        Node1 newNode=new Node1(val,temp,back);
        back.next=newNode;
        temp.prev=newNode;
        return head;
    }

    //here we cant change head
    // i.e (head!=node)
    static void insertBeforeNode(Node1 node,int val)
    {
       Node1 back= node.prev;
       Node1 newNode=new Node1(val,node,back);
       back.next=newNode;
       node.prev=newNode;

    }












    public static void main(String args[]) {

        int arr[]={1,4,5,6,9,90};
        Node1 abc=convertTodoublLL(arr);
        //abc=deleteHeadof2DLL(abc);
        //abc=deleteTailof2DLL(abc);
        //abc=deleteKthelement(abc,6);
        //deleteNode(abc.next.next.next.next.next);
        //Node1 abc1=insertBeforeHead(abc,13);
        //Node1 abc2=insertBeforeTail(abc,60);
        //Node1 abc3= insertBeforeKthElement(abc,5,56);

        //Node1 abc4=insertAfterHead(abc,90);
        //insertBeforeNode(abc.next.next,1145);
        print(abc);




    }
}


