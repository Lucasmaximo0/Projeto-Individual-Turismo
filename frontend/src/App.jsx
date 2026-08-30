import { useState } from "react"
import axios from"axios"
import "./App.css"
import ListaDestinos from "./componentes/ListaDestinos"
import CadastroDestino from "./componentes/CadastroDestino"

function App() {
  const[destinos,setDestinos] = useState([])



function buscarDados(){
  axios.get("http://localhost:8080/Destino")
  .then(resposta => {setDestinos(resposta.data)})
  .catch(erro => {
    console.log("Não foi possível buscar os destinos:", erro)
  })
}

return (
  <>
      <h1>Destinos Turísticos</h1>

      <CadastroDestino/>

      <button onClick={buscarDados}>
        Buscar Destinos
      </button>

      <ListaDestinos destinos={destinos}/>
    </>
  )
}

export default App
