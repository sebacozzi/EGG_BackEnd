export const Api_RickAndMorty={
    URL: 'https://rickandmortyapi.com/api' ,
    urlPersonajes: function(){return `${this.URL}/character`},
    urlPersonaje:  function (id){return `${this.URL}/character/${id}`}
}