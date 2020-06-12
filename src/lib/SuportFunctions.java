package lib;

// Se importan las librerías a utilizar.
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class SuportFunctions {
        
    /**
     * Método para utilizar de manera cómoda y rápida el CardLayout.
     * @param base JPanel Base; es el JPanel contenedor o padre.
     * @param opc  JPanel Opc; es el JPanel que se va a mostrar o hijo.
     */
    public void cardSelection(JPanel base, JPanel opc){
        base.removeAll(); // Elimina el contenido del JPanel principal.
        base.add(opc); // Añade el segundo JPanel al JPanel principal.
        base.repaint(); // Actualiza el contenido del JPanel principal.
        base.revalidate(); // Validar el contenido del JPanel principal.
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos de validación ">

    /**
     * Método para validar números enteros y positivos
     * @param evt Variable KeyEvent.
     */
    public void integerPositiveKeyTyped(KeyEvent evt){
        // Se trae el caracter ingresado en el campo de texto correspondiente.
        char numbers = evt.getKeyChar();
        // Se aplica la condición para que se elimine o no el caracter.
        if(numbers < '0' || numbers > '9')
            // Si cumple la condición, el caracter se elimina.
            evt.consume();
    }
    
    /**
     * Método para validar letras del abecedario.
     * @param evt variable de tipo KeyEvent
     */
    public void alphabetKeyTyped(KeyEvent evt){
        // Se trae el caracter ingresado en el campo de texto correspondiente.
        char letters = evt.getKeyChar();
        // Se aplica la condición para que se elimine o no el caracter.
        if((letters < 'a' || letters > 'z') && (letters < 'A' || letters > 'Z') 
                && (letters != ' '))
            // Si cumple la condición, el caracter se elimina.
            evt.consume();
    }
    
    /**
     * Método para comprobar que dos contraseñas son iguales.
     * @param passOne Primera contraseña.
     * @param passTwo Segunda contraseña.
     * @return Variable booleana.
     */
    public boolean isPasswordCorrect(char[] passOne, char[] passTwo) {
        
        // Variable a retornar.
        boolean valor = true;
        
        // Puntero iniciado en posición '0'.
        int pointer = 0;
        
        // Primera validación; Si las contraseñas tienen el mismo largo.
        if (passOne.length != passTwo.length)
            valor = false; // -> Retornar 'true'.
        
        else{
            
            /*
             * Mientras la variable a retornar sea verdadera y el puntero sea 
             * menor al largo de las contraseñas.
             */
            while((valor) && (pointer < passOne.length)){
                
                /*
                 * Si la primera contraseña en la posición del puntero es 
                 * distinta a la segunda contraseña en la misma posición del 
                 * puntero.
                 */
                if (passOne[pointer] != passTwo[pointer])
                    valor = false; // -> Retornar 'false'.
                
                pointer++; // -> Se incrementa el puntero.
                
            }
            
        }
        
        return valor; // -> Retornar el valor obtenido ('true' o 'false').
    }
        
    /**
     * Método para verificar un correo electrónico.
     * @param email correo electrónico a verificar.
     * @return variable booleana.
     */
    public boolean verifyEmail(String email){
        
        // Variable a retornar.
        boolean valor = true;
        
        //<editor-fold defaultstate="collapsed" desc=" Explicación de la expresión regular utilizada ">
        /*
         *  ^ especifica el inicio de la entrada.
         *  ([_a-z0-9-]) primer grupo. Se refiere a la aparición de uno o más 
         *      caracteres compuestos por guión bajo, letras, números y guiones.
         *  (\\.[_a-z0-9-]) segundo grupo. Puede ser opcional y repetible, se 
         *      refiere a la aparición de un punto seguido de uno o más caracte-
         *      res compuestos por guión bajo, letras, números y guiones.
         *  *@ carácter arroba.
         *  ([a-z0-9-]) tercer grupo. Especifica la aparición de uno o más ca-
         *      racteres compuestos por letras, números y guiones.
         *  (\\.[a-z0-9-]) cuarto grupo. Especifica un punto seguido de uno o 
         *      más caracteres compuestos por letras, números y guiones.
         *  (\\.[a-z]{2,4}) quinto grupo. Especifica un punto seguido de entre 
         *      2 y 4 letras, con el fin de considerar dominios terminados, por 
         *      ejemplo, en .co y .info.
         *  $ especifica el fin de la entrada.
         */
        //</editor-fold>
        String emailPattern =   "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
                                "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        
        // Se compila la expresión.
        Pattern pattern = Pattern.compile(emailPattern);
        
        // El correo pasado por parámetro no puede encontrarse vacío.
        if(email != null){
            
            /* 
             * En caso de que el email no sea nulo, se le aplica el patrón y se 
             * comprueba si cumple con este o no para mostrar por la salida es-
             * tándar el mensaje Valido.
             */
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches())
                System.out.println("Email válido");
            
            else{
                System.out.println("Email no válido");
                valor = false;
            }
        }
        // De encontrarse vacío.
        else
            valor = false;
        
        // Se retorna el valor.
        return valor;
    }
    
    //</editor-fold>
    
    // Método para dar formato a números.
    
    /**
     * Método para dar formato a variables de tipo Double.
     * @param number es el número al que se le quiere dar un formato.
     * @param decimal la cantidad de decimales que se quieren mostrar.
     * @return retorna el número con el formato deseado.
     */
    public Double numberDecimalFormat(Double number, Integer decimal){
        return Math.round(number * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }
    
    // Método para obtener sentencias aleatorias de datos.
    
    /**
     * Método para obtener sentencia String con datos aleatorios.
     * @param type Según sea el tipo, la sentencia a construir es distinta:
     * - type '0': Números en el rango [0,9].
     * - type '1': Todo el abecedario en letras mayúsculas, minúsculas y los 
     * números en el rango [0,9].
     * - type '2': Todo el abecedario en letras mayúsculas y minúsculas.
     * - type '3': Todo el abecedario en letras mayúsculas.
     * - type '4': Todo el abecedario en letras minúsculas.
     * @param lenght Longitud que tendrá la sentencia.
     * @return Sentencia de datos aleatorios de tipo String.
     */
    public String randomCharacterString(char type, int lenght){
        
        // Array de caracteres válidos para el código de confirmación.
        char[] chars = null;
        
        // StringBuilder de longitud 'lenght'.
        StringBuilder sb = new StringBuilder(lenght);

        // Instanciar clase Random.
        java.util.Random random = new java.util.Random();

        // Segun el type se obtiene una cadena distinta.
        switch(type){
            
            /*
             * type '0': Números en el rango [0,9].
             */
            case '0':
                chars = "0123456789".toCharArray();
            
            /*
             * type '1': Todo el abecedario en letras mayúsculas, minúsculas y
             *           los números en el rango [0,9].
             */
            case '1':                
                chars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789".toCharArray();
            
            /*
             * type '2': Todo el abecedario en letras mayúsculas y minúsculas.
             */
            case '2':
                chars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".toCharArray();
                
            /*
             * type '3': Todo el abecedario en letras mayúsculas.
             */
            case '3':
                chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            
            /*
             * type '4': Todo el abecedario en letras minúsculas.
             */
            case '4':
                chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            
        }
        
        // Ciclo para construir aleatoriamente la variable StringBuilder.
        for (int i = 0; i < lenght; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        
        // Retorna el valor obtenido en forma de String.
        return sb.toString();
        
    }
    
}
