/* A continuación, se deben realizar las siguientes consultas:*/
-- 1. Mostrar el nombre de todos los pokemon.
SELECT 
    nombre
FROM
    pokemon;

-- 2. Mostrar los pokemon que pesen menos de 10k.
SELECT 
    *
FROM
    pokemon
WHERE
    peso < 10;
    
-- 3. Mostrar los pokemon de tipo agua.
call muestraPokemonByTipo('agua');
SELECT 
    *
FROM
    pokemon p
WHERE
    EXISTS( SELECT 
            *
        FROM
            pokemon_tipo pt
        WHERE
            pt.id_tipo = (SELECT 
                    id_tipo
                FROM
                    tipo
                WHERE
                    UPPER(nombre) = 'AGUA'));

-- 4. Mostrar los pokemon de tipo agua, fuego o tierra ordenados por tipo.
select * from pokemon p
where numero_pokedex in (select numero_pokedex from pokemon_tipo pt where pt.id_tipo in (select id_tipo from tipo where upper(nombre) in ('AGUA','TIERRA','FUEGO')));

-- 5. Mostrar los pokemon que son de tipo fuego y volador.
call muestraPokemonByTipos('fuego','volador');
SELECT 
    *
FROM
    pokemon p
WHERE
    numero_pokedex IN (SELECT 
            numero_pokedex
        FROM
            pokemon_tipo pt
        WHERE
            pt.id_tipo IN (SELECT 
                    id_tipo
                FROM
                    tipo
                WHERE
                    UPPER(nombre) IN ('VOLADOR', 'FUEGO')));

-- 6. Mostrar los pokemon con una estadística base de ps mayor que 200.
SELECT 
    *
FROM
    pokemon
WHERE
    numero_pokedex IN (SELECT 
            numero_pokedex
        FROM
            estadisticas_base
        WHERE
            ps > 200);

-- 7. Mostrar los datos (nombre, peso, altura) de la prevolución de Arbok.
SELECT 
    nombre, peso, altura
FROM
    pokemon
WHERE
    numero_pokedex = (SELECT 
            pokemon_origen
        FROM
            evoluciona_de
        WHERE
            pokemon_evolucionado = (SELECT 
                    numero_pokedex
                FROM
                    pokemon
                WHERE
                    nombre = 'Arbok'));
                    
-- 8. Mostrar aquellos pokemon que evolucionan por intercambio.
SELECT 
    *
FROM
    pokemon
WHERE
    numero_pokedex IN (SELECT 
            numero_pokedex
        FROM
            pokemon_forma_evolucion
        WHERE
            id_forma_evolucion = (SELECT 
                    id_tipo_evolucion
                FROM
                    tipo_evolucion
                WHERE
                    tipo_evolucion = 'Intercambio'));

-- 9. Mostrar el nombre del movimiento con más prioridad.
select * from movimiento
order by prioridad desc
limit 1;

-- 10. Mostrar el pokemon más pesado.
SELECT 
    *
FROM
    pokemon
ORDER BY peso DESC
LIMIT 1;

-- 11. Mostrar el nombre y tipo del ataque con más potencia.
select a.nombre, (select tipo from tipo_ataque where id_tipo_ataque = a.id_tipo) as tipo, potencia from movimiento a
where potencia = (select max(potencia) from movimiento);

-- 12. Mostrar el número de movimientos de cada tipo.
select count(*) as movimientos, (select tipo from tipo_ataque where id_tipo_ataque = a.id_tipo) as tipo from movimiento a
group by tipo;

-- 13. Mostrar todos los movimientos que puedan envenenar.
/* Segun la descripcion del movimiento*/
select * from movimiento where descripcion like '%enven%';

/* Segun el movimento secundario */
SELECT 
    *
FROM
    movimiento
WHERE
    id_movimiento IN (SELECT 
            id_movimiento
        FROM
            movimiento_efecto_secundario
        WHERE
            id_efecto_secundario = (SELECT 
                    id_efecto_secundario
                FROM
                    efecto_secundario
                WHERE
                    efecto_secundario LIKE '%enven%'));
                    
-- 14. Mostrar todos los movimientos que causan daño, ordenados alfabéticamente por nombre.
SELECT 
    *
FROM
    movimiento
WHERE
    potencia > 0
ORDER BY nombre;
SELECT 
    *
FROM
    movimiento
WHERE
    descripcion LIKE '%daño%'
ORDER BY nombre;

-- 15. Mostrar todos los movimientos que aprende pikachu.
SELECT 
    p.nombre AS pokemon,
    m.nombre AS nombre_ataque,
    tf.tipo_aprendizaje
FROM
    pokemon_movimiento_forma pm
        INNER JOIN
    movimiento m ON pm.id_movimiento = m.id_movimiento
        INNER JOIN
    pokemon p ON p.numero_pokedex = pm.numero_pokedex
        LEFT JOIN
    tipo_forma_aprendizaje tf ON pm.id_forma_aprendizaje = tf.id_tipo_aprendizaje
WHERE
    pm.numero_pokedex = (SELECT 
            numero_pokedex
        FROM
            pokemon
        WHERE
            nombre = 'pikachu');

-- 16. Mostrar todos los movimientos que aprende pikachu por MT (tipo de aprendizaje).
SELECT 
    p.nombre AS pokemon,
    m.nombre AS nombre_ataque,
    tf.tipo_aprendizaje
FROM
    pokemon_movimiento_forma pm
        INNER JOIN
    movimiento m ON pm.id_movimiento = m.id_movimiento
        INNER JOIN
    pokemon p ON p.numero_pokedex = pm.numero_pokedex
        RIGHT JOIN
    tipo_forma_aprendizaje tf ON pm.id_forma_aprendizaje = tf.id_tipo_aprendizaje
WHERE
    pm.numero_pokedex = (SELECT 
            numero_pokedex
        FROM
            pokemon
        WHERE
            nombre = 'pikachu');

-- 17. Mostrar todos los movimientos de tipo normal que aprende pikachu por nivel.

-- 18. Mostrar todos los movimientos de efecto secundario cuya probabilidad sea mayor al 30%.
SELECT 
    m.nombre,
    (SELECT 
            efecto_secundario
        FROM
            efecto_secundario
        WHERE
            id_efecto_secundario = mes.id_efecto_secundario) descrip,
    mes.probabilidad
FROM
    movimiento_efecto_secundario mes
        INNER JOIN
    movimiento m ON m.id_movimiento = mes.id_movimiento
WHERE
    mes.probabilidad > 30;
    
-- 19. Mostrar todos los pokemon que evolucionan por piedra.
select * from pokemon_evolucion_piedra;

-- 20. Mostrar todos los pokemon que no pueden evolucionar.
select * from pokemon_no_evolucionan;

-- 21. Mostrar la cantidad de los pokemon de cada tipo.
select * from cantidad_tipo_pokemon;
