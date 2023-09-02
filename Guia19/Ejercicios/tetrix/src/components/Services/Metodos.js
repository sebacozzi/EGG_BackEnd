
export function puedeBajar(listaFichas, ficha) {
    const fichasdebajo = listaFichas.filter((f) => f.y === ficha.y + 1)
    return fichasdebajo.every((ficha1) => {
        if (ficha.id !== ficha1.id) {
            if (ficha1.y === ficha.y + 1)
                if (
                    ((ficha1.x <= ficha.x && ficha1.to >= ficha.x) || (ficha1.x <= ficha.x && ficha1.to >= ficha.x)) ||
                    ((ficha.x <= ficha1.x && ficha.to >= ficha1.x) || (ficha.x <= ficha1.x && ficha.to >= ficha1.x))
                ) {
                    return false;
                }
        }
        return true;
    })
};

export function getFicha(ficha, incrementoY = 0) {
    const id = ficha.id;
    const nPieza = ficha.pieza;
    const x = ficha.x;
    const y = ficha.y - incrementoY;
    const to = ficha.to;
    const puntos = ficha.puntos;
    return { id: id, pieza: nPieza, x: x, y: y, to: to, puntos: puntos };
}

export function creaFicha(fx, fy, maximo,idFicha) {
    const id = idFicha.current;
    const nPieza = Math.round(Math.random() * maximo) + 1;
    const to = fx + (nPieza - 1);
    idFicha.current = (idFicha.current + 1);
    const puntos = nPieza*nPieza;
    return { id: id, pieza: nPieza, x: fx, y: fy, to: to, puntos: puntos };

}

export function getFichas(listaFichas) {
    let tempFichas = [];
    listaFichas.forEach((ficha) => {
        tempFichas = [...tempFichas, getFicha(ficha, 0)];
    })
    return tempFichas;
}