package com.solicita.model;

public class Perfil {

    private int id;
    private String curso;
    private String situacao;
    private int aluno_id;
    private int unidade_id;
    private int curso_id;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public int getUnidade_id() {
        return unidade_id;
    }

    public void setUnidade_id(int unidade_id) {
        this.unidade_id = unidade_id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }
}