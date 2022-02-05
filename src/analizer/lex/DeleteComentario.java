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
            if(this.cadena.contains("//")){
                this.snippet = this.cadena.substring(0, this.cadena.indexOf("//"));
                this.snippet = this.snippet.trim();
            }
            else{
                this.snippet = this.cadena;
            }
        }

        public String getCadena() {
        
            return this.snippet;

        }
}
