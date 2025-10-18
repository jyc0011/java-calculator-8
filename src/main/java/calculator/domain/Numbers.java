package calculator.domain;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }

    public List<Integer> getList() {
        return numbers;
    }
}
