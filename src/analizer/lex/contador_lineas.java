package analizer.lex;

public class contador_lineas {
    private int line;
    private int word;
    
        public contador_lineas(){
            line = 0;
            word = 0;
        }

        public void setLine(){
            this.line += 1; 
        }
        
        public void setword(){
            this.word += 1;
        }

        public void clear_word(){
            this.word = 0;
        }

        public int getLine(){
            return line;
        }
        public int getWord(){
            return word;
        }
}
