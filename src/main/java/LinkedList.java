public class LinkedList<T extends Comparable<T>>
{
    private ListItem<T> head;

    /*
     * This method add a new element on the linkedlist.
     * If head point is null, the new element is located on the head else we insert from the head.
     */
    public void add(T data) {
        if (head == null) {
            head = new Item(data);
        }
        else {
            insert(head, data);
        }
    }

    /*
     * This methode compare the current item value and value to add.
     * If the item value is lower than parameter value we add the new data to next case else we rotate elements.
     */
    private void insert(ListItem<T> item, T data){
        int compare = item.compareTo(data);
        if(compare < 0){
            if(item.getNext() != null) {
                insert(item.getNext(), data);
            }
            else{
                Item newItem = new Item(data);
                newItem.setPrevious(item);
                item.setNext(newItem);
            }
        }
        if(compare > 0){
            Item newItem = new Item(data);
            newItem.setNext(item);

            if(item.getPrevious() != null){
                newItem.setPrevious(item.getPrevious());
                item.getPrevious().setNext(newItem);
            }
            else{
                head = newItem;
                item.setPrevious(newItem);
            }
        }
    }

    /*
     * This methode print the linkedlist on the screen.
     */
    public void printList() {
        ListItem item = head;
        while (item != null) {
            System.out.println(item.getData());
            item = item.getNext();
        }
    }
}
