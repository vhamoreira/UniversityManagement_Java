package projeto_lp_aed2;


import java.io.Serializable;
import java.util.ArrayList;

public class Controlador implements Serializable {

    //private SeparateChainingHashST<Integer, Turma> turmaST = new SeparateChainingHashST<>();
    private ArrayList<Turma> turmas = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();


    public void addTurma(Turma t) {
        for (Turma ti : this.getTurmas()) {
            if(ti.getId_turma() == t.getId_turma()){
                System.out.println("turma ja registada");
                return;
            }
        }
        this.getTurmas().add(t);
    }

    public Professor searchProfessor(String profName) {
        for (Professor pi : this.getProfessores()) {
            if (pi.getNome().compareTo(profName) == 0) {
                return pi;
            }
        }
        return null;
    }


    public ArrayList<Turma> allTurmasByProfessor(Professor p) {
        ArrayList<Turma> turmaArrayList = new ArrayList<>();
        for(Turma ti : this.getTurmas()){
            if(ti.getProfessor().compareTo(p.getNome()) == 0){
                turmaArrayList.add(ti);
            }
        }
        return turmaArrayList;
    }


    public void addProfessor(Professor p) {
        for (Professor pi : this.getProfessores()) {
            if(pi.getId_professor() == p.getId_professor()){
                System.out.println("Professor ja registado");
                return;
            }
        }
        this.getProfessores().add(p);
    }


    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }
}
