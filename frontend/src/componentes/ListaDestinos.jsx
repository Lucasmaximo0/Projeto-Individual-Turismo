import DestinoCard from "./DestinoCard"

function ListaDestinos({ destinos }) {

    return (
        <div>
            {destinos.map(destino => (
                <DestinoCard
                    key={destino.id}
                    destino={destino}
                />
            ))}
        </div>
    )
}

export default ListaDestinos