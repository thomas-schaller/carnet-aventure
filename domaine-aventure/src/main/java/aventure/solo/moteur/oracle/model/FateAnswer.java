package aventure.solo.moteur.oracle.model;

public record FateAnswer(boolean yes, boolean exceptional, boolean randomEvent) {


    public boolean isYes() { return yes; }
    public boolean isExceptional() { return exceptional; }
    public boolean isRandomEvent() { return randomEvent; }

    @Override
    public String toString() {
        if (yes && exceptional) return "OUI EXCEPTIONNEL";
        if (yes) return "OUI";
        if (exceptional) return "NON EXCEPTIONNEL";
        return "NON";
    }
}
