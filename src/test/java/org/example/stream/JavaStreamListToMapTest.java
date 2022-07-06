package org.example.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaStreamListToMapTest {

    @Test
    public void stream_list_to_map_테스트() {
        Member member = new Member("Lee", 30);
        Member member2 = new Member("Kim", 35);
        List<Member> list = new ArrayList<>(Arrays.asList(member, member2));


        Map<String, Integer> map = list
                .stream()
                .collect(Collectors.toMap(
                        i1 -> i1.getName(),
                        i2 -> i2.getAge())
                );

        assertThat(map.size()).isEqualTo(2);
        assertThat(map.get("Lee")).isEqualTo(30);
    }

    @Test
    public void stream_map_to_list_테스트() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Lee", 30);
        map.put("Kim", 35);

        List<Integer> values = map.entrySet()
                .stream().map(i -> i.getValue())
                .collect(Collectors.toList());

        assertThat(values.get(0)).isEqualTo(30);
    }


    public static class Member {
        private String name;
        private int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}