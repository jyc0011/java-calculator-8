package calculator.compute;

import java.util.List;

public class Adder { // 더하기
    public static int sum(List<Integer> numbers) { // 리스트의 모든 수를 더한다.
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
