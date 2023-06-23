-- 1. Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
SELECT codigo_oficina, ciudad from oficina;

-- 2. Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
select ciudad, telefono from oficina
where pais = 'Espana';

-- 3. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
select nombre, concat(apellido1,' ', apellido2) as apellidos, email from empleado
where codigo_jefe = 7;

-- 4. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
select puesto, nombre, concat(apellido1, ' ', apellido2) apellidos, email from empleado
where codigo_jefe is null;

-- 5. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
select	nombre, concat(apellido1, ' ', apellido2) apellidos, puesto from empleado
where upper(puesto)  <> 'REPRESENTANTE VENTAS';

-- 6. Devuelve un listado con el nombre de los todos los clientes españoles.
select nombre_cliente from cliente
where upper(pais)  = 'SPAIN';

-- 7. Devuelve un listado con los distintos estados por los que puede pasar un pedido.
select distinct estado from pedido;

-- 8. Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga 
 -- en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. 
	-- Resuelva la consulta:
	-- o Utilizando la función YEAR de MySQL.
	-- o Utilizando la función DATE_FORMAT de MySQL.
	-- o Sin utilizar ninguna de las funciones anteriores.
select codigo_cliente from pago
where year(fecha_pago) = 2008;

select codigo_cliente from pago
where date_format(fecha_pago,'%Y') = 2008;

select codigo_cliente from pago
where fecha_pago >= '2008-01-01' and fecha_pago <= '2008-12-31' ;

-- 9. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de
 -- entrega de los pedidos que no han sido entregados a tiempo.
select codigo_pedido,codigo_cliente, fecha_esperada, fecha_entrega from pedido
where fecha_entrega> fecha_esperada;

-- 10. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de
 -- entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.
	-- o Utilizando la función ADDDATE de MySQL.
	-- o Utilizando la función DATEDIFF de MySQL.
select codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega from pedido
where (adddate( fecha_entrega, interval 2 day)) < fecha_esperada;

select codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega from pedido
where (datediff(fecha_esperada,fecha_entrega)) > 2;
    
-- 11. Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
select * from pedido
where upper(estado) = 'RECHAZADO';

-- 12. Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
select * from pedido
where month(fecha_entrega) = 1
and Upper(estado) = 'ENTREGADO'; 

-- 13. Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal.
 -- Ordene el resultado de mayor a menor.
select * from pago
where upper(forma_pago) = 'PAYPAL'
 and year(fecha_pago) = 2008
 order by total desc;

-- 14. Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en
 -- cuenta que no deben aparecer formas de pago repetidas.
select distinct forma_pago from pago;
 
-- 15. Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que
 -- tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de
 -- venta, mostrando en primer lugar los de mayor precio.
 select * from 
 producto
 where upper(gama) = 'ORNAMENTALES' and
 cantidad_en_stock > 100
 order by precio_venta desc;
 
-- 16. Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo
 -- representante de ventas tenga el código de empleado 11 o 30.
select * from cliente
where ciudad = 'Madrid' and
codigo_empleado_rep_ventas in (11,30);


/*Consultas multitabla (Composición interna)
Las consultas se deben resolver con INNER JOIN.*/
-- 1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
select cliente.nombre_cliente, concat(empleado.nombre,' ', empleado.apellido1) as Nombre_Apellido from cliente 
inner join empleado on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado;

-- 2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
select cliente.nombre_cliente, concat(empleado.nombre,' ', empleado.apellido1) as Nombre_Apellido from cliente 
inner join empleado on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
where cliente.codigo_cliente in (select pago.codigo_cliente from pago);

-- 3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.
select cliente.nombre_cliente, concat(empleado.nombre,' ', empleado.apellido1) as Nombre_Apellido from cliente 
inner join empleado on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
where cliente.codigo_cliente not in (select pago.codigo_cliente from pago);

-- 4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes
 -- junto con la ciudad de la oficina a la que pertenece el representante.
select cliente.nombre_cliente, concat(empleado.nombre,' ', empleado.apellido1) as Nombre_y_Apellido, oficina.ciudad from cliente 
inner join empleado on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
inner join oficina on empleado.codigo_oficina = oficina.codigo_oficina
where cliente.codigo_cliente in (select pago.codigo_cliente from pago);
 
-- 5. Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus
 -- representantes junto con la ciudad de la oficina a la que pertenece el representante.
 select cliente.nombre_cliente, concat(empleado.nombre,' ', empleado.apellido1) as Nombre_y_Apellido, oficina.ciudad from cliente 
inner join empleado on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
inner join oficina on empleado.codigo_oficina = oficina.codigo_oficina
where cliente.codigo_cliente not in (select pago.codigo_cliente from pago);

-- 6. Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
SELECT 
    oficina.linea_direccion1
FROM
    oficina
        INNER JOIN
    empleado ON oficina.codigo_oficina IN (SELECT 
            empleado.codigo_oficina
        FROM
            oficina
                INNER JOIN
            cliente ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
        WHERE
            cliente.ciudad = 'Fuenlabrada');


-- 7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad
 -- de la oficina a la que pertenece el representante.
select cliente.nombre_cliente, concat(empleado.nombre,' ', empleado.apellido1) as representante, oficina.ciudad from cliente
inner join empleado on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
inner join oficina on empleado.codigo_oficina = oficina.codigo_oficina;
 
-- 8. Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
select concat(empleado.nombre,' ', empleado.apellido1) as empleado, concat(jefe.nombre,' ', jefe.apellido1) as jefe from empleado
inner join empleado as jefe on jefe.codigo_empleado = empleado.codigo_jefe;

-- 9. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
select distinct nombre_cliente from cliente
inner join pedido on cliente.codigo_cliente = pedido.codigo_cliente
where pedido.fecha_esperada <> fecha_entrega;

-- 10. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
select distinct cliente.nombre_cliente, producto.gama from producto
inner join detalle_pedido on detalle_pedido.codigo_producto = producto.codigo_producto
inner join pedido on detalle_pedido.codigo_pedido = pedido.codigo_pedido
inner join cliente on pedido.codigo_cliente = cliente.codigo_cliente;

/*Consultas multitabla (Composición externa)
Resuelva todas las consultas utilizando las cláusulas LEFT JOIN, RIGHT JOIN, JOIN.*/
-- 1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
SELECT DISTINCT
    c.codigo_cliente,
    c.nombre_cliente,
    p.fecha_pago
FROM
    pago p
        RIGHT JOIN
    cliente c ON c.codigo_cliente = p.codigo_cliente
WHERE
    p.codigo_cliente IS NULL
ORDER BY c.codigo_cliente;

-- 2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
SELECT DISTINCT
    cliente.nombre_cliente, pedido.fecha_pedido
FROM
    pedido
        RIGHT JOIN
    cliente ON cliente.codigo_cliente = pedido.codigo_cliente
WHERE
    pedido.codigo_cliente IS NULL
ORDER BY nombre_cliente;

-- 3. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que
 -- no han realizado ningún pedido.
 SELECT DISTINCT
    cliente.codigo_cliente,
    cliente.nombre_cliente,
    pedido.fecha_pedido,
    pago.fecha_pago
FROM
    pedido
        RIGHT JOIN
    cliente ON cliente.codigo_cliente = pedido.codigo_cliente
        LEFT JOIN
    pago ON cliente.codigo_cliente = pago.codigo_cliente
WHERE
    pedido.codigo_cliente IS NULL
ORDER BY codigo_cliente;

-- 4. Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
SELECT 
    *
FROM
    empleado
WHERE
    empleado.codigo_oficina IS NULL;

--  5. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
SELECT DISTINCT
    empleado.nombre, cliente.nombre_cliente
FROM
    empleado
        LEFT JOIN
    cliente ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
WHERE
    codigo_cliente IS NULL;

-- 6. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los
 -- que no tienen un cliente asociado.
SELECT DISTINCT
    empleado.nombre, cliente.nombre_cliente
FROM
    empleado
        LEFT JOIN
    cliente ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
WHERE
    codigo_cliente IS NULL
        AND empleado.codigo_oficina IS NULL;

-- 7. Devuelve un listado de los productos que nunca han aparecido en un pedido.
SELECT 
    p.codigo_producto, p.nombre, p.precio_venta
FROM
    producto p
        LEFT JOIN
    detalle_pedido dp ON dp.codigo_producto = p.codigo_producto
WHERE
    dp.cantidad IS NULL
GROUP BY p.codigo_producto;

-- 8. Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los
 -- representantes de ventas de algún cliente que haya realizado la compra de algún producto
 -- de la gama Frutales.
 SELECT DISTINCT
    o.codigo_oficina,
    o.linea_direccion1,
    o.ciudad,
    o.pais,
    pr.gama
FROM
    oficina o
        LEFT JOIN
    empleado e ON e.codigo_oficina = o.codigo_oficina
        LEFT JOIN
    cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
        LEFT JOIN
    pedido p ON p.codigo_cliente = c.codigo_cliente
        LEFT JOIN
    detalle_pedido dp ON dp.codigo_pedido = p.codigo_pedido
        LEFT JOIN
    producto pr ON pr.codigo_producto = dp.codigo_producto
WHERE
    pr.gama <> 'Frutales';
 
-- 9. Devuelve un listado con los clientes que han realizado algún pedido, pero no han realizado ningún pago.
SELECT DISTINCT
    cl.nombre_cliente, pa.total
FROM
    cliente cl
        LEFT JOIN
    pedido p ON p.codigo_cliente = cl.codigo_cliente
        LEFT JOIN
    pago pa ON p.codigo_cliente = pa.codigo_cliente
WHERE
    pa.codigo_cliente IS NULL;

-- 10. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.
SELECT DISTINCT
    e.nombre, e.apellido1, e1.nombre AS nombre_jefe
FROM
    empleado e
        RIGHT JOIN
    empleado e1 ON e.codigo_empleado = e1.codigo_jefe
        LEFT JOIN
    cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE
    c.codigo_empleado_rep_ventas IS NULL;

/*Consultas resumen*/
-- 1. ¿Cuántos empleados hay en la compañía?
SELECT 
    COUNT(*) AS Empleados
FROM
    empleado;

-- 2. ¿Cuántos clientes tiene cada país?
SELECT 
    COUNT(*) AS Cantidad, pais
FROM
    cliente
GROUP BY pais;

-- 3. ¿Cuál fue el pago medio en 2009?
SELECT 
    SUM(pago.total) / COUNT(*)
FROM
    pago
WHERE
    YEAR(fecha_pago) = 2009;

-- 4. ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
SELECT 
    COUNT(estado), estado
FROM
    pedido
GROUP BY estado
ORDER BY COUNT(estado) DESC;

-- 5. Calcula el precio de venta del producto más caro y más barato en una misma consulta.
SELECT 
    MAX(precio_venta) AS Mas_Caro,
    MIN(precio_venta) AS Mas_Barato
FROM
    producto;

-- 6. Calcula el número de clientes que tiene la empresa.
SELECT 
    COUNT(*) AS Cantidad_Clientes
FROM
    cliente;

-- 7. ¿Cuántos clientes tiene la ciudad de Madrid?
SELECT 
    COUNT(*) AS Cantidad_Clientes
FROM
    cliente
WHERE
    UPPER(ciudad) = 'MADRID';

-- 8. ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?
SELECT 
    ciudad, COUNT(*) AS Cantidad_Clientes
FROM
    cliente
WHERE
    UPPER(ciudad) LIKE 'M%'
GROUP BY ciudad;

-- 9. Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
SELECT 
    CONCAT(empleado.nombre, ' ', empleado.apellido1) AS nombre_apellido,
    COUNT(cliente.nombre_cliente) AS cantidad
FROM
    empleado,
    cliente
WHERE
    cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
GROUP BY nombre_apellido;

-- 10. Calcula el número de clientes que no tiene asignado representante de ventas.
SELECT 
    COUNT(*) clientes_sin_vendedor
FROM
    cliente
WHERE
    codigo_empleado_rep_ventas IS NULL;

-- 11. Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado
 -- deberá mostrar el nombre y los apellidos de cada cliente.
SELECT 
    CONCAT(cliente.nombre_cliente,
            '-> ',
            cliente.nombre_contacto,
            ' ',
            cliente.apellido_contacto) AS nombre_completo,
    MIN(pago.fecha_pago) AS primer_pago,
    MAX(pago.fecha_pago) AS ultimo_pago
FROM
    cliente
        LEFT JOIN
    pago ON pago.codigo_cliente = cliente.codigo_cliente
GROUP BY cliente.codigo_cliente;

-- 12. Calcula el número de productos diferentes que hay en cada uno de los pedidos.
SELECT 
    codigo_pedido,
    COUNT(codigo_producto) AS cantidad_items,
    SUM(precio_unidad * cantidad) AS total_pedido
FROM
    detalle_pedido
GROUP BY codigo_pedido;

-- 13. Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.
SELECT 
    codigo_pedido, SUM(cantidad) AS total_productos
FROM
    detalle_pedido
GROUP BY codigo_pedido;

-- 14. Devuelve un listado de los 20 productos más vendidos y el número total de unidades que
 -- se han vendido de cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.
SELECT 
    producto.nombre,
    COUNT(detalle_pedido.codigo_producto) AS cantidad
FROM
    detalle_pedido,
    producto
WHERE
    producto.codigo_producto = detalle_pedido.codigo_producto
GROUP BY detalle_pedido.codigo_producto
ORDER BY cantidad DESC
LIMIT 20;

-- 15. La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el
 -- IVA y el total facturado. La base imponible se calcula sumando el coste del producto por el
 -- número de unidades vendidas de la tabla detalle_pedido. El IVA es el 21 % de la base
 -- imponible, y el total la suma de los dos campos anteriores.
SELECT 
    SUM(cantidad * precio_unidad) AS base_imponible,
    (SUM(cantidad * precio_unidad) * 0.21) AS IVA,
    (SUM(cantidad * precio_unidad) + (SUM(cantidad * precio_unidad) * 0.21)) AS total_ventas
FROM
    detalle_pedido;

-- 16. La misma información que en la pregunta anterior, pero agrupada por código de producto.
SELECT 
    SUM(d.cantidad * d.precio_unidad) AS base_imponible,
    (SUM(d.cantidad * d.precio_unidad) * 0.21) AS IVA,
    (SUM(d.cantidad * d.precio_unidad) + (SUM(d.cantidad * d.precio_unidad) * 0.21)) AS total_ventas,
    p.nombre
FROM
    detalle_pedido d, producto p
where d.codigo_producto = p.codigo_producto
group by d.codigo_producto ;
    
-- 17. La misma información que en la pregunta anterior, pero agrupada por código de producto
 -- filtrada por los códigos que empiecen por OR.
 SELECT 
    SUM(d.cantidad * d.precio_unidad) AS base_imponible,
    (SUM(d.cantidad * d.precio_unidad) * 0.21) AS IVA,
    (SUM(d.cantidad * d.precio_unidad) + (SUM(d.cantidad * d.precio_unidad) * 0.21)) AS total_ventas,
    p.nombre,
    d.codigo_producto
FROM
    detalle_pedido d,
    producto p
WHERE
    d.codigo_producto = p.codigo_producto
        AND d.codigo_producto LIKE 'OR%'
GROUP BY d.codigo_producto;
 
 
-- 18. Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se
 -- mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA)
 SELECT 
    p.nombre,
    SUM(d.cantidad) AS cantidad,
    SUM(d.cantidad * d.precio_unidad) AS base_imponible,
    (SUM(d.cantidad * d.precio_unidad) + (SUM(d.cantidad * d.precio_unidad) * 0.21)) AS total
FROM
    detalle_pedido d,
    producto p
WHERE
    p.codigo_producto = d.codigo_producto
GROUP BY d.codigo_producto
HAVING total > 3000;
 
 
/*Subconsultas con operadores básicos de comparación*/
-- 1. Devuelve el nombre del cliente con mayor límite de crédito.
SELECT 
    nombre_cliente
FROM
    cliente
WHERE
    codigo_cliente = (SELECT 
            codigo_cliente
        FROM
            cliente
        ORDER BY limite_credito DESC
        LIMIT 1);

-- 2. Devuelve el nombre del producto que tenga el precio de venta más caro.
SELECT 
    nombre
FROM
    producto
ORDER BY precio_venta DESC
LIMIT 1;

-- 3. Devuelve el nombre del producto del que se han vendido más unidades. (Tenga en cuenta
 -- que tendrá que calcular cuál es el número total de unidades que se han vendido de cada
 -- producto a partir de los datos de la tabla detalle_pedido. Una vez que sepa cuál es el código
 -- del producto, puede obtener su nombre fácilmente.)
 select nombre from producto
 where codigo_producto = (select codigo_producto, sum(cantidad) as none from detalle_pedido limit 1 );
 
 
 
-- 4. Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER JOIN).
-- 5. Devuelve el producto que más unidades tiene en stock.
-- 6. Devuelve el producto que menos unidades tiene en stock.
-- 7. Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria.

/*Subconsultas con ALL y ANY*/
-- 1. Devuelve el nombre del cliente con mayor límite de crédito.
-- 2. Devuelve el nombre del producto que tenga el precio de venta más caro.
-- 3. Devuelve el producto que menos unidades tiene en stock.

/*Subconsultas con IN y NOT IN*/
-- 1. Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente.
-- 2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
-- 3. Devuelve un listado que muestre solamente los clientes que sí han realizado ningún pago.
-- 4. Devuelve un listado de los productos que nunca han aparecido en un pedido.
-- 5. Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que
 -- no sean representante de ventas de ningún cliente.
 
 
/*Subconsultas con EXISTS y NOT EXISTS*/
-- 1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
-- 2. Devuelve un listado que muestre solamente los clientes que sí han realizado ningún pago.
-- 3. Devuelve un listado de los productos que nunca han aparecido en un pedido.
-- 4. Devuelve un listado de los productos que han aparecido en un pedido alguna vez.

