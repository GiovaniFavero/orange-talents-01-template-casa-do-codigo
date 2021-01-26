package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.config.validation.ProibeEmailDuplicadoAutorValidator;
import br.com.zup.casadocodigo.controller.dto.AutorDto;
import br.com.zup.casadocodigo.controller.dto.NovoAutorRequest;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid NovoAutorRequest autorParametro) throws Exception{
        if(autorRepository.countByEmail(autorParametro.getEmail()) > 0) {
           throw new Exception("Email já cadastrado!");
        }
        Autor autor = autorParametro.converter();
        autorRepository.save(autor);
        return ResponseEntity.ok(new AutorDto(autor));
    }
}
