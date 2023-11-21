const content = document.getElementById("content");

const getPokemon = () => {
  var idPokemon = document.getElementById("pokemonId").value;
  var intIdPokemon = parseInt(idPokemon);

  if(intIdPokemon >=1  && intIdPokemon <=1017){
    var url = 'http://localhost:8080/app-web/api/pokemon?id=' + idPokemon;
    fetch(url)
      .then(
        response => response.json()
      ).then(
        data => {
          content.innerHTML = `
          <p>ID: ${data.id}</p>
          <p>Nombre: ${data.name}</p>
          <p>Altura: ${data.height/10}m</p>
          <p>Peso: ${data.weight/10}kg</p>
      `;
        }
      ).catch(
        error => { console.log("Error al buscar el Pokemon", error); }
      );
  }

}

const getCovidUSData = () => {
  var dateCovid = document.getElementById("covidDate").value;
  console.log(dateCovid);
  var strDateCovid = dateCovid.replaceAll("-","");
  console.log(strDateCovid);

  var url = 'http://localhost:8080/app-web/api/covid?date=' + strDateCovid;
  fetch(url)
    .then(
      response => response.json()
    ).then(
      data => {
        content.innerHTML = `
        <p>Fecha: ${data.date}</p>
        <p>Positivos: ${data.positive}</p>
        <p>Negativos: ${data.negative}</p>
        <p>Pendientes: ${data.pending}</p>
    `;
      }
    ).catch(
      error => { console.log("Error al buscar el Pokemon", error); }
    );
}