package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;

import static java.lang.String.valueOf;

public class PaymentTest {

    @DisplayName("Payment를 해당 도메인 클래스에서 생성하고 검증합니다.")
    @Test
    void createPrepared(){
     //given
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        Payment payment = Payment.createPrepared(1L, "USD",
                BigDecimal.TEN, BigDecimal.valueOf(1_000), LocalDateTime.now(clock));

     //when

     //then
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(valueOf(10_000));
        Assertions.assertThat(payment.getValidUntil()).isEqualTo(LocalDateTime.now(clock).plusMinutes(30));
    }

    @DisplayName("")
    @Test
    void isValid(){
     //given
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        Payment payment = Payment.createPrepared(
                1L, "USD", BigDecimal.TEN, BigDecimal.valueOf(1_000), LocalDateTime.now(clock));

     //when

     //then
        Assertions.assertThat(payment.isValid(clock)).isTrue();
        Assertions.assertThat(payment.isValid(Clock.offset(clock, Duration.of(30, ChronoUnit.MINUTES))))
                .isFalse();
    }
}
