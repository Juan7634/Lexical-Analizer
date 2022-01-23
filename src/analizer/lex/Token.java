package analizer.lex;

public class Token {
    private Tipos tipo;
    private String valor;

    public Tipos getTipos() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }


    enum Tipos{
        NUMERO ("[0-9]+"),
        OPERADOR_BINARY ("[+|-|/|*]"),
        ID ("[a-zA-Z][a-zA-Z0-9]*"),
        SIGNO_IGUALACION ("=");

            public final String patron;
            Tipos (String cadena) {
                this.patron = cadena;

            }                
    }

}
