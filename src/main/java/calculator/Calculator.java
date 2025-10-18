package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) { // 구분자가 있는 경우
            return 0;
        }
    }
}
