public class Button {
    // применяем Singleton шаблон для ссылки на единственный объект этого класса
    private static Button button;
    //устанавливаем volatile-переменную состояния игрушки, которой будут пользоваться 2 потока
    volatile boolean trigger;


    public static Button getInstance() {
        if (button == null) {
            button = new Button();
        }
        return button;
    }

    private Button() {
        trigger = false;
    }

    // метод возвращения состояния игрушки
    public boolean getTrigger() {
        return trigger;
    }

    // метод замены состояния игрушки
    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }

}
