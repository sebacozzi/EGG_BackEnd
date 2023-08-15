import { API_RM } from "../constants/Api.const";

class RickAndMortyService {
    async getTodosLosPersonajes(){
        const response = await fetch(API_RM.personajes());
        return response.json();
    };

    async getPersonaje(id){
        const response = await fetch(API_RM.personaje(id));
        return response.json();
    };

}

export default new RickAndMortyService();