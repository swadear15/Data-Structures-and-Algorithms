
import java.io.File;
import processing.core.PImage;

public class SpaceStation {
	
	
	//private static int bgcolor;
	
	private static PImage background;
	
	
	private static Amogus[] players;
	private static int NUM_PLAYERS = 8;
	
	private static int impostorIndex;
	
	
	public static void setup() {
		//sprite = Utility.loadImage("images"+File.separator+"sprite1.png");
		background = Utility.loadImage("images"+File.separator+"background.jpeg");
		players = new Amogus[NUM_PLAYERS];
		players[0] = new Amogus(Utility.randGen.nextInt(3) + 1);
		impostorIndex = Utility.randGen.nextInt(NUM_PLAYERS) + 1;
		System.out.println("Imposter Index: " + impostorIndex);
	}
	
	public static void draw() {
		Utility.image(background, 600, 500);
		players[0].draw();
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				if (players[i].isImpostor()) {
					for (int j = 0; j < players.length; j++) {
						if (i != j) {
							if (players[j] != null) {
								if (overlap(players[i], players[j])) {
									players[j].unalive();
								}
							}
						}
					}
				}
			}
		}
			
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				players[i].draw();
			}
		}
		
		
		
	}
	
	public static void keyPressed() {
		int randColor;
		int xCordRNG;
		int yCordRNG;
		boolean isPoster;
		if (Utility.key() == 'a') {
			randColor = Utility.randGen.nextInt(3)+1;
			xCordRNG = Utility.randGen.nextInt(Utility.width());
			yCordRNG = Utility.randGen.nextInt(Utility.height());
			for (int i = 0; i < players.length; i++) {
				if (i == impostorIndex) {
					isPoster = true;
				}
				else {
					isPoster = false;
				}
				if (players[i] == null) {
					players[i] = new Amogus(randColor, xCordRNG, yCordRNG, isPoster);
					return;
				}
			}
		}
	}
	public static boolean isMouseOver(Amogus player) {
		float maxWidthPlayer = player.getX() + (player.image().width / 2);
		float minWidthPlayer = player.getX() - (player.image().width / 2);
		
		float maxHeightPlayer = player.getY() + (player.image().height / 2);
		float minHeightPlayer = player.getY() - (player.image().height / 2);
		
		if (Utility.mouseX() > minWidthPlayer && Utility.mouseX() < maxWidthPlayer) {
			if(Utility.mouseY() > minHeightPlayer && Utility.mouseY() < maxHeightPlayer) {
				return true;
			}
		}
		return false;
	}
	
	public static void mousePressed() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				if (isMouseOver(players[i])) {
					players[i].startDragging();
				}
			}
		}
	}
	
	public static void mouseReleased() {
		for (int i = 0; i < players.length; i++) {
				if (players[i] != null) {
					players[i].stopDragging();
				}
				
		}
	}
	
	public static boolean overlap(Amogus p1, Amogus p2) {
		float l1x = p1.getX() - (p1.image().width / 2);
		float l1y = p1.getY() - (p1.image().height / 2);
		float r1x = p1.getX() + (p1.image().width / 2);
		float r1y = p1.getY() + (p1.image().height / 2);
		
		float l2x = p2.getX() - (p2.image().width / 2);
		float l2y = p2.getY() - (p2.image().height / 2);
		float r2x = p2.getX() + (p2.image().width / 2);
		float r2y = p2.getY() + (p2.image().height / 2);
		
		 if (l1x == r1x || l1y == r1y || r2x == l2x || l2y == r2y) {
			 return false;
		 }
	           // If one rectangle is on left side of other
	     if (l1x > r2x || l2x > r1x) {
	    	 return false;
	     }
	 
	        // If one rectangle is above other
	     if (r1y < l2y || r2y < l1y) {
	    	 return false;
	     }
        return true;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utility.runApplication();
	}

}
