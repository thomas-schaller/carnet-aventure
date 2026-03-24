package moteur.oracle.model.evenement;

public record SignificationEvenement(String mot1, String mot2) {
    @Override
    public String toString() {
        return mot1 + " " + mot2;
    }
}
