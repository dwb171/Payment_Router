package com.daveB.payment_router.routing;

public enum Urgency {
    /** within seconds */
    INSTANT,
    /** by EOD */
    SAMEDAY,
    /** next business day or later */
    STANDARD
}
