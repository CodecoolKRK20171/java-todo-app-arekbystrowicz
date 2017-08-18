import java.util.Scanner;


public class View {

    private static final int MAX_DESC_LEN = 20;
    private static final int MIN_DESC_LEN = 3;
    private static final String INDEXES = "[1-9]+";
    private static final String OPERATIONS = "[0-3]";

    private Scanner input;

    public View() {
        input = new Scanner(System.in);
    }

    public int getIndex() {
        String index;

        do  {
            System.out.println("Povide item index: ");
            index = input.nextLine();
        } while (!index.matches(INDEXES));

        return Integer.parseInt(index) - 1;
    }

    public String getDescription() {
        String desc;

        do {
            System.out.println("Povide item description: ");
            desc = input.nextLine();
        } while (desc.length() < MIN_DESC_LEN || desc.length() > MAX_DESC_LEN);

        return desc;
    }

    public String getOperation() {
        String operation;

        printMenu();
        do {
            System.out.println("Choose operation: ");
            operation = input.nextLine();
        } while (!operation.matches(OPERATIONS));

        return operation;
    }

    private void printMenu() {
        String menu;

        menu =  "    1) add item\n";
        menu += "    2) mark item as done\n";
        menu += "    3) terminate all done\n";
        menu += "    0) exit\n";

        System.out.println(menu);
    }

    public void print(String message) {
        System.out.println("\n" + message);
    }

}
