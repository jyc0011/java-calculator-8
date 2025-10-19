package calculator.compute;

import calculator.domain.Numbers;

/**
 * {@link Numbers} 객체의 합을 계산하는 클래스.
 */
public class Adder {
    /**
     * {@link Numbers} 객체 내부의 정수 리스트를 전부 더함.
     *
     * @param numbers 덧셈을 수행할 {@code Numbers} 객체
     * @return 합계
     */
    public static int sum(Numbers numbers) {
        int total = 0;
        for (int number : numbers.getList()) {
            total += number;
        }
        return total;
    }
}
