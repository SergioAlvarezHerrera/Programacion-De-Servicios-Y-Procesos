import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class VistaCarrera extends JFrame {
	
	private JLabel corredor1;
	private JLabel corredor2;
	private JTextArea resultado;
	public VistaCarrera() {
	
		JPanel pista = new JPanel();
		add(pista );
		pista.setLayout(null);
		pista.setVisible(true);
		
		
        resultado = new JTextArea();
        resultado.setEditable(false);  
        resultado.setBackground(Color.LIGHT_GRAY);
        resultado.setText("Esperando a que los corredores empiecen...");

       
        add(resultado, BorderLayout.SOUTH);


        corredor1 = new JLabel();
		corredor1.setIcon(new ImageIcon("Lib/uno.png"));
		corredor1.setBounds(10, 50, 100, 50);
		pista.add(corredor1);
		
		corredor2 = new JLabel();
		corredor2.setIcon(new ImageIcon("Lib/paul.png"));
		corredor2.setBounds(10, 300, 100, 50);
		pista.add(corredor2);		
		
		
		
		setVisible(true);
		setBackground(Color.black);
		setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	
	
	public void moverCorredor1(int x) {
	    corredor1.setLocation(x, corredor1.getY());
	    
	}

	public void moverCorredor2(int x) {
	    corredor2.setLocation(x, corredor2.getY());
	}

	public void mostrarResultado(String mensaje) {
	    resultado.setText(mensaje);
	    repaint();  
	}
	
	
	public static void main(String[] args) {
		VistaCarrera vistaCarrera = new VistaCarrera();

	    
	    Corredor corredor1 = new Corredor(10, 50, 400, true, vistaCarrera);
	    Corredor corredor2 = new Corredor(10, 100, 400, true, vistaCarrera);
	    
	    
	    Thread hiloCorredor1 = new Thread(corredor1, "corredor1");
	    Thread hiloCorredor2 = new Thread(corredor2, "corredor2");
	    
	   
	    hiloCorredor1.start();
	    hiloCorredor2.start();
	}
	
	
}
