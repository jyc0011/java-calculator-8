package calculator.compute;

import calculator.domain.Numbers;
import java.util.ArrayList;
import java.util.List;

public class Operands { // 연산자 추출
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
