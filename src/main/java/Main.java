public class Main {
    public static void main(String[] args) throws InterruptedException {

        User user = new User("Пользователь");
        user.start();

        Toy toy = new Toy("Бесполезная коробка");
        toy.start();

        user.join(); //отлавливаем завершение потока-пользователя
        if (!user.isAlive()) {
            toy.interrupt(); //прерываем поток-игрушку, если поток-пользователя неживой
        }
    }
}
