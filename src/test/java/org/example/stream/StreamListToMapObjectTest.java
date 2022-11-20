package org.example.stream;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamListToMapObjectTest {

    @Test
    @DisplayName("list를Map<String, DTO> 변환")
    public void streamListToMapObjectTest01() throws Exception {
        List<DtoA> list = new ArrayList<>();
        list.add(new DtoA("key1", "bcde"));
        list.add(new DtoA("key2", "bcde123"));

        Map<String, DtoB> map =
                list.stream().map(a -> new DtoB(a.getKey(), a.getValue()))
                        .collect(Collectors.toMap(DtoB::getKey, Function.identity()));
        Assertions.assertEquals(2, map.keySet().size());
        Assertions.assertEquals("bcde", map.get("key1").getValue());
        Assertions.assertEquals("key1", map.get("key1").getKey());
    }


    private static class DtoA {
        private String key;
        private String value;

        public DtoA(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    private static class DtoB {
        private String key;
        private String value;

        public DtoB(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
