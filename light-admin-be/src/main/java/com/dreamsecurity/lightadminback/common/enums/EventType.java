package com.dreamsecurity.lightadminback.common.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * EventType
 *
 * @author smmoon
 * @since 2025-04-04
 */
@Getter
@ToString
public enum EventType {
    LOGIN("LOGIN"),
    LOGOUT("LOGOUT"),
    CREATE("CREATE"),
    SEARCH("SEARCH"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    UNKNOWN("UNKNOWN");

    private String type;

    EventType(String type) {
        this.type = type;
    }
}
