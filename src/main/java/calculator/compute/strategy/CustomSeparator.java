package calculator.compute.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {
    private static final Pattern CUSTOM_SEPARATOR = Pattern.compile("//(.*)\\\\n(.*)");
    private static final Pattern INVALID_CUSTOM = Pattern.compile("(.*[ \t\n\r\f\u000B].*)|(.*\\d.*)");

    private static void validateCustom(String custom) { // 커스텀 구분자의 유효성
        if (custom == null || custom.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 존재한다면 비어있을 수 없습니다.");
        }
        if (INVALID_CUSTOM.matcher(custom).matches()) {
            throw new IllegalArgumentException("커스텀 구분자는 공백이나 숫자를 포함할 수 없습니다.");
        }
    }

    private static void validateInput(String input, String separator) { // 입력 유효성
        String quotedDelimiter = Pattern.quote(separator);
        String consecutiveRegex = "(.*)" + quotedDelimiter + quotedDelimiter + "(.*)";
        String trailingRegex = "(.*)" + quotedDelimiter + "$";
        Pattern invalidPattern = Pattern.compile(consecutiveRegex + "|" + trailingRegex);
        if (invalidPattern.matcher(input).matches()) {
            throw new IllegalArgumentException("구분자가 연속으로 사용되거나 문자열의 마지막에 위치할 수 없습니다.");
        }
    }

    @Override
    public String[] split(String input) {
        Matcher matcher = CUSTOM_SEPARATOR.matcher(input);
        if (matcher.matches()) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자 형식입니다.");
        }
        String custom = matcher.group(1);
        String numbers = matcher.group(2);
        validateCustom(custom);
        validateInput(numbers, custom);
        if (numbers.isEmpty()) {
            return new String[0];
        }
        return numbers.split(Pattern.quote(custom));

    }
}
