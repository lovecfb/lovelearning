package com.love.arithmetic;

/**
 * Created by ls on 2018/11/16.
 */
public class Test {

//    https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/

    public static void main(String[] args) {

         /* Let us create two sorted linked
       lists to test the methods
       Created lists:
           llist1: 5->10->15,
           llist2: 2->3->20
    */
        Merge2SortedLinkedLists.MergeLists llist1 = new Merge2SortedLinkedLists().new MergeLists();
        Merge2SortedLinkedLists.MergeLists llist2 = new Merge2SortedLinkedLists().new MergeLists();

        // Node head1 = new Node(5);
        llist1.addToTheLast(new Merge2SortedLinkedLists().new Node(5));
        llist1.addToTheLast(new Merge2SortedLinkedLists().new Node(10));
        llist1.addToTheLast(new Merge2SortedLinkedLists().new Node(15));

        // Node head2 = new Node(2);
        llist2.addToTheLast(new Merge2SortedLinkedLists().new Node(2));
        llist2.addToTheLast(new Merge2SortedLinkedLists().new Node(3));
        llist2.addToTheLast(new Merge2SortedLinkedLists().new Node(20));


        llist1.head = new Merge2SortedLinkedLists().new Gfg().sortedMerge(llist1.head,
                llist2.head);
        llist1.printList();


    }
}
