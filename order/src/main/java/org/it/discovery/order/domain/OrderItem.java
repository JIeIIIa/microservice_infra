package org.it.discovery.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderItem {
    private final int bookId;

    private final int number;
}
