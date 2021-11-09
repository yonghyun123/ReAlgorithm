package codility.generic;

import java.io.Serializable;

public class CastingGenericDTO<T> implements Serializable{
    private T object;
    public void setObject(T obj){
        this.object = obj;
    }
    public T getObject(){
        return this.object;
    }
}
class GenericSample{
    public static void main(String[] args) {
        GenericSample sample = new GenericSample();
        sample.checkGenericDTO();
    }

    public void checkGenericDTO(){
        CastingGenericDTO<String> dto1 = new CastingGenericDTO<>();
        dto1.setObject(new String());
        
    }
}
