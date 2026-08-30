function DestinoCard({ destino }) {

    return (
        <div>
            <h2>{destino.nome}</h2>
            <p>Cidade: {destino.cidade}</p>
            <p>Estado: {destino.estado}</p>
            <p>Descrição: {destino.descricao}</p>
            <p>Preço médio: R$ {destino.precoMedio}</p>
        </div>
    )
}

export default DestinoCard