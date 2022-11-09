package LULA;

import java.util.ArrayList;

public class Local {
    private String id;
    private String nome;
    private int ramal;
    private ArrayList<Comitiva> visitas;

    public Local(String id, String nome, int ramal) {
        this.id = id;
        this.nome = nome;
        this.ramal = ramal;
        this.visitas = new ArrayList<Comitiva>();
    }

    public String getId() {
        return this.id;
    }
    
    public void adicionaVisita(Comitiva comitiva) {
    	if (this.visitas.contains(comitiva)) {
    		throw new IllegalArgumentException("Visita já cadastrada");
    	} else if (this.visitas.size() >= 100) {
    		throw new IndexOutOfBoundsException("Limite total de visitas já cadastradas");
    	} else {
    		this.visitas.add(comitiva);
    	}
    }
    
    public int contaVisitas() {
    	int total = 0;
    	for (Comitiva com : this.visitas) {
    		total += com.getQtd();
    	}
    	return total;
    }
    
    public String listaVisitas() {
    	String out = "";
    	for (Comitiva com : this.visitas) {
    		out += com.toString();
    	}
    	return out;
    }

    @Override
    public String toString() {
        return "\n" + this.id + " - " + this.nome + " - " + this.ramal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        
        Local testeLocal = (Local) o;
        return this.id == testeLocal.id;
    }
}
