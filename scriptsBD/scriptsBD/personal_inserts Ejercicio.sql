 -- 1. Obtener los datos completos de los empleados.
select * from departamentos;

-- 2. Obtener los datos completos de los departamentos.
SELECT * FROM empleados;

-- 3. Listar el nombre de los departamentos.
select nombre_depto from departamentos;

-- 4. Obtener el nombre y salario de todos los empleados.
select nombre,sal_emp from empleados;

-- 5. Listar todas las comisiones.
select comision_emp from empleados;

-- 6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
select * from empleados where UPPER(cargo_emp) = 'SECRETARIA';

-- 7. Obtener los datos de los empleados vendedores, ordenados por nombre alfabéticamente.
select * from empleados where UPPEr(cargo_emp) = 'VENDEDOR' order by nombre;

-- 8. Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a mayor.
select nombre, cargo_emp from empleados order by sal_emp;

-- 9. Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad de “Ciudad Real”
select nombre from empleados where upper(cargo_emp) like 'JEFE%' and id_depto in (select id_depto from departamentos where UPPER(ciudad) = 'CIUDAD REAL');

-- 10. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las respectivas tablas de empleados.
select nombre as Nombre, cargo_emp as Cargo from empleados;

-- 11. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión de menor a mayor.
select sal_emp,comision_emp from empleados where id_depto = 2000 order by comision_emp; 

/* 12. Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta 
de: sumar el salario y la comisión, más una bonificación de 500. Mostrar el nombre del
empleado y el total a pagar, en orden alfabético.
*/
select nombre,(sal_emp + comision_emp + 500) as Sueldo from empleados where id_depto = 3000 order by nombre;

-- 13. Muestra los empleados cuyo nombre empiece con la letra J.
select * from empleados where nombre like 'J%';

-- 14. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos empleados que tienen comisión superior a 1000.
select sal_emp, comision_emp,(sal_emp + comision_emp) as Sueldo, nombre from empleados where comision_emp>1000;

-- 15. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión.
select sal_emp, comision_emp,(sal_emp + comision_emp) as Sueldo, nombre from empleados where comision_emp=0;

-- 16. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
select * from empleados where comision_emp>sal_emp;

-- 17. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
select * from empleados where comision_emp<=(sal_emp*0.3); 

-- 18. Hallar los empleados cuyo nombre no contiene la cadena “MA”
select * from empleados where nombre not like 'MA';
select * from empleados where UPPER(nombre) not like 'MA';

-- 19. Obtener los nombres de los departamentos que sean “Ventas”, “Investigación” o ‘Mantenimiento.
select * from departamentos where lower(nombre_depto) in ('ventas', 'investigación', 'mantenimiento');
select * from departamentos;

-- 20. Ahora obtener el contrario, los nombres de los departamentos que no sean “Ventas” ni “Investigación” ni ‘Mantenimiento.
select * from departamentos where lower(nombre_depto) not in ('ventas', 'investigación', 'mantenimiento');

-- 21. Mostrar el salario más alto de la empresa.
select max(sal_emp) as Salario_Maximo from empleados;

-- 22. Mostrar el nombre del último empleado de la lista por orden alfabético.
<<<<<<< HEAD
select nombre from empleados order by nombre DESC limit 1;

-- 23. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
select * from empleados order by sal_emp;
select (Max(sal_emp)-min(sal_emp)) as Diferencia from empleados;

-- 24. Hallar el salario promedio por departamento. 
select avg(empleados.sal_emp) as Promedio, departamentos.nombre_depto from empleados,departamentos where empleados.id_depto = departamentos.id_depto group by departamentos.id_depto;

-- Consultas con Having
-- 25. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de empleados de esos departamentos.
select departamentos.nombre_depto, count(empleados.nombre) as Empleados from departamentos, empleados 
	where departamentos.id_depto = empleados.id_depto
	group by empleados.id_depto
    having Empleados>3;

-- 26. Hallar los departamentos que no tienen empleados
select departamentos.nombre_depto, count(empleados.nombre) as Empleados from departamentos, empleados 
	where departamentos.id_depto = empleados.id_depto
	group by empleados.id_depto
    having Empleados=0;


-- Consulta Multitabla (Uso de la sentencia JOIN/LEFT JOIN/RIGHT JOIN)
-- 27. Mostrar la lista de empleados, con su respectivo departamento y el jefe de cada departamento.
select id_emp,nombre,sex_emp,fec_nac,fec_incorporacion,sal_emp,comision_emp,cargo_emp, nombre_depto,nombre_jefe_depto from empleados
inner join departamentos on empleados.id_depto = departamentos.id_depto; 

-- Consulta con Subconsulta
-- 28. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.
select round(avg(sal_emp),3) Promedio_Sueldo from empleados;
select id_emp,nombre,sex_emp,fec_nac,fec_incorporacion,sal_emp,comision_emp,cargo_emp, nombre_depto,nombre_jefe_depto from empleados
inner join departamentos on empleados.id_depto = departamentos.id_depto 
where empleados.sal_emp >= (select avg(sal_emp) from empleados)
order by nombre_depto;
=======
select nombre from empleados
order by nombre desc
limit 1;

-- 23. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
select Max(sal_emp)-min(sal_emp) as diferencia from empleados;

-- 24. Hallar el salario promedio por departamento. 
select avg(empleados.sal_emp), departamentos.nombre_depto from empleados,departamentos
where empleados.id_depto = departamentos.id_depto
group by nombre_depto;

-- Consultas con Having
-- 25. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de empleados de esos departamentos.
select count(empleados.nombre) as Cantidad_Empleados, departamentos.nombre_depto from empleados, departamentos
where empleados.id_depto = departamentos.id_depto
group by empleados.id_depto
having Cantidad_Empleados >3;

-- 26. Hallar los departamentos que no tienen empleados
select count(empleados.nombre) as Cantidad_Empleados, departamentos.nombre_depto from empleados, departamentos
where empleados.id_depto = departamentos.id_depto
group by empleados.id_depto
having Cantidad_Empleados =0;

-- Consulta Multitabla (Uso de la sentencia JOIN/LEFT JOIN/RIGHT JOIN)
-- 27. Mostrar la lista de empleados, con su respectivo departamento y el jefe de cada departamento.
select empleados.*,nombre_depto, nombre_jefe_depto from empleados
inner join departamentos on empleados.id_depto = departamentos.id_depto;

-- Consulta con Subconsulta
-- 28. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.
select id_emp, nombre,sex_emp,fec_nac, fec_incorporacion,sal_emp,comision_emp,cargo_emp,nombre_depto from empleados
inner join departamentos on empleados.id_depto = departamentos.id_depto
where sal_emp >= (select avg(sal_emp) from empleados);
select avg(sal_emp) from empleados;
select count(*) from empleados;
>>>>>>> 5997b48ef64f412088969fbea2843bd21e095168
