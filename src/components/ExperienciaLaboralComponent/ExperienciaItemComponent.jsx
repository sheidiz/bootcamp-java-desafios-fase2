import React from "react";

function ExperienciaItemComponent( { experiencia } ) {
    const { puesto, empresa, fechas } = experiencia;

    return (
        <div className="pb-3">
            <p className="fw-bold mb-1">{puesto}</p>
            <div className="d-flex flex-col justify-content-between">
                <p className="d-inline">{empresa}</p>
                <p className="d-inline">{fechas}</p>
            </div>
        </div>
    )
}

export default ExperienciaItemComponent