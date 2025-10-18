package calculator.compute;

import java.util.ArrayList;
import java.util.List;

public class Operands { // 연산자 추출
    public static List<Integer> from(String[] numberStrings) { // 문자열을 리스트로 변환
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numberStrings) {
            numbers.add(Integer.parseInt(numberStr));
        }
        return numbers;
    }
}
