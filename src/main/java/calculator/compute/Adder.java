package calculator.compute;

import calculator.domain.Numbers;

public class Adder { // 더하기
    public static int sum(Numbers numbers) { // 리스트의 모든 수를 더한다.
        int total = 0;
        for (int number : numbers.getList()) {
            total += number;
        }
        return total;
    }
}
