package tobyspring.hellospring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRateData(
        @JsonProperty("result") String result,
        @JsonProperty("rates") Map<String, BigDecimal> rates) {
}

