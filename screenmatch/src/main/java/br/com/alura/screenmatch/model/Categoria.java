package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action"),
    ANIMACAO("Animation"),
    AVENTURA("Adventure"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    DOCUMENTARIO("Documentary"),
    FANTASIA("Fantasy"),
    FICCAO("Science Fiction"),
    MUSICAL("Musical"),
    TERROR("Horror"),
    SUSPENSE("Suspense"),
    ROMANCE("Romance"),
    CRIME("Crime");

    private final String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public String getCategoriaOmdb() {
        return categoriaOmdb;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
