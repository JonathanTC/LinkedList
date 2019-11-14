public class LinkedList<T extends Comparable<T>>
{
    private ListItem<T> head;

    public void add(T data) {
        if (head == null) {
            head = new Item(data);
        }
        else {
            insert(head, data);
        }
    }

    private void insert(ListItem item, T data){
        if(item.getNext() != null){
            int compare = item.compareTo(data);
            if(compare < 0){
                insert(item.getNext(), data);
            }
            if(compare > 0){
                // make a new Item
                Item newItem = new Item(data);
                newItem.setNext(item);

                if(item.getPrevious() != null){
                    newItem.setPrevious(item.getPrevious());
                    // configure old item
                    item.getPrevious().setNext(newItem);
                }
                else{
                    head = newItem;
                    item.setPrevious(newItem);
                }
            }
        }
        else {
            int compare = item.compareTo(data);
            if (compare < 0){
                // add the new item at the end of list
                Item newItem = new Item(data);
                //configure link between new Item and currentItem
                newItem.setPrevious(item);
                item.setNext(newItem);
            }
            if(compare > 0){
                Item newItem = new Item(data);
                newItem.setNext(item);

                if(item.getPrevious() != null) {
                    newItem.setPrevious(item.getPrevious());
                    // configure old item
                    item.getPrevious().setNext(newItem);
                }
                else {
                    head = newItem;
                    item.setPrevious(newItem);
                }
            }
        }
    }

    public void printList() {
        ListItem item = head;
        while (item != null) {
            System.out.println(item.getData());
            item = item.getNext();
        }
    }
}
