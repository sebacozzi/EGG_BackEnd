import { Api_RickAndMorty } from "../Consts/Api.const";

class RAMservices {
  async obtenerPesonajes() {
    const response = await fetch(Api_RickAndMorty.urlPersonajes());

    return response.json();
  }
}

export default new RAMservices();
