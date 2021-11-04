public class Dracula {
    private final String NAME = "Влад Цепеш";
    private int age;
    private boolean hunger;
    private String hobbies;
    private final String LOCATION = "Сигишоара, Трансильвания";
    private boolean isHumanBited;

    public String getNAME() {
        return NAME;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHunger() {
        return hunger;
    }

    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Dracula() {
        this.isHumanBited = false;
        this.hunger = true;
        this.hobbies = "пить кровь человеков :-E";
    }

    public void biteHumans() {
        isHumanBited = true;
        System.out.println("Укусил человека");
    }

    public void isDraculaHungerAfterBite() {
        if (isHumanBited) {
            System.out.println("Я голодный? Нет!");
        }
        else {
            System.out.println("Я голодный? Да!");
        }
    }
}
