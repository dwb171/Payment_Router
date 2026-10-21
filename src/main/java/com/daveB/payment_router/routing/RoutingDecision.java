package com.daveB.payment_router.routing;

import com.daveB.payment_router.rail.PaymentRail;

/** rail chosen and why */
public record RoutingDecision(
        PaymentRail rail,
        String reason
) {
}
