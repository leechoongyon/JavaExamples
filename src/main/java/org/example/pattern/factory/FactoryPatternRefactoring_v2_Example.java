package org.example.pattern.factory;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FactoryPatternRefactoring_v2_Example {
    public static void main(String[] args) {
        SportInstance sportInstance = SportInstance.findSportInstance(SportInstance.SOCCER.getCode());
        System.out.println(sportInstance.getSupplier().get());
    }

    @Getter
    private enum SportInstance {
        SOCCER("SOCCER", () -> "play soccer..."),
        BASEBALL("BASEBALL", () -> "play baseball..."),
        ;

        private static Map<String, SportInstance> instanceMap =
                Arrays.stream(SportInstance.values()).collect(Collectors.toMap(o -> o.getCode(), o -> o));

        private String code;
        private Supplier<String> supplier;


        SportInstance(String code, Supplier supplier) {
            this.code = code;
            this.supplier = supplier;
        }

        private static SportInstance findSportInstance(String sportTypeCd) {
            return Optional.ofNullable(instanceMap.get(sportTypeCd))
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
