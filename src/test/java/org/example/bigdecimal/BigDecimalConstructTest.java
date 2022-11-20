package org.example.bigdecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalConstructTest {

    @Test
    @DisplayName("BigDecimal double construct 테스트")
    public void BigDecimalConstructTest01() throws Exception {
        BigDecimal a = new BigDecimal(0.1);
        BigDecimal expected = new BigDecimal(0.1000000000000000055511151231257827021181583404541015625);
        Assertions.assertEquals(expected, a);
    }

    @Test
    @DisplayName("BigDecimal string construct 테스트")
    public void BigDecimalConstructTest02() throws Exception {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal expected = new BigDecimal("0.1");
        Assertions.assertEquals(expected, a);
    }
}
