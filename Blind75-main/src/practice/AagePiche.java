package practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class AagePiche {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(11);
        deque.add(13);
        deque.add(55);
        System.out.println(deque.pop());
        System.out.println(deque.getLast());

    }
}
