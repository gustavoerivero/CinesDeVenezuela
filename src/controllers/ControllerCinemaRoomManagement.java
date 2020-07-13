/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.CinemaRoom;
import models.database.CinemaRoomCRUD;

// Se importan las views a utilizar.
import views.CinemaRoomManagement;
import views.ChangeBranch;
import views.PopupMessage;
import views.SelectOption;
import views.tables.Table;

// Se importan las librerías a utilizar.
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *  Materia: Laboratorio I
 *  Sección: 1
 *      Integrantes:
 *          @author Brizuela, Yurisbellys   C.I: 27.142.239
 *          @author Miranda, Marihec        C.I: 26.120.075
 *          @author Montero, Michael        C.I: 26.561.077
 *          @author Rivero, Gustavo         C.I: 26.772.857
 *          @author Torrealba, Luis         C.I: 26.121.249
 **/

public class ControllerCinemaRoomManagement {
    
    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private CinemaRoom ciRoom;
    // Models.database
    private CinemaRoomCRUD ciRoomCRUD;
    
    // Views
    private CinemaRoomManagement ciRoomManagement;
    private ChangeBranch changeBranch;
    private PopupMessage popup;
    
    // Controllers
    private ControllerMainMenu contMainMenu;
    
    // Librerías de soporte
    private SupportFunctions support;
    
    // Variables del usuario.
    private String  rolUser,
                    nameUser,
                    branchUser;
    
    // Variables para CRUD del empleado.
    private String  id,
                    branch;
    
    private int   fila,
                  column;
    
                    
    
    //</editor-fold>
    
    /**
     * Constructor del gestor de sala.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    
    public ControllerCinemaRoomManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        ciRoomManagement   = new CinemaRoomManagement();
        support         = new SupportFunctions();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(ciRoomManagement .panContainerCinemaRoom, ciRoomManagement .panConsultList);
        
        }
    
    
}
