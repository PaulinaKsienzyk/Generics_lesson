package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListTool {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Lukasz S.");
        list.add("Lukasz B.");
        list.add("Lukasz P.");

        System.out.println(list);
        System.out.println(list.get(0));

//        String name2 = list.get(2);         // ynocompile
        String name2 = (String) list.get(2);
        String name3 = "test " + list.get(2);

        System.out.println(name3);

        list.add(LocalDateTime.now());        // yucompile

        

    }
}
