package costa.gabriel.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Rota para criar ninjas", description = "Essa rota cria um ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja (@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso! \n" + "ID: " + novoNinja.getId() + "\n Nome: " + novoNinja.getNome());
    }

    @GetMapping("/listar")
    @Operation(summary = "Rota para listar", description = "Essa rota lista todos os ninjas no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro para listar ninjas")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Rota para listar ninja por ID", description = "Essa rota lista um único ninja específico pelo seu ID (passado na url)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro para listar ninja")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com este id não encontrado.");
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Rota para alterar ninja", description = "Essa rota lista altera um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro para alterar ninja")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuário envia o ID no caminho da requisição")
            @PathVariable Long id,
            @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nenhum ninja com este ID foi encontrado.");
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Rota para deletar ninja", description = "Essa rota deleta um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro para deletar ninja")
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjasPorId(id) != null) {
            NinjaDTO ninjaParaDeletar = ninjaService.listarNinjasPorId(id);
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o nome "+ ninjaParaDeletar.getNome() + " deletado com sucesso!\n");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID " + id + " não existe!");
    }


}
