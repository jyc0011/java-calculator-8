package calculator.domain;

import java.util.List;

/**
 * 정수 리스트를 캡슐화하고 유효성을 검사.
 */
public class Numbers {
    private final List<Integer> numbers;

    /**
     * 정수 리스트를 받아 유효성 검사 수행, {@code Numbers} 객체 생성
     *
     * @param numbers 변환된 정수 리스트
     * @throws IllegalArgumentException 리스트에 음수가 포함된 경우
     */
    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 유효성 검사가 완료된 리스트 반환
     *
     * @return 덧셈에 사용될 정수 리스트
     */
    public List<Integer> getList() {
        return numbers;
    }

    /**
     * 예외 처리. 음수 입력 X
     */
    private void validate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }
}
