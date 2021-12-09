package forkjoin;

import forkjoin.domain.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class DropTask extends RecursiveTask<List<Actor>> {

    private final List<Actor> actors;

    public DropTask(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    protected List<Actor> compute() {
        if (actors.size() < 10)  // workload?
            return dropAllActors();

        int chunkSize = actors.size() / 3;
        var part1 = actors.subList(0, chunkSize);
        var part2 = actors.subList(chunkSize, 2 * chunkSize);
        var part3 = actors.subList(2 * chunkSize, actors.size());

        var task1 = new DropTask(part1);
        task1.fork();
        var task2 = new DropTask(part2);
        task2.fork();
        var task3 = new DropTask(part3);
        task3.fork();

        try {
            var actors1 = task1.get();
            var actors2 = task2.get();
            var actors3 = task3.get();
            var almostResult = new ArrayList<>(actors1);
            almostResult.addAll(actors2);
            almostResult.addAll(actors3);
            return almostResult;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new IllegalStateException("no");
        }
    }

    private List<Actor> dropAllActors() {
        return actors.stream()
                .map(actor -> actor.drop())
                .toList();
    }
}
