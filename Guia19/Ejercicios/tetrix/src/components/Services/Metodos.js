/** 
 * Metodo encargador de verificar si la ficha puede bajar de lugar
*/
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

export function getFichas(listaFichas,incremento=0) {
    let tempFichas = [];
    listaFichas.forEach((ficha) => {
        tempFichas = [...tempFichas, getFicha(ficha, incremento)];
    })
    return tempFichas;
}

export function sumaFichas(listaFichas){
    let suma=0;
    listaFichas.forEach((f)=>{
        suma+=f.pieza;
    })
    return suma;
}

export function eliminarFilaCompleta(listaFichas, filas, maximo) {

    let tempFichas = [];
    let puntos=0;
    for (let index = 0; index < filas; index++) {
        const fila = listaFichas.filter((f) => f.y === index);

        if (fila.length !== 0) {
            let suma = 0;
            fila.forEach(f => {
                suma += f.pieza;
            });
            if (suma !== maximo) {
                tempFichas = tempFichas.concat(fila);
            } else {
                puntos = 0;

                fila.forEach(f => puntos += f.puntos);
            }
        }
    }
    return [tempFichas,puntos];
}

export function creaFila(cols, id_ficha,filas) {

    let continuar = false;
    let linea = [];
    do {
        continuar = false;
        let largoMaximo = 4;
        for (let i = 0; i < cols; i++) {
            if ((cols - i) < largoMaximo + 1) {
                largoMaximo = i - cols;
            }
            if (largoMaximo > 0) {
                const llevaFicha = Math.round(Math.random()) === 1; ///  Randomiza si va a cargar una ficha en esa columna
                if (llevaFicha) {
                    // Crear ficha.
                    id_ficha.current = id_ficha.current + 1;
                    const nf = creaFicha(i, filas-1, largoMaximo, id_ficha);
                    i += nf.pieza - 1;
                    linea = linea.concat([nf]);

                }
            }
        }
        if (linea.length === 0) {
            continuar = true;
        } else {
            return linea;
        }
    } while (continuar);
}

export function generateCombinations(targetSum, numbers) {
    const result = [];
    
    function findCombinations(currentCombination, currentSum, startIndex) {
      if (currentSum === targetSum) {
        result.push(currentCombination.slice()); // Guardar la combinación encontrada
        return;
      }
  
      if (currentSum > targetSum || startIndex === numbers.length) {
        return;
      }
  
      for (let i = startIndex; i < numbers.length; i++) {
        currentCombination.push(numbers[i]);
        findCombinations(currentCombination, currentSum + numbers[i], i); // Permitir repeticiones
        currentCombination.pop();
      }
    }
  
    findCombinations([], 0, 0);
    return result;
  }
  
  
 
  
  