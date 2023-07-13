USE nba;


-- ---------- CANDADO A
SELECT 
    (SELECT 
            COUNT(*)         FROM
            estadisticas
        WHERE
            asistencias_por_partido = (SELECT 
                    MAX(asistencias_por_partido)
                FROM
                    estadisticas)) AS Posicion_Candado_A,
    (SELECT 
            SUM(peso) FROM
            jugadores
        WHERE
            posicion LIKE '%C%'
                AND nombre_equipo IN (SELECT 
                    nombre
                FROM
                    equipos
                WHERE
                    conferencia = 'East')) AS Clave_Candado_A
FROM
    estadisticas
LIMIT 1;

-- ---------- CANDADO B

SELECT 
    (SELECT 
            COUNT(*) AS posicion_candado_B
        FROM
            estadisticas
        WHERE
            asistencias_por_partido > (SELECT 
                    COUNT(*)
                FROM
                    jugadores
                WHERE
                    nombre_equipo = 'Heat')) AS Posicion_Candado_B,
    (SELECT 
            COUNT(*)
        FROM
            partidos
        WHERE
            temporada LIKE '%99%') AS clave_Candado_B
FROM
    partidos
LIMIT 1;

-- ---------- CANDADO C
SELECT 
    (SELECT 
            ROUND((((SELECT 
                                COUNT(*)
                            FROM
                                jugadores j
                                    INNER JOIN
                                equipos e ON j.nombre_equipo = e.nombre
                            WHERE
                                j.procedencia = 'Michigan'
                                    AND e.conferencia = 'West') / (SELECT 
                                COUNT(*)
                            FROM
                                jugadores
                            WHERE
                                peso >= 195)) + 0.9945))
        FROM
            jugadores
        LIMIT 1) AS posicion_candado_C,
    (SELECT 
            ROUND(AVG(puntos_por_partido) + COUNT(asistencias_por_partido) + SUM(tapones_Por_partido))
        FROM
            estadisticas
        WHERE
            jugador IN (SELECT 
                    j.codigo
                FROM
                    jugadores AS j
                        INNER JOIN
                    equipos e ON e.nombre = j.nombre_Equipo
                WHERE
                    e.Division = 'Central')) AS clave_candado_C
FROM
    equipos
LIMIT 1;

-- ---------- CANDADO D
SELECT 
    (SELECT 
            ROUND(SUM(tapones_por_partido)) AS posicion_Candado_D
        FROM
            estadisticas
        WHERE
            jugador = (SELECT 
                    codigo
                FROM
                    jugadores
                WHERE
                    nombre = 'Corey Maggette')
                AND temporada = '00/01') AS pocision_candado_D,
    (SELECT 
            ROUND(SUM(puntos_por_partido))
        FROM
            estadisticas e
                RIGHT JOIN
            jugadores j ON j.codigo = e.jugador
        WHERE
            j.procedencia = 'Argentina') AS clave_candado_D
FROM
    estadisticas
LIMIT 1;