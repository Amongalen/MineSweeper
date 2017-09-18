package amongalen.minesweeperproject;

/**
 *
 * @author Adam Parys
 */
public class MineSweeperMain {

    final static String MINEFIELD_INPUT = "*...\n..*.\n....";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyMineSweeper ms = new MyMineSweeper();
        ms.setMineField(MINEFIELD_INPUT);
        System.out.println(ms.getHintField());
    }

}
