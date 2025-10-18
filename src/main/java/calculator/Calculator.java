package calculator;

import calculator.compute.Adder;
import calculator.compute.Operands;
import calculator.compute.OperatorSplit;
import java.util.List;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        try {
            String[] numberStrings = OperatorSplit.split(input); // 입력으로부터 숫자 문자열 추출 (커스텀 구분자도 추출해야함.)
            List<Integer> numbers = Operands.from(numberStrings);// 문자열서 숫자 리스트로
            return Adder.sum(numbers);
        } catch (NumberFormatException e) { // 구분자가 있는 경우
            return 0;
        }
    }
}
