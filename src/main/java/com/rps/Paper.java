package com.rps;

import java.util.Objects;

public class Paper {
    final String paper;

    public Paper(String paper) {
        this.paper = paper;
    }

    public String getPaper() {
        return "Paper";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper1 = (Paper) o;
        return Objects.equals(paper, paper1.paper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paper);
    }
}

