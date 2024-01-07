import React, { useState } from 'react';
import CrearTurno from './CrearTurno';

function Turnero() {

    const [tipoTurno, setTipoTurno] = useState('');
    const [creacionTurnoAbierto, setCreacionTurnoAbierto] = useState(false);

    const handleOnClose = () => {
        setCreacionTurnoAbierto(false)
    }

    return (
        <>
            <div className="container m-2 p-2 border d-flex flex-row gap-3">
                <button className="btn btn-outline-dark rounded-0 fw-semibold"
                    onClick={() => { setTipoTurno('Caja'), setCreacionTurnoAbierto(true) }}>
                    CAJA
                </button>
                <button className="btn btn-outline-dark rounded-0 fw-semibold"
                    onClick={() => { setTipoTurno('Oficial'), setCreacionTurnoAbierto(true) }}>
                    OFICIAL
                </button>
                <button className="btn btn-outline-dark rounded-0 fw-semibold"
                    onClick={() => { setTipoTurno('Online'), setCreacionTurnoAbierto(true) }}>
                    ONLINE
                </button>
            </div>
            <CrearTurno visible={creacionTurnoAbierto} onClose={handleOnClose} tipoTurno={tipoTurno} />
        </>
    )
}

export default Turnero