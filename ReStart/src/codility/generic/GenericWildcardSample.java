package codility.generic;

public class GenericWildcardSample {
    public static void main(String[] args) {
        GenericWildcardSample sample = new GenericWildcardSample();
        WildcardGeneric<String> gen = new WildcardGeneric<>();
        sample.genericMethod(gen,"ddd");    
    }
    //메서드 타입에서 T 제네릭 사용을 봐야함
    public <T> void genericMethod(WildcardGeneric<T> c, T data){
        c.setWildcard(data);
        
        // T value = c.getWildcard();
        System.out.println(c.getWildcard());
    }
}
