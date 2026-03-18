package aventure.solo.value;

// les valeurs du facteur de chaos est compris entre 1 et 9.
public class ChaosFactor {

    public final static int VALEUR_MAX = 9;
    public final static int VALEUR_MIN = 1;

    private final int valeurChaos;

    public ChaosFactor(int valeurChaos)
    {
        if (valeurChaos < 1 || valeurChaos > 9)
        {
            throw new IllegalArgumentException("La valeur de chaos doit être entre 1 et 9. alors qu'elle est de " +valeurChaos);
        }
        this.valeurChaos = valeurChaos;
    }

    public ChaosFactor incrementer()
    {
        return new ChaosFactor(Math.min(VALEUR_MAX,valeurChaos+1));
    }

    public ChaosFactor decrementer()
    {
        return new ChaosFactor(Math.max(VALEUR_MIN,valeurChaos-1));
    }

    public int getValeur() {
        return valeurChaos;
    }
}
