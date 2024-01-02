import React from 'react';
import MensajeCSS from './Mensaje.module.css';

function Mensaje({ children }) {
    const valido = JSON.stringify(children).includes("Correcta");

    return (
        <div className={`mt-3 p-3 border text-center
        ${MensajeCSS.mensaje} ${valido ? 'bg-success-subtle' : 'bg-danger-subtle'}`}>
            {children}
        </div>
    )
}

export default Mensaje