import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

  @org.junit.jupiter.api.Test
  void shouldCalculateForRegisteredAndUnderLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1000_60;
    boolean registered = true;
    long expected = 30;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    assertEquals(expected, actual);
  }

  @org.junit.jupiter.api.Test
  void shouldCalculateForRegisteredAndOverLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1_000_000_60;
    boolean registered = true;
    long expected = 500;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):

    assertEquals(expected, actual);
  }
  @org.junit.jupiter.api.Test
  void shouldCalculateForUnregisteredAndWithoutLimit() {
    BonusService service = new BonusService();
    // подготавливаем данные;
    long amount = 100_000;
    boolean registered = false;
    long expected = 30;

    //вызов целевого метода;
    long actual = service.calculate(amount, registered);

    assertEquals(expected, actual);
  }
  @org.junit.jupiter.api.Test
  void shouldCalculateForTooBigAmountAndUnregisteredAndOverLimit() {
    BonusService service = new BonusService();
    // подготавливаем данные;
    long amount = 100_000_000;
    boolean registered = false;
    long expected = 500_00;

    //вызов целевого метода;
    long actual = service.calculate(amount, registered);

    assertEquals(expected, actual);
  }
}