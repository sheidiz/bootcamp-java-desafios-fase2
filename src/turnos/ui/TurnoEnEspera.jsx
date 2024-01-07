import React from 'react'

export default function TurnoEnEspera({id, turno}) {
    return (
        <div className='p-3 border'>
            <p>T{id} {turno.tipoTurno}</p>
            <button>Atender</button>
        </div>
    )
}
