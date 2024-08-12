package mmn15_q2;

import java.util.Random;

import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mmn15_q2Controller {
	private Sticks sticks = new Sticks();
	

	@FXML
	public void initialize() {
		for (int i = 0; i < 5; i++) {// creating 5 threads - philosophers
			int philNum = i;
			Thread phil = new Thread(() -> philAction(philNum)); // assigning the threads specific function
			phil.start();
		}

	}
	/* this method is the work each thread is executing */
	private void philAction(int philNum) {

		while (true) {
			think();
			int firstStick = getMinStick(philNum);
			int secondStick = getMaxStick(philNum);
			sticks.takeStick(firstStick);
			sticks.takeStick(secondStick);
			eat(philNum);
			sticks.releaseStick(firstStick, secondStick);
		}
	}

	/* think is a method for sleeping random time between 0 to 5 seconds */
	private void think() {
		Random rand = new Random();
		try {
			Thread.sleep(rand.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/* eat change the GUI in a way the whom that's eating will have 2 sticks next to him replacing 2 sticks from the center */
	private void eat(int philNum) {

		Random rand = new Random();
		boolean showStick = true;
		switch (philNum) {
		// taking the stick from the center and placing them next to the philosopher 
		case 0:
			Platform.runLater(() -> {
				stick1.setVisible(!showStick);
				stick2.setVisible(!showStick);
				phil1RightStick.setVisible(showStick);
				phil1LeftStick.setVisible(showStick);
			});
			break;
		case 1:
			Platform.runLater(() -> {
				stick2.setVisible(!showStick);
				stick3.setVisible(!showStick);
				phil2RightStick.setVisible(showStick);
				phil2LeftStick.setVisible(showStick);
			});
			break;
		case 2:
			Platform.runLater(() -> {
				stick3.setVisible(!showStick);
				stick4.setVisible(!showStick);
				phil3RightStick.setVisible(showStick);
				phil3LeftStick.setVisible(showStick);
			});
			break;
		case 3:
			Platform.runLater(() -> {
				stick4.setVisible(!showStick);
				stick5.setVisible(!showStick);
				phil4RightStick.setVisible(showStick);
				phil4LeftStick.setVisible(showStick);
			});
			break;
		case 4:
			Platform.runLater(() -> {
				stick5.setVisible(!showStick);
				stick1.setVisible(!showStick);
				phil5RightStick.setVisible(showStick);
				phil5LeftStick.setVisible(showStick);
			});
			break;
		default:
			;

		}
		// eating - sleeping for random time
		try {
			Thread.sleep(rand.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// returning the sticks from the philosopher to the center 
		switch (philNum) {

		case 0:
			Platform.runLater(() -> {

				stick1.setVisible(showStick);
				stick2.setVisible(showStick);
				phil1RightStick.setVisible(!showStick);
				phil1LeftStick.setVisible(!showStick);
			});

			break;
		case 1:
			Platform.runLater(() -> {
				stick2.setVisible(showStick);
				stick3.setVisible(showStick);
				phil2RightStick.setVisible(!showStick);
				phil2LeftStick.setVisible(!showStick);
			});
			break;
		case 2:
			Platform.runLater(() -> {
				stick3.setVisible(showStick);
				stick4.setVisible(showStick);
				phil3RightStick.setVisible(!showStick);
				phil3LeftStick.setVisible(!showStick);
			});
			break;
		case 3:
			Platform.runLater(() -> {
				stick4.setVisible(showStick);
				stick5.setVisible(showStick);
				phil4RightStick.setVisible(!showStick);
				phil4LeftStick.setVisible(!showStick);
			});
			break;
		case 4:
			Platform.runLater(() -> {
				stick5.setVisible(showStick);
				stick1.setVisible(showStick);
				phil5RightStick.setVisible(!showStick);
				phil5LeftStick.setVisible(!showStick);
			});
			break;
		default:
			;

		}
		// to make the returned sticks observable on the GUI added 1 sec sleep
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int getMaxStick(int philNum) {
		return Math.max(philNum, (philNum + 1) % 5);
	}

	private int getMinStick(int philNum) {
		return Math.min(philNum, (philNum + 1) % 5);

	}

	@FXML
	private ImageView stick1;

	@FXML
	private ImageView stick2;

	@FXML
	private ImageView stick3;

	@FXML
	private ImageView stick4;

	@FXML
	private ImageView stick5;

	@FXML
	private ImageView phil2RightStick;

	@FXML
	private ImageView phil2LeftStick;

	@FXML
	private ImageView phil3RightStick;

	@FXML
	private ImageView phil3LeftStick;

	@FXML
	private ImageView phil4RightStick;

	@FXML
	private ImageView phil4LeftStick;

	@FXML
	private ImageView phil5RightStick;

	@FXML
	private ImageView phil5LeftStick;

	@FXML
	private ImageView phil1RightStick;

	@FXML
	private ImageView phil1LeftStick;
	
	
	

}
