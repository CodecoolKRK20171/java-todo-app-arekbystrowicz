public class Controller {

    private static final String EXIT = "0";
    private static final String ADD = "1";
    private static final String MARK = "2";
    private static final String TERMINATE = "3";

    private View view;
    private TodoList items;

    public Controller() {
        view = new View();
        items = new TodoList();
    }

    public void start() {
        String operation;
        String desc;

        items.addItem(view.getDescription());

        do {
            view.print(items.toString());
            operation = view.getOperation();
            resolve(operation);
        } while (!operation.equals(EXIT));

    }

    private void resolve(String operation) {
        switch (operation) {
            case ADD:
                items.addItem(view.getDescription());
                break;
            case MARK:
                markItem();
                break;
            case TERMINATE:
                items.removeDone();
                break;
            case EXIT:
                break;
        }
    }

    private void markItem() {
        view.print(items.toString());
        try {
            items.markAsDone(view.getIndex());
        }
        catch (InvalidItemIndexException e) {
            view.print(e.getMessage());
        }
    }


}
