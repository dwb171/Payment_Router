package com.daveB.payment_router.rail;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentRailTest {

    @Test
    void hasThreeRails() {
        // Act: get all the enum values (hint: you saw this in RailController)
        PaymentRail[] rails = PaymentRail.values();

        // Assert: check how many there are
        assertThat(rails).hasSize(3);
    }
}