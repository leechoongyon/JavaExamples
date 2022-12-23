package org.example.function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapMethodTest {

    @org.junit.jupiter.api.Test
    @DisplayName("LIST_를_MAP_으로_변환하는_메소드_테스트")
    public void listToMapMethodTest01 () throws Exception {
        Test test = new Test("test", "etc");
        Test test2 = new Test("test2", "etc2");
        List<Test> list = new ArrayList<>();
        list.add(test);
        list.add(test2);
        Map<String, Test> map = convertListToMap(list,  Test::getName);
        Assertions.assertEquals(2, map.size());
        Assertions.assertEquals("etc2", map.get("test2").getEtc());
    }

    public static <K, T> Map<K, T> convertListToMap(List<T> list,
                                           Function<? super T, ? extends K> mapper) {
        return list.stream().collect(Collectors.toMap(mapper, Function.identity()));
    }

    public static class Test {
        private String name;
        private String etc;

        public Test(String name, String etc) {
            this.name = name;
            this.etc = etc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEtc() {
            return etc;
        }

        public void setEtc(String etc) {
            this.etc = etc;
        }
    }
}
