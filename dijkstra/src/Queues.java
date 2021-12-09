import java.util.*;

public class Queues {

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>(
                Comparator.comparingInt(String::length)
        );
        queue.add("nein");
        queue.add("ja");
        queue.add("vielleicht");
        while(!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
