import java.util.LinkedList;


public class TodoList{

    private LinkedList<TodoItem> items;

    public TodoList() {
        items = new LinkedList<TodoItem>();
    }

    public void addItem(String newDescription) {
        items.add(new TodoItem(newDescription));
    }

    private TodoItem getByIndex(int index) throws InvalidItemIndexException {
        if (!isIndexValid(index))
            throw new InvalidItemIndexException("There is no such item");

        return items.get(index);
    }

    private boolean isIndexValid(int index) {
        return (index >= 0 && index < items.size());
    }

    public String toString() {
        String asString;

        asString = "";
        for (int i = 0; i < items.size(); i++)
            asString += String.valueOf(i+1) + items.get(i).toString() + "\n";

        return asString;
    }

    public void markAsDone(int index) throws InvalidItemIndexException{
        getByIndex(index).markAsDone();
    }

    public void removeDone() {
        for (int i = 0; i < items.size(); i++)
            if (items.get(i).getIsDone() == true)
                items.remove(i);
    }


}
