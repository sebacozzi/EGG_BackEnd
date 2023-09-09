const Idioma = {
    //get: function (ln) { if (ln == 'es') { return {es} } else { return {en} } },

 es : {
    tx_name: 'Español',
    tx_f_rest: 'Fichas Restantes',
    tx_filas: 'Filas',
    tx_tiempo: 'Tiempo',
    tx_tiempo_det: 'seg',
    tx_puntos: 'Puntos',
    tx_pausa: 'Pausa',
    tx_nivel: 'Nivel',
    tx_dif: 'Dificultad',
    tx_titulo_fin: [, 'Juego Terminado', 'Ganaste', 'Pausa'],
    tx_pausar: 'Pausar',
    tx_dificultad: ['Facil',
        'Intermedio',
        'Dificil',
        'Extremo'],
    tx_continue: 'Continuar',
    tx_fin_perdio: ['Tiempo Finalizado!!!', 'Se termino el tablero!!!'],

},
 en : {
    tx_name: 'English',
    tx_f_rest: 'Remaining Tabs',
    tx_filas: 'Rows',
    tx_tiempo: 'Time',
    tx_tiempo_det: 'sec',
    tx_puntos: 'Points',
    tx_pausa: 'Pause',
    tx_nivel: 'Level',
    tx_dif: 'Difficulty',
    tx_titulo_fin: [, 'GameOver', 'You Won', 'Pause'],
    tx_pausar: 'Pause',
    tx_dificultad: ['Easy',
        'Intermediate',
        'Difficult',
        'Extreme'],
    tx_continue: 'Continue',
    tx_fin_perdio: ['Time Out!!', 'The board is finished!!!'],
},
}

export function texto(ln) {
    switch (ln) {
        case 'en': return Idioma.en;
        case 'es': return Idioma.es;

        default:
            return Idioma.es;
    }
}
export function getNames() {
    let result=[];
    for (const lang in Idioma) {
        if (Object.hasOwnProperty.call(Idioma, lang)) {
            const element = Idioma[lang];
            result= [...result,element.tx_name]    
            console.log('Lang: '+lang)    
        }
    }
    return result;
}
    //export default Idioma;