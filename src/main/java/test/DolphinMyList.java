package test;

import java.util.ArrayList;
import java.util.List;

public class DolphinMyList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // allowed to have empty angel brackets
        list.add("Lukasz S.");
        list.add("Lukasz B.");
        list.add("Lukasz P.");

        System.out.println(list);
        System.out.println(list.get(0));

//        String name2 = list.get(2);         // ynocompile
//        String name2 = (String) list.get(2);
        String name3 = "test " + list.get(2);

        System.out.println(name3);

//        list.add(LocalDateTime.now());        // finally we can not put it in
        System.out.println(list);

        List<Integer> shoeSizes = new ArrayList<>();
//        shoeSizes.add("one");
        shoeSizes.add(38);
        shoeSizes.add(42);

        for (Integer size : shoeSizes) {
            if (size == 42) {
                System.out.println("It contains the meaning of life");
            } else {
                System.out.println("It does not contain the meaning of life");
            }
        }

    }
}
