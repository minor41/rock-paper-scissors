package com.rps;

import java.util.Objects;

public class Scissors extends Move {
    final String name = "Scissors";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scissors scissors1 = (Scissors) o;
        return Objects.equals(name, scissors1.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Scissors ";
    }
}