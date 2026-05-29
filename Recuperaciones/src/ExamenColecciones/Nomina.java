package ExamenColecciones;

import java.time.YearMonth;

public class Nomina {
    public YearMonth mes;
    public double salarioBase;
    public double porcentajeRetencion;

    public Nomina(YearMonth mes, double salarioBase, double porcentajeRetencion) {
        this.mes = mes;
        this.salarioBase = salarioBase;
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public YearMonth getMes() {
        return mes;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    public double getSalarioNeto() {
        return salarioBase * (1 - porcentajeRetencion/100);
    }

}
