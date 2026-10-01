package com.daveB.payment_router.rail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rails")
public class RailController {

    @GetMapping
    public List<PaymentRail> listRails() {
        return List.of(PaymentRail.values());
    }
}
