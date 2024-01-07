export const crearTurno = (id, estado, fecha_turno, tipo_turno, motivo) => {
    return {
        id,
        estado,
        fechaTurno: fecha_turno,
        tipoTurno: tipo_turno,
        motivo
    }
}
export const crearTurnoOficial = (turno, nombre_oficial, apellido_oficial) => {
    return {
        ...turno,
        nombreOficial: nombre_oficial,
        apellidoOficial: apellido_oficial
    }
}
export const atenderTurno = (turno) => {
    return {
        ...turno,
        estado: 'Turno Atendido.'
    }
}
export const finalizarTurno = (turno, fecha_finalizacion) => {
    return {
        ...turno,
        estado: 'Turno Finalizado.',
        fechaFinalizacion: fecha_finalizacion
    }
}
