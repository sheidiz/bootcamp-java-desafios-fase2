export const toFecha = (inputFecha) => {
    const inputFechaSplit = inputFecha.split("/");

    const dia = parseInt(inputFechaSplit[0]);
    const mes = parseInt(inputFechaSplit[1]);
    const anio = parseInt(inputFechaSplit[2]);

    if (!validarFecha(dia, mes, anio) || inputFecha.length !== 10) return null;

    return {
        dia: inputFechaSplit[0],
        mes: inputFechaSplit[1],
        anio: inputFechaSplit[2]
    }
}

const validarAnio = (anio) => {
    return (anio >= 1900 && anio <= 2099);
}

const validarMes = (mes) => {
    return (mes >= 1 && mes <= 12);
}

const esAnioBisiesto = (anio) => {
    return ((anio % 4 == 0) && (anio % 100 != 0 || (anio % 100 == 0 && anio % 400 == 0)));
}

const validarFecha = (dia, mes, anio) => {
    let diasXMes = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    if (esAnioBisiesto(anio)) diasXMes[1] = 29;

    return (dia > 0 && dia <= diasXMes[mes - 1]) && (validarMes(mes)) && (validarAnio(anio));
}