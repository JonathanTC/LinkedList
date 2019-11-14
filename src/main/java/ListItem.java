public abstract class ListItem<T extends Comparable<T>> {
    protected ListItem<T> previous, next;
    protected T data;

    public ListItem<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListItem<T> previous) {
        this.previous = previous;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int compareTo(T data){
        return this.data.compareTo(data);
    }
}