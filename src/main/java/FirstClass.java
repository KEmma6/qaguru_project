public class FirstClass {
    public static void main(String[] args) {
        Dracula dracula = new Dracula();

        dracula.setAge(585);

        System.out.println("Меня зовут " + dracula.getNAME() + "\n" +
                "Мой текущий возраст " + dracula.getAge() + " лет" + "\n" +
                "Я живу в " + dracula.getLOCATION() + "\n" +
                "Я люблю " + dracula.getHobbies());

        dracula.biteHumans();
        dracula.isDraculaHungerAfterBite();
    }
}
