package com.company.person;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

}