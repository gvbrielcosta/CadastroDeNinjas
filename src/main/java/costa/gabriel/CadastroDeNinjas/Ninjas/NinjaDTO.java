package costa.gabriel.CadastroDeNinjas.Ninjas;

import costa.gabriel.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String rank;
    private MissoesModel missoes;


}
