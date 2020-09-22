package projeto_lp_aed2;

import edu.princeton.cs.algs4.BinaryOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.Serializable;

public class Turma implements Serializable {
    private int id_turma;
    private int numero_alunos;
    private String curso;
    private String ucurricular;
    private String professor;

    public Turma(int id_turma, String curso, String ucurricular, int numero_alunos, String professor) {
        this.id_turma = id_turma;
        this.numero_alunos = numero_alunos;
        this.curso = curso;
        this.ucurricular = ucurricular;
        this.professor = professor;


    }

    /**
     * carrega turmas
     *
     * @param turmaST redblack turma
     * @param path    caminho
     * @param profST  redblack professor
     */

    public static void loadTurmas(SeparateChainingHashST<Integer, Turma> turmaST, String path, SeparateChainingHashST<Integer, Professor> profST, SeparateChainingHashST<Integer, UCurricular> ucST) {
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

                Turma aux_turma = new Turma(Integer.parseInt(aux), aux2, aux3, Integer.parseInt(aux4), aux5);

                turmaST.put(Integer.parseInt(aux), aux_turma);
            }


        } catch (Exception exception) {
            System.out.println(exception);

        }

    }

    /**
     * guarda a redblack na base de dados
     *
     * @param turmaST redblack turma
     * @param path    caminho
     */

    public static void saveTurma(SeparateChainingHashST<Integer, Turma> turmaST, String path) {
        Out out = new Out(path);
        out.println("Turma;Curso;UnidadeCurricular;NumAlunos;Professor;");
        for (Integer key : turmaST.keys()) {
            out.println(
                    turmaST.get(key).getId_turma() + ";"
                            + turmaST.get(key).getCurso() + ";"
                            + turmaST.get(key).getUcurricular() + ";"
                            + turmaST.get(key).getNumero_alunos() + ";"
                            + turmaST.get(key).getProfessor() + ";");

        }
    }
    /**
     * grava turmas em binario
     * @param turmaST
     */
    public static void saveTurmaBinary(SeparateChainingHashST<Integer, Turma> turmaST) {

        BinaryOut bo = new BinaryOut(".//data//turmasBinary.txt");
        for (Integer key : turmaST.keys()) {
            Turma aux = turmaST.get(key);
            bo.write(
                    aux.getId_turma() + ";"
                            + aux.getCurso() + ";"
                            + aux.getUcurricular() + ";"
                            + aux.getProfessor() + ";");
        }

    }

    /**
     * imprime todas as turmas
     */
    public static void printTurmas(SeparateChainingHashST<Integer, Turma> turmaST) {
        System.out.println("####Lista de Turmas: ######");
        try {
            for (Integer key : turmaST.keys()) {
                print_turma(turmaST, key);

            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * imprime a turma consoante a key pretendida
     *
     * @param turmaST  redblack turma
     * @param id_turma codigo da turma para imprimir
     */

    public static void print_turma(SeparateChainingHashST<Integer, Turma> turmaST, int id_turma) {
        System.out.println("Id Turma: " + turmaST.get(id_turma).getId_turma());
        System.out.println("Numero de alunos: " + turmaST.get(id_turma).getNumero_alunos());
        System.out.println("Curso: " + turmaST.get(id_turma).getCurso());
        System.out.println("Unidades Curriculares: " + turmaST.get(id_turma).getUcurricular());
        System.out.println("Professores: " + turmaST.get(id_turma).getProfessor() + "\n");
    }

    /**
     * imprime todas as turmas de um certo professor
     *
     * @param turmaST   redblack turma
     * @param professor pretendido
     */

    public static void printTurmasProfessor(SeparateChainingHashST<Integer, Turma> turmaST, String professor) {
        try {
            for (Integer key : turmaST.keys()) {
                boolean verify = turmaST.get(key).getProfessor().equalsIgnoreCase(professor);
                if (verify) {
                    print_turma(turmaST, key);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * insere uma nova turma na redblack
     *
     * @param turmaST       redblack turma
     * @param numero_alunos
     * @param curso
     * @param ucurricular
     * @param professor
     */

    public static void insertTurma(SeparateChainingHashST<Integer, Turma> turmaST, int id_turma, int numero_alunos, String curso, String ucurricular, String professor) {
        Turma aux_turma = new Turma(id_turma, curso, ucurricular, numero_alunos, professor);
        turmaST.put(id_turma, aux_turma);

        if (turmaST.contains(id_turma)) {
            System.out.println("Turma inserida com sucesso!");
        } else {
            System.out.println("Turma nao inserida");
        }
    }

    /**
     * remove uma turma da redblack consoante a key passada
     *
     * @param turmaST  redblack
     * @param id_turma key do turma
     */

    public static void removeTurma(SeparateChainingHashST<Integer, Turma> turmaST, int id_turma) {
        if (turmaST.contains(id_turma)) {
            turmaST.delete(id_turma);
            System.out.println("\nTurma Removida com sucesso!");
        } else {
            System.out.println("\nEsta turma nao existe!!" + "\n");
        }
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public int getNumero_alunos() {
        return numero_alunos;
    }

    public void setNumero_alunos(int numero_alunos) {
        this.numero_alunos = numero_alunos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getUcurricular() {
        return ucurricular;
    }

    public void setUcurricular(String ucurricular) {
        this.ucurricular = ucurricular;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }


}
