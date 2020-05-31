
package lib;

// Se importan las librerías necesarias para el funcionamiento de la clase.
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.*;
import java.util.*;

/**
 *
 * @author Gustavo
 */

//<editor-fold defaultstate="collapsed" desc=" Leyenda ">
    /*
     *
     * - - - - - - - - - - - - - - - - - - - - VARIABLES - - - - - - - - - - - - - - - - - - - - - -
     *
     * Chunk:                   El la parte más pequeña que se puede añadir a un documento, la 
     *                          mayor parte de los elementos se pueden dividir en varios Chunks 
     *                          y básicamente es un String con una fuente determinada.
     * Image:                   Representación gráfica de imágenes podemos utilizar: JPEG, PNG 
     *                          o GIF.
     * Paragraph:               Es una serie de chunks.
     * Chapter:                 Se usa para añadir una sección especial al documento.
     * DottedLineSeparator:     Dibuja una línea de puntos de izquierda a derecha.
     * List:                    Utilizado para representar listas en el documento.
     * PdfPTable:               Es un elemento que nos permite crear una tabla cuya posición pue-
     *                          de ser absoluta pero que también se puede añadir directamente al 
     *                          documento.
     * Font:                    Representa el tipo de fuente a utilizar.
     * Element:                 Indica el tipo de elemento.
     *
     * - - - - - - - - - - - - - - - - - - - - - - MÉTODOS - - - - - - - - - - - - - - - - - - - - -  
     *
     * open():                  Para poder crear el documento, se debe implementar el método open().
     * close():                 Para culminar la creación del documento, se debe implementar el
     *                          método close().
     * setAlignment(int):       Método que le indica la alineación correspondiente al elemento.
     * setFont(Font):           Método que indica el formato de la fuente del elemento.
     * append(String):          Método que añade un elemento a un Chunk.
     * add(Chunk):              Método que añade un elemento Chunk a un Paragraph.
     * scaleAbsolute(int, int): Método que le indica las dimensiones correspondientes a una Image.
     * getInstance(String):     Método que indica la ubicación del elemento a agregar en el documen-
     *                          to.
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  
     * 
     * Mayor información: http://codigoxules.org/en/java-itext-pdf-creando-pdf-java-itext/
     *
     */
        
//</editor-fold>

public class PDFGenerator {
    
    // Se crean las variables necesarias (Preferiblemente crear solamente Font)
    private Font fontBold = new Font(Font.FontFamily.COURIER, 8, Font.BOLD);
    private Font fontNormal = new Font(Font.FontFamily.COURIER, 6, Font.NORMAL);
    private Font fontItalic = new Font(Font.FontFamily.COURIER, 6, Font.ITALIC);
    
    private Font fontLittleBold = new Font(Font.FontFamily.COURIER, 4, Font.BOLD);
    private Font fontLittleNormal = new Font(Font.FontFamily.COURIER, 4, Font.NORMAL);
    
    // Método para agregar texto en el documento.
    private Paragraph setText(String txt, Font font, int element){
        
        // Se crean las variables necesarias.
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        
        // Se le indica la alineación del texto a agregar y su tipo de Fuente.
        p.setAlignment(element);
        c.append(txt);
        c.setFont(font);
        
        // Se añade el texto y retorna su valor.
        p.add(c);
        return p;
        
    }
    
    // Método para agregar imágenes al documento.
    private Image setImage(String path, int WIDTH, int HEIGHT, int element){
        
        // Se crean las variables necesarias.
        Image img = null;
        
        try {
            
            // Se obtiene la ruta de la imagen a agregar.
            img = Image.getInstance(path);
            
            // Se indican las dimensiones de la imagen a agregar.
            img.scaleAbsolute(WIDTH, HEIGHT);
            
            // Se indica la alineación que tendrá la imagen a agregar.
            img.setAlignment(element);
            
        } catch (Exception e) {
            
            // Si existe algún error en la creación del documento, se muestra en consola.
            System.out.print("Error: " + e);
            
        }
        
        // Retorna la imagen creada.
        return img;
        
    }
        
    // Método para crear el ticket de golosinas
    public void pdfCandyTicket(String name, String seller, String branch, 
                               String path, int id, ArrayList<String> product_names,
                               ArrayList<Integer> product_cants){
        
        // Se crea una variable con la fecha actual del sistema.
        Calendar fecha = new java.util.GregorianCalendar();
            
        // Se fragmentan los elementos de fecha.
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
            
        // Se crean las variables de tipo String con los datos de la fecha.
        String dma = "FECHA: " + dia + "/" + mes + "/" + año;
        String hms = "HORA: " + hora + ":" + minuto + ":" + segundo;
        
        try {
            
            // Se crea el documento con las dimensiones y márgenes indicados.
            Document doc = new Document(PageSize.B7, 14, 14, 8, 8);
            
            // Indica la ubicación en donde se guardará el documento.
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            
            // Se abre el documento para comenzar con su creación.
            doc.open();
            
            // Se añade la información
            doc.add(setText("SENIAT", fontLittleBold, Element.ALIGN_CENTER));
            doc.add(setImage("src/views/images/CDV-large.png", 59, 42, Element.ALIGN_CENTER));
            doc.add(setText(branch, fontNormal, Element.ALIGN_CENTER));
            doc.add(setText("Cliente: " + name, fontNormal, Element.ALIGN_LEFT));
            doc.add(setText("Vendedor: " + seller, fontNormal, Element.ALIGN_LEFT));
            doc.add(setText("NO FISCAL", fontNormal, Element.ALIGN_CENTER));
            doc.add(setText("NO FISCAL:    " + id, fontNormal, Element.ALIGN_JUSTIFIED_ALL));
            doc.add(setText(dma + "   " + hms, fontNormal, Element.ALIGN_JUSTIFIED_ALL));
            doc.add(Chunk.NEWLINE); // -> Línea en blanco.
                  
            // Se elabora un DottedLineSeparator con el propósito de dividir el documento con una línea
            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            
            // Sección que muestra los productos comprados con su cantidad.
            doc.add(dottedline);
            doc.add(setText("NO FISCAL", fontBold, Element.ALIGN_CENTER));
            for(int i = 0; i < product_names.size(); i++){
                String product = product_names.get(i) + " (x" + 
                                 product_cants.get(i) + ")"; 
                doc.add(setText(product, fontBold, Element.ALIGN_LEFT));
            }
            
            doc.add(Chunk.NEWLINE); // -> Línea en blanco.
            doc.add(dottedline);
            
            // Footer del documento.
            doc.add(setText("NO FISCAL", fontBold, Element.ALIGN_CENTER));
            
            // Se cierra la creación del documento.
            doc.close();
            
        } catch (Exception e) {
            
            // Si existe algún error en la creación del documento, se muestra en consola.
            System.out.print("Error: " + e);
            
        }
        
    }
    
}
