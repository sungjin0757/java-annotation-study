package item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Sample4Test {
    public static void main(String[] args) throws Exception{
        int tests=0;
        int passed=0;

        Class<?> testClass = Class.forName("item39.Sample4");

        for (Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(ExceptionTestV3.class) ||
                    m.isAnnotationPresent(ExceptionTestContainer.class)){
                tests++;
                try{
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패 : 예외를 던지지 않음%n", m);
                }catch (InvocationTargetException wrappedExc){
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionTestV3[] excTests = m.getAnnotationsByType(ExceptionTestV3.class);
                    for( ExceptionTestV3 excTest : excTests){
                        if(excTest.value().isInstance(exc)){
                            passed++;
                            break;
                        }
                    }
                    if(passed==oldPassed){
                        System.out.printf("테스트 %s 실패 : 발생한 예외 %s%n",m,
                                exc);
                    }
                }catch (Exception exc){
                    System.out.println("잘못 사용한 @Test: "+m);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n",passed,tests-passed);
    }
}
