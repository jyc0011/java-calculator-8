package calculator.compute.strategy;

import java.util.regex.Pattern;

public class DefaultSeparator implements Separator {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final Pattern INVALID_DEFAULT = Pattern.compile("(.*[:,][:,].*)|(.*[:,]$)");

    private static void validateDefault(String input) { // 정규식 검증
        if (INVALID_DEFAULT.matcher(input).matches()) {
            throw new IllegalArgumentException("구분자가 연속으로 사용되거나 문자열의 마지막에 위치할 수 없습니다.");
        }
    }

    @Override
    public String[] split(String input) {
        validateDefault(input);
        return input.split(DEFAULT_SEPARATOR);
    }
}