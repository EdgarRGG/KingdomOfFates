package ui;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Clase que crea la ventana de JFrame y el Canvas para pintar por pantalla.
 * @author Edgar Rubio
 *
 */

public class DisplayScreen {

    private JFrame frame;
    private Canvas canvas;
    private Image icon;

    private String title;
    private int width, height;

    public DisplayScreen(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        try {
			icon = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setIconImage(icon);
        frame.setUndecorated(true);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setBackground(Color.black); 
      
        //canvas será lo que pinte en la pantalla
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        canvas.setBackground(Color.black);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }

}
