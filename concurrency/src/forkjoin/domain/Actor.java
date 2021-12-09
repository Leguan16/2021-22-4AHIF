package forkjoin.domain;

public record Actor(int y) {

    public Actor drop() {
        return new Actor(y - 1);
    }
}
