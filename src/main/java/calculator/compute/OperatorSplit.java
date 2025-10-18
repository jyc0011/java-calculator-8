package calculator.compute;

public class OperatorSplit { // 숫자 문자열을 리스트로 변환
    private static final String DEFAULT_SEPARATOR = "[,:]";

    // TODO : 커스텀 구분자 내용, 구분자로 끝이 나면 오류를 출력.

    public static String[] split(String input) {
        return input.split(DEFAULT_SEPARATOR);
    }
}