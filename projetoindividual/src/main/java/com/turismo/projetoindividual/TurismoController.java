package com.turismo.projetoindividual;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/Destino")
@CrossOrigin(origins = "http://localhost:5173")

public class TurismoController {
    //    private List<Destino> destinos = new ArrayList<>();
    //    private  Integer contador = 0;

    private final JdbcTemplate jdbcTemplate;

    public TurismoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping

    public Destino cadastrar(@RequestBody Destino destino) {

        String sql = """
                INSERT INTO destino
                (nome, cidade, estado, descricao, preco_medio)
                VALUES (?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                destino.getNome(),
                destino.getCidade(),
                destino.getEstado(),
                destino.getDescricao(),
                destino.getPrecoMedio()
        );

        return destino;
    }

    //    public  Destino cadastrar(@RequestBody Destino destino){
//        destino.setId(++contador);
//        destinos.add(destino);
//
//        return destino;
//
//    }
//
    @GetMapping
    public List<Destino> listar(){
        String sql =  """
    SELECT id, nome, cidade, estado, descricao, preco_medio 
    FROM destino """;
        return  jdbcTemplate.query(sql,(rs, rowNum) -> {
            Destino destino = new Destino();
            destino.setId(rs.getInt("id"));
            destino.setNome(rs.getString("nome"));
            destino.setCidade(rs.getString("cidade"));
            destino.setEstado(rs.getString("estado"));
            destino.setDescricao(rs.getString("descricao"));
            destino.setPrecoMedio(rs.getDouble("preco_medio"));

            return  destino;
        });
    }
}