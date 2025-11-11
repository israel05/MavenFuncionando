package org.israeldelamo;
/*
Put header here


 */

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import org.israeldelamo.bbdd.ConexionBD;


import javafx.scene.control.Alert;


import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FXMLController implements Initializable {
    
    @FXML
    private Label lblOut;
    
    @FXML
    private void btnClickVacio() {

        try {

            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/informes/informe.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, new JREmptyDataSource());
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ha ocurrido un error");
            alert.showAndWait();
            e.printStackTrace();
        }
       
    }



     @FXML
    private void btnClickMaria() throws SQLException, JRException, IOException {
        
    /**
     * Lanza un Jasper Reports a partir de su nombre sin extensión y teniendo alojado en resources>informes
     * arroja errores de tipo Alert según el try de IO, SQL o Jasper
     *
     * @param elInformeALanzar el nombre del informe a lanzar pero sin extensión y ubicado en la carpeta informes de resources
     */

 
        try {
            //abrimos la base de datos
            ConexionBD conexion = new ConexionBD();
           
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/informes/Cherry.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, new ConexionBD().getConexion());
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ha ocurrido un error");
            alert.showAndWait();
            e.printStackTrace();
        }
       
    }


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
