const content = document.getElementById("content");

const getPokemon = () => {
  var idPokemon = document.getElementById("pokemonId").value;
  var intIdPokemon = parseInt(idPokemon);

  headers =
    `<tr>
      <th>ID</th>
      <th>Nombre</th>
      <th>Altura</th>
      <th>Peso</th>
    </tr>`;

  if (intIdPokemon >= 1 && intIdPokemon <= 1017) {
    var url = 'http://localhost:8080/app-web/api/pokemon?id=' + idPokemon;
    fetch(url)
      .then(
        response => response.json()
      ).then(
        data => {
          content.innerHTML = headers + `
          <tr>
            <td>${data.id}</td>
            <td>${data.name}</td>
            <td>${data.height / 10}m</td>
            <td>${data.weight / 10}kg</td>
          </tr>`;
        }
      ).catch(
        error => { console.log("Error al buscar el Pokemon", error); }
      );
  }
}

const getCovidUSData = () => {
  var dateCovid = document.getElementById("covidDate").value;
  var strDateCovid = dateCovid.replaceAll("-", "");

  headers =
    `<tr>
      <th>Fecha</th>
      <th>Positivos</th>
      <th>Negativos</th>
      <th>Pendientes</th>
    </tr>`;

  var url = 'http://localhost:8080/app-web/api/covid?date=' + strDateCovid;
  fetch(url)
    .then(
      response => response.json()
    ).then(
      data => {
        content.innerHTML = headers + `
          <tr>
            <td>${data.date}</td>
            <td>${data.positive}</td>
            <td>${data.negative}</td>
            <td>${data.pending}</td>
          </tr>`;
      }
    ).catch(
      error => { console.log("Error al buscar el Pokemon", error); }
    );
}

const getPost = () => {
  var idPost = document.getElementById("postId").value;
  var intIdPost = parseInt(idPost);

  headers =
    `<tr>
      <th>ID</th>
      <th>ID de Usuario</th>
      <th>Titulo</th>
      <th>Cuerpo</th>
    </tr>`;

  if (intIdPost >= 1 && intIdPost <= 100) {
    var url = 'http://localhost:8080/app-web/api/placeholder?id=' + intIdPost;
    fetch(url)
      .then(
        response => response.json()
      ).then(
        data => {
          content.innerHTML = headers + `
          <tr>
            <td>${data.id}</td>
            <td>${data.userId}</td>
            <td>${data.title}</td>
            <td>${data.body}</td>
          </tr>`;
        }
      ).catch(
        error => { console.log("Error al buscar el Post", error); }
      );
  }
}