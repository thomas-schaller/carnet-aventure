package moteur.oracle.port;


import moteur.oracle.model.FateAnswer;
import moteur.oracle.model.FateQuestion;

public interface FateOracle {

    FateAnswer ask(FateQuestion question, int chaosFactor);
}
