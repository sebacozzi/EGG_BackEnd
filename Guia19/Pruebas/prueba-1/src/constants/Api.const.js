export const API_RM={
    url:'https://rickandmortyapi.com/api',
    
    personajes: function(){
        return `${this.url}/character`
    },
    personaje: function(id){
        return `${this.url}/character/${id}`;
    }
};