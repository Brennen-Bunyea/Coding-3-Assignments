public class ArrayList
{
    private int[] data;
    private int size;

    public ArrayList()
    {
        data = new int[10];
        size = 0;
    }

    //function to resize the array when it is full
    private void Capacity()
    {
        if(size >= data.length)
        {
            int[] newData = new int[data.length * 2];
            for(int i = 0; i < data.length; i++)
            {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    //append
    public void append(int value)
    {
        Capacity();
        data[size] = value;
        size++;
    }

    //prepend
    public void prepend(int value)
    {
        Capacity();
        int i = size - 1;
        while(i > 0)
        {
            data[i + 1] = data[i];
            i = i - 1;
        }
        data[0] = value;
        size = size + 1;
    }

    //insert at index
    public void insert(int index, int value)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Capacity();
        int i = size - 1;
        while (i >= index) {
            data[i + 1] = data[i];
            i = i - 1;
        }

        data[index] = value;

        size = size + 1;
    }

    //remove at index
    public int remove(int index)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        int removed = data[index];
        for(int i = index; i < size - 1; i++)
        {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    //search
    public int search(int value)
    {
        for(int i = 0; i < size; i++)
        {
            if(data[i] == value)
            {
                return i;
            }
        }
        return -1;
    }

    //selection sort
    public void sort(boolean ascending)
    {
        int i;
        int j;
        int selected;
        int temp;

        for(i = 0; i < size - 1; i++)
        {
            selected = i;
            for(j = i + 1; j < size; j++)
            {
                //true
                if(ascending)
                {
                    if(data[j] < data[selected])
                    {
                        selected = j;
                    }
                }
                //false
                else
                {
                    if(data[j] > data[selected])
                    {
                        selected = j;
                    }
                }
            }
            temp = data[i];
            data[i] = data[selected];
            data[selected] = temp;
        }
    }

    public void print()
    {
        System.out.print("[");
        for(int i = 0; i < size; i++)
        {
            System.out.print(data[i] + " ");
        }
        System.out.println("]");
    }
}
