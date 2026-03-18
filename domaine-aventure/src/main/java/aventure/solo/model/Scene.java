package aventure.solo.model;

public class Scene {

    private final String titre;
    private final String description;
    private int numeroScene = 1;

    public Scene(String titre, String description )
    {
        this.titre=titre;
        this.description=description;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getNumeroScene() {
    return numeroScene;
    }

    public void setNumeroScene(int numeroScene) {
        this.numeroScene=numeroScene;
    }

}
