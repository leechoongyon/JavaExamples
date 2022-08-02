package org.example.pattern.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class FactoryPatternExample {

    public static void main(String[] args) {
        Sport sport = getSport(SportTypeCd.SOCCER);
        sport.play();
    }

    public static Sport getSport(SportTypeCd sportTypeCd) {
        if (SportTypeCd.BASEBALL.equals(sportTypeCd)) {
            return new Baseball();
        } else if (SportTypeCd.SOCCER.equals(sportTypeCd)) {
            return new Soccer();
        } else {
            throw new IllegalArgumentException(String.format("invalid sportTypeCd : ", sportTypeCd));
        }
    }


    @Getter
    @RequiredArgsConstructor
    public enum SportTypeCd {
        SOCCER("SOCCER", "축구"),
        BASEBALL("BASEBALL", "야구")
        ;

        private final String code;
        private final String desc;
    }

}
