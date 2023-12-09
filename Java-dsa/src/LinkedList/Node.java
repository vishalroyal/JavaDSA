package LinkedList;

import java.sql.SQLOutput;

public class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

   public Node(int data)
   {
       this.data=data;
       this.next=null;
   }

   static Node convertTOLL(int arr[])
   {
       //
       Node head=new Node(arr[0]);
       Node mover=head;
       for(int i=1;i< arr.length;i++)
       {
           Node temp=new Node(arr[i]);
           mover.next=temp;
           mover=temp;

       }

       return head;
   }

    static Node firstNodeDelete(Node head){
        Node temp=head;
        while(temp!=null)
        {
            temp=temp.next;
        }

        return temp;

    }

    static int searchInLL(Node head, int val)
    {
        Node temp=head;
        while(temp!=null) {

            if (temp.data == val) {
                System.out.println("yes got the ans "+temp.data);
                return 1;

            }
            temp=temp.next;
        }
        System.out.println("failed boss");
        return 0;
    }

    static Node deletetailLL(Node head)
    {
        Node temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }

    static Node deletebykthvalue(Node head,int k)
    {
        Node temp=head; int count=0; Node prev=null;
        if(head==null)
            return null;

        if(k==1)
        {
            head=head.next;
            return head;
        }
        while(temp!=null)
        {
            count++;
            if(count==k)
            {
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    static Node deletebyele(Node head,int ele)
    {
        Node temp=head;  Node prev=null;
        if(head==null)
            return null;

        if(temp.data==ele)
        {
            head=head.next;
            return head;
        }
        while(temp!=null)
        {
           // count++;
            if(temp.data==ele)
            {
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }


    public static void print(Node head)
    {
        while(head!=null) {
            System.out.print(head.data+ " ");
            head=head.next;
        }
        System.out.println();
    }


    public static Node insertAtStart(Node head,int value)
    {
        Node temp=new Node(value,head);
        return temp;
    }
     static int lengthOfLL(Node head) {

        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }

    public static Node insertAtEnd(Node head,int value)
    {
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new Node(value);
        return head;
    }

    public static Node insertAtKth(Node head,int k,int val) {
        Node temp = head;
        int counter = 0;
        if (head == null) {
            if (k == 1)
                new Node(val);
            else
                return head;
        } else {
            if (k == 1)
                return new Node(val);
            while (temp != null) {
                counter++;
                if (counter == (k - 1)) {
                    Node x = new Node(val, temp.next);
                    temp.next = x;
                    break;
                }
                temp = temp.next;

            }

        }
        return head;
    }


    public static Node insertBeforeKth(Node head,int k,int val) {
        Node temp = head;
        if (head == null) {
            return null;
        } else {
            if (head.data==k)
                return new Node(val,head);
            while (temp.next != null) {
                if (temp.next.data == k) {
                    Node x = new Node(val, temp.next);
                    temp.next = x;
                    break;
                }
                temp = temp.next;

            }

        }
        return head;
    }





    /*
    Linked List Implementation
    1) Addition   2) Deletion


    1) first
    2) last
    3)  position
    4) value

     */



   public static void main(String args[])
   {
        int arr[]={1,4,5,7};
     Node head = convertTOLL(arr);
       searchInLL(head,5);
       //lengthOfLL(head);
       System.out.println("Length of LL is "+ lengthOfLL(head));
       /*     commenting out cause its all about delete
       firstNodeDelete(head);
       Node remaing= deletetailLL(head);
       print(remaing);
       Node kby =  deletebykthvalue(head,3);
       Node del=deletebyele(head,4);
       print(kby);
       print(del);
        */
       //Node all=insertAtStart(head,100);
       //insertAtEnd(head,14);
    //Node kth  = insertAtKth(head,3,400);
    Node vlth =insertBeforeKth(head,7,300);
      // print(all);
       //print(kth);
       print(vlth);





   }




}
