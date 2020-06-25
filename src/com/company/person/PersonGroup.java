package com.company.person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonGroup {
    public static void group(Collection<Person> personList, Parameters parameter) {

        if (parameter.getChoice().equals("birthplace")) {
            Map<String, List<Person>> personGrouped =
                    personList.stream().collect(Collectors.groupingBy(Person::getBirthTown));

            for (Map.Entry<String, List<Person>> entry : personGrouped.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        } else if (parameter.getChoice().equals("name")) {
            Map<Object, List<Person>> personGrouped =
                    personList.stream().collect(Collectors.groupingBy(Person::getName));

            for (Map.Entry<Object, List<Person>> entry : personGrouped.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        } else {
            Map<Object, List<Person>> personGrouped =
                    personList.stream().collect(Collectors.groupingBy(Person::getSurname));

            for (Map.Entry<Object, List<Person>> entry : personGrouped.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        }
    }

    public static Optional<Map<String, List<Person>>> groupByMisha1(Collection<Person> personList, Parameters parameters) {
        if (parameters == null) return Optional.empty();
        Stream<Person> stream = personList.stream();
        switch (parameters) {
            case NAME:
                Map<String, List<Person>> collect = stream.collect(Collectors.groupingBy(Person::getName));
                return Optional.of(collect);
            case SURNAME:
                return Optional.of(stream.collect(Collectors.groupingBy(Person::getSurname)));
            case BIRTHPLACE:
                return Optional.of(stream.collect(Collectors.groupingBy(Person::getBirthTown)));
        }
        return Optional.empty();
    }

    public static List<Group<?>> groupByMisha2(Collection<Person> personList, Parameters parameters) {
        List<Group<?>> groupList = new ArrayList<>();

        personList.forEach(person -> {
            Object key = null;
            switch (parameters) {
                case NAME:
                    key = person.getName();
                    break;
                case SURNAME:
                    key = person.getSurname();
                    break;
                case BIRTHPLACE:
                    key = person.getBirthTown();
                    break;
            }
            int i = groupList.indexOf(new Group<>(key));
            Group<?> group = new Group<>(key);
            if (i < 0) {
                groupList.add(group);
            } else {
                group = groupList.get(i);
            }

            group.add(person);
        });

        return groupList;
    }

    public static Optional<Map<String, List<Person>>> groupByMisha3(Collection<Person> personList, Parameters parameters) {
        Map<String, List<Person>> result = new HashMap<>();
        personList.forEach(person -> {
            String key = null;
            switch (parameters) {
                case NAME:
                    key = person.getName();
                    break;
                case SURNAME:
                    key = person.getSurname();
                    break;
                case BIRTHPLACE:
                    key = person.getBirthTown();
                    break;
            }
            List<Person> people = result.get(key);
            if (people == null) {
                people = new ArrayList<>();
                result.put(key, people);
            }
            people.add(person);

        });
        return Optional.of(result);
    }

}