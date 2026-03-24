package moteur.oracle;

import moteur.oracle.model.FateAnswer;
import moteur.oracle.model.FateQuestion;
import moteur.oracle.model.value.Odds;
import moteur.oracle.port.FateOracle;

import java.util.Random;

public class MythicFateOracle implements FateOracle {

    private final Random random = new Random();

    @Override
    public FateAnswer ask(FateQuestion question, int chaosFactor) {

        int roll = d100();
        int chance = computeChance(question.odds(), chaosFactor);

        boolean yes = roll <= chance;

        boolean exceptional = isExceptional(roll, chance, yes);
        boolean randomEvent = isRandomEvent(roll, chaosFactor);

        return new FateAnswer(yes, exceptional, randomEvent);
    }

    private int computeChance(Odds odds, int chaosFactor) {
        // Ajustement simple du chaos
        int modifier = (chaosFactor - 5) * 5;
        int result = odds.getBaseChance() + modifier;

        return Math.max(1, Math.min(99, result));
    }

    private boolean isExceptional(int roll, int chance, boolean yes) {
        if (yes) {
            return roll <= chance / 5;
        } else {
            return roll >= 100 - ((100 - chance) / 5);
        }
    }

    private boolean isRandomEvent(int roll, int chaosFactor) {
        // double digit rule (11,22,33,...)
        int dizaines = roll / 10;
        int unites = roll % 10;

        return dizaines == unites && roll <= chaosFactor * 11;
    }

    private int d100() {
        return random.nextInt(100) + 1;
    }
}