package com.celiv;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class CircularLinkedList {
    static Node head;
//    Inside this class, there will
//    be a static class to
//    represent the node.
//    Each node will contain
//    two pointers – previous and
//    next and a data item. Then you can have operations to
//    add nodes to the list and to traverse the list.
    static class Node{
        int data;
        Node next;
        Node prev;

    public Node() {

    }
    public Node(int data) {
        this.data=data;
    }
}
    static Node GetNode(int data) {
        return new Node(data);
    }
//functions that we are going to used
    //functions to insert Node
    //this function insert a node at the end of the Node
    static void addNodeToEnd(int value){
        //if the List is empty
        if(head == null){
            //create new Node
            Node newNode= new Node();
            //add value
            newNode.data= value;
            //add next node
            // we used that expression below to show that
            //next and prev nodes are the same
            newNode.next=newNode.prev=newNode;
            //set head as a new node
            head=newNode;
            return;
        }
        //find the node at the end of the node
        Node last= (head).prev;
        //now create the new node you want to add
        Node newNode=new Node();
        newNode.data=value;
        //next of newNode point to head
        newNode.next=head;
        ///thus the prev of head point to newNode
        (head).prev=newNode;

        ///you can now ser newNode prev to last
        //this is just useful when adding next node to end
        newNode.prev=last;
        //make newNode next of old last
        last.next=newNode;

    }
    static void addNodeInBetween(int value){
        if(head==null){
            Node newNode=new Node();
            newNode.data=value;
            newNode.next=newNode.prev=newNode;
            head=newNode;
            return;
        }
        ArrayList<Integer> values=new ArrayList<Integer>();
        Node temp =head;
        while (temp.next!=head){
            values.add(temp.data);
            temp=temp.next;
        }
        int pos=0;
        for(int i= 0; i<values.size()-1;i++){
            if(value>values.get(i)){
              pos=i;
            }
        }
    }

    static Node insertToPosition(Node headNode, int position, int data){
        Node head=headNode;
        if(position<1){
            System.out.println("Invalid position");

        }
        if(position==1){
            Node newNode=new Node(data);
            newNode.next = headNode;
            head = newNode;
        } else {
            while (position-- != 0) {
                if (position == 1) {
                    // adding Node at required position
                    Node newNode = GetNode(data);

                    // Making the new Node to point to
                    // the old Node at the same position
                    newNode.next = headNode.next;

                    // Replacing current with new Node
                    // to the old Node to point to the new Node
                    headNode.next = newNode;
                    break;
                }
                headNode = headNode.next;
            }
            if (position != 1)
                System.out.print("Position out of range");
        }
        return head;
    }
}
