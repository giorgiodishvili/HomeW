package com.company.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Group<G> {
    private G key;
    private Collection<Person> people;

    public Group(G key) {
        this.key = key;
        people = new ArrayList<>();
    }

    public void add(Person person) {
        people.add(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group<?> group = (Group<?>) o;
        return key.equals(group.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "Group{" +
                "key=" + key +
                ", people=" + people +
                "}\n";
    }
}
