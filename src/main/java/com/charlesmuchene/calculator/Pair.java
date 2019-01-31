package com.charlesmuchene.calculator;

/**
 * Pair class
 *
 * A generic helper class to hold a pair values
 */
class Pair<T> {

    private final T first;
    private final T second;

    Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    T getFirst() {
        return first;
    }

    T getSecond() {
        return second;
    }

    /**
     * Determine if any of the values is null
     *
     * @return {@code true} if any of the values is null otherwise {@code false}
     */
    boolean isAnyValueNull() {
        return first == null || second == null;
    }
}
