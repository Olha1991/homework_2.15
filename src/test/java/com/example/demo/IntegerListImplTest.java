package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerListImplTest {
    private final IntegerList integerList = new IntegerListImpl();

    @AfterEach
    public void afterEach(){
        integerList.clear();
    }

    @Test
    public void addTest(){
        Integer[] elements = {1,2, 3,4};
        add(elements);
        for(int i = 0; i < elements.length; i++){
            assertThat(integerList.get(i)).isEqualTo(elements[i]);
            assertThat(integerList.contains(elements[i])).isTrue();
            assertThat(integerList.indexOf(elements[i])).isEqualTo(i);
            assertThat(integerList.lastIndexOf(elements[i])).isEqualTo(i);
        }
        assertThat(integerList.toArray()).hasSize(elements.length);
        assertThat(integerList.toArray()).containsExactly(elements);
    }

    @Test
    public void addByIndexTest() {
        Integer[] elements = {1, 2, 3, 4};
        add(elements);

        integerList.add(0, 6);
        assertThat(integerList.size()).isEqualTo(elements.length + 1);
        assertThat(integerList.get(0)).isEqualTo(6);



        integerList.add(3, 6);
        assertThat(integerList.size()).isEqualTo(elements.length + 2);
        assertThat(integerList.get(3)).isEqualTo(6);
        assertThat(integerList.lastIndexOf(6)).isEqualTo(3);
        assertThat(integerList.indexOf(6)).isEqualTo(0);

        integerList.add(5, 6);
        assertThat(integerList.size()).isEqualTo(elements.length + 3);
        assertThat(integerList.get(5)).isEqualTo(6);
        assertThat(integerList.lastIndexOf(6)).isEqualTo(5);
        assertThat(integerList.indexOf(6)).isEqualTo(0);


    }

    private void add(Integer[] elements){
        assertThat(integerList.isEmpty()).isTrue();
        Stream.of(elements).forEach(integerList :: add);
        assertThat(integerList.size()).isEqualTo(elements.length);

    }
}