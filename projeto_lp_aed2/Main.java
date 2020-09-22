package projeto_lp_aed2;

import edu.princeton.cs.algs4.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * @author vhamoreira
 */
public class Main {
    private static String FILE_DELIMETER = ";";


    /**
     * @param args the command line arguments
     */
    public static SeparateChainingHashST<String, Curso> cursoST = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Aluno> alunoST = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Professor> profST = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, UCurricular> ucST = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Turma> turmaST = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String, Sala> salaST = new SeparateChainingHashST<>();
    //public static SeparateChainingHashST<String,Horario> horarioST = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String,Horario>horario_salaST = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String,Horario>horario_alunoST = new SeparateChainingHashST<>();




    public static void main(String[] args) throws ParseException, FileNotFoundException {
        //symbol tables creation

        //paths
        String path1 = ".//data//cursos.txt";
        String path2 = ".//data/professores.txt";
        String path3 = ".//data//alunos.txt";
        String path4 = ".//data//salas.txt";
        String path5 = ".//data//rede.txt";
        String path6 = ".//data//coords.txt";
        String path7 = ".//data//turmas.txt";
        String path8 = ".//data//uc.txt";
        String path9 = ".//data//horario.txt";
        String path10 = ".//data//horario_salas.txt";
        String path11 = ".//data//horario_alunos.txt";


        //////////////////////////////////////////////LOADS////////////////////////////////////////

        Curso.loadCurso(cursoST, path1);
        Professor.loadProfessores(profST, path2, cursoST,ucST);
        Aluno.loadAluno(alunoST,path3, cursoST);
        Turma.loadTurmas(turmaST, path7,profST,ucST);
        Horario.loadHorario(horario_salaST,path10);
        Sala.loadSala(salaST,horario_salaST,path4);
        UCurricular.loadUC(ucST, path8);
        Aluno.loadHorarioAluno(horario_alunoST, path11);

        //////////////////////////////////////////Cursos//////////////////////////////////////////////

        //Curso.insertCurso(cursoST,5, "Fisioterapia","FISI", "2018");
        //Curso.removeCurso(cursoST,"FISI");
        //Curso.editCurso(cursoST,1);
        //Curso.print_curso(cursoST,"EINF");
        //Curso.printCursos(cursoST);
        //Curso.printCursoInAno(cursoST,"2019");
        //Curso.saveCurso(cursoST,path1);

       /////////////////////////////////////Professores/////////////////////////////////////////////////

        //Professor.insertProfessor(cursoST,profST,8, "MOTR","Rui","Fisioterapia", "Patologia I");
        //Professor.removeProf(cursoST,profST,1);
        //Professor.editProf(cursoST,profST,1);
        //Professor.print_professor(profST,1);
        //Professor.printProfs(profST);
        //Professor.saveProf(profST, path2);
        //Professor.printUCdoProf(profST,"Redes I");

        //////////////////////////////////////Alunos//////////////////////////////////////////////////

        //Aluno.insertAluno(cursoST,alunoST,6,"Vitor Silva","Engenharia Informatica");
        //Aluno.removeAluno(cursoST,alunoST,1);
        //Aluno.editAluno(cursoST,alunoST,1);
        //Aluno.printAlunosHorarios(alunoST, horario_alunoST);
        //Aluno.print_aluno(alunoST,1);
        //Aluno.printAlunos(alunoST);
        //Aluno.saveAluno(alunoST, path3);

        ///////////////////////////////////////Salas/////////////////////////////////////////////////

        //Sala.insertSala(salaST, "8", "Sala 102", 20, 1,2,1,2,10);

        //Sala.insertHorarioNaSala(salaST,horario_salaST,"8",LocalTime.of(12,00),LocalTime.of(13,00),DayOfWeek.MONDAY);
        //Sala.insertHorarioNaSala(salaST,horario_salaST,"8",LocalTime.of(13,00),LocalTime.of(14,00),DayOfWeek.MONDAY);
        //Sala.insertHorarioNaSala(salaST,horario_salaST,"1",LocalTime.of(17,00),LocalTime.of(18,00),DayOfWeek.MONDAY);

        //Sala.printSalas(salaST,horario_salaST);
        //Sala.print_sala(salaST,horario_salaST,"8");

        //Sala.printHorarios(salaST,horario_salaST,"3");


        //Sala.removeSala(salaST,1);
        //Sala.saveSala(salaST,path4);
        //Sala.print_salaTomadas(salaST,"50");
        //Sala.procuraDisponibilidade(salaST,horario_salaST,"3",LocalTime.of(12,00),LocalTime.of(13,00),DayOfWeek.MONDAY);
        //Sala.saveHorarioSala(salaST,horario_salaST,"3",path10);
        Sala.printSalasporTomadas(salaST,100);

        /////////////////////////////////////////Turmas////////////////////////////////////////////////

        //Turma.insertTurma(turmaST,8, 25, "Fisioterapia", "Patologia I", "Ana Guedes");
        //Turma.print_turma(turmaST,1);
        //Turma.printTurmas(turmaST);
        //Turma.removeTurma(turmaST,1);
        //Turma.printTurmasProfessor(turmaST,"Beatriz Gomes");
        //Turma.saveTurma(turmaST, path7);


        /////////////////////////////////////////UCurricular////////////////////////////////////////////////

        //UCurricular.insertUC(ucST, 12, "SDIS", 10, 3);
        //UCurricular.printUcs(ucST);
        //UCurricular.print_uc(ucST, 2);
        //UCurricular.removeUC(ucST, 12);
        //UCurricular.saveUC(ucST, path8);


        /////////////////////////////////////////GRAFOS////////////////////////////////////////////////

        /*
        0/20 - Entrada/Saida
        1/2/3 - Corredor 1º, 2º e 3º pisos
        4/5 - WC
        6/7/8/9 - Salas 1º piso
        10/11/12/13 - salas 2º piso
        14/15/16/17 - salas 3º piso
        18/19 - escadas 1º e 2º piso
         */
        In in = new In(path6);
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(in);

        //System.out.println(g);
        //GrafoController.printSP(g, 0);
        //GrafoController.printSP_FromAtoB(g, 0, 20);
        //GrafoController.isConnected(g);

            /*
        Sala sala1 = new Sala("1", "104", 30, 1,25, 10,30,1);
        Sala sala2 = new Sala("2", "105", 60, 1, 40, 20,20,2);
        Sala sala3 = new Sala("3", "208", 30, 2, 20, 10,20,3);
        Sala sala4 = new Sala("4", "210-professor", 10, 2, 10,5,10,4);

        //Grafo grafo = new Grafo(1, 10,50);
        GrafoController grafoController = new GrafoController();


        try {
            grafoController.cria_grafo();
            // Piso 1
            grafoController.createEdge(sala1.getVertice(), sala2.getVertice(), grafoController.calculateWeight(sala1, sala2), 5);
            grafoController.createEdge(sala3.getVertice(), sala4.getVertice(), grafoController.calculateWeight(sala3, sala4), 10);


            EdgeWeightedDigraph graph = grafoController.getGlobalGraph();
            graph.toString();

            LOGGER.info(graph.toString());
            LOGGER.info("Creating sub-graph from floor 1");
            LOGGER.info(locationManager.getSubGraphFromFloor(1).toString());
            LOGGER.info("Creating sub-graph from floor 2");
            LOGGER.info(locationManager.getSubGraphFromFloor(2).toString());
            LOGGER.info("Creating sub-graph from floor 3");
            LOGGER.info(locationManager.getSubGraphFromFloor(3).toString());


        } catch (Exception e) {
            System.out.println("Erro!");
        }
                         */
    }


}
