package org.example.pattern.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class FactoryPatternRefactoringExample {

    private static Map<SportTypeCd, Sport> map = new HashMap<>();
    static {
        map.put(SportTypeCd.SOCCER, new Soccer());
        map.put(SportTypeCd.BASEBALL, new Baseball());
    }

    public static void main(String[] args) {
        Sport sport = getSport(SportTypeCd.SOCCER);
        sport.play();
    }

    public static Sport getSport(SportTypeCd sportTypeCd) {
        return map.get(sportTypeCd);
    }


    @Getter
    @RequiredArgsConstructor
    private enum SportTypeCd {
        SOCCER("SOCCER", "축구"),
        BASEBALL("BASEBALL", "야구")
        ;

        private final String code;
        private final String desc;
    }
}
