package aventure.solo.moteur.oracle;

import aventure.solo.moteur.oracle.model.FateAnswer;
import aventure.solo.moteur.oracle.model.FateQuestion;
import aventure.solo.moteur.oracle.model.value.Odds;
import org.junit.jupiter.api.Test;

class MythicFateOracleTest {
    FateQuestion question = new FateQuestion("La porte est-elle verrouillée ?", Odds.LIKELY);
    MythicFateOracle oracle = new MythicFateOracle();

    @Test
    public void testAnswer(){
    FateAnswer answer = oracle.ask(question, 6);
    System.out.print(answer.toString());
    }
}