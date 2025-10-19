package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 문자열 덧셈 계산기의 진입점
 */
public class Application {
    /**
     * 사용자로부터 입력을 받고, 계산 결과를 출력합니다.
     */
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = Calculator.add(input);
        System.out.println("결과 : " + result);
        Console.close();
    }
}
