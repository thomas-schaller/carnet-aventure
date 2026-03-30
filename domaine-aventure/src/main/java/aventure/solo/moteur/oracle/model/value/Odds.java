package aventure.solo.moteur.oracle.model.value;

public enum Odds {
    IMPOSSIBLE(10),
    VERY_UNLIKELY(25),
    UNLIKELY(35),
    EVEN(50),
    LIKELY(65),
    VERY_LIKELY(75),
    CERTAIN(90);

    private final int baseChance;

    Odds(int baseChance) {
        this.baseChance = baseChance;
    }

    public int getBaseChance() {
        return baseChance;
    }
}
