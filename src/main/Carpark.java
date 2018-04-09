package main;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Carpark {
	
		
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the input in the format x,y:XXXXXXX");
		
		String input = in.nextLine();
		
		String pattern = "(\\d+),(\\d+):[lLrRfF]+";
		
		if(!Pattern.matches(pattern, input)){
			
			System.out.println("Invalid inputs");
		}
		
		else{
		
			String[] firstSplit = input.split(":");
			
			String position = firstSplit[0];
			String command = firstSplit[1];
			
			String[] secondSplit = position.split(",");
			
			int x = Integer.parseInt(secondSplit[0]);
			int y = Integer.parseInt(secondSplit[1]);
			
			Position newPosition = new Carpark().findPosition(x,y, command);
			
			System.out.println("New Position ---->"+ newPosition.getX()+","+newPosition.getY());
		}
		
	}
	
	// Method to create a new position based on the initial input
	// and move as per the input. 
	
	public Position findPosition(int x, int y, String command){
		
		Position position = null;
		
		try{
			position = new Position(x, y, "North");
		
		
			for(int i = 0; i < command.length(); i++){
				
				switch(command.toUpperCase().charAt(i)){
				
				case 'L' : position.turnLeft();
				break;
				
				case 'R' : position.turnRight();
				break;
				
				case 'F' : position.moveForward();

				}
			}
			
			
		}
		catch(InvalidPositionException ex){
			System.out.println(ex.getMessage());
		}
		
		
		return position;
	}
	
}