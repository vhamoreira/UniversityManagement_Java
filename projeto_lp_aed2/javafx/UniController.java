package projeto_lp_aed2.javafx;


import edu.princeton.cs.algs4.SeparateChainingHashST;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto_lp_aed2.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class UniController implements Initializable {
    //tabela turmas
    public TableView<Turma> turmasTable;
    public TableColumn<Turma, String> numAlunosCol;
    public TableColumn<Turma, String> uniCurricularCol;
    public TableColumn<Turma, String> cursoCol;
    public TableColumn<Turma, String> turmaCol;
    public TableColumn<Professor, String> professorCol;

    public TextField professorField1;
    public TextField numAlunosField1;
    public TextField uniCurricularlField1;
    public TextField cursoField1;
    public TextField turmaField1;
    public ComboBox<String> professorComboBox;

    //Tabela prof
    public TableView<Professor> profsTable;

    public TableColumn<Professor, String> idprofCol;
    public TableColumn<Professor, String> identifierCodeCol;
    public TableColumn<Professor, String> nomeProfCol;
    public TableColumn<Professor, String> cursoProfCol;
    public TableColumn<Professor, String> uniCurricularProfCol;

    public TextField idProfField;
    public TextField identifierCodeField;
    public TextField nomeProfField;
    public TextField cursoProfField;
    public TextField uCurricularProfField;


    private Controlador ct;


    private static final String FILE_DELIMITER = ";";
    //paths
    private static final String PATH_TURMAS = ".//data//turmas.txt";
    private static final String PATH_PROF = ".//data//professores.txt";
    private static final String PATH_BIN = ".//data//data_uni.bin";



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ct = new Controlador();
        //tabela de turmas
        turmaCol.setCellValueFactory(new PropertyValueFactory<>("id_turma"));
        cursoCol.setCellValueFactory(new PropertyValueFactory<>("curso"));
        uniCurricularCol.setCellValueFactory(new PropertyValueFactory<>("ucurricular"));
        numAlunosCol.setCellValueFactory(new PropertyValueFactory<>("numero_alunos"));
        professorCol.setCellValueFactory(new PropertyValueFactory<>("professor"));

        //tabela de professores
        idprofCol.setCellValueFactory(new PropertyValueFactory<>("id_professor"));
        identifierCodeCol.setCellValueFactory(new PropertyValueFactory<>("codigo_professor"));
        nomeProfCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cursoProfCol.setCellValueFactory(new PropertyValueFactory<>("curso"));
        uniCurricularProfCol.setCellValueFactory(new PropertyValueFactory<>("ucurriculares"));

    }


    public void handleReadFileAction(ActionEvent actionEvent) {
        turmasTable.getItems().clear();
        profsTable.getItems().clear();
        try {
            ArrayList<Turma> turmasArrayList = readTurmasFromFile();
            turmasTable.getItems().addAll(turmasArrayList);
            ArrayList<Professor> professorArrayList = readProfessoresFromFile();
            profsTable.getItems().addAll(professorArrayList);
            addProfessorsToComboBox(ct.getProfessores());




        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void handleSaveFileAction(ActionEvent actionEvent) {
        saveTurmasToFile();
        saveProfessoresToFile();
    }

    public void handleReadBinFileAction(ActionEvent actionEvent)  {
        readFromBinFile();

            profsTable.getItems().clear();
            turmasTable.getItems().clear();
            profsTable.getItems().addAll(ct.getProfessores());
            turmasTable.getItems().addAll(ct.getTurmas());

            addProfessorsToComboBox(ct.getProfessores());

    }

    public void handleSaveBinFileAction(ActionEvent actionEvent) {
        saveToBinFile();
    }

    public void handleExitAction(ActionEvent actionEvent) {
        System.out.println("exit");
    }

    public void handleAddTurmaAction(ActionEvent actionEvent) {
        Turma t = new Turma(Integer.parseInt(turmaField1.getText()), cursoField1.getText(), uniCurricularlField1.getText(), Integer.parseInt(numAlunosField1.getText()), professorField1.getText());
        for(Professor ti: ct.getProfessores()){
            if(ti.getNome().compareTo(t.getProfessor()) == 0){
                turmasTable.getItems().add(t);
                turmaField1.setText("");
                cursoField1.setText("");
                uniCurricularlField1.setText("");
                numAlunosField1.setText("");
                professorField1.setText("");
                System.out.println("Turma Adicionada!");
            }
            else
                System.out.println("Nao é possivel adicionar essa turma a esse professor, porque "+t.getProfessor()+" não existe!");
        }
    }


    public void handleSelectProfessorAction(ActionEvent actionEvent) {

        turmasTable.getItems().clear();
        String profName = professorComboBox.getValue();
        Professor p = ct.searchProfessor(profName);
        if(p != null){
            turmasTable.getItems().addAll(ct.allTurmasByProfessor(p));
        }

    }



    private ArrayList<Turma> readTurmasFromFile() throws IOException {
        ArrayList<Turma> turmasArrayList = new ArrayList<>();
        BufferedReader br = openBufferedReader(PATH_TURMAS);
        if(br != null){
            br.readLine();
            String line = br.readLine();
            while(line != null){
                String[] dFields = line.split(FILE_DELIMITER); // dFields[0] - registration, dFields[1] - marca, dFields[2] - model
                Turma t = new Turma(Integer.parseInt(dFields[0]), dFields[1], dFields[2],Integer.parseInt(dFields[3]), dFields[4]);
                //System.out.println(t);
                ct.addTurma(t);

                //vehiclesArrayList.add(v);

                line = br.readLine();
            }
            br.close();
        }
        return ct.getTurmas();
    }

    private ArrayList<Professor> readProfessoresFromFile() throws IOException {
        ArrayList<Professor> professoresArrayList = new ArrayList<>();
        BufferedReader br = openBufferedReader(PATH_PROF);
        if(br != null){
            br.readLine();
            String line = br.readLine();
            while(line != null){
                String[] dFields = line.split(FILE_DELIMITER);
                Professor p = new Professor(Integer.parseInt(dFields[0]),dFields[1], dFields[2], dFields[3], dFields[4]);
                //System.out.println(t);
                ct.addProfessor(p);
                //vehiclesArrayList.add(v);

                line = br.readLine();
            }
            br.close();
        }
        return ct.getProfessores();
    }

    private BufferedReader openBufferedReader(String pathTurmas) {
        try {
            FileReader fr = new FileReader(pathTurmas);
            BufferedReader br = new BufferedReader(fr);

            return br;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }
    private PrintWriter openPrintWriter(String path){
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            return pw;
        } catch (IOException e) {
            System.out.println("I/O Exception");
        }
        return null;
    }

    private void saveTurmasToFile(){
        PrintWriter pw = openPrintWriter(PATH_TURMAS);
        if (pw != null){
            pw.write("Turma"+ FILE_DELIMITER + "Curso" + FILE_DELIMITER + "UnidadeCurricular" +FILE_DELIMITER + "NumAlunos" + FILE_DELIMITER + "Professor;\n");
            for (Turma ti: turmasTable.getItems()) {
                pw.write(ti.getId_turma() + FILE_DELIMITER + ti.getCurso() + FILE_DELIMITER + ti.getUcurricular() + FILE_DELIMITER + ti.getNumero_alunos() + FILE_DELIMITER + ti.getProfessor() +"\n");

            }
            pw.close();
        }
    }

    private void saveProfessoresToFile(){
        PrintWriter pw = openPrintWriter(PATH_PROF);
        if (pw != null){
            pw.write("id_professor"+ FILE_DELIMITER +"codigo_professor" + FILE_DELIMITER +"nome"+ FILE_DELIMITER +"curso"+ FILE_DELIMITER +"ucurriculares;\n");
            for (Professor pi: profsTable.getItems()) {
                pw.write(pi.getId_professor() + FILE_DELIMITER + pi.getCodigo_professor() + FILE_DELIMITER + pi.getNome() + FILE_DELIMITER + pi.getCurso() + FILE_DELIMITER + pi.getUcurriculares() +"\n");

            }
            pw.close();
        }
    }

    private void addProfessorsToComboBox(ArrayList<Professor> professors){
        professorComboBox.getItems().clear();
        for (Professor pi: professors) {
            professorComboBox.getItems().add(pi.getNome());
        }
    }

    private void saveToBinFile(){
        File f = new File(PATH_BIN);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromBinFile(){
        File f = new File(PATH_BIN);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ct = (Controlador) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void handleAddProfAction(ActionEvent actionEvent) {
        Professor p = new Professor(Integer.parseInt(idProfField.getText()), identifierCodeField.getText(), nomeProfField.getText(), cursoProfField.getText(), uCurricularProfField.getText());
        for(Professor pi: ct.getProfessores()){
            if(pi.getCodigo_professor().compareTo(p.getCodigo_professor()) == 0){
                System.out.println("Erro! "  +p.getNome()+" ja se encontra adicionado");
                return;
            }
        }
        profsTable.getItems().add(p);
        idProfField.setText("");
        identifierCodeField.setText("");
        nomeProfField.setText("");
        cursoProfField.setText("");
        uCurricularProfField.setText("");
        System.out.println("Professor Adicionado!");

    }
}
