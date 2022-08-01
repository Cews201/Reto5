
package Controlador;

import Modelo.Conexion;
import Modelo.DatosModelDB;
import Modelo.DatosSucursalPuestoTrabajo;
import Modelo.PuestoTrabajo;
import Modelo.Sucursal;
import Vistas.AddUserForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControllerSucursalPuestoTrabajo implements ActionListener{
    private final AddUserForm view;
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<DatosSucursalPuestoTrabajo> list;
    DatosModelDB model = new DatosModelDB();
    
    public final void getListaSucursales(){
        list = model.getSucursales();
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                int idSucursal = list.get(i).getIdSucursal();
                String nombreSucursal = list.get(i).getNombreSucursal();
                view.cbSucursal.addItem(new Sucursal(idSucursal,nombreSucursal));
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se encontraron sucursales","",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public final void getPuestosTrabajo(int idSucursal){
        list = model.getPuestosTrabajo(idSucursal);
        if(list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                DefaultComboBoxModel model = (DefaultComboBoxModel)view.cbOcupacion.getModel();
                int idPuestoTrabajo =  list.get(i).getIdPuestoTrabajo();
                String nombrePuestoTrabajo = list.get(i).getNombrePuestoTrabajo();
                System.out.println(idPuestoTrabajo + "  "+nombrePuestoTrabajo);
                
                view.cbOcupacion.addItem(new PuestoTrabajo(idPuestoTrabajo, nombrePuestoTrabajo));
            }
        }   
        else{
            JOptionPane.showMessageDialog(null, "No se encontraron puestos de trabajo","",JOptionPane.ERROR_MESSAGE);
        }
                
    }
    public final void events(){
        view.cbSucursal.addActionListener(this);
    }

    public ControllerSucursalPuestoTrabajo(AddUserForm view) {
        this.view = view;
        this.getListaSucursales();
        Sucursal sucursal = (Sucursal)view.cbSucursal.getSelectedItem();
        getPuestosTrabajo(sucursal.getIdSucursal());
        events();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        if(evento.equals(view.cbSucursal)){
            view.cbOcupacion.removeAllItems();
            Sucursal sucursal = (Sucursal) view.cbSucursal.getSelectedItem();
            getPuestosTrabajo(sucursal.getIdSucursal());
            
        }
    }
    
    
    
}
