public class HashTableAddressing<K, V> {
    //Represents each bucket in the table
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + "= " + value;
        }
    }

    private Entry<K, V>[] table;
    //true means empty after delete
    private boolean[] wasDeleted;
    //number of pairs
    private int size;
    //current table length
    private int capacity;
    //when to resize
    private double loadFactorThreshold;

    public HashTableAddressing(int initialCapacity, double loadFactorThreshold) {
        this.capacity = initialCapacity;
        this.loadFactorThreshold = loadFactorThreshold;
        initiate();
    }



    private void initiate()
    {
        table = (Entry<K, V>[]) new Entry[capacity];
        wasDeleted = new boolean[capacity];
        //all booleans default to false -> meaning EMPTY-SINCE-START
        size = 0;
    }


    //hashing function uses key.hashCode() and modulo operation
    private int getHashing(K key)
    {
        int hash = key.hashCode();
        //ensure it isnt a negative value, then modify the capacity
        return (hash & 0x7FFFFFFF) % capacity;
    }

    //linear probing function that given a base hash and attempt number, it will return the next index to try
    private int probing(int hash, int i)
    {
        // Linear probing: (hash + i) % capacity
        return (hash + i) % capacity;
    }

    //add a key-value pair into the hash table
    public void add(K key, V value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Key is null");
        }

        //resize if needed
        double currentLoadFactor = (double) size / capacity;
        if (currentLoadFactor >= loadFactorThreshold) {
            resize();
        }

        int hash = getHashing(key);
        int firstDeletedIndex = -1;

        //search for a place to put the key
        for (int i = 0; i < capacity; i++)
        {
            int idx = probing(hash, i);

            //empty, so insert
            if (table[idx] == null)
            {
                if (firstDeletedIndex != -1) {
                    table[firstDeletedIndex] = new Entry<>(key, value);
                    wasDeleted[firstDeletedIndex] = false;
                } else
                {
                    table[idx] = new Entry<>(key, value);
                    wasDeleted[idx] = false;
                }
                size++;
                return;
            }

            //empty, remember first such slot
            if (wasDeleted[idx])
            {
                if (firstDeletedIndex == -1)
                {
                    firstDeletedIndex = idx;
                }
                //keep probing
                continue;
            }

            //occupied bucket
            if (table[idx].key == key)
            {
                //key already exists, so update the value
                table[idx].value = value;
                return;
            }
        }

        //if the loop ends without inserting, the table is full, but shouldn't happen because we should be resizing
        if (firstDeletedIndex != -1) {
            table[firstDeletedIndex] = new Entry<>(key, value);
            wasDeleted[firstDeletedIndex] = false;
            size++;
        } else {
            //resize + reinsert
            resize();
            add(key, value);
        }
    }

    //get the value associated with key
    public V get(K key)
    {
        if (key == null) {
            return null;
        }

        int hash = getHashing(key);

        for (int i = 0; i < capacity; i++)
        {
            int idx = probing(hash, i);

            // Case 1: bucket is completely empty and has never been used
            // EMPTY-SINCE-START -> stop searching; key not in table
            if (table[idx] == null && !wasDeleted[idx])
            {
                return null;
            }

            // Case 2: bucket is empty but was used before (EMPTY-AFTER-DELETE)
            // We must keep probing because the key might be further down the cluster.
            if (table[idx] == null && wasDeleted[idx])
            {
                continue;
            }

            // Case 3: bucket is OCCUPIED (safe to read table[idx].key)
            if (table[idx].key.equals(key))
            {
                return table[idx].value;
            }
        }

        // Full loop and not found
        return null;
    }


    //remove a key-value pair
    public boolean remove(K key)
    {
        if (key == null) return false;

        int hash = getHashing(key);

        for (int i = 0; i < capacity; i++)
        {
            int idx = probing(hash, i);

            // empty-since-start: key not present
            if (table[idx] == null && !wasDeleted[idx])
            {
                return false;
            }

            // skip empty-after-delete
            if (table[idx] == null && wasDeleted[idx])
            {
                continue;
            }

            // OCCUPIED bucket
            if (table[idx].key.equals(key))
            {
                table[idx] = null;        // clear entry
                wasDeleted[idx] = true;   // mark as empty-after-delete
                size--;
                return true;
            }
        }
        return false;
    }


    private void resize()
    {
        int oldCapacity = capacity;
        Entry<K, V>[] oldTable = table;
        boolean[] oldWasDeleted = wasDeleted;

        capacity = oldCapacity * 2;
        initiate();

        for(int i = 0; i < oldCapacity; i++)
        {
            if(oldTable[i] != null && !oldWasDeleted[i])
            {
                add(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    public int size()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void printTable() {
        System.out.println("Hash Table (capacity = " + capacity + ", size = " + size + "):");
        for (int i = 0; i < capacity; i++)
        {
            System.out.print("Bucket " + i + ": ");
            if (table[i] == null && !wasDeleted[i])
            {
                System.out.println("EMPTY-SINCE-START");
            } else if (table[i] == null && wasDeleted[i])
            {
                System.out.println("EMPTY-AFTER-DELETE");
            } else
            {
                System.out.println(table[i]);
            }
        }
        System.out.println();
    }
}