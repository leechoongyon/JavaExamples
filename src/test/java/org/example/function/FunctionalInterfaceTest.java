package org.example.function;

import java.util.function.BiPredicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTest {

    @Test
    public void functionalInterfaceTest01() throws Exception {
        FunctionalInterfaceSample func = message -> System.out.println(message);
        func.helloWorld("HelloWorld...");
    }

    @Test
    public void supplierFunctionalInterfaceTest() throws Exception {
        Supplier<String> getMessage = () -> "Hello World...";
        Assertions.assertEquals("Hello World...", getMessage.get());
    }

    @Test
    public void consumerFunctionalInterfaceTest() throws Exception {
        Consumer<String> setMessage = message -> System.out.println(message);
        setMessage.accept("Hello World...");
    }

    @Test
    public void functionFuntionalInterfaceTest() throws Exception {
        Function<String, String> appendPrefixSuffix = (str) -> "###" + str + "###";
        Assertions.assertEquals("###Hello World###", appendPrefixSuffix.apply("Hello World"));

    }

    @Test
    public void predicateFunctionalInterfaceTest() throws Exception {
        Predicate<String> isEqualsHelloWorld = message -> message.equals("Hello World");
        Assertions.assertEquals(true, isEqualsHelloWorld.test("Hello World"));
        Predicate<String> isNotEqualsHelloWorld = isEqualsHelloWorld.negate();
        Assertions.assertEquals(true, isNotEqualsHelloWorld.test("Hello..."));
    }

    @Test
    void biPredicateFunctionalInterfaceTest() {
        BiPredicate<String, String> biPredicate = (x, y) -> {
            return x.equals(y);
        };
        Assertions.assertEquals(true, biPredicate.test("Hello World", "Hello World"));
    }

    public interface FunctionalInterfaceSample {
        public abstract void helloWorld(String message);
    }
}
