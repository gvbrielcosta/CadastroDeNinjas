package costa.gabriel.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja (){
        return "Ninja criado!";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Ninjas encontrados com sucesso!";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listarid")
    public String mostrarTodosOsNinjasPorId(){
        return "Ninjas por ID encontrados com sucesso!";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarid")
    public String alterarNinjaPorId(){
        return "Ninja alterado com sucesso!";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarid")
    public String deletarNinjaPorId(){
        return "Ninja deletado com sucesso!";
    }


}
