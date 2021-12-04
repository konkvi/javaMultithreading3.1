public class Toy extends Thread{

    public static Button button;
    public static final int TIME_TO_WAIT = 1000;

    public Toy(String name) {
        super(name);
        button = Button.getInstance();
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            try {
                Thread.sleep(TIME_TO_WAIT);
            } catch (InterruptedException e) {
                System.out.printf("%s в это время спала\n", Thread.currentThread().getName());
                break;
            }
            if (button.getTrigger()) {
                button.setTrigger(false);
                System.out.printf("%s выключил игрушку\n", Thread.currentThread().getName());
            }
        }
    }
}
