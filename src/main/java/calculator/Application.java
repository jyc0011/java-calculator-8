package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.*)\\\\n(.*)");
    private static final Pattern INVALID_DEFAULT_PATTERN = Pattern.compile("(.*[:,][:,].*)|(.*[:,]$)");

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculate(input);
        System.out.println("결과 : " + result);
        Console.close();
    }

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numberStrings;
        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numberInput = matcher.group(2);
            if (customDelimiter.isEmpty() || customDelimiter.matches(".*[\\s\\d].*")) {
                throw new IllegalArgumentException();
            }

            String quotedDelimiter = Pattern.quote(customDelimiter);
            if (!numberInput.isEmpty() && numberInput.matches(
                    "(.*)" + quotedDelimiter + quotedDelimiter + "(.*)|(.*)" + quotedDelimiter + "$")) {
                throw new IllegalArgumentException();
            }
            numberStrings = numberInput.split(quotedDelimiter);

        } else {
            if (INVALID_DEFAULT_PATTERN.matcher(input).matches()) {
                throw new IllegalArgumentException();
            }
            numberStrings = input.split("[,:]");
        }

        return sumNumbers(numberStrings);
    }

    private static int sumNumbers(String[] numberStrings) {
        int sum = 0;
        for (String numStr : numberStrings) {
            if (numStr.isEmpty()) {
                continue;
            }

            int number;
            try {
                number = Integer.parseInt(numStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }
        return sum;
    }
}