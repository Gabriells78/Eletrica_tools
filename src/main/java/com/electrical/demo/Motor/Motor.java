package com.electrical.demo.Motor;

import static com.electrical.demo.tools.Principal.raizDeTres;

public class Motor {
    private Enum TipoMotor;
    private Float PotenciaMotor;
    private String CategoriaConjugacao;
    private Float RotacaoNominal;
    private int Frequencia;
    private int TensoesNominais;
    private Float CorrentesNominais;
    private String GrauDeProtecao;
    private Float NumeroDeVezesNominal;
    private Float FatorDePotencia;
    private Float Rendimento;
    public double distancia;
    public double cobreCondutividade = 58 * 1000;

    public Motor() {
    }

    public Motor(Enum TipoMotor, Float PotenciaMotor, String CategoriaConjugacao, Float RotacaoNominal, int Frequencia, int tensoesNominais,
                 Float CorrentesNominais, String GrauDeProtecao, Float NumeroDeVezesNominal, Float FatorDePotencia, Float Rendimento){
     this.TipoMotor = TipoMotor;
     this.PotenciaMotor = PotenciaMotor;
     this.CategoriaConjugacao = CategoriaConjugacao;
     this.RotacaoNominal = RotacaoNominal;
     this.Frequencia = Frequencia;
     this.TensoesNominais = tensoesNominais;
     this.CorrentesNominais = CorrentesNominais;
     this.GrauDeProtecao = GrauDeProtecao;
     this.NumeroDeVezesNominal = NumeroDeVezesNominal;
     this.FatorDePotencia = FatorDePotencia;
     this.Rendimento = Rendimento;

    }


    public Enum getTipoMotor() {
        return TipoMotor;
    }

    public void setTipoMotor(Enum tipoMotor) {
        TipoMotor = tipoMotor;
    }

    public Float getPotenciaMotor() {
        return PotenciaMotor;
    }

    public void setPotenciaMotor(Float potenciaMotor) {
        PotenciaMotor = potenciaMotor;
    }

    public String getCategoriaConjugacao() {
        return CategoriaConjugacao;
    }

    public void setCategoriaConjugacao(String categoriaConjugacao) {
        CategoriaConjugacao = categoriaConjugacao;
    }

    public Float getRotacaoNominal() {
        return RotacaoNominal;
    }

    public void setRotacaoNominal(Float rotacaoNominal) {
        RotacaoNominal = rotacaoNominal;
    }

    public int getFrequencia() {
        return Frequencia;
    }

    public void setFrequencia(int frequencia) {
        Frequencia = frequencia;
    }

    public int getTensoesNominais() {
        return TensoesNominais;
    }

    public void setTensoesNominais(int tensoesNominais) {
        TensoesNominais = tensoesNominais;
    }

    public Float getCorrentesNominais() {
        return CorrentesNominais;
    }

    public void setCorrentesNominais(Float correntesNominais) {
        CorrentesNominais = correntesNominais;
    }

    public String getGrauDeProtecao() {
        return GrauDeProtecao;
    }

    public void setGrauDeProtecao(String grauDeProtecao) {
        GrauDeProtecao = grauDeProtecao;
    }

    public Float getNumeroDeVezesNominal() {
        return NumeroDeVezesNominal;
    }

    public void setNumeroDeVezesNominal(Float numeroDeVezesNominal) {
        NumeroDeVezesNominal = numeroDeVezesNominal;
    }

    public Float getFatorDePotencia() {
        return FatorDePotencia;
    }

    public void setFatorDePotencia(Float fatorDePotencia) {
        FatorDePotencia = fatorDePotencia;
    }

    public Float getRendimento() {
        return Rendimento;
    }

    public void setRendimento(Float rendimento) {
        Rendimento = rendimento;
    }


    public void SeccaoCabo(double distancia) throws Exception {
        double cabo;
        cabo = (raizDeTres * distancia * getCorrentesNominais() * getFatorDePotencia()) / cobreCondutividade *(getTensoesNominais()*0.03);
        System.out.printf("seccao do cabo: %.2f.",cabo);

        throw new NullPointerException("Informacoes do motor nao inseridas: ");
    }


    public String toString(){
        return "Tipo do Motor: " + getTipoMotor() + "\nPotencia: " + getPotenciaMotor() + "\nConjugacao: " + getCategoriaConjugacao() +
                "\nRotacao: " + getRotacaoNominal() + "\nFrequencia: " + getFrequencia()+ "\nTensoes Nominais: " + getTensoesNominais() +
                "\nCorrentesNominais" + getCorrentesNominais() + "\nGrau de Protecao: " + getGrauDeProtecao() + "\nNumero de vezes a Corrente" +
                "\nnominal: " + getNumeroDeVezesNominal() + "\nFator de Potencai: " + getFatorDePotencia() + "\nRendimento: " + getRendimento();}



}