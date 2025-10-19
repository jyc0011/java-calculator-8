package calculator.compute.strategy;

import java.util.regex.Pattern;

/**
 * 기본 구분자(,) 또는 (:)를 처리
 */
public class DefaultSeparator implements Separator {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final Pattern INVALID_DEFAULT = Pattern.compile("(.*[:,][:,].*)|(.*[:,]$)");

    /**
     * 유효성 검사. 연속 여부, 마지막에 배치 여부. 정규식 이용.
     */
    private static void validateDefault(String input) {
        if (INVALID_DEFAULT.matcher(input).matches()) {
            throw new IllegalArgumentException("구분자가 연속으로 사용되거나 문자열의 마지막에 위치할 수 없습니다.");
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * 기본 구분자(,) 또는 (:)를 기준으로 문자열을 분리
     */
    @Override
    public String[] split(String input) {
        validateDefault(input);
        return input.split(DEFAULT_SEPARATOR);
    }
}