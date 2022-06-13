package item40;

import java.util.HashSet;
import java.util.Set;

/**
 * override 가 일관되게 달려 있어야 실수할 가능성이 줄어듬.
 */
public class BigramV2 {
    private final char first;
    private final char second;

    public BigramV2(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this){
            return true;
        }
        if(!(o instanceof BigramV2))
            return false;
        BigramV2 b = (BigramV2) o;
        return b.first == first && b.second == second;
    }

    @Override
    public int hashCode(){
        return 31 * first + second;
    }

    public static void main(String[] args){
        Set<BigramV2> s = new HashSet<>();
        for(int i=0 ; i < 10 ; i++){
            for(char ch = 'a' ; ch <= 'z' ; ch++){
                s.add(new BigramV2(ch, ch));
            }
        }

        // 위의 코드에서 equals 는 Overriding 이 아닌 Overloading 되었기 때문에 equals 가 먹지 않는다.
        // 따라서, set 의 equals 및 hashcode 가 먹지 않는다.
        System.out.println(s.size());
    }

}
