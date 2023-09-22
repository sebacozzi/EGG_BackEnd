const Levels=[
    {
        nivel:1,
        columnas:10,
        filas:10,
        tiempo:10,
        meta:{
            fichas:50,
            filas:10,
            bonificatiempo:5,
        }
    },
    {
        nivel:2,
        columnas:12,
        filas:11,
        tiempo:25,
        meta:{
            fichas:50,
            filas:10,
            bonificatiempo:5,
        }
    },
    {
        nivel:3,
        columnas:10,
        filas:10,
        tiempo:10,
        meta:{
            fichas:50,
            filas:10,
            bonificatiempo:5,
        }
    },
    
]

export function getNivel(nivel){
    return Levels[nivel];
};

export const NivelMaximo= Levels.length;