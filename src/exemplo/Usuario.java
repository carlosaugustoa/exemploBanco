package exemplo;

public class Usuario {

    private int id;
    private String nome;
    private int idade;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        @Override
        public String toString() {
            return "Usuario{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + '}';
        }
    
}
    
    

