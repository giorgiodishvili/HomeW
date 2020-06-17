package com.company;

import com.company.compare.CountryComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Country> datalist = new ArrayList<>();
        FileReader fr = new FileReader("/home/giorgi/country.csv");
        BufferedReader br = new BufferedReader(fr); //ციკლებს და რაღაცებს ისევ ეს ვარჩიე (გადაკეთება პრობლემა არაა :D) (( ფაილი შემოვიტანე ამით))
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // უსერ ინფუთი


        String line;
        line = br.readLine(); //სათაური წავაკითხე ჯერ ლისტში რო არ ჩაყრილიყო
        while (br.ready()) {         //(index out of bound ერრორს მიგდებდა და როგორც მივხვდი ფაილშია ცარიელი ხაზებო)
            // ვიცი ასე არ უნდა გამეკეთებინა მაგრამ ვერაფერი მოუხერხე ცარიელ ხაზებს :/ trim/isEmpty
            line = br.readLine();       //ფაილისთვის აქედან ვიწყებ კითხვას რეალურად
            if (line.length() != 0) {
                String[] values = line.split(",");
                int population = Integer.parseInt(values[1]);                //ვარჩიე ინტზე გადამეყვანა
                int area = Integer.parseInt(values[2]);                     //იგივე აქაც
                Country temp = new Country(values[0], population, area);
                datalist.add(temp);
            }
        }
        System.out.println("რომელი ველის მიხედვით გსურს რომ დავალაგო ქვეყნები?");
        System.out.println("1. სახელის მიხედვით");
        System.out.println("2. ფართობის მიხედვით");
        System.out.println("3. მოსახლეობის მიხედვით");
        String choice = reader.readLine();
        while (!choice.contentEquals("foo")) { //არასწორი მონაცემს თუ შემოიყვანს ეს ციკლი თავიდან შემოაყვანინებს
            // (ზოგადად ვარჩევდი ასარჩევებში მეოთხე ოფციის დამატებას "პროგრამიდან გამოსვლა/დასრულება)
            if (choice.contentEquals("1")) { //== არ ადარებდა კარგად და ეს ვარჩიე თან როგორც მივხვდი ზუსტად bufferreader ისთვის გამოიყენება
                CountryComparator.ByName ByName = new CountryComparator.ByName();
                datalist.sort(ByName);
                Collections.reverse(datalist); //ეს რახან ვიპოვე გამოვიყენე თორე ფორ ციკლით შემეძლო უკნიდან ამობეჭვდა
                System.out.println(datalist); //ესეთი ტიპის ამობეჭდა ვარჩიე კვლავ :დდ სილამაზისთვის For each შეიძლება
                choice = "foo";
            } else if (choice.contentEquals("2")) {
                CountryComparator.ByArea ByArea = new CountryComparator.ByArea();
                datalist.sort(ByArea);
                Collections.reverse(datalist);

                System.out.println(datalist);
                choice = "foo";
            } else if (choice.contentEquals("3")) {
                CountryComparator.ByPopulation ByPopulation = new CountryComparator.ByPopulation();
                datalist.sort(ByPopulation);
                Collections.reverse(datalist);

                System.out.println(datalist);
                choice = "foo";
            } else {
                System.out.println("გთხოვთ შემოიყვანოთ სწორი მონაცემი. (1,2,3) ");
                choice = reader.readLine();
            }
        }
    }
}
//მადლობა ყურადღებისთვის :დდ


