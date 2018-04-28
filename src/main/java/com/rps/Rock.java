package com.rps;

import java.util.Objects;

public class Rock implements Move{
    final String rock;

    public Rock(String rock) {
        this.rock = rock;
    }

    public String getRock() {
        return rock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rock rock1 = (Rock) o;
        return Objects.equals(rock, rock1.rock);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rock);
    }

    @Override
    public String move(String move) {
        return rock;
    }
}