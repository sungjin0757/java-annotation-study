package item39;

import java.util.ArrayList;
import java.util.List;

public class Sample4 {
    @ExceptionTestV3(IndexOutOfBoundsException.class)
    @ExceptionTestV3(NullPointerException.class)
    public static void doublyBad(){
        List<String> list = new ArrayList<>();
        list.add(5,null);
    }

}
