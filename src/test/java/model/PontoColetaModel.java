package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class PontoColetaModel {
    @Expose(serialize = false)
    private Integer id;

    @Expose
    private String nome;

    @Expose
    private String tipoResiduo;

    @Expose
    private String endereco;

    @Expose
    private Double latitude;

    @Expose
    private Double longitude;
}
