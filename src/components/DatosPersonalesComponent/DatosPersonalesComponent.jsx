import React from "react";
import data from "../../utils/data";
import DatosPersonalesStyle from "./DatosPersonales.module.css";

function DatosPersonalesComponent() {
    return (
        <div>
            <h1 className="text-md-center">{data.datosPersonales.nombre}</h1>
            <h3 className="text-md-center pb-3">{data.datosPersonales.titulo}</h3>
            <hr className={DatosPersonalesStyle.borderGrey}/>
            <div className="text-md-start mx-4">
                <p className="fw-medium fs-5">Sobre mi</p>
                <p>{data.datosPersonales.sobreMi}</p>
                <p className="fw-medium fs-5 mb-2">Conocimientos</p>
                <ul className="text-start">
                    {data.datosPersonales.conocimientos.map((item, index) => {
                        return (<li key={index}>{item}</li>)
                    })}
                </ul>
            </div>
        </div>
    )
}

export default DatosPersonalesComponent;