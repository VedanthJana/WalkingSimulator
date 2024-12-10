
import java.util.Random;
import java.io.File;
import processing.core.PImage;

public class WalkingSim {
	
	private static Random randGen; // Random generator
    private static int bgColor; // Background color
    private static PImage[] frames; // Array for multiple animation frames
    private static Walker[] walkers; // Array for Walker objects
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Utility.runApplication(); // starts the application
		
	}
		
		public static void setup() {
	        
			 randGen = new Random(256); // Initialize the Random object
		     bgColor = randGen.nextInt(); // Generate a random integer for the background color
		  
		    // Initialize the frames array to the length specified by Walker.NUM_FRAMES
		     
		     frames = new PImage[Walker.NUM_FRAMES];

		   
		  // Load each frame image
		        for (int index = 0; index < frames.length; index++) {
		            frames[index] = Utility.loadImage("images" + File.separator + "walk-" + index + ".png");
		        }
		        
		     // Initialize the walkers array
		        walkers = new Walker[8]; // Create an array for 8 Walker objects
		        
		     // Generate a random number of walkers to add
		        int numWalkers = randGen.nextInt(walkers.length) + 1; // Random number between 1 and 8

		        // Remove the existing walker from the first index
		        walkers[0] = null;

		        // Add new walkers with random positions
		        for (int i = 0; i < numWalkers; i++) {
		            // Generate random coordinates
		            float x = randGen.nextFloat() * Utility.width(); // Random x position
		            float y = randGen.nextFloat() * Utility.height(); // Random y position
		            walkers[i] = new Walker(x, y); // Create a new Walker with random coordinates
		        }

	    }

	    public static void draw() {
	    	Utility.background(bgColor); // Set the background color
	    	
	    	// Draw all non-null walkers
	        for (Walker walker : walkers) {
	            if (walker != null) {
	                Utility.image(frames[walker.getCurrentFrame()], walker.getPositionX(), walker.getPositionY());
	            }
	        }
	    }
	}

