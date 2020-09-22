package projeto_lp_aed2;

import edu.princeton.cs.algs4.BinaryOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.*;
import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor implements Serializable {
    private int id_professor;
    private String codigo_professor;
    private String nome;
    private String curso;
    private String ucurriculares;

    private List<Horario> horario_profST = new ArrayList<>();

    public List<Horario> getHorario_profST() {
        return horario_profST;
    }

    public ArrayList<Atendimento> atendimentos = new ArrayList<>();


    public Professor(int id_professor, String codigo_professor, String nome, String curso, String ucurriculares) {
        this.id_professor = id_professor;
        this.codigo_professor = codigo_professor;
        this.nome = nome;
        this.curso = curso;
        this.ucurriculares = ucurriculares;

    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public String getCodigo_professor() {
        return codigo_professor;
    }

    public void setCodigo_professor(String codigo_professor) {
        this.codigo_professor = codigo_professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getUcurriculares() {
        return ucurriculares;
    }

    public void setUcurriculares(String ucurriculares) {
        this.ucurriculares = ucurriculares;
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(ArrayList<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }


    /**
     * carrega professores para a redblack professor e associa o curso ao professor
     *
     * @param profST  redblack professor
     * @param path    caminho
     * @param cursoST redblack cursoST
     * @param ucST    redblack ucST
     */

    public static void loadProfessores(SeparateChainingHashST<Integer, Professor> profST, String path, SeparateChainingHashST<String, Curso> cursoST, SeparateChainingHashST<Integer, UCurricular> ucST) {
        In in = new In(path);
        in.readLine();

        try {
            while (!in.isEmpty()) {


                String[] token = in.readLine().split(";");

                String aux = token[0];
                String aux2 = token[1];
                String aux3 = token[2];
                String aux4 = token[3];
                String aux5 = token[4];

                Professor aux_professor = new Professor(Integer.parseInt(aux), aux2, aux3, aux4, aux5);

                profST.put(Integer.parseInt(aux), aux_professor);
            }
        } catch (Exception exception) {
            System.out.println(exception);

        }

        /*for (Integer key : profST.keys()) {
            cursoST.get(String.valueOf(profST.get(key).getId_professor())).getProfessor_cursoST().put(key, profST.get(key));

        }*/


        //for (Integer key : profST.keys()){
        //ucST.get(profST.get(key).getId_professor()).getProfessor_ucST().put(key,profST.get(key));
        //}

    }

    /**
     * grava a redblack prof na bd
     *
     * @param profST redblack professor
     * @param path   caminho
     */

    public static void saveProf(SeparateChainingHashST<Integer, Professor> profST, String path) {
        Out out = new Out(path);

        out.println("id_professor;codigo_professor;nome;curso;ucurriculares;");
        for (Integer key : profST.keys()) {
            out.println(profST.get(key).getId_professor() + ";" + profST.get(key).getCodigo_professor() + ";" + profST.get(key).getNome() + ";" + profST.get(key).getCurso() + ";" + profST.get(key).getUcurriculares() + ";");
        }
    }

    /**
     * grava prof em binario
     *
     * @param profST
     */

    public static void saveProfBinary(SeparateChainingHashST<Integer, Professor> profST) {

        File f = new File(".//data//profsBinary.txt");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Integer key : profST.keys()) {
                Professor aux = profST.get(key);
                oos.write(
                        Integer.parseInt(aux.getId_professor() + ";"
                            + aux.getCodigo_professor() + ";"
                            + aux.getNome() + ";"
                            + aux.getCurso() + ";"
                            + aux.getUcurriculares() + ";"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * imprime todos os professores na redblack professor
     *
     * @param profST redblack prof
     */

    public static void printProfs(SeparateChainingHashST<Integer, Professor> profST) {
        System.out.println("##############Listagem dos Professores##############");
        try {
            for (Integer key : profST.keys()) {
                print_professor(profST, key);
                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * imprime professores consoante a key passada
     *
     * @param profST redblack professor
     * @param key    key do prof
     */

    public static void print_professor(SeparateChainingHashST<Integer, Professor> profST, int key) {
        System.out.println("ID do Professor: " + profST.get(key).getId_professor());
        System.out.println("Codigo do Professor: " + profST.get(key).getCodigo_professor());
        System.out.println("Nome do Professor: " + profST.get(key).getNome());
        System.out.println("Curso do Professor: " + profST.get(key).getCurso());
        System.out.println("Unidades Curriculares: " + profST.get(key).getUcurriculares());
    }

    /**
     * insere um novo objeto do tipo professor a redblack professor
     *
     * @param cursoST
     * @param profST
     * @param id_professor
     * @param codigo_professor
     * @param nome
     * @param curso
     * @param ucurriculares
     */

    public static void insertProfessor(SeparateChainingHashST<String, Curso> cursoST, SeparateChainingHashST<Integer, Professor> profST, int id_professor, String codigo_professor, String nome, String curso, String ucurriculares) {

            Professor aux_professor = new Professor(id_professor, codigo_professor, nome, curso, ucurriculares);
            profST.put(id_professor, aux_professor);
            //cursoST.get(String.valueOf(profST.get(id_professor).getId_professor())).getProfessor_cursoST().put(id_professor, profST.get(id_professor));

            if (profST.contains(id_professor)) {
                System.out.println("Professor inserido com sucesso!");
            } else {
                System.out.println("Professor nao inserido");
            }

    }

    /**
     * remove o professor da redblack professor consoante a key pretendida
     *
     * @param cursoST
     * @param profST
     * @param id_professor key prof
     */

    public static void removeProf(SeparateChainingHashST<String, Curso> cursoST, SeparateChainingHashST<Integer, Professor> profST, int id_professor) {
        if (profST.contains(id_professor)) {
            cursoST.get(String.valueOf(profST.get(id_professor).getId_professor())).getProfessor_cursoST().delete(id_professor);
            profST.delete(id_professor);

            System.out.println("\nProfessor removido com sucesso \n");
        } else {
            System.out.println("\n Este professor não existe!!" + "\n");
        }
    }

    /**
     * edita qualquer informaçao do professor que o utilizador escolha
     *
     * @param cursoST
     * @param profST
     * @param id_professor
     */

    public static void editProf(SeparateChainingHashST<String, Curso> cursoST, SeparateChainingHashST<Integer, Professor> profST, int id_professor) {
        if (profST.contains(id_professor)) {
            System.out.println("1 - Nome do Professor");
            System.out.println("2 - Curso");
            System.out.println("3 - Unidades Curriculares");

            Scanner scanIn = new Scanner(System.in);
            String choice = scanIn.nextLine();

            switch (choice) {
                case "1":
                    String nome = scanIn.nextLine();
                    profST.get(id_professor).setNome(nome);
                    break;
                case "2":
                    String curso = scanIn.nextLine();
                    profST.get(id_professor).setCurso(curso);
                    break;
                case "3":
                    String ucurriculares = scanIn.nextLine();
                    profST.get(id_professor).setUcurriculares(ucurriculares);
                    break;
            }

            System.out.println("\n Professor editado com sucesso! \n");

        } else {
            System.out.println("\n Este professor nao existe !!" + "\n");
        }
    }

    /**
     * imprime todas as uc de um certo professor
     *
     * @param profST        redblack turma
     * @param ucurriculares pretendido
     */

    public static void printUCdoProf(SeparateChainingHashST<Integer, Professor> profST, String ucurriculares) {
        try {
            for (Integer key : profST.keys()) {
                boolean verify = profST.get(key).getUcurriculares().equalsIgnoreCase(ucurriculares);
                if (verify) {
                    print_professor(profST, key);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * insere um horario no professor
     **/

    public static void insertHorarioProfessor(SeparateChainingHashST<Integer, Professor> profST, int id_professor, LocalTime horaInicio, LocalTime horaFim, DayOfWeek dia) {
        Professor professor = profST.get(id_professor);
        if (professor != null) {
            professor.addHorario(horaInicio, horaFim, dia);
        }
    }

    /**
     * imprime os horarios
     */

    public void printHorario() {
        for (Horario horario : this.horario_profST) {
            System.out.println(horario);
        }
    }

    /**
     * adiciona o horario
     *
     * @param horaInicio
     * @param horaFim
     * @param dia
     */


    public void addHorario(LocalTime horaInicio, LocalTime horaFim, DayOfWeek dia) {
        Horario horario = new Horario(horaInicio, horaFim, dia);
        if (!this.horario_profST.contains(horario))
            this.horario_profST.add(horario);
    }



   /* public void addAtendimento(Atendimento a) {
        this.getAtendimentos().add(a);
    }

    public List<Atendimento> procuraAtendimentos(LocalTime hI, LocalTime hF, DayOfWeek dia) {
        ArrayList<Atendimento> listaAtendimentos = new ArrayList();

        for (Atendimento a : this.getAtendimentos()) {
            if ((a.gethI().compareTo(hI) == 0 && a.gethF().compareTo(hF) == 0 && a.getDia().compareTo(dia) == 0)) {
                listaAtendimentos.add(a);
            }
        }
        return listaAtendimentos;
    }



    public ArrayList<Atendimento> atendimentosEntre(LocalTime hI, LocalTime hF){
        ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();
        for(Atendimento a: this.atendimentos){
            if(a.gethI().compareTo(hI) >=0 && a.gethF().compareTo(hF) <=0 ){

                listaAtendimentos.add(a);
            }

        }
        return listaAtendimentos;
    }

*/

}






