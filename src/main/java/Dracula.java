import java.util.Calendar;

public class Dracula {
    private final String name = "Влад Цепеш";
    private boolean hunger;
    private String hobbies;
    private final String location = "Сигишоара, Трансильвания";
    private boolean isHumanBited;
    private final int yearOfBirth = 1436;

    public String getNAME() {
        return name;
    }

    public String getLOCATION() {
        return location;
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

    public int getYearOfBirth() {
        return yearOfBirth;
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

    public void printInformationOfDracula() {
        System.out.println("Меня зовут " + getNAME() + "\n" +
                "Мой текущий возраст " + draculaAgeCalculation() + " лет" + "\n" +
                "Я живу в " + getLOCATION() + "\n" +
                "Я люблю " + getHobbies());
    }

    public int draculaAgeCalculation() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - getYearOfBirth();
    }
}
