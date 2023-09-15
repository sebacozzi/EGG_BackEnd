const Idioma = {
    //get: function (ln) { if (ln == 'es') { return {es} } else { return {en} } },

    es: {
        img: 'https://flagcdn.com/160x120/es.png',
        tx_name: 'Español',
        tx_idioma: 'Lenguaje',
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
        tx_guarda: 'Guardar',
        tx_cancelar: 'Cancelar',
        tx_detalle_dificultad: [
            'Agrega linea cada tiempo determinado (1.3 segundos), tiempo de bonificación 80 segundos.',
            'Agrega linea cada tiempo determinado (1 segundo), tiempo de bonificación 60 segundos.',
            'Agrega linea cada tiempo determinado (0.8 segundos), tiempo de bonificación 45 segundos.',
            'Agrega linea cada tiempo determinado (1 segundo) y  tras movimiento, tiempo de bonificación 45 segundos.']
    },
    us: {
        img: 'https://flagcdn.com/160x120/us.png',
        tx_name: 'English',
        tx_idioma: 'Language',
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
        tx_guarda: 'Save',
        tx_cancelar: 'Cancel',
        tx_detalle_dificultad: [
            'Adds a line at regular intervals (1.3 seconds), with a bonus time of 80 seconds.',
            'Adds a line at regular intervals (1 second), with a bonus time of 60 seconds.',
            'Adds a line at regular intervals (0.8 seconds), with a bonus time of 45 seconds.',
            'Adds a line at regular intervals (1 second) and after each move, with a bonus time of 45 seconds.']
    },
    it: {
        img: 'https://flagcdn.com/160x120/it.png',
        tx_name: 'Italiano',
        tx_idioma: 'Lingua',
        tx_f_rest: 'Schede rimanenti',
        tx_filas: 'Righe',
        tx_tiempo: 'Tempo',
        tx_tiempo_det: 'sec',
        tx_puntos: 'Punti',
        tx_pausa: 'Pausa',
        tx_nivel: 'Livello',
        tx_dif: 'Difficoltà',
        tx_titulo_fin: ['Game Over', 'Hai vinto', 'Pausa'],
        tx_pausar: 'Pausa',
        tx_dificultad: ['Facile', 'Intermedio', 'Difficile', 'Estremo'],
        tx_continue: 'Continua',
        tx_fin_perdio: ['Tempo scaduto!!', 'Il tabellone è finito!!!'],
        tx_guarda: 'Salva',
        tx_cancelar: 'Annulla',
        tx_detalle_dificultad: [
            'Aggiunge una linea a intervalli regolari (1.3 secondi), con un tempo bonus di 80 secondi.',
            'Aggiunge una linea a intervalli regolari (1 secondo), con un tempo bonus di 60 secondi.',
            'Aggiunge una linea a intervalli regolari (0.8 secondi), con un tempo bonus di 45 secondi.',
            'Aggiunge una linea a intervalli regolari (1 secondo) e dopo ogni mossa, con un tempo bonus di 45 secondi.']
    },
}

export function texto(ln) {

    for (const lang in Idioma) {
        if (Object.hasOwnProperty.call(Idioma, lang)) {
            if (lang == ln) {
                return Idioma[lang];
            }
        }
    }
    return Idioma['es'];
}
export function getNombresIdiomas() {
    let result = [];
    for (const lang in Idioma) {
        if (Object.hasOwnProperty.call(Idioma, lang)) {
            const element = Idioma[lang];
            result = [...result, { nombre: element.tx_name, value: lang, img: element.img, }]
        }
    }
    return result;
}
//export default Idioma;