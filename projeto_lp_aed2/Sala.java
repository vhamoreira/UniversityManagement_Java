
package projeto_lp_aed2;


import edu.princeton.cs.algs4.*;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalTime;



public class Sala extends Grafo implements Serializable {
    private String numero_sala;
    private String tipo;
    private int capacidade;
    private int piso;
    private int ntomadas;

    private SeparateChainingHashST<String, Horario>horario_salaST = new SeparateChainingHashST<>();

    public Sala(String numero_sala, String tipo, int capacidade, int piso, int ntomadas, int x, int y, int vertice) {
        super(x, y, vertice);
        this.numero_sala = numero_sala;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.piso = piso;
        this.ntomadas = ntomadas;
    }

    public String getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(String numero_sala) {
        this.numero_sala = numero_sala;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNtomadas() {
        return ntomadas;
    }

    public void setNtomadas(int ntomadas) {
        this.ntomadas = ntomadas;
    }

    public SeparateChainingHashST<String, Horario> getHorario_salaST() {
        return horario_salaST;
    }


    public static void loadSala(SeparateChainingHashST<String, Sala> salaST, SeparateChainingHashST<String,Horario> horarioST, String path) {
        In in = new In(path);
        in.readLine();  //mostrar parametros no txt

        try {
            while (!in.isEmpty()) {

                String[] token = in.readLine().split(";");

                String aux = token[0];
                String aux2 = token[1];
                String aux3 = token[2];
                String aux4 = token[3];
                String aux5 = token[4];
                String aux6 = token[5];
                String aux7 = token[6];
                String aux8 = token[7];


                Sala aux_sala = new Sala(aux, aux2, Integer.parseInt(aux3), Integer.parseInt(aux4), Integer.parseInt(aux5), Integer.parseInt(aux6), Integer.parseInt(aux7), Integer.parseInt(aux8));
                salaST.put(aux, aux_sala);

            }
        } catch (Exception exception) {
            System.out.println(exception);

        }

    }

    /**
     * guarda a redblack na base de dados
     *
     * @param salaST redblack turma
     * @param path   caminho
     */

    public static void saveSala(SeparateChainingHashST<String, Sala> salaST, String path) {
        Out out = new Out(path);

        out.println("numero_sala;tipo;capacidade;int piso;ntomadas;");
        for (String key : salaST.keys()) {
            out.println(
                    salaST.get(key).getNumero_sala() + ";"
                            + salaST.get(key).getTipo() + ";"
                            + salaST.get(key).getCapacidade() + ";"
                            + salaST.get(key).getPiso() + ";"
                            + salaST.get(key).getNtomadas() + ";");
        }
    }

    /**
     * guarda as salas em binario
     *
     * @param salaST
     */
    public static void saveSalasBinary(SeparateChainingHashST<String, Sala> salaST) {

        BinaryOut bo = new BinaryOut(".//data//salasBinary.txt");
        for (String key : salaST.keys()) {
            Sala aux = salaST.get(key);
            bo.write(
                    aux.getNumero_sala() + ";"
                            + aux.getTipo() + ";"
                            + aux.getCapacidade() + ";"
                            + aux.getPiso() + ";"
                            + aux.getNtomadas() + ";");
        }

    }

    /**
     * imprime todas as salas
     */
    public static void printSalas(SeparateChainingHashST<String, Sala> salaST,SeparateChainingHashST<String,Horario>horario_salaST) {
        System.out.println("####Lista de Salas: ######");
        try {
            for (String key : salaST.keys()) {
                print_sala(salaST,horario_salaST, key);

            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * imprime a sala consoante a key pretendida
     *
     * @param salaST      redblack sala
     * @param numero_sala codigo da sala para imprimir
     */
    public static void print_sala(SeparateChainingHashST<String, Sala> salaST,SeparateChainingHashST<String,Horario>horario_salaST, String numero_sala) {
        Sala sala = salaST.get(numero_sala);
        if (sala == null) return;
        System.out.println("Numero Sala: " + sala.getNumero_sala());
        System.out.println("Tipo: " + salaST.get(numero_sala).getTipo());
        System.out.println("Capacidade " + salaST.get(numero_sala).getCapacidade());
        System.out.println("Piso " + salaST.get(numero_sala).getPiso());
        System.out.println("Numero de Tomadas: " + salaST.get(numero_sala).getNtomadas());
        sala.printHorarios(salaST,horario_salaST,numero_sala);
        System.out.println();

    }



    /**
     * insere uma nova sala na redblack
     *
     * @param salaST      redblack sala
     * @param numero_sala
     * @param tipo
     * @param capacidade
     * @param piso
     * @param ntomadas
     **/

    public static void insertSala(SeparateChainingHashST<String, Sala> salaST, String numero_sala, String tipo, int capacidade, int piso, int ntomadas, int x, int y, int vertice ) {

        Sala aux_sala = new Sala(numero_sala, tipo, capacidade, piso, ntomadas,x,y,vertice);
        salaST.put(numero_sala, aux_sala);
        if (salaST.contains(numero_sala)) {
            System.out.println("\nSala adicionada com sucesso!!\n");
        } else {
            System.out.println("\nSala nao adicionada" + "\n");

        }
    }


    /**
     * remove uma sala da redblack consoante a key passada
     *
     * @param salaST      redblack
     * @param numero_sala key do sala
     */

    public static void removeSala(SeparateChainingHashST<String, Sala> salaST, String numero_sala) {
        if (salaST.contains(numero_sala)) {
            salaST.delete(numero_sala);
            System.out.println("\nSala Removida com sucesso!");
        } else {
            System.out.println("\nEsta sala nao existe!!" + "\n");
        }
    }


    /**
     * insere um horario na sala
     **/

    public static void insertHorarioNaSala(SeparateChainingHashST<String, Sala> salaST, SeparateChainingHashST<String, Horario> horario_salaST, String numero_sala, LocalTime horaInicio, LocalTime horaFim, DayOfWeek dia) {
        Sala sala = salaST.get(numero_sala);
        if (sala != null) {
            sala.addHorario(horario_salaST, horaInicio, horaFim, dia);
        }
    }

    /**
     * imprime os horarios
     */
   public static void printHorarios(SeparateChainingHashST<String,Sala> salaST,SeparateChainingHashST<String,Horario> horario_salaST, String numero_sala){
       Sala sala = salaST.get(numero_sala);
       if(sala == null) return;{
           for (String num : horario_salaST.keys()){
               if(num.compareTo(numero_sala) == 0) {
                   System.out.println(horario_salaST.get(num));
               }
           }
           /*
           System.out.println("Horarios:");
           System.out.println("Hora Inicio: " + horario_salaST.get(numero_sala).getHoraInicio() + ";");
           System.out.println("Hora Fim: " + horario_salaST.get(numero_sala).getHoraFim() + ";");
           System.out.println("Dia: " + horario_salaST.get(numero_sala).getDia() + ";");


            */

       }
   }


    /**
     * adiciona o horario
     *
     * @param horaInicio
     * @param horaFim
     * @param dia
     */

    public void addHorario(SeparateChainingHashST<String, Horario> horario_salaST, LocalTime horaInicio, LocalTime horaFim, DayOfWeek dia) {
        Horario horario = new Horario(horaInicio, horaFim, dia);
        if (!horario_salaST.contains(numero_sala))
            horario_salaST.put(numero_sala, horario);
    }


    public static void saveHorarioSala(SeparateChainingHashST<String, Sala> salaST, SeparateChainingHashST<String, Horario> horario_salaST, String numero_sala, String path) {
        Out out = new Out(path);
        Horario horario = horario_salaST.get(numero_sala);
                out.print("Numero sala: " + salaST.get(numero_sala).getNumero_sala() + ";" + "Dia:" + horario.getDia() + ";" + "Hora Inicio:" + horario.getHoraInicio() + ";" + "Hora Fim:" + horario.getHoraFim() + ";\n" );
            }



     /**
    * procurar disponibilidade na sala no horario
    */
     public static void procuraDisponibilidade(SeparateChainingHashST<String,Sala> salaST,SeparateChainingHashST<String,Horario> horario_salaST,String numero_sala,LocalTime hI,LocalTime hF,DayOfWeek dia){
         try {
             Horario horario = horario_salaST.get(numero_sala);
                //verifica se a hora passada está dentro da hora ocupada da sala
                if(hI.isAfter(horario.getHoraInicio()) && hI.isBefore(horario.getHoraFim()) && horario.getDia().equals(dia) || hF.isAfter(horario.getHoraInicio()) && hF.isBefore(horario.getHoraFim()) ){
                     System.out.println("Horario Ocupado!");
                     printHorarios(salaST,horario_salaST, numero_sala);

                 }
                 else{
                     System.out.println("Horario Disponivel!");
                 }

         } catch (Exception exception) {
             System.out.println(exception);
         }
     }

    public void printAllHorarios() {
        for(String name : this.horario_salaST.keys()){
            Horario h = this.horario_salaST.get(name);
            System.out.println("\t" + h);
            h.printAllHorarios();
        }

    }

    public static void printSalasporTomadas (SeparateChainingHashST<String, Sala> salaST,String numero_sala,  int ntomadas){
            Sala sala = salaST.get(numero_sala);
            if (sala == null) return;
            System.out.println("Numero Sala: " + sala.getNumero_sala());
            System.out.println("Numero de Tomadas: " + salaST.get(numero_sala).getNtomadas());
            System.out.println();

        }

    }



}





















