package calculator.compute;

import calculator.compute.strategy.CustomSeparator;
import calculator.compute.strategy.DefaultSeparator;
import calculator.compute.strategy.Separator;
import java.util.regex.Pattern;

public class OperatorSplit { // 숫자 문자열을 리스트로 변환
    public static String[] split(String input) {
        Separator separator;
        if (isCustom(input)) {
            separator = new CustomSeparator();
        } else {
            separator = new DefaultSeparator();
        }
        return separator.split(input);
    }

    private static boolean isCustom(String input) {
        Pattern CUSTOM_INPUT_PATTERN = Pattern.compile("//(.*)\\\\n(.*)");
        return CUSTOM_INPUT_PATTERN.matcher(input).matches();
    }
}