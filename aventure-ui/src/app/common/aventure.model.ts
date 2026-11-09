import { Objectif } from "./objectif.model";
import { Personnage } from "./personnage.model";
import { Scene } from "./scene.model";

export interface Aventure {
    id: string,
    titre: string,
    notes: string ,
    scenes?: Scene[] ,
    objectifs?: Objectif[]  ,
    personnages?: Personnage[] 

}