--Consulta 1
SELECT cita.codigo,cita.cod_cliente, cita.fecha, cita.horario, cita.cod_tratamiento, cita.cod_promocion, cita.cancelar FROM cita
JOIN cliente
ON cliente.codigo = cita.cod_cliente
JOIN tratamiento
ON tratamiento.codigo = cita.cod_tratamiento
JOIN promocion
on promocion.codigo = cita.cod_promocion
--Consulta 2
SELECT cita.codigo,cita.cod_cliente, cita.fecha, cita.horario, cita.cod_tratamiento, cita.cod_promocion, cita.cancelar FROM cita
JOIN cliente
ON cliente.codigo = cita.cod_cliente
JOIN tratamiento
ON tratamiento.codigo = cita.cod_tratamiento
JOIN promocion
ON promocion.codigo = cita.cod_promocion
WHERE cita.cancelar