package org.example.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamWithExceptionTest {

    @Test
    public void stream_내에서_RuntimeException_테스트() {
        String[] strings = new String[] {"hello", "world", "hi"};
        List<String> list = Arrays.asList(new String[]{"abcde", "test", "abc"});

        Assertions.assertThrows(IllegalStateException.class, () -> {
            Arrays.asList(strings).stream().filter(str -> !list.contains(str))
                    .findFirst().ifPresent(str -> {
                        throw new IllegalStateException();
                    });
        } );
    }

    @Test
    public void stream_내에서_CheckedException_발생_테스트() {
        List<String> result =
                Arrays.stream(new String[]{"테스트1", "테스트2"})
                        .map(wrap(s -> URLEncoder.encode(s, Charset.defaultCharset().name())))
                        .collect(Collectors.toList());
        Assertions.assertEquals(2, result.size());
    }

    @FunctionalInterface
    private interface FunctionWithException<T, R, E extends Exception> {
        R apply(T t) throws E;
    }

    private <T, R, E extends Exception> Function<T, R> wrap(FunctionWithException<T, R, E> f) {
        return arg -> {
            try {
                return f.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
