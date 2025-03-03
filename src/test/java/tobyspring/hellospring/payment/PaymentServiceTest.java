package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tobyspring.hellospring.exrate.WebApiExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @DisplayName("prepare 메소드가 요구사항 3가지를 잘 충족했는지 검증한다.")
    @Test
    void prepare() throws IOException {
     //given
        PaymentService paymentService = new PaymentService(new WebApiExRateProvider());

     //when
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

     //then
        // 환율정보 가져오기
        assertThat(payment.getExRate()).isNotNull();
        // 원화 환산 금액 계산하기
        assertThat(payment.getConvertedAmount())
                .isEqualTo(payment.getExRate().multiply(payment.getForeignCurrencyAmount()));
        // 원화 환상 금액 유효시간 계산하기
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));

    }

}