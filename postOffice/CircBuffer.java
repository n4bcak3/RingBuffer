package postOffice;//         _____  __                __     ______
// .-----.|  |  ||  |--.----.---.-.|  |--.|__    |
// |     ||__    |  _  |  __|  _  ||    < |__    |
// |__|__|   |__||_____|____|___._||__|__||______|
//                                       4 project


public class CircBuffer {
    private String[] data;
    private int head;
    private int tail;

    public CircBuffer(int length) {
        this.data = new String[length];
        this.head = 0;
        this.tail = 0;
    }

    synchronized public boolean store(String item){
        if(!isFull()){
            data[tail++] = item;
            if (tail == data.length)
                tail = 0;
            return true;
        } else
            return false;
    }

    synchronized public String read(){
        if (head != tail){
            String value = data[head++];
            if (head == data.length)
                head = 0;
            return value;
        }
        return null;
    }

    private boolean isFull(){
        if (tail+1 == head)
            return true;
        if (tail == (data.length -1) && head==0)
            return true;

        return false;
    }
}