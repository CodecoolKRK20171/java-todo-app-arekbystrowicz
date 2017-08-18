public class TodoItem{

    private String description;
    private boolean isDone;

    public TodoItem(String description) {
        this.description = description;
        isDone = false;
    }

    public String getDescription() {
        return description;
    }
    public boolean getIsDone() {
        return isDone;
    }
    public void markAsDone() {
        isDone = true;
    }

    public String toString() {
        String asString;

        if (isDone)
            asString = " [X] " + description;
        else
            asString = " [ ] " + description;

        return asString;
    }

}
