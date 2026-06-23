package _01_Classes;

public class ModelPerson {

    // Declaração das variáveis de instância que armazenam os dados do usuário
    private int id;
    private String nome, sobrenome, telefone, cpf, email, sexo, cargo;

    // Construtor padrão (sem parâmetros)
    public ModelPerson() {
    }

    // Construtor com parâmetros para inicializar as variáveis de instância
    public ModelPerson(int id, String nome, String sobrenome, String telefone, String cpf, String email, String sexo, String cargo) {
        this.id = id; // Inicializa o id do usuário
        this.nome = nome; // Inicializa o nome do usuário
        this.sobrenome = sobrenome; // Inicializa o sobrenome do usuário
        this.telefone = telefone; // Inicializa o telefone do usuário
        this.cpf = cpf; // Inicializa o CPF do usuário
        this.email = email; // Inicializa o email do usuário
        this.sexo = sexo; // Inicializa o sexo do usuário
        this.cargo = cargo; // Inicializa o cargo do usuário
    }

    // Getters (Métodos para acessar os valores das variáveis de instância)
    
    public int getId() {
        return id; // Retorna o id do usuário
    }

    public String getNome() {
        return nome; // Retorna o nome do usuário
    }

    public String getSobrenome() {
        return sobrenome; // Retorna o sobrenome do usuário
    }

    public String getTelefone() {
        return telefone; // Retorna o telefone do usuário
    }

    public String getCpf() {
        return cpf; // Retorna o CPF do usuário
    }

    public String getEmail() {
        return email; // Retorna o email do usuário
    }

    public String getSexo() {
        return sexo; // Retorna o sexo do usuário
    }

    public String getCargo() {
        return cargo; // Retorna o cargo do usuário
    }

    // Setters (Métodos para definir os valores das variáveis de instância)

    public void setId(int id) {
        this.id = id; // Define o id do usuário
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome do usuário
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome; // Define o sobrenome do usuário
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone; // Define o telefone do usuário
    }

    public void setCpf(String cpf) {
        this.cpf = cpf; // Define o CPF do usuário
    }

    public void setEmail(String email) {
        this.email = email; // Define o email do usuário
    }

    public void setSexo(String sexo) {
        this.sexo = sexo; // Define o sexo do usuário
    }

    public void setCargo(String cargo) {
        this.cargo = cargo; // Define o cargo do usuário
    }

}
