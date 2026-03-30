package aventure.solo.moteur.oracle.port;


import aventure.solo.moteur.oracle.model.FateAnswer;
import aventure.solo.moteur.oracle.model.FateQuestion;

public interface FateOracle {

    FateAnswer ask(FateQuestion question, int chaosFactor);
}
