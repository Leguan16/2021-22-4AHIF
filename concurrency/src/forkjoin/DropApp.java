package forkjoin;

import forkjoin.domain.Actor;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class DropApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executor = new ForkJoinPool();
        var actors = new Random().ints(100, 1,100)
                .mapToObj(y -> new Actor(0))
                .toList();
        var dropper = new DropTask(actors);
        var task = executor.submit(dropper);
        actors = task.get();
        executor.shutdown();
        var ys = actors
                .stream()
                .mapToInt(actor -> actor.y())
                .toArray();
        System.out.println(Arrays.toString(ys));
    }
}
