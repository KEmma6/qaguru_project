import java.util.Calendar;

public class Dracula {
    private static Dracula instance;
    private static final String NAME = "Влад Цепеш";
    private boolean hunger;
    private String hobbies;
    private final String location = "Сигишоара, Трансильвания";
    private boolean isHumanBited;
    private final int yearOfBirth = 1436;
    private static int tusks = 4;
    private String girl = "Lucy Westenra";

    public String getNAME() {
        return NAME;
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

    public String getPreferredGirl() {
        return girl;
    }

    private Dracula() {
        this.isHumanBited = false;
        this.hunger = true;
        this.hobbies = "пить кровь человеков :-E";
    }

    public static Dracula getInstance(){
        if(instance == null){		//если объект еще не создан
            instance = new Dracula();	//создать новый объект
        }
        return instance;		// вернуть ранее созданный объект
    }

    public void biteHumans() {
        isHumanBited = true;
        System.out.println("Укусил человека");
    }

    public void isDraculaHungerAfterBite() {
        if (isHumanBited) {
            System.out.println("Я голодный? Нет!");
        } else {
            System.out.println("Я голодный? Да!");
        }
    }

    public void printInformationOfDracula() {
        System.out.println("Меня зовут " + getNAME() + "\n" +
                "Мой текущий возраст " + draculaAgeCalculation() + " лет" + "\n" +
                "Я живу в " + getLOCATION() + "\n" +
                "Я люблю " + getHobbies()) + "\n" +
                "I prefer " + getPreferredGirl() + "\n");
    }

    public int draculaAgeCalculation() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - getYearOfBirth();
    }

    public static void resultsOfDraculasAttack() {
        String[] words = NAME.split(" ");
        String name = words[0];
        String secondName = words[1];
        String a = "а";
        System.out.println("Количество ран, после укуса " + name + a + " " + secondName + a + " = " + BiteOfDracula.countOfWounds());
    }

    public static class BiteOfDracula {
        public static int countOfWounds() {
            return tusks;
        }
    }
}
