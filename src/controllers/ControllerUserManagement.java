
package controllers;
// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.User;
import models.database.UserCRUD;
import models.database.BranchCRUD;
import models.database.RoleCRUD;

// Se importan las views a utilizar.
import views.UserManagement;
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
 */

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import lib.SupportFunctions;
import models.User;
import models.database.BranchCRUD;
import models.database.UserCRUD;
import views.ChangeBranch;
import views.PopupMessage;
import views.UserManagement;

/**
 *
 * @author Marihec
 */
public class ControllerUserManagement{
    
    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private User us;
        // Models.database
        private UserCRUD usCRUD;
        private BranchCRUD braCRUD;
    
    // Views
    private UserManagement usManagement;
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
    
    // Variables para CRUD del Usuario.
    private String  email,
                    id,
                    role,
                    password;
    
    
    //</editor-fold>
    
    /**
     * Constructor del gestor de Usuarios.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.**/
    
     public ControllerUserManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        usManagement   = new UserManagement();
        support         = new SupportFunctions();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(usManagement.panContainerUser, usManagement.panConsultList);
        
        }
    
}

