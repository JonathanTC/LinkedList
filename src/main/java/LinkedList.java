public class LinkedList<T extends Comparable<T>>
{
    private ListItem<T> head, currentItem;

    /*
     * This method add a new element on the linkedlist.
     * If head point is null, the new element is located on the head else we insert from the head.
     */
    public void add(T data) {
        if (head == null) {
            head = new Item(data);
        }
        else {
            compare(head, data);
        }
    }

    /*
     * This methode compare the current item value and value to add.
     * If the item value is lower than parameter value we write the new data to next case else we write element before.
     */
    private void compare(ListItem<T> item, T data){
        currentItem = item;
        int compare = item.compareTo(data);
        if(compare < 0){
            if(item.getNext() != null) {
                compare(item.getNext(), data);
            }
            else{
                writeAfter(data);
            }
        }
        if(compare > 0){
            writeBefore(data);
        }
    }

    /*
     * This methode write new item with data value before the current item
     */
    public void writeBefore(T data){
        Item newItem = new Item(data);
        newItem.setNext(currentItem);

        if(currentItem.getPrevious() != null){
            newItem.setPrevious(currentItem.getPrevious());
            currentItem.getPrevious().setNext(newItem);
        }
        else{
            head = newItem;
            currentItem.setPrevious(newItem);
        }
    }

    /*
     * This methode write new item with data value after the current item
     */
    public void writeAfter(T data){
        Item newItem = new Item(data);
        newItem.setPrevious(currentItem);
        currentItem.setNext(newItem);
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
