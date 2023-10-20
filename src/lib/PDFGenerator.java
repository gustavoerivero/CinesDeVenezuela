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
/**
 * - - - - - - - - - - - - - - - - - - - - VARIABLES - - - - - - - - - - - - - -
 * - - - - - - - -
 *
 * Chunk: El la parte más pequeña que se puede añadir a un documento, la mayor
 * parte de los elementos se pueden dividir en varios Chunks y básicamente es un
 * String con una fuente determinada. Image: Representación gráfica de imágenes
 * podemos utilizar: JPEG, PNG o GIF. Paragraph: Es una serie de chunks.
 * Chapter: Se usa para añadir una sección especial al documento.
 * DottedLineSeparator: Dibuja una línea de puntos de izquierda a derecha. List:
 * Utilizado para representar listas en el documento. PdfPTable: Es un elemento
 * que nos permite crear una tabla cuya posición pue- de ser absoluta pero que
 * también se puede añadir directamente al documento. Font: Representa el tipo
 * de fuente a utilizar. Element: Indica el tipo de elemento.
 *
 * - - - - - - - - - - - - - - - - - - - - - - MÉTODOS - - - - - - - - - - - - -
 * - - - - - - - -
 *
 * open(): Para poder crear el documento, se debe implementar el método open().
 * close(): Para culminar la creación del documento, se debe implementar el
 * método close(). setAlignment(int): Método que le indica la alineación
 * correspondiente al elemento. setFont(Font): Método que indica el formato de
 * la fuente del elemento. append(String): Método que añade un elemento a un
 * Chunk. add(Chunk): Método que añade un elemento Chunk a un Paragraph.
 * scaleAbsolute(int, int): Método que le indica las dimensiones
 * correspondientes a una Image. getInstance(String): Método que indica la
 * ubicación del elemento a agregar en el documen- to. - - - - - - - - - - - - -
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 *
 * Mayor información:
 * http://codigoxules.org/en/java-itext-pdf-creando-pdf-java-itext/
 *
 * @version iText 5.0.5
 * @author Gustavo
 */
//</editor-fold>
/**
 * Clase generadora de PDFs.
 */
public class PDFGenerator {

    // Se crean las variables necesarias (Preferiblemente crear solamente Font)
    private Font fontBold = new Font(Font.FontFamily.COURIER, 8, Font.BOLD);
    private Font fontNormal = new Font(Font.FontFamily.COURIER, 6, Font.NORMAL);
    private Font fontItalic = new Font(Font.FontFamily.COURIER, 6, Font.ITALIC);

    private Font fontLittleBold = new Font(Font.FontFamily.COURIER, 4, Font.BOLD);
    private Font fontLittleNormal = new Font(Font.FontFamily.COURIER, 4, Font.NORMAL);

    /**
     * Método para agregar textos en forma de Paragraph.
     *
     * @param txt texto que se desea incorporar.
     * @param font tipo de fuente a utilizar.
     * @param element alineación que se le quiere dar al texto.
     * @return variable de tipo Paragraph con el formado indicado.
     */
    private Paragraph setText(String txt, Font font, int element) {

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

    /**
     * Método para agregar imágenes al documento.
     *
     * @param path Ruta de la imagen que se va a incorporar.
     * @param WIDTH Ancho de la imagen.
     * @param HEIGHT Alto de la imagen.
     * @param element Alineación en el documento.
     * @return variable de tipo Image con el formato indicado.
     */
    private Image setImage(String path, int WIDTH, int HEIGHT, int element) {

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

    /**
     * Método para crear un PDF con formato de ticket de golosinas.
     *
     * @param name Nombre que se dará al documento.
     * @param seller Nombre del vendedor.
     * @param branch Nombre de la sucursal.
     * @param path Ruta en donde se va a guardar el documento.
     * @param id Código del ticket.
     * @param product_names Listado de las golosinas compradas.
     * @param product_cants Listado de la cantidad de golosinas compradas.
     */
    public void pdfCandyTicket(String name, String seller, String branch,
            String path, int id, ArrayList<String> product_names,
            ArrayList<Integer> product_cants) {

        // Se crea una variable con la fecha actual del sistema.
        Calendar fecha = new java.util.GregorianCalendar();

        // Se fragmentan los elementos de fecha.
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1; // Se suma un valor puesto que el mes es un vector que inicia en '0'
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
            PdfWriter.getInstance(doc, new FileOutputStream(path + "-Ticket.pdf"));

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
            for (int i = 0; i < product_names.size(); i++) {
                String product = product_names.get(i) + " (x"
                        + product_cants.get(i) + ")";
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

    /**
     * Método para crear un PDF con formato de ticket de golosinas.
     *
     * @param name Nombre que se dará al documento.
     * @param seller Nombre del vendedor.
     * @param branch Nombre de la sucursal.
     * @param path Ruta en donde se va a guardar el documento.
     * @param id Código del ticket.
     * @param seats Listado de asientos.
     * @param product_cants Listado de la cantidad de asientos.
     */
    public void pdfMovieTicket(String name, String seller, String branch,
            String movie, String sala, String hour,
            String path, int id, ArrayList<String> product_names,
            ArrayList<Integer> product_cants) {

        // Se crea una variable con la fecha actual del sistema.
        Calendar fecha = new java.util.GregorianCalendar();

        // Se fragmentan los elementos de fecha.
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1; // Se suma un valor puesto que el mes es un vector que inicia en '0'
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
            PdfWriter.getInstance(doc, new FileOutputStream(path + "-Boleto.pdf"));

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
            
            doc.add(setText(movie, fontBold, Element.ALIGN_CENTER));
            doc.add(setText(sala + "   " + hour, fontLittleBold, Element.ALIGN_JUSTIFIED_ALL));
            
            for (int i = 0; i < product_names.size(); i++) {
                String product = product_names.get(i) + " (x"
                        + product_cants.get(i) + ")";
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

    /**
     * Método para crear documentos PDFs con formato para facturas.
     *
     * @param data_enterprise Información sobre la empresa.
     * @param data_seller Información sobre el vendedor.
     * @param data_client Información sobre el cliente.
     * @param id_ticket Código del/de los ticket/s.
     * @param type_ticket Tipo de factura ('1' para golosinas. '2' para
     * funciones).
     * @param id_invoice Código de la factura.
     * @param product_names Listado de los productos.
     * @param product_cants Listado de la cantidad de productos.
     * @param product_amounts Listado de los montos a pagar de los productos.
     * @param path Ruta en donde se va a guardar el documento.
     */
    public void pdfInvoice(ArrayList<String> data_enterprise, ArrayList<String> data_seller,
            ArrayList<String> data_client, ArrayList<String> id_ticket,
            char type_ticket, String id_invoice, ArrayList<String> product_names,
            ArrayList<Integer> product_cants, ArrayList<Double> product_amounts,
            String path) {

        // Se crea una variable con la fecha actual del sistema.
        Calendar fecha = new java.util.GregorianCalendar();

        // Se fragmentan los elementos de fecha.
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1; // Se suma un valor puesto que el mes es un vector que inicia en '0'
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
            PdfWriter.getInstance(doc, new FileOutputStream(path + "-Invoice.pdf"));

            // Se abre el documento para comenzar con su creación.
            doc.open();

            // Se añade la información.
            doc.add(setText("SENIAT", fontLittleBold, Element.ALIGN_CENTER));

            // Se indica el id de la Empresa.
            doc.add(setText(data_enterprise.get(0), fontLittleBold, Element.ALIGN_CENTER));

            // Se añaden los demás datos de la Sucursal
            for (int i = 1; i < data_enterprise.size(); i++) {
                doc.add(setText(data_enterprise.get(i), fontLittleNormal, Element.ALIGN_CENTER));
            }

            // Se añaden los datos del vendedor.
            for (int i = 0; i < data_seller.size(); i++) {
                doc.add(setText(data_seller.get(i), fontLittleNormal, Element.ALIGN_LEFT));
            }

            // Se añaden los datos del cliente.
            for (int i = 0; i < data_client.size(); i++) {
                doc.add(setText(data_client.get(i), fontLittleNormal, Element.ALIGN_LEFT));
            }

            // Si el ticket es de tipo '1' se imprime una factura de golosinas.
            if (type_ticket == '1') {
                doc.add(setText("Ticket de golosinas N°: " + id_ticket.get(0), fontLittleNormal, Element.ALIGN_LEFT));
            } // Si el ticket es de tipo '2' se imprime una factura de funciones
            else {
                doc.add(setText("Ticket de funciones", fontLittleNormal, Element.ALIGN_LEFT));
            }

            // Se añaden los datos de factura y del momento en el que se hizo el pago
            doc.add(setText("FACTURA", fontLittleNormal, Element.ALIGN_CENTER));
            doc.add(setText("FACTURA:    " + id_invoice, fontLittleNormal, Element.ALIGN_JUSTIFIED_ALL));
            doc.add(setText(dma + "   " + hms, fontLittleNormal, Element.ALIGN_JUSTIFIED_ALL));

            doc.add(Chunk.NEWLINE); // -> Línea en blanco.

            // Se elabora un DottedLineSeparator con el propósito de dividir el documento con una línea
            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);

            // Sección que muestra los productos comprados con su cantidad.
            doc.add(dottedline);

            // Se crean variables para mostrar montos.
            double amount = 0, amount_ajust = 0, total = 0;

            // Si el ticket es de tipo '1' se muestra el detalle de las golosinas compradas.
            if (type_ticket == '1') {

                // Se inicia un ciclo para mostrar todas las golosinas compradas.
                for (int i = 0; i < product_names.size(); i++) {

                    // Se hace el cálculo de precio por cantidad del producto.
                    amount = product_amounts.get(i) * product_cants.get(i);

                    // Se ajusta el monto para que muestre solo dos decimales.
                    amount_ajust = Math.round(amount * Math.pow(10, 2)) / Math.pow(10, 2);

                    // Se acumula el monto.
                    total += amount_ajust;

                    // Se crea la variable String a mostrar.
                    String product = product_names.get(i) + " (x" + product_cants.get(i) + ") Bs "
                            + String.valueOf(amount_ajust);

                    // Se muestra la variable String.
                    doc.add(setText(product, fontLittleNormal, Element.ALIGN_LEFT));

                }
            } // Si el ticket es de tipo '2' se muestra el detalle de los tickets de funciones comprados.
            else {

                // Se inicia un ciclo para mostrar los tickets de funciones comprados.
                for (int i = 0; i < product_names.size(); i++) {

                    // Se obtiene el monto del ticket.
                    amount = product_amounts.get(i);

                    // Se ajusta el monto para que muestre solo dos decimales.
                    amount_ajust = Math.round(amount * Math.pow(10, 2)) / Math.pow(10, 2);

                    // Se acumula el monto.
                    total += amount_ajust;

                    // Se crea la variable String a mostrar.
                    String product = product_names.get(i) + " " + id_ticket.get(i)
                            + " Bs " + String.valueOf(amount_ajust);

                    // Se muestra la variable String.
                    doc.add(setText(product, fontLittleNormal, Element.ALIGN_LEFT));

                }

            }

            doc.add(Chunk.NEWLINE); // -> Línea en blanco.
            doc.add(dottedline);

            // Footer del documento.
            doc.add(setText("TOTAL: Bs" + String.valueOf(total), fontLittleBold, Element.ALIGN_JUSTIFIED_ALL));

            // Se cierra la creación del documento.
            doc.close();

        } catch (Exception e) {

            // Si existe algún error en la creación del documento, se muestra en consola.
            System.out.print("Error: " + e);

        }

    }

}
