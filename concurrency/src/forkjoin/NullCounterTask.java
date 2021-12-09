package forkjoin;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class NullCounterTask extends RecursiveTask<Integer> {

    private final List<?> list;
    private final int threshold;

    public NullCounterTask(Collection<?> coll, int threshold) {
        this.list = new ArrayList<>(coll);
        this.threshold = threshold;
    }

    @Override
    protected Integer compute() {
        if (sizeBelowThreshold())
            return (int) countNulls();
        else {
            var cutIndex = list.size() / 2;
            var part1 = list.subList(0, cutIndex);
            var part2 = list.subList(cutIndex, list.size());
            var forkedTask = new NullCounterTask(part1, threshold).fork();
            int nullsInPart2 = new NullCounterTask(part2, threshold).invoke();
            try {
                return forkedTask.get() + nullsInPart2;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("Shouldn't happen");
        }
    }

    private long countNulls() {
        return list.stream()
                .filter(Objects::isNull)
                .count();
    }

    private boolean sizeBelowThreshold() {
        return list.size() < threshold;
    }
}
