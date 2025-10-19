package calculator.compute.strategy;

/**
 * 문자열 분리 전략 정의
 */
public interface Separator {
    String[] split(String input);
}