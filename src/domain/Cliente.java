package domain;

public class Cliente {

    private String nome;
    private String telefone;
    private String endereco;
    private  String veiculoDesejado;
    private String veiculoAlugado;
    private String dataEmprestimo;
    private String horaEmprestimo;
    private String dataDevolucao;
    private String horaDevolucao;

    public Cliente(String nome, String telefone, String endereco, String veiculoDesejado,
                   String veiculoAlugado) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.veiculoDesejado = veiculoDesejado;
        this.veiculoAlugado = veiculoAlugado;
    }


    public Cliente(String nome, String telefone, String endereco, String veiculoDesejado, String veiculoAlugado,
                   String dataEmprestimo, String horaEmprestimo, String dataDevolucao, String horaDevolucao) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.veiculoDesejado = veiculoDesejado;
        this.veiculoAlugado = veiculoAlugado;
        this.dataEmprestimo = dataEmprestimo;
        this.horaEmprestimo = horaEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.horaDevolucao = horaDevolucao;
    }

    public Cliente() {

    }

    public String getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(String horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }

    public String getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String  dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public void setVeiculoAlugado(String veiculoAlugado) {
        this.veiculoAlugado = veiculoAlugado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getVeiculoDesejado() {
        return veiculoDesejado;
    }

    public void setVeiculoDesejado(String veiculoDesejado) {
        this.veiculoDesejado = veiculoDesejado;
    }

    @Override
    public String toString() {

        return  "(Nome = " + nome + ")  " +
                "(Telefone = " + telefone + ")  " +
                "(Endereco = " + endereco + ")" +
                "(VeiculoDesejado = " + veiculoDesejado + ")";
    }
}
