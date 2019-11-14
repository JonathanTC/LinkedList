public class Item<T extends Comparable<T>> extends ListItem<T> {
    public Item(T data){
        this.data = data;
    }
}