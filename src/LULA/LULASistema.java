package LULA;

import java.util.ArrayList;

public class LULASistema {
    private ArrayList<Local> locais;
    private ArrayList<Comitiva> comitivas;

    public LULASistema() {
        this.locais = new ArrayList<Local>();
        this.comitivas = new ArrayList<Comitiva>();
    }

    public void cadastraLocal(String id, String nome, int ramal) {
        Local local = new Local(id, nome, ramal);

        if (this.locais.contains(local)) {
            throw new IllegalArgumentException("Local ja cadastrado");
        } else if (this.locais.size() >= 100) {
            throw new IndexOutOfBoundsException("Excedido o limite de locais cadastrados");
        } else {
            this.locais.add(local);
        }
    }

    public void cadastraComitiva(int id, String descricao, int qtdPessoas, String telefone) {
    	Comitiva comitiva = new Comitiva(id, descricao, qtdPessoas, telefone);
    	
        if (id < 0 || id > 99) {
            throw new IndexOutOfBoundsException();
        } else if (this.comitivas.contains(comitiva)) {
        	throw new IllegalArgumentException("Comitiva já cadastrada");
        }
        
        this.comitivas.add(comitiva);
    }
    
    public void cadastraVisita(String idLocal, int idComitiva) {
    	Comitiva comitiva = null;
    	for (Comitiva com : this.comitivas) {
    		if (com.getId() == idComitiva) {
    			comitiva = com;
    		}
    	}
    	if(comitiva == null) {
    		throw new IllegalArgumentException("Comitiva não cadastrada");
    	}
    	
    	
    	for (Local loc : this.locais) {
    		if (loc.getId().equals(idLocal)) {
    			loc.adicionaVisita(comitiva);
    		}
    	}
    }
    
    public String listaVisitas(String idLocal) {
    	for (Local loc : this.locais) {
    		if (loc.getId().equals(idLocal)) {
    			return loc.listaVisitas();
    		}
    	}
    	throw new IllegalArgumentException("Local nao cadastrado");
    }
    
    public int contaVisitas(String idLocal) {
    	for (Local loc : this.locais) {
    		if (loc.getId().equals(idLocal)) {
    			return loc.contaVisitas();
    		}
    	}
    	throw new IllegalArgumentException("Local nao cadastrado");
    }
    

    public String exibeLocal(String id) {
        for (int i = 0; i < this.locais.size(); i++) {
            if (this.locais.get(i).getId().equals(id)) {
                return this.locais.get(i).toString();
            }
        }
        return "Local não cadastrado";
    }

    public String exibeComitiva(int id) {
        for (int i = 0; i < this.comitivas.size(); i++) {
            if (this.comitivas.get(i).getId() == id) {
                return this.comitivas.get(i).toString();
            }
        }
        return "Comitiva não cadastrada";
    }
    
    public String listaLocais() {
    	String out = "";
    	for (Local loc : this.locais) {
    		out += loc.toString();
    	}
    	return out;
    }
    
    public String listaComitivas() {
    	String out = "";
    	for (Comitiva com : this.comitivas) {
    		out += com.toString();
    	}
    	return out;
    }
}
