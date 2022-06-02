package item39;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {
    @ExceptionTestV2( {IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad(){
        List<String> list = new ArrayList<>();
        list.add(5,null);
    }

}
