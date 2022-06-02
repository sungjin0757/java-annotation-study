package item39;

import java.lang.annotation.*;

/**
 * 명시한 예외를 던져야만 성공하는 테스트
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTestV3 {
    Class<? extends Throwable> value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExceptionTestContainer{
    ExceptionTestV3[] value();
}
