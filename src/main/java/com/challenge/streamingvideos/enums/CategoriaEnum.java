package com.challenge.streamingvideos.enums;

public enum CategoriaEnum {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    CINEMA_ARTE("Cinema de arte"),
    CHANCHADA("Chanchada"),
    COMEDIA("Comédia"),
    COMEDIA_ACAO("Comédia de ação"),
    COMEDIA_TERROR("Comédia de terror"),
    COMEDIA_DRAMATICA("Comédia dramática"),
    COMEDIA_ROMANTICA("Comédia romântica"),
    DANCA("Dança"),
    DOCUMENTARIO("Documentário"),
    DOCUFICCAO("Docuficção"),
    DRAMA("Drama"),
    ESPIONAGEM("Espionagem"),
    FAROESTE("Faroeste"),
    FANTASIA("Fantasia"),
    FANTASIA_CIENTIFICA("Fantasia científica"),
    FICCAO_CIENTIFICA("Ficção científica"),
    FILMES_COM_TRUQES("Filmes com truques"),
    FILMES_DE_GUERRA("Filmes de guerra"),
    MISTERIO("Mistério"),
    MUSICAL("Musical"),
    FILME_POLICIAL("Filme policial"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    THRILLER("Thriller");
    private final String descricao;
    private CategoriaEnum(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
