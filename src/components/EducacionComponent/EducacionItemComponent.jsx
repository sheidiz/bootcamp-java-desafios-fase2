import React from 'react'

function EducacionItemComponent({ educacion }) {
    const { titulo, institucion, fechas, detalles } = educacion;

    return (
        <div className="pb-3">
            <p className="fw-bold mb-1">{titulo}</p>
            <div className="d-flex flex-col justify-content-between">
                <p className="d-inline">{institucion}</p>
                <p className="d-inline">{fechas}</p>
            </div>
            <p>{detalles}</p>
        </div>
    )
}

export default EducacionItemComponent