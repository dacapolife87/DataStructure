package dataStructure.list.arraylist;

public class ArrayList {
    private Object[] data;
    private int size;
    private int index;

    public ArrayList() {
        this.size = 1;
        this.data = new Object[this.size];
        this.index = 0;
    }

    public void add(Object obj) {
        if(this.index == this.size -1) {
            doubling();
        }

        data[this.index] = obj;
        this.index++;
    }

    private void doubling() {
        this.size = this.size * 2;
        Object[] newData = new Object[this.size];
        for(int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        this.data = newData;
    }

    public Object get(int i) throws Exception {
        if(i > this.index - 1) {
            throw new Exception("ArrayindexOfBound");
        }else if(i < 0) {
            throw new Exception("Nefative Value");
        }
        return this.data[i];
    }

    public void remove(int i) throws Exception {
        if(i > this.index - 1) {
            throw new Exception("ArrayindexOfBound");
        }else if(i < 0) {
            throw new Exception("Nefative Value");
        }

        for(int x = i; x < this.data.length - 1;x++) {
            data[x] = data[x + 1];
        }
        this.index--;
    }
}
