package com.company;


import com.company.person.Parameters;
import com.company.person.Person;
import com.company.person.PersonGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Person> personlist = new ArrayList<Person>();
        personlist.add(new Person("Max", "Max", "California"));
        personlist.add(new Person("Andrew", "Andrew", "Los Angeles"));
        personlist.add(new Person("1726", "John", "New York"));
        personlist.add(new Person("5223", "Michael", "New York"));
        personlist.add(new Person("7765", "Sam", "California"));
        personlist.add(new Person("3442", "Max", "New York"));


        new PersonGroup().group(personlist, Parameters.SURNAME);
new PersonGroup().a=2;
    }

    public static int fun(String str) {
        int ans = Pattern.compile(",")
                .splitAsStream(str)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        return ans;
//         int ans=0;
//        String[] split = s.split(",");
//        for(int i=0;i<split.length;i++){
//            int temp=Integer.parseInt(split[i]);
//            ans+=temp;
//        }
//        return ans;
    }

}
//მადლობა ყურადღებისთვის :დდ


