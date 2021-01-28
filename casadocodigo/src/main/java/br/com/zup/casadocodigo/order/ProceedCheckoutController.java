package br.com.zup.casadocodigo.order;

import br.com.zup.casadocodigo.shared.config.validation.CheckCpfCnpjValidator;
import br.com.zup.casadocodigo.shared.config.validation.StateBelongsToCountryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/proceed-checkout")
public class ProceedCheckoutController {

    @Autowired
    private StateBelongsToCountryValidator stateBelongsToCountryValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(stateBelongsToCountryValidator);
    }

    @PostMapping
    public ResponseEntity create (@RequestBody @Valid NewPaymentRequestDto request) {
        return ResponseEntity.ok().build();
    }
}
