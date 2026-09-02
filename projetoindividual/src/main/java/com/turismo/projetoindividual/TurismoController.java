package com.turismo.projetoindividual;

import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Destino> cadastrar(@RequestBody Destino destino) {

        if (destino.getNome() == null || destino.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do destino é obrigatório");
        }

        if (destino.getCidade() == null || destino.getCidade().isBlank()) {
            throw new IllegalArgumentException("A cidade é obrigatória");
        }

        if (destino.getEstado() == null || destino.getEstado().isBlank()) {
            throw new IllegalArgumentException("O estado é obrigatório");
        }

        if (destino.getDescricao() == null || destino.getDescricao().isBlank()) {
            throw new IllegalArgumentException("A descrição é obrigatória");
        }

        if (destino.getPrecoMedio() == null || destino.getPrecoMedio() < 0) {
            throw new IllegalArgumentException("O preço médio deve ser maior ou igual a zero");
        }

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

        return ResponseEntity.status(201).body(destino);
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
    public List<Destino> listar() {
        String sql = """
                SELECT id, nome, cidade, estado, descricao, preco_medio 
                FROM destino """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Destino destino = new Destino();
            destino.setId(rs.getInt("id"));
            destino.setNome(rs.getString("nome"));
            destino.setCidade(rs.getString("cidade"));
            destino.setEstado(rs.getString("estado"));
            destino.setDescricao(rs.getString("descricao"));
            destino.setPrecoMedio(rs.getDouble("preco_medio"));

            return destino;
        });
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarPorId(@PathVariable Integer id){

        String sql = """
    Select id, nome, cidade, estado, descricao,
    preco_medio FROM destino where id = ?""";

        List<Destino>  destinos = jdbcTemplate.query(sql,(rs, rowNum) -> {
            Destino destino = new Destino();

            destino.setId(rs.getInt("id"));
            destino.setNome(rs.getString("nome"));
            destino.setCidade(rs.getString("cidade"));
            destino.setEstado(rs.getString("estado"));
            destino.setDescricao(rs.getString("descricao"));
            destino.setPrecoMedio(rs.getDouble("preco_medio"));

            return  destino;

        },id);

        if (destinos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(destinos.get(0));

    }
    // aqui é o erro 404
    @PutMapping("/{id}")
    public ResponseEntity<Destino> atualizar(
            @PathVariable Integer id,
            @RequestBody Destino destino) {

        if (destino.getNome() == null || destino.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do destino é obrigatório");
        }

        if (destino.getCidade() == null || destino.getCidade().isBlank()) {
            throw new IllegalArgumentException("A cidade é obrigatória");
        }

        if (destino.getEstado() == null || destino.getEstado().isBlank()) {
            throw new IllegalArgumentException("O estado é obrigatório");
        }

        if (destino.getDescricao() == null || destino.getDescricao().isBlank()) {
            throw new IllegalArgumentException("A descrição é obrigatória");
        }

        if (destino.getPrecoMedio() == null || destino.getPrecoMedio() < 0) {
            throw new IllegalArgumentException("O preço médio deve ser maior ou igual a zero");
        }

        String sql = """
            UPDATE destino
            SET nome = ?,
                cidade = ?,
                estado = ?,
                descricao = ?,
                preco_medio = ?
            WHERE id = ?
            """;

        int linhasAlteradas = jdbcTemplate.update(
                sql,
                destino.getNome(),
                destino.getCidade(),
                destino.getEstado(),
                destino.getDescricao(),
                destino.getPrecoMedio(),
                id
        );

        if (linhasAlteradas == 0) {
            return ResponseEntity.notFound().build();
        }

        destino.setId(id);

        return ResponseEntity.ok(destino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {

        String sql = """
            DELETE FROM destino
            WHERE id = ?
            """;

        int linhasAlteradas = jdbcTemplate.update(sql, id);

        if (linhasAlteradas == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}