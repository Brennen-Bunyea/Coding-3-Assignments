public class LinearProbing<K, V>
{

    private static class Entry<K, V>
    {
        K key;
        V value;

        Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public String toString()
        {
            return key + " = " + value;
        }
    }

    private Entry<K, V>[] table;
    private boolean[] wasDeleted;
    private int capacity;
    private int size;
    private final double loadFactorThreshold = 0.6;

    public LinearProbing(int capacity)
    {
        this.capacity = capacity;
        table = (Entry<K, V>[]) new Entry[capacity];
        wasDeleted = new boolean[capacity];
    }

    private int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int probe(int hash, int i)
    {
        return (hash + i) % capacity;
    }

    private void resize()
    {
        int oldCapacity = capacity;
        Entry<K, V>[] oldTable = table;
        boolean[] oldDeleted = wasDeleted;

        capacity *= 2;

        table = (Entry<K, V>[]) new Entry[capacity];
        wasDeleted = new boolean[capacity];
        size = 0;

        for (int i = 0; i < oldCapacity; i++)
        {
            if (oldTable[i] != null && !oldDeleted[i])
            {
                add(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    public void add(K key, V value)
    {
        if ((double) size / capacity >= loadFactorThreshold)
            resize();

        int hash = hash(key);
        int firstDeleted = -1;

        for (int i = 0; i < capacity; i++)
        {
            int idx = probe(hash, i);

            if (table[idx] == null)
            {
                if (firstDeleted != -1)
                {
                    table[firstDeleted] = new Entry<>(key, value);
                    wasDeleted[firstDeleted] = false;
                } else {
                    table[idx] = new Entry<>(key, value);
                }
                size++;
                return;
            }

            if (wasDeleted[idx] && firstDeleted == -1)
            {
                firstDeleted = idx;
            }

            if (table[idx] != null && table[idx].key.equals(key))
            {
                table[idx].value = value;
                return;
            }
        }
    }

    public V get(K key)
    {
        int hash = hash(key);

        for (int i = 0; i < capacity; i++)
        {
            int idx = probe(hash, i);

            if (table[idx] == null && !wasDeleted[idx])
                return null;

            if (table[idx] == null && wasDeleted[idx])
                continue;

            if (table[idx].key.equals(key))
                return table[idx].value;
        }
        return null;
    }

    public boolean remove(K key)
    {
        int hash = hash(key);

        for (int i = 0; i < capacity; i++)
        {
            int idx = probe(hash, i);

            if (table[idx] == null && !wasDeleted[idx])
                return false;

            if (table[idx] == null && wasDeleted[idx])
                continue;

            if (table[idx].key.equals(key))
            {
                table[idx] = null;
                wasDeleted[idx] = true;
                size--;
                return true;
            }
        }
        return false;
    }

    public void printTable()
    {
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
