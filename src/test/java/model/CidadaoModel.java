package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class CidadaoModel {
    @Expose(serialize = false)
    private Integer id;

    @Expose
    private String nome;

    @Expose
    private String cpf;

    @Expose
    private Boolean necessidadeAcessibilidade;

    @Expose
    private String tipoAcessibilidade;
}
