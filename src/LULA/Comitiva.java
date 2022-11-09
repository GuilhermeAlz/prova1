package LULA;

public class Comitiva {
    private int id;
    private String descricao;
    private int qtdPessoas;
    private String telefone;

    public Comitiva(int id, String descricao, int qtdPessoas, String telefone) {
        this.id = id;
        this.descricao = descricao;
        this.qtdPessoas = qtdPessoas;
        this.telefone = telefone;
    }

    public int getId() {
        return this.id;
    }
    
    public int getQtd() {
    	return this.qtdPessoas;
    }

    @Override
    public String toString() {
        String out = "\nID: " + this.id + "\nComitiva: " + this.descricao + "\nIntegrantes: " + this.qtdPessoas + "\nContato: " + this.telefone;
        return out;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        
        Comitiva testeLocal = (Comitiva) o;
        return this.id == testeLocal.id;
    }
}
