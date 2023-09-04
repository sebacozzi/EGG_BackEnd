const Idioma = {
    get: function (ln){if (ln=='es'){return es}else{return en}}}
    const es= {
        tx_name: 'Español',
        tx_f_rest: 'Fichas Restantes',
        tx_filas: 'Filas',
        tx_tiempo: 'Tiempo',
        tx_tiempo_det: 'seg',
        tx_puntos: 'Puntos',
        tx_j_p: 'Juego Terminado',
        tx_pausa: 'Pausa',
        tx_nivel: 'Nivel',
        tx_dif: 'Dificultad',
        tx_j_g: 'Juego Ganado',
        tx_pausar: 'Pausar',
        tx_dificultad:['Facil',
                    'Intermedio',
                    'Dificil',
                    'Extremo'],
        tx_continue:'Continuar',
        tx_fin_perdio: ['Tiempo Finalizado!!', 'Se termino el tablero!!!'],
        
    };
    const en= {
        tx_name: 'English',
        tx_f_rest: 'Remaining Tabs',
        tx_filas: 'Rows',
        tx_tiempo: 'Time',
        tx_tiempo_det: 'sec',
        tx_puntos: 'Points',
        tx_j_p: 'Game Over',
        tx_pausa: 'Pause',
        tx_nivel: 'Level',
        tx_dif: 'Difficulty',
        tx_j_g: 'You Won',
        tx_pausar: 'Pause',
        tx_dificultad:['Easy',
        'Intermediate',
        'Difficult',
        'Extreme'],
        tx_continue:'Continue',
        tx_fin_perdio: ['Time Out!!','The board is finished!!!'],
    };

    export function texto(ln){switch (ln) {
        case 'en': return Idioma.get('en');
            case'es': return Idioma.get('es');
    
        default:
            return Idioma.get('es');
    }}
    //export default Idioma;