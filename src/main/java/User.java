public class User extends Thread{

    public static Button button;
    public static final int TIME_TO_SLEEP = 3000;
    private int count = 0;
    private int maxCount  = 4;

    public User(String name) {
        super(name);
        button = Button.getInstance();
    }

    @Override
    public void run() {
        while (count < maxCount){
            try {
                Thread.sleep(TIME_TO_SLEEP);
            } catch (InterruptedException e) {
                System.out.printf("%s в это время спал\n", Thread.currentThread().getName());
            }
            if (!button.getTrigger()) {
                button.setTrigger(true);
                System.out.printf("%s включил игрушку\n", Thread.currentThread().getName());
                count++;
                continue;
            } else {
                break;
            }
        }
    }
}
