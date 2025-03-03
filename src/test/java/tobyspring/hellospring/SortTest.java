package tobyspring.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    Sort sort;

    @BeforeEach
    void beforeEach() {
        sort = new Sort();
        System.out.println(this);
    }

    @DisplayName("길이가 짧은 문자열부터 오름차순 정렬한다.")
    @Test
    void sort(){
     //given

     //when
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        //then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("b", "aa"));
    }

    @DisplayName("3개의 문자열을 길이에 따라 오름차순 정렬한다.")
    @Test
    void sort3Items(){
     //given

     //when
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));

     //then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("b", "aa", "ccc"));
    }

    @DisplayName("이미 정렬된 3개의 문자열을 길이에 따라 오름차순 정렬한다.")
    @Test
    void sortAlreadySorted(){
        //given

        //when
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));

        //then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("b", "aa", "ccc"));
    }
}