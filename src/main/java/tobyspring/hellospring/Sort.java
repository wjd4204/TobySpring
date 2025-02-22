package tobyspring.hellospring;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void main(String[] args) {

        List<Integer> scores = Arrays.asList(5,7,1,9,2,8);
        Collections.sort(scores, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });

        scores.forEach(System.out::println);
    }
}
