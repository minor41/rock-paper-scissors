package com.rps;

import java.util.Objects;

public class Scissors {
    final String scissors;

    public Scissors(String scissors) {
        this.scissors = scissors;
    }

    public String getScissors() {
        return "Scissors";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scissors scissors1 = (Scissors) o;
        return Objects.equals(scissors, scissors1.scissors);
    }

    @Override
    public int hashCode() {

        return Objects.hash(scissors);
    }
}