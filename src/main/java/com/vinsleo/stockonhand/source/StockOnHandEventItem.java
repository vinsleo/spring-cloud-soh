package com.vinsleo.stockonhand.source;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "dc",
        "sku",
        "summary_transaction",
        "stock_type",
        "event_ts",
        "units"
})
public class StockOnHandEventItem {
    private int dc;
    private int sku;
    private int units;

    private int summary_transaction;
    private int stock_type;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime event_ts;
}
