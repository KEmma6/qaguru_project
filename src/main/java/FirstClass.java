public class FirstClass {
    public static void main(String[] args) {
        Dracula dracula =  Dracula.getInstance();

        dracula.printInformationOfDracula();
        dracula.biteHumans();
        dracula.isDraculaHungerAfterBite();
        Dracula.resultsOfDraculasAttack();
    }
}
