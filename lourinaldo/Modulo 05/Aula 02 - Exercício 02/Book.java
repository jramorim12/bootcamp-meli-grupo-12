public class Book {

    private boolean disponivel;
    private String titulo;
    private String isbn;
    private String autor;

    public Book(){}

    public Book(boolean disponivel, String titulo, String isbn, String autor) {
        this.disponivel = disponivel;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public void emprestimo(){
        this.setDisponivel(false);
    }

    public void devolver(){
        this.setDisponivel(true);
    }

    public String toString(){
        return this.getTitulo()+", "+this.getIsbn()+", "+this.getAutor();
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
