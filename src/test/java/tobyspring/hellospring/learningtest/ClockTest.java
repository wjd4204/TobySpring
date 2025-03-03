package tobyspring.hellospring.learningtest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockTest {

    // Clock을 이용하여 LocalDateTime.now()를 가져올 수 있나?
    @Test
    void clock(){
        Clock clock = Clock.systemDefaultZone();

        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        // dt1보다 dt2가 더 나중이라는 검증
        Assertions.assertThat(dt2).isAfter(dt1);
    }

    // Clock을 Test에서 사용할 때 내가 원하는 시간을 지정해서 현재 시간을 가져오게 할 수 있는가?
    @Test
    void fixedClock(){
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        Assertions.assertThat(dt2).isEqualTo(dt1);
    }

}
