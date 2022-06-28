package org.example.stream;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamListMaxTest {

    private List<TestIO> list = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        TestIO io = new TestIO("test1", 1000L);
        TestIO io2 = new TestIO("test2", 2000L);

        list.add(io);
        list.add(io2);
    }

    @Test
    public void LIST_값_중_가장큰객체출력_테스트 () throws Exception {
        TestIO testIO = list.stream()
                .filter(io -> StringUtils.hasText(io.getName()))
                .max(Comparator.comparing(TestIO::getAmount))
                .orElseThrow(NoSuchElementException::new);
        Assertions.assertEquals(2000, testIO.getAmount());
    }

    public static class TestIO {
        private String name;
        private Long amount;

        public String getName() {
            return name;
        }

        public Long getAmount() {
            return amount;
        }

        public TestIO(String name, Long amount) {
            this.name = name;
            this.amount = amount;
        }
    }



}
