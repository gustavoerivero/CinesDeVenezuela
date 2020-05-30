
package lib;

// Se importan las librerías necesarias
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.util.Calendar;

/**
 *
 * @author Gustavo
 */
public class PDFGenerator {
    
    // Se crean las variables necesarias (Preferiblemente crear solamente Font)
    private Font fontBold = new Font(Font.FontFamily.COURIER, 8, Font.BOLD);
    private Font fontNormal = new Font(Font.FontFamily.COURIER, 6, Font.NORMAL);
    private Font fontItalic = new Font(Font.FontFamily.COURIER, 6, Font.ITALIC);
    
    private Font fontLittleBold = new Font(Font.FontFamily.COURIER, 4, Font.BOLD);
    private Font fontLittleNormal = new Font(Font.FontFamily.COURIER, 4, Font.NORMAL);
    
    // Método para agregar texto
    private Paragraph setText(String txt, Font font, int element){
        
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(element);
        c.append(txt);
        c.setFont(font);
        p.add(c);
        return p;
        
    }
    
    // Método para agregar imágenes
    private Image setImage(String path, int WIDTH, int HEIGHT, int element){
        
        Image img = null;
        
        try {
            img = Image.getInstance(path);
            img.scaleAbsolute(WIDTH, HEIGHT);
            img.setAlignment(element);
            
        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
        
        return img;
        
    }
        
    // Método para crear el ticket de golosinas
    public void pdfCandyTicket(String name, String seller, String branch, 
                               String path, int id, String product){
        
        try {
            
            Document doc = new Document(PageSize.B7, 14, 14, 8, 8);
            
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            
            doc.open();
            
            doc.add(setText("SENIAT", fontLittleBold, Element.ALIGN_CENTER));
                        
            doc.add(setImage("src/views/images/CDV-large.png", 59, 42, Element.ALIGN_CENTER));
            
            doc.add(setText(branch, fontNormal, Element.ALIGN_CENTER));
            
            doc.add(setText("Cliente: " + name, fontNormal, Element.ALIGN_LEFT));
            
            doc.add(setText("Vendedor: " + seller, fontNormal, Element.ALIGN_LEFT));
            
            doc.add(setText("NO FISCAL", fontNormal, Element.ALIGN_CENTER));
            
            doc.add(setText("NO FISCAL:    " + id, fontNormal, Element.ALIGN_JUSTIFIED_ALL));
            
            Calendar fecha = new java.util.GregorianCalendar();
            
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            int segundo = fecha.get(Calendar.SECOND);
            
            String dma = "FECHA: " + dia + "/" + mes + "/" + año;
            String hms = "HORA: " + hora + ":" + minuto + ":" + segundo;
                    
            doc.add(setText(dma + "   " + hms, fontNormal, Element.ALIGN_JUSTIFIED_ALL));
                        
            doc.add(setText("_____________________________________________________________", fontNormal, Element.ALIGN_CENTER));
            
            doc.add(setText("NO FISCAL", fontBold, Element.ALIGN_CENTER));
            
            doc.add(setText(product, fontBold, Element.ALIGN_LEFT));
            
            doc.add(setText("_____________________________________________________________", fontNormal, Element.ALIGN_CENTER));
            
            doc.add(setText("NO FISCAL", fontBold, Element.ALIGN_CENTER));
            
            doc.close();
            
        } catch (Exception e) {
            
            System.out.print("Error: " + e);
            
        }
        
    }
    
}
