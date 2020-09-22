package projeto_lp_aed2;


import edu.princeton.cs.algs4.BinaryOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vhamoreira
 */

public class Aluno {
    private int id_aluno;
    private String nome_aluno;
    private String curso;

    private List<Horario> horario_alunoST = new ArrayList<>();



    public Aluno(int id_aluno, String nome_aluno, String curso) {
        this.id_aluno = id_aluno;
        this.nome_aluno = nome_aluno;
        this.curso = curso;

    }

    public List<Horario> getHorario_alunoST() {
        return horario_alunoST;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    /**
     * carrega alunos para a redblack alunos e associa o aluno ao curso em que se encontra inscrito
     *
     * @param alunoST redblack aluno
     * @param path    caminho
     * @param cursoST redblack curso
     */

    public static void loadAluno(SeparateChainingHashST<Integer, Aluno> alunoST, String path, SeparateChainingHashST<String, Curso> cursoST) {

        In in = new In(path);

        in.readLine();
        try {
            while (!in.isEmpty()) {

                String[] token = in.readLine().split(";");

                String aux = token[0];
                String aux2 = token[1];
                String aux3 = token[2];

                Aluno aux_aluno = new Aluno(Integer.parseInt(aux), aux2, aux3);

                alunoST.put(Integer.parseInt(aux), aux_aluno);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }

        /*
        for(Integer key : alunoST.keys()){
            cursoST.get(String.valueOf(alunoST.get(key).getId_aluno())).getAluno_cursoST().put(key, alunoST.get(key));
        }
        */



    }

    /**
     * grava a redblack aluno na base de dados
     *
     * @param alunoST redblack aluno
     * @param path    caminho
     */

    public static void saveAluno(SeparateChainingHashST<Integer, Aluno> alunoST, String path) {
        Out out = new Out(path);
        out.println("id_aluno;nome;curso;");
        for (Integer key : alunoST.keys()) {
            out.println(alunoST.get(key).getId_aluno() + ";" + alunoST.get(key).getNome_aluno() + ";" + alunoST.get(key).getCurso() + ";");

        }
    }

    /**
     * grava os alunos em binario
     * @param alunoST
     */
    public static void saveAlunoBinary(SeparateChainingHashST<Integer, Aluno> alunoST) {

        BinaryOut bo = new BinaryOut(".//data//alunosBinary.txt");
        for (Integer key : alunoST.keys()) {
            Aluno aux = alunoST.get(key);
            bo.write(
                    aux.getId_aluno() + ";"
                            + aux.getNome_aluno() + ";"
                            + aux.getCurso() + ";");
        }

    }

    /**
     * imprime todos os alunos na redblack aluno
     *
     * @param alunoST redblack aluno
     */

    public static void printAlunos(SeparateChainingHashST<Integer, Aluno> alunoST) {
        System.out.println("#################Listagem dos Alunos##########" + "\n");

        try {
            for (Integer key : alunoST.keys()) {
                print_aluno(alunoST, key);
                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * imprime aluno consoante a key passada na funcao
     *
     * @param alunoST redblack aluno
     * @param key     key do aluno
     */

    public static void print_aluno(SeparateChainingHashST<Integer, Aluno> alunoST, int key) {

        System.out.println("Id aluno : " + alunoST.get(key).getId_aluno());
        System.out.println("Nome aluno: " + alunoST.get(key).getNome_aluno());
        System.out.println("Curso: " + alunoST.get(key).getCurso());

    }

    /**
     * insere um novo objeto do tipo aluno à redblack aluno
     *
     * @param alunoST    redblack aluno
     * @param cursoST    redblack curso
     * @param id_aluno
     * @param nome_aluno
     * @param curso
     */

    public static void insertAluno(SeparateChainingHashST<String, Curso> cursoST, SeparateChainingHashST<Integer, Aluno> alunoST, int id_aluno, String nome_aluno, String curso) {
            Aluno aux_aluno = new Aluno(id_aluno, nome_aluno, curso);
            alunoST.put(id_aluno, aux_aluno);
            //cursoST.get(String.valueOf(alunoST.get(id_aluno).getId_aluno())).getAluno_cursoST().put(id_aluno, alunoST.get(id_aluno));

            if (alunoST.contains(id_aluno)) {
                System.out.println("Aluno inserido com sucesso!");
            } else {
                System.out.println("Aluno nao inserido");
            }
        }


    /**
     * remove o aluno da redblack aluno consoante a key pertendida
     *
     * @param cursoST
     * @param alunoST
     * @param id_aluno key aluno
     */

    public static void removeAluno(SeparateChainingHashST<String, Curso> cursoST, SeparateChainingHashST<Integer, Aluno> alunoST, int id_aluno) {
        if (alunoST.contains(id_aluno)) {
            cursoST.get(String.valueOf(alunoST.get(id_aluno).getId_aluno())).getAluno_cursoST().delete(id_aluno);
            alunoST.delete(id_aluno);

            System.out.println("\nAluno removido com sucesso \n");
        } else {
            System.out.println("\nEste aluno nao existe!" + "\n");
        }
    }

    /**
     * edita qualquer informação do aluno que o utilizador escolher
     *
     * @param cursoST
     * @param alunoST
     * @param id_aluno
     */

    public static void editAluno(SeparateChainingHashST<String, Curso> cursoST, SeparateChainingHashST<Integer, Aluno> alunoST, int id_aluno) throws ParseException {
        //id_aviao || nome_aluno || data_nascimento || curso || horario
        if (alunoST.contains(id_aluno)) {
            System.out.println("1 - Nome do aluno");
            System.out.println("2 - Curso");

            Scanner scanIn = new Scanner(System.in);
            String choice = scanIn.nextLine();

            switch (choice) {

                case "1":
                    String nome_aluno = scanIn.nextLine();
                    alunoST.get(id_aluno).setNome_aluno(nome_aluno);
                    break;

                case "2":
                    String curso = scanIn.nextLine();
                    alunoST.get(id_aluno).setCurso(curso);
                    break;
            }
            System.out.println("\nAluno editado com sucesso! \n");
        } else {
            System.out.println("\nEste aluno nao existe!!" + "\n");
        }
    }

    /**
     * insere um horario no professor
     **/

    public static void insertHorarioAluno(SeparateChainingHashST<Integer,Aluno> alunoST, int id_aluno, LocalTime horaInicio, LocalTime horaFim, DayOfWeek dia) {
        Aluno aluno = alunoST.get(id_aluno);
        if(aluno!=null) {
            aluno.addHorario(horaInicio,horaFim,dia);
        }
    }

    /**
     * imprime os horarios
     */
    public static void printHorarios(SeparateChainingHashST<Integer,Aluno> alunoST,SeparateChainingHashST<String,Horario> horario_alunoST, int id_aluno) {
        Aluno aluno = alunoST.get(id_aluno);
        if (aluno == null) return;
        {
            for (String num : horario_alunoST.keys()) {
                if (Integer.parseInt(num) == id_aluno) {
                    System.out.println(horario_alunoST.get(num));
                }
            }
        }
    }

    /**
     * adiciona o horario
     * @param horaInicio
     * @param horaFim
     * @param dia
     */


    public void addHorario(LocalTime horaInicio, LocalTime horaFim, DayOfWeek dia){
        Horario horario=new Horario(horaInicio,horaFim,dia);
        if(!this.horario_alunoST.contains(horario))
            this.horario_alunoST.add(horario);
    }
    public static void loadHorarioAluno(SeparateChainingHashST<String, Horario> horario_alunoST, String path) {
        In in = new In(path);
        in.readLine();

        try {
            while (!in.isEmpty()) {

                String[] token = in.readLine().split(";");

                String id_horario_aluno = token[0];
                String id_aluno = token[1];
                String tempoInicial = token[2];
                String tempoFinal = token[3];
                String dia = token[4];
                String uniCurricular = token[5];


                Horario aux_horario = new Horario(Integer.parseInt(id_aluno), uniCurricular, LocalTime.parse(tempoInicial), LocalTime.parse(tempoFinal), DayOfWeek.valueOf(dia));

                horario_alunoST.put(id_horario_aluno, aux_horario);

            }
        } catch (Exception exception) {
            System.out.println(exception);


        }
    }

    /**
     * imprime todas as salas
     */
    public static void printAlunosHorarios(SeparateChainingHashST<Integer, Aluno> alunoST,SeparateChainingHashST<String,Horario>horario_alunoST) {
        System.out.println("####Lista de Alunos e Horarios: ######");
        try {
            for (Integer key : alunoST.keys()) {
                print_aluno_horario(alunoST,horario_alunoST, key);

            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * imprime a sala consoante a key pretendida
     *
     * @param alunoST      redblack sala
     * @param key codigo da sala para imprimir
     */
    public static void print_aluno_horario(SeparateChainingHashST<Integer, Aluno> alunoST,SeparateChainingHashST<String,Horario>horario_alunoST, int key) {
        Aluno aluno = alunoST.get(key);
        if (aluno == null) return;
        System.out.println("Id aluno : " + alunoST.get(key).getId_aluno());
        System.out.println("Nome aluno: " + alunoST.get(key).getNome_aluno());
        System.out.println("Curso: " + alunoST.get(key).getCurso());
        aluno.printHorarios(alunoST,horario_alunoST, key);

        System.out.println();

    }

}
