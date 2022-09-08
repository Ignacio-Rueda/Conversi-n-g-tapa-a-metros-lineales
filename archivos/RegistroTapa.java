import javax.swing.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
public class RegistroTapa {
   public static void main(String[] args) {
   		ArrayList<CaracteristicasTapa> almacen = new ArrayList<CaracteristicasTapa>();
   		
      JTextField xField = new JTextField(30);//nombre cliente
      JTextField yField = new JTextField(5);//lote
      JTextField zField = new JTextField(5);//peso
      JTextField wField = new JTextField(20);//incidencia

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("NOMBRE CLIENTE:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("LOTE:"));
      myPanel.add(yField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("PESO(G):"));
      myPanel.add(zField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("INCIDENCIA:"));
      myPanel.add(wField);
      wField.setText("PLIEGUES");

			int result = 0;
			
		while(result==0){
		try{
      result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Introduce nombre,lote,peso en gramos e incidencia", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
      		
      almacen.add(new CaracteristicasTapa(xField.getText(),yField.getText(),Double.parseDouble(zField.getText()),wField.getText()));
      xField.setText("");
      yField.setText("");
      zField.setText("");
      wField.setText("PLIEGUES");
      }
      }
      catch (Exception e){
      JOptionPane.showMessageDialog(null, "LOS VALORES INTRODUCIDOS NO SON VÁLIDOS", "PEDIDOS LIMPIEZA", 0);
      }
     }
     //DATOS A FICHERO TEXTO
    
     try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("INCIDENCIA.txt"));
					for(int n = 0;n<almacen.size();n++){
						bw.write(n+1+")"+almacen.get(n).getNombreCliente()+"L:"+almacen.get(n).getLote()+almacen.get(n).getMetros()+almacen.get(n).getIncidencia()+"\n");
					}
					String separacion = (" ");
					bw.write(separacion.repeat(60)+"TOTAL: "+CaracteristicasTapa.getMetrosTotales()+"mL~");
					
				
					bw.close();
			} catch (IOException ioe) {
			System.out.println("No se ha podido escribir en el fichero");
			}


     
   }
}

