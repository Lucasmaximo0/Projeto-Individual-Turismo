import { useState } from "react"
import axios from "axios"

function CadastroDestino() {

    const [nome, setNome] = useState("")
    const [cidade, setCidade] = useState("")
    const [estado, setEstado] = useState("")
    const [descricao, setDescricao] = useState("")
    const [precoMedio, setPrecoMedio] = useState("")

    function cadastrarDestino(event) {

        event.preventDefault()

        const destino = {
            nome: nome,
            cidade: cidade,
            estado: estado,
            descricao: descricao,
            precoMedio: Number(precoMedio)
        }

        axios.post("http://localhost:8080/Destino", destino)
            .then(resposta => {
                console.log("Destino cadastrado:", resposta.data)

                alert("Destino cadastrado com sucesso!")

                setNome("")
                setCidade("")
                setEstado("")
                setDescricao("")
                setPrecoMedio("")
            })
            .catch(erro => {
                console.log("Não foi possível cadastrar o destino:", erro)
            })
    }

    return (
        <form onSubmit={cadastrarDestino}>

            <h2>Cadastrar Destino</h2>

            <input
                type="text"
                placeholder="Nome"
                value={nome}
                onChange={event => setNome(event.target.value)}
            />
            <br />

            <input
                type="text"
                placeholder="Cidade"
                value={cidade}
                onChange={event => setCidade(event.target.value)}
            />
            <br />

            <input
                type="text"
                placeholder="Estado"
                value={estado}
                onChange={event => setEstado(event.target.value)}
            />
            <br />

            <input
                type="text"
                placeholder="Descrição"
                value={descricao}
                onChange={event => setDescricao(event.target.value)}
            />
            <br />

            <input
                type="number"
                placeholder="Preço médio"
                value={precoMedio}
                onChange={event => setPrecoMedio(event.target.value)}
            />
            <br /><br />

            <button type="submit">
                Cadastrar
            </button>
            <br />
            <br />

        </form>
    )
}

export default CadastroDestino