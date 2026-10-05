package com.daveB.payment_router.rail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(RailController.class)
class RailControllerTest {

    @Autowired
    MockMvcTester mvc;

    @Test
    void listRailsReturnsAllRails() {
        assertThat(mvc.get().uri("/api/v1/rails"))      // 1. which URL?
                .hasStatus(200)                         // 2. assert the HTTP status is 200 (type .hasStatus and see what autocomplete offers)
                .bodyJson()
                .isStrictlyEqualTo("""
                        ["ACH","WIRE","RTP"]
                        """);                     // 3. the exact JSON you saw in the browser
    }
}