package projeto_lp_aed2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;


public class Horario {


    private LocalTime horaInicio;
    private LocalTime horaFim;
    private DayOfWeek dia;

    private SeparateChainingHashST<String,Horario> horario_salaST = new SeparateChainingHashST<>();
    public SeparateChainingHashST<String,Horario> getHorario_salaST() {
        return horario_salaST;
    }
    public void setHorario_salaST(SeparateChainingHashST<String,Horario> horario_salaST) {
        this.horario_salaST = horario_salaST;
    }



    public Horario(LocalTime horaInicio, LocalTime horaFim, DayOfWeek dia) {

        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.dia = dia;
    }

    public Horario(int id_aluno, String uniCurricular, LocalTime horaInicio, LocalTime horaFim, DayOfWeek dia) {

        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }


    public static void loadHorario(SeparateChainingHashST<String, Horario> horario_salaST, String path) {
        In in = new In(path);
        in.readLine();

        try {
            while (!in.isEmpty()) {

                String[] token = in.readLine().split(";");

                String aux = token[0];
                String aux2 = token[1];
                String aux3 = token[2];
                String aux4 = token[3];


                Horario aux_horario = new Horario(LocalTime.parse(aux2), LocalTime.parse(aux3), DayOfWeek.valueOf(aux4));
                horario_salaST.put(aux, aux_horario);

            }
        } catch (Exception exception) {
            System.out.println(exception);


        }
    }
//save horarios no txt


    public void printAllHorarios() {
        for (String Key : this.horario_salaST.keys()) {
            Horario h = this.horario_salaST.get(Key);
            System.out.println(h);
        }

    }


    @Override
    public String toString() {
        return "Horario: dia:"+this.dia+" Inicio:"+this.horaInicio+" Fim:"+this.horaFim;
    }


}


