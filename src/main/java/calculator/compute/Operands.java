package calculator.compute;

import calculator.domain.Numbers;
import java.util.ArrayList;
import java.util.List;

public class Operands { // 연산자 추출
    public static Numbers from(String[] numberStrings) { // 문자열을 리스트로 변환
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numberStrings) {
            numbers.add(Integer.parseInt(numberStr));
        }
        return new Numbers(numbers);
    }
}
