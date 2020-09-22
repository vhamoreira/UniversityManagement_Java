package projeto_lp_aed2;

import edu.princeton.cs.algs4.BinaryOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class UCurricular {
    private int id_uc;
    private String nome;
    private int ects;
    private int ano;

    private SeparateChainingHashST<Integer, Professor> professor_ucST = new SeparateChainingHashST<>();

    public UCurricular(int id_uc, String nome, int ects, int ano) {
        this.id_uc = id_uc;
        this.nome = nome;
        this.ects = ects;
        this.ano = ano;
    }

    public static void loadUC(SeparateChainingHashST<Integer, UCurricular> ucST, String path) {
        In in = new In(path);
        in.readLine();

        try {
            while (!in.isEmpty()) {

                String[] token = in.readLine().split(";");

                String aux = token[0];
                String aux2 = token[1];
                String aux3 = token[2];
                String aux4 = token[3];


                UCurricular aux_uc = new UCurricular(Integer.parseInt(aux), aux2, Integer.parseInt(aux3), Integer.parseInt(aux4));

                ucST.put(Integer.parseInt(aux), aux_uc);
            }


        } catch (Exception exception) {
            System.out.println(exception);

        }
    }

    /**
     * guarda a redblack na base de dados
     *
     * @param ucST redblack UC
     * @param path caminho
     */

    public static void saveUC(SeparateChainingHashST<Integer, UCurricular> ucST, String path) {
        Out out = new Out(path);
        out.println("id_uc;nome;ects;ano;");

        for (Integer key : ucST.keys()) {
            out.println(
                    ucST.get(key).getId_uc() + ";"
                            + ucST.get(key).getNome() + ";"
                            + ucST.get(key).getEcts() + ";"
                            + ucST.get(key).getAno() + ";");

        }
    }
    /**
     * grava ucs em binario
     * @param ucST
     */
    public static void saveUCBinary(SeparateChainingHashST<Integer, UCurricular> ucST) {

        BinaryOut bo = new BinaryOut(".//data//UcurricularesBinary.txt");
        for (Integer key : ucST.keys()) {
            UCurricular aux = ucST.get(key);
            bo.write(
                    aux.getNome() + ";"
                            + aux.getEcts() + ";"
                            + aux.getAno() + ";");
        }

    }

    /**
     * imprime todas as uc na redblack uc
     *
     * @param ucST redblack prof
     */

    public static void printUcs(SeparateChainingHashST<Integer, UCurricular> ucST) {
        System.out.println("##############Listagem das Unidades Curriculares##############");
        try {
            for (Integer key : ucST.keys()) {
                print_uc(ucST, key);
                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * imprime uc consoante a key passada
     *
     * @param ucST redblack uc
     * @param key  key da uc
     */

    public static void print_uc(SeparateChainingHashST<Integer, UCurricular> ucST, int key) {
        System.out.println("ID: " + ucST.get(key).getId_uc());
        System.out.println("Nome: " + ucST.get(key).getNome());
        System.out.println("ECTS: " + ucST.get(key).getEcts());
        System.out.println("Ano: " + ucST.get(key).getAno());

    }

    /**
     * insere um novo objeto do tipo UC a redblack UC
     *
     * @param ucST
     * @param id_uc
     * @param nome
     * @param ects
     * @param ano
     */

    public static void insertUC(SeparateChainingHashST<Integer, UCurricular> ucST, int id_uc, String nome, int ects, int ano) {
        if (ucST.contains(id_uc)) {
            System.out.println("\nUC não adicionada!!" + "\n");


        } else {
            UCurricular aux_uc = new UCurricular(id_uc, nome, ects, ano);
            ucST.put(id_uc, aux_uc);
            System.out.println("\nUnidade Curricular adicionada com sucesso! \n");
        }
    }

    /**
     * remove uma uc da redblack consoante a key passada
     *
     * @param ucST  redblack
     * @param id_uc key da uc
     */

    public static void removeUC(SeparateChainingHashST<Integer, UCurricular> ucST, int id_uc) {
        if (ucST.contains(id_uc)) {
            ucST.delete(id_uc);
            System.out.println("\nUC Removida com sucesso!");
        } else {
            System.out.println("\nEsta UC nao existe!!" + "\n");
        }
    }

    public SeparateChainingHashST<Integer, Professor> getProfessor_ucST() {
        return professor_ucST;
    }

    public int getId_uc() {
        return id_uc;
    }

    public void setId_uc(int id_uc) {
        this.id_uc = id_uc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


}
