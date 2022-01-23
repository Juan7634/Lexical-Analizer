package analizer.lex;

public class DeleteComentario {
    private String cadena;
    private String snippet;

        public DeleteComentario() {
            this.cadena = "";
            this.snippet = "";
        }

        public void setCadena(String cadena) {
            this.cadena = cadena;
        }

        public String getCadena() {
            if(this.cadena.contains("//")){
                this.snippet = this.cadena.substring(0, this.cadena.indexOf("//"));
                this.snippet = this.snippet.trim();
            }
            else{
                this.snippet = this.cadena;
            }

            return this.snippet;

        }
}
