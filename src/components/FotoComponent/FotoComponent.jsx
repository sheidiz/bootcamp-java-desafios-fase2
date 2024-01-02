import React from "react";
import data from "../../utils/data";
import thisStyes from "./FotoComponent.module.css";

function FotoComponent() {
    return (
        <>
            <img className={thisStyes.img} src={data.foto} alt="Imagen de perfil" />
        </>
    )
}

export default FotoComponent