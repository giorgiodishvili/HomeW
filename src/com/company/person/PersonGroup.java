package com.company.person;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PersonGroup {
     int a=3;
    public static void group(Collection<Person> personList, Parameters parameters) {
        if (parameters.getChoice().equals("birthplace")) {
            Map<Object, List<Person>> personGrouped =
                    personList.stream().collect(Collectors.groupingBy(Person::getBirthTown));

            for (Map.Entry<Object, List<Person>> entry : personGrouped.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        } else if (parameters.getChoice().equals("name")) {
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

}