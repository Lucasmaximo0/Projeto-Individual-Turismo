    import axios from "axios"

    function DestinoCard({ destino }) {

    function excluirDestino() {

        axios.delete(`http://localhost:8080/Destino/${destino.id}`)
            .then(() => {
                alert("Destino excluído com sucesso!")
            })
            .catch(erro => {
                console.log("Não foi possível excluir o destino:", erro)
            })
    }    

    return (
        <div>
            <h2>{destino.nome}</h2>
            <p>Cidade: {destino.cidade}</p>
            <p>Estado: {destino.estado}</p>
            <p>Descrição: {destino.descricao}</p>
            <p>Preço médio: R$ {destino.precoMedio}</p>

            <button onClick={excluirDestino}>
                🗑️ Excluir
            </button>


        </div>
    )
}

export default DestinoCard