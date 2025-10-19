package calculator.compute;

import calculator.domain.Numbers;
import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 배열을 {@link Numbers} 도메인 객체로 변환하는 클래스. 변환 과정에서 숫자 형식 유효성 검사.
 */
public class Operands {
    /**
     * 문자열 배열(String[])을 {@link Numbers} 도메인 객체로 변환.
     *
     * @param numberStrings 숫자 문자열 배열
     * @return 유효성 검사가 완료된 {@code Numbers} 객체
     * @throws IllegalArgumentException 숫자가 아닌 값(공백, 소수점 등)이 포함되었거나, 음수가 포함된 경우 ({@code Numbers} 생성자)
     */
    public static Numbers from(String[] numberStrings) { // 문자열을 리스트로 변환
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numberStrings) {
            if (numberStr.isEmpty()) {
                continue;
            }
            try {
                numbers.add(Integer.parseInt(numberStr));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력값에 구분자를 제외하고 숫자가 아닌 문자(공백, 소수점 등)가 포함되었습니다.", e);
            }
        }
        return new Numbers(numbers);
    }
}
