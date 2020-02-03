import linkedlist.DoublyLinkedList;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {

        Deque deque = new Deque();



        for (int i = 1; i <= 100; i++) {
            deque.offer(i);
        }

        for (int i = 101; i <= 200; i++) {
            deque.push(i);
        }


        System.out.println();
    }
}
