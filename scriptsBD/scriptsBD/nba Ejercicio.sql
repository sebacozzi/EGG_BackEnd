-- 1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
SELECT 
    Nombre
FROM
    jugadores
ORDER BY nombre;

-- 2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por nombre alfabéticamente.
SELECT 
    nombre
FROM
    jugadores
WHERE
    Posicion = 'C' AND peso > 200
ORDER BY nombre;

-- 3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.
SELECT 
    nombre
FROM
    equipos
ORDER BY nombre;

-- 4. Mostrar el nombre de los equipos del este (East).
SELECT 
    nombre
FROM
    equipos
WHERE
    UPPER(Conferencia) = 'EAST';

-- 5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
SELECT 
    *
FROM
    equipos
WHERE
    UPPER(ciudad) LIKE 'C%'
ORDER BY nombre;

-- 6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
select nombre, nombre_equipo from jugadores
order by Nombre_equipo;

-- 7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
select * from jugadores
where Nombre_equipo = 'Raptors'
order by nombre;

-- 8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.
select Puntos_por_partido from estadisticas
where jugador = (select codigo from jugadores where nombre = 'Pau Gasol');

-- 9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
select Puntos_por_partido from estadisticas
where jugador = (select codigo from jugadores where nombre = 'Pau Gasol') and
temporada = '04/05';

-- 10. Mostrar el número de puntos de cada jugador en toda su carrera.
select nombre, sum(Puntos_por_partido) from jugadores
inner join estadisticas on estadisticas.jugador = jugadores.codigo
group by nombre;

-- 11. Mostrar el número de jugadores de cada equipo.
select Nombre_equipo, count(nombre_equipo) from jugadores
 group by Nombre_equipo;

-- 12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
select nombre, sum(Puntos_por_partido) from jugadores
inner join estadisticas on estadisticas.jugador = jugadores.codigo
group by nombre
order by sum(Puntos_por_partido) desc
limit 1;

-- 13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
select nombre, conferencia, division from equipos
where nombre = (select Nombre_equipo from jugadores
order by altura desc limit 1);

-- 14. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
select avg(Puntos_por_partido) from estadisticas
 where jugador in (select codigo from jugadores where nombre_equipo in (select nombre from equipos where division = 'Pacific'))
 group by jugador;

-- 15. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
select equipo_local, equipo_visitante, abs(puntos_local-puntos_visitante) as diferencia FROM partidos

where abs(puntos_local-puntos_visitante)= (select abs(puntos_local-puntos_visitante) FROM partidos
order by abs(puntos_local-puntos_visitante) desc
limit 1);

-- 16. Mostrar la media de puntos en partidos de los equipos de la división Pacific.


-- 17. Mostrar los puntos de cada equipo en los partidos, tanto de local como de visitante.
select equipo_local,puntos_local,equipo_visitante,puntos_visitante from partidos;

-- 18. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, equipo_ganador), en caso de empate sera null.
SELECT 
    codigo,
    equipo_local,
    equipo_visitante,
    IF(puntos_local < puntos_visitante,
        equipo_visitante,
        IF(puntos_local > puntos_visitante,
            equipo_local,
            NULL)) AS equipo_ganador
FROM
    partidos; 