package item39;

public class Sample {
    @Test
    public static void m1(){
        // 성공
    }

    public static void m2(){

    }

    @Test
    public static void m3(){
        throw new RuntimeException("실패");
    }

    @Test
    public void m5(){
        // 실패 해야 한다.
    }

    public static void m6(){

    }

    @Test
    public static void m7(){
        throw new RuntimeException("실패");
    }

    public static void m8(){

    }
}
