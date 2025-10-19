package calculator.compute;

import calculator.compute.strategy.CustomSeparator;
import calculator.compute.strategy.DefaultSeparator;
import calculator.compute.strategy.Separator;
import java.util.regex.Pattern;

/**
 * 입력 문자열에 맞는 {@link Separator}를 선택하고 분리 작업을 위임하는 클래스.
 */
public class OperatorSplit {
    private static final Pattern CUSTOM_INPUT_PATTERN = Pattern.compile("//(.*)\\\\n(.*)");
    private static final Separator DEFAULT = new DefaultSeparator();
    private static final Separator CUSTOM = new CustomSeparator();

    /**
     * 입력을 분석해 알맞은 구분자를 찾아 전략을 선택하고 문자열 분리 위임.
     *
     * @param input 원본 입력 문자열
     * @return 분리된 숫자 문자열 배열
     * @throws IllegalArgumentException 구분자 규칙이 유효하지 않은 경우
     */
    public static String[] split(String input) {
        Separator separator;
        if (isCustom(input)) {
            separator = CUSTOM;
        } else {
            separator = DEFAULT;
        }
        return separator.split(input);
    }

    /**
     * 커스텀 구분자를 사용하는지 확인
     *
     * @param input 원본 입력 문자열
     * @return 커스텀 구분자를 사용하면 true
     */
    private static boolean isCustom(String input) {
        return CUSTOM_INPUT_PATTERN.matcher(input).matches();
    }
}