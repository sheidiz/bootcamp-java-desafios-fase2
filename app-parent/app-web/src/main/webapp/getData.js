const getPokemon = () => {
  var idPokemon = document.getElementById("pokemonId").value;
  var pokemonInfo = document.getElementById("content");

  var intIdPokemon = parseInt(idPokemon);
  if(intIdPokemon >=1  && intIdPokemon <=1017){
    var url = 'http://localhost:8080/app-web/api/pokemon?id=' + idPokemon;
    fetch(url)
      .then(
        response => response.json()
      ).then(
        data => {
          pokemonInfo.innerHTML = `
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