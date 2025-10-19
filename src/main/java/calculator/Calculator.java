package calculator;

import calculator.compute.Adder;
import calculator.compute.Operands;
import calculator.compute.OperatorSplit;
import calculator.domain.Numbers;

/**
 * 문자열 분리, 구분자 추출, 문자열->숫자 변환&검증, 덧셈 수행
 */
public class Calculator {
    /**
     * 입력된 문자열을 기반으로 덧셈 수행
     *
     * @param input 덧셈할 문자열 (예: "1,2", "//;\\n1;2")
     * @return 결과 (int)
     * @throws IllegalArgumentException 입력 형식이 유효하지 않은 경우
     */
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numberStrings = OperatorSplit.split(input); // 입력으로부터 숫자 문자열 추출 (커스텀 구분자도 추출해야함.)
        Numbers numbers = Operands.from(numberStrings);// 문자열서 숫자 리스트로
        return Adder.sum(numbers); // 리스트 생성 후 더하기
    }
}
