import java.util.ArrayList;

public class HashMap<K, V> {

    public static final int HASH_SIZE = 255;
    private ArrayList<Data>[] hashTable = new ArrayList[HASH_SIZE];
    private HashFuntion<K> mHashFuntion;

    public HashMap(HashFuntion<K> hashFuntion) {
        this.mHashFuntion = hashFuntion;
        for (int i = 0; i < HASH_SIZE ; i++) {
            hashTable[i] = new ArrayList<>();
        }
    }

    public void put(K key, V value) {
        int index = (int)hashFuntion(key);
        int chainnedIndex = indexOf(key, hashTable[index]);

        if(chainnedIndex >= 0 )
            hashTable[index].remove(chainnedIndex);

        hashTable[index].add(new Data(key, value));
    }

    public V get(K key) {
        int index = (int)hashFuntion(key);
        int chainnedIndex = indexOf(key, hashTable[index]);

        if(chainnedIndex >= 0 )
            return (V) hashTable[index].get(chainnedIndex).getValue();

        else
            return null;
    }

    public boolean remove(K key) {
        int index = (int)hashFuntion(key);
        int chainnedIndex = indexOf(key, hashTable[index]);

        if(chainnedIndex >= 0) {
            hashTable[index].remove(chainnedIndex);
            return true;
        }
        return false;
    }


    public void removeAll() {
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i].clear();
        }
    }

    private long hashFuntion(K key) {
        if(mHashFuntion != null)
            return mHashFuntion.hahfuntion(key) % HASH_SIZE;
        else
            return Math.abs(key.hashCode()) % HASH_SIZE;
    }

    public int getSize() {
        int sumCount = 0;
        for (ArrayList items: hashTable) {
            sumCount += items.size();
        }
        return sumCount;
    }

    private int indexOf(K key, ArrayList<Data> hashTable) {
        int retIndex = -1;
        for (int i = 0; i < hashTable.size() ; i++) {
            if(hashTable.get(i).equals(key)) {
                retIndex =  i;
            }
        }
        return retIndex;
    }

    private class Data<K, V> {
        private K key;
        private V value;

        public Data(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object key) {
            return key.equals(key);
        }
    }
}


