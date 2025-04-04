package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import entities.Livro;
import services.LivroService;
import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Integer id) {
        return livroService.findById(id);
    }

    @PostMapping
    public Livro saveLivro(Livro livro) {
        return livroService.save(livro);
    }

    @PutMapping
    public Livro updateLivro(Livro livro) {
        return livroService.update(livro);
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Integer id) {
        this.livroService.delete(id);
    }

    @GetMapping("/titulo/{palavra}")
    public List<Livro> findByTittle(@PathVariable String palavra) {
        return livroService.findByTittle(palavra);
    }

    @GetMapping("/autor/{autor}")
    public List<Livro> findByAutor(@PathVariable String autor) {
        return livroService.findByAutor(autor);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Livro> findByCategoria(@PathVariable String categoria) {
        return livroService.findByCategoria(categoria);
    }

    @GetMapping("/disponiveis")
    public List<Livro> findByDisponibilidade() {
        return livroService.findByDisponibilidade();
    }
}
