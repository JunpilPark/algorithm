import org.junit.Assert;
import org.junit.Test;

public class HashMapTest {


    private boolean isRange(int code) {
        if(code > 0 && code < HashMap.HASH_SIZE)
            return true;
        else
            return false;

    }

    @Test
    public void hashSizeTest() {
        HashMap<String, Integer> hashMap = new HashMap<>(null);
        hashMap.put("1", 100);
        hashMap.put("2", 200);
        hashMap.put("3", 300);
        hashMap.put("4", 400);
        hashMap.put("5", 500);
        hashMap.put("6", 600);
        hashMap.put("7", 600);
        hashMap.put("8", 600);
        hashMap.put("9", 600);
        hashMap.put("10", 600);
        hashMap.put("11", 600);
        hashMap.put("12", 600);
        hashMap.put("13", 600);
        hashMap.put("14", 600);
        hashMap.put("15", 600);

        Assert.assertEquals(hashMap.getSize(), 15);
    }

    @Test
    public void hash() {
    }
}