


import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;


public class mmn11_q2Controller {
		
		private final int NUM_OF_SHAPES = 10;
		
		@FXML
	    private Button btn;

	    @FXML
	    private Canvas canv;
	    
	    private GraphicsContext gc;
	    
	    
	    @FXML
	    public void initialize() {
	    	gc = canv.getGraphicsContext2D();
	    }
	    
	    	

	    @FXML
	    void btnPressed(ActionEvent event) {
	    	/* canvas size */
	    	int WIDTH = (int) canv.getWidth();
	    	int HIGHT = (int) canv.getHeight();
	    	
	    	Random rnd = new Random();
	    	int j;
	    	
	    	/* clear the canvas before pressing */ 
	    	gc.clearRect(0, 0, WIDTH,HIGHT);
	    	/* loop for generating 10 random shapes */
	    	for(int i = 0; i < NUM_OF_SHAPES; i++) {
	    		gc.setFill(Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));
	    		gc.setStroke(Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));
	    		
	    		j = rnd.nextInt(3);
	    		if (j == 0) 	    			
	    	    	gc.fillRect( rnd.nextInt(WIDTH), rnd.nextInt(HIGHT), rnd.nextInt(WIDTH/4), rnd.nextInt(HIGHT/4));	    		
	    		else if (j == 1) 
	    	    	gc.fillOval(rnd.nextInt(WIDTH), rnd.nextInt(HIGHT),rnd.nextInt(WIDTH/4),rnd.nextInt(HIGHT/4));
	    		
	    		else 	    			
	    			gc.strokeLine(rnd.nextInt(WIDTH), rnd.nextInt(HIGHT),rnd.nextInt(WIDTH/4),rnd.nextInt(HIGHT/4));
	    			
    		}
	    		
    	}

	}
