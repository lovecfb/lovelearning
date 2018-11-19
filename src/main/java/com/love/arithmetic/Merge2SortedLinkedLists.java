package com.love.arithmetic;

/**
 * Created by ls on 2018/11/16.
 */
public class Merge2SortedLinkedLists {


    class Node {

        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    class MergeLists {

        Node head;

        public void addToTheLast(Node node) {
            if (head == null)
                head = node;
            else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = node;
            }
        }

        void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data + "  ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    class Gfg {

        Node sortedMerge(Node headA, Node headB) {

            Node dummyNode = new Node(0);
            Node tail = dummyNode;

            while (true) {

                /* if either list runs out,use the other list */
                if (headA == null) {
                    tail.next = headB;
                    break;
                }

                if (headB == null) {
                    tail.next = headA;
                    break;
                }

                /* Compare the data of the two lists whichever lists' data is smaller, append it into tail and
                   advance the head to the next Node
                */
                if (headA.data <= headB.data) {
                    tail.next = headA;
                    headA = headA.next;
                } else {
                    tail.next = headB;
                    headB = headB.next;
                }

                /* Advance the tail */
                tail = tail.next;
            }
            return dummyNode.next;
        }

    }


}
