package aventure.solo.configuration;


import aventure.solo.application.*;
import aventure.solo.port.AventureRepository;
import aventure.solo.moteur.oracle.port.FateOracle;
import aventure.solo.moteur.oracle.port.RandomEventGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public GenererRandomEventUseCase genererRandomEventUseCase(@Autowired AventureRepository aventureRepository,
                                                               @Autowired  RandomEventGenerator generator) {
        return new GenererRandomEventUseCase(aventureRepository,generator);
    }

    @Bean
    public PoserQuestionUseCase poserQuestionUseCase(AventureRepository aventureRepository, FateOracle oracle)
    {
        return new PoserQuestionUseCase(aventureRepository,oracle);
    }

    @Bean
    public AjoutPersonnageUseCase ajouterPersonnageUseCase(AventureRepository aventureRepository)
    {
        return new AjoutPersonnageUseCase(aventureRepository);
    }

    @Bean
    public AjoutObjectifUseCase ajouterObjectifUseCase(AventureRepository aventureRepository)
    {
        return new AjoutObjectifUseCase(aventureRepository);
    }

    @Bean
    public AjoutSceneUseCase ajoutSceneUseCase(AventureRepository aventureRepository)
    {
        return new AjoutSceneUseCase(aventureRepository);
    }
    @Bean
    public ListerAventureUseCase listerAventureUseCase(AventureRepository aventureRepository)
    {
        return new ListerAventureUseCase(aventureRepository);
    }

    @Bean
    public CreerAventureUseCase creerAventureUseCase(AventureRepository aventureRepository)
    {
        return new CreerAventureUseCase(aventureRepository);
    }

}
