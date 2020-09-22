package projeto_lp_aed2;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Atendimento {

    private LocalTime hI;
    private LocalTime hF;
    private DayOfWeek dia;

    public Atendimento(LocalTime hI, LocalTime hF, DayOfWeek dia){
        this.hI = hI;
        this.hF = hF;
        this.dia = dia;
    }

    public LocalTime gethI() {
        return hI;
    }

    public void sethI(LocalTime hI) {
        this.hI = hI;
    }

    public LocalTime gethF() {
        return hF;
    }

    public void sethF(LocalTime hF) {
        this.hF = hF;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }
}
