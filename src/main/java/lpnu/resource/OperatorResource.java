package lpnu.resource;

import lpnu.dto.OperatorDTO;
import lpnu.service.OperatorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class OperatorResource {
    private OperatorService operatorService;

    public OperatorResource(final OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("/operators")
    public List<OperatorDTO> getAllOperators() {
        return operatorService.getAllOperator();
    }

    @GetMapping("/operators/{id}")
    public OperatorDTO getOperatorById(@PathVariable final long id) {
        return operatorService.getOperatorById(id);
    }


    @PostMapping(value = "/operators", produces = "application/json", consumes = "application/json")
    public OperatorDTO saveOperator(@RequestBody final OperatorDTO operatorDTO) {
        return operatorService.saveOperator(operatorDTO);
    }


    @PutMapping(value = "/operators", produces = "application/json", consumes = "application/json")
    public OperatorDTO updateOperator(@RequestBody final OperatorDTO operatorDTO) {
        return operatorService.updateOperator(operatorDTO);
    }


    @DeleteMapping("/operators/{id}")
    public ResponseEntity deleteOperatorById(@PathVariable final long id) {
        operatorService.deleteOperatorById(id);
        return ResponseEntity.ok().build();
    }
}
