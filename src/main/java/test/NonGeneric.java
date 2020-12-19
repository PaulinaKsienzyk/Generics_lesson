package test;

import java.util.ArrayList;
import java.util.List;

public class NonGeneric {
    // verify that there is no casting in generics

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("something to get out");
        CharSequence s = list.get(0);
    }
}
