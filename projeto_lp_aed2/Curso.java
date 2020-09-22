package projeto_lp_aed2;

import edu.princeton.cs.algs4.BinaryOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.Scanner;


public class Curso {

    private int id_curso;
    private String nome_curso;
    private String codigo_curso;
    private String ano_letivo;

    private SeparateChainingHashST<Integer, Aluno> aluno_cursoST = new SeparateChainingHashST<>();
    private SeparateChainingHashST<Integer, Professor> professor_cursoST = new SeparateChainingHashST<>();

    public Curso(int id_curso, String nome_curso, String codigo_curso, String ano_letivo) {
        this.id_curso = id_curso;
        this.nome_curso = nome_curso;
        this.codigo_curso = codigo_curso;
        this.ano_letivo = ano_letivo;
    }


    public SeparateChainingHashST<Integer, Aluno> getAluno_cursoST() {
        return aluno_cursoST;
    }

    public SeparateChainingHashST<Integer, Professor> getProfessor_cursoST() {
        return professor_cursoST;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getAno_letivo() {
        return ano_letivo;
    }

    public void setAno_letivo(String ano_letivo) {
        this.ano_letivo = ano_letivo;
    }



    /**
     * carrega cursos
     *
     * @param cursoST redblack curso
     * @param path    caminho
     */

    public static void loadCurso(SeparateChainingHashST<String, Curso> cursoST, String path) {
        In in = new In(path);
        in.readLine();

        try {
            while (!in.isEmpty()) {
                String[] token = in.readLine().split(";");
                String aux = token[0];
                String aux2 = token[1];
                String aux3 = token[2];
                String aux4 = token[3];
                Curso aux_curso = new Curso(Integer.parseInt(aux), aux2, aux3, aux4);
                cursoST.put(aux3, aux_curso);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * guarda a redblack na base de dados
     *
     * @param cursoST redblack curso
     * @param path    caminho
     */

    public static void saveCurso(SeparateChainingHashST<String, Curso> cursoST, String path) {
        Out out = new Out(path);

        out.println("id_curso;nome_curso;codigo_curso;ano_letivo;");
        for (String key : cursoST.keys()) {
            out.println(
                    cursoST.get(key).getId_curso() + ";"
                            + cursoST.get(key).getNome_curso() + ";"
                            + cursoST.get(key).getCodigo_curso() + ";"
                            + cursoST.get(key).getAno_letivo() + ";");

        }
    }

    /**
     * grava cursos em binario
     * @param cursoST
     */
    public static void saveCursoBinary(SeparateChainingHashST<String, Curso> cursoST) {

        BinaryOut bo = new BinaryOut(".//data//cursosBinary.txt");
        for (String key : cursoST.keys()) {
            Curso aux = cursoST.get(key);
            bo.write(
                    aux.getId_curso() + ";"
                            + aux.getCodigo_curso() + ";"
                            + aux.getAno_letivo() + ";");
        }

    }

    /**
     * imprime todos os cursos
     */
    public static void printCursos(SeparateChainingHashST<String, Curso> cursoST) {
        System.out.println("####Lista de Cursos: ######");
        try {
            for (String key : cursoST.keys()) {
                print_curso(cursoST, key);

            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * imprime o curso consoante a key pretendida
     *
     * @param cursoST      redblack cursos
     * @param codigo_curso codigo do curso para imprimir
     */

    public static void print_curso(SeparateChainingHashST<String, Curso> cursoST, String codigo_curso) {
        System.out.println("Id curso: " + cursoST.get(codigo_curso).getId_curso());
        System.out.println("Nome do Curso: " + cursoST.get(codigo_curso).getNome_curso());
        System.out.println("Codigo do Curso: " + cursoST.get(codigo_curso).getCodigo_curso());
        System.out.println("Ano Letivo: " + cursoST.get(codigo_curso).getAno_letivo() + "\n");
    }

    /**
     * imprime todos os cursos de um certo ano letivo
     *
     * @param cursoST    redblack curso
     * @param ano_letivo ano pretendido
     */

    public static void printCursoInAno(SeparateChainingHashST<String, Curso> cursoST, String ano_letivo) {
        try {
            for (String key : cursoST.keys()) {
                boolean verify = cursoST.get(key).getAno_letivo().equalsIgnoreCase(ano_letivo);
                if (verify) {
                    print_curso(cursoST, key);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * insere um novo curso na redblack
     *
     * @param cursoST      redblack curso
     * @param nome_curso
     * @param codigo_curso
     * @param ano_letivo
     */

    public static void insertCurso(SeparateChainingHashST<String, Curso> cursoST, int id_curso, String nome_curso, String codigo_curso, String ano_letivo) {
        Curso aux_curso = new Curso(id_curso, nome_curso, codigo_curso, ano_letivo);
        cursoST.put(codigo_curso, aux_curso);

        if (cursoST.contains(codigo_curso)) {
            System.out.println("Curso inserido com sucesso!");
        } else {
            System.out.println("Curso nao inserido");
        }
    }

    /**
     * remove um curso da redblack consoante a key passada
     *
     * @param cursoST      redblack
     * @param codigo_curso key do curso
     */

    public static void removeCurso(SeparateChainingHashST<String, Curso> cursoST, String codigo_curso) {
        if (cursoST.contains(codigo_curso)) {
            cursoST.delete(codigo_curso);
            System.out.println("\nCurso Removido com sucesso!");
        } else {
            System.out.println("\nEste curso nao existe!!" + "\n");
        }
    }

    /**
     * edita a informação pretendida pelo utilizador
     *
     * @param cursoST      redblack curso
     * @param id_curso key do curso para ser editado
     */

    public static void editCurso(SeparateChainingHashST<String, Curso> cursoST, int id_curso) {
        if (cursoST.contains(String.valueOf(id_curso))) {
            System.out.println("1 - Nome do Curso");
            System.out.println("2 - Ano Letivo");

            Scanner scanIn = new Scanner(System.in);
            String choice = scanIn.nextLine();

            switch (choice) {
                case "1":
                    String nome_curso = scanIn.nextLine();
                    cursoST.get(String.valueOf(id_curso)).setNome_curso(nome_curso);
                    break;
                case "2":
                    String ano_letivo = scanIn.nextLine();
                    cursoST.get(String.valueOf(id_curso)).setAno_letivo(ano_letivo);
                    break;

            }
            System.out.println("\nCurso editado com sucesso!\n");
        } else {
            System.out.println("\nEste Curso nao existe!!" + "\n");
        }
    }
}

