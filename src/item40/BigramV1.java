package item40;

import java.util.HashSet;
import java.util.Set;

public class BigramV1 {
    private final char first;
    private final char second;

    public BigramV1(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public boolean eqauls(BigramV1 b) {
        return b.first == first && b.second == second;
    }

    public int hashcode(){
        return 31 * first + second;
    }

    public static void main(String[] args){
        Set<BigramV1> s = new HashSet<>();
        for(int i=0 ; i < 10 ; i++){
            for(char ch = 'a' ; ch <= 'z' ; ch++){
                s.add(new BigramV1(ch, ch));
            }
        }

        // 위의 코드에서 equals 는 Overriding 이 아닌 Overloading 되었기 때문에 equals 가 먹지 않는다.
        // 따라서, set 의 equals 및 hashcode 가 먹지 않는다.
        System.out.println(s.size());
    }

}
