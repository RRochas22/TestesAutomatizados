package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ConsumoEnergeticoModel {
    @Expose(serialize = false)
    private Integer id;

    @Expose
    private String idResidencia;

    @Expose
    private String mesReferencia;

    @Expose
    private Double consumoKwh;

    @Expose
    private String fonteEnergia;
}
