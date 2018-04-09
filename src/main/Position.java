package main;

public class Position {
	
	private static final int min = 15;
	
	private static final int max = 15;
	
	
	private int x;
	
	private int y;
	
	private String direction;
	
	
	public Position(int x, int y, String direction) throws InvalidPositionException{
		
		if(isValid(x,y)){
			
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
				
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	
	public void turnLeft(){
		
		switch(this.direction){
			
		case "North" : direction = "West";
		break;
		
		case "West" : direction = "South";
		break;
		
		case "South" : direction = "East";
		break;
		
		case "East" : direction = "North";
		break;
		
		}
		
	}
	
	
	public void turnRight(){
		
		switch(direction){
		
		case "North" : direction = "East";
		break;
		
		case "East" : direction = "South";
		break;
		
		case "South" : direction = "West";
		break;
		
		case "West" : direction = "North";
		
		
		}
		
	}
	
	public void moveForward() throws InvalidPositionException{
		
		switch(direction){
		
		case "North" :
			if(isValid(x, y + 1)){
				y++;
			}
		break;
		
		case "West" :
			if(isValid(x - 1, y)){
				x--;
			}
		break;
	
		case "South" :
			if(isValid(x, y - 1)){
				y--;
			}
		break;
		
		case "East" :
			if(isValid(x + 1, y)){
				x++;
			}
		}
	}
	
	public void moveBack() throws InvalidPositionException{
		
		switch(direction){
		
		case "North" :
			if(isValid(x, y - 1)){
				y--;
			}
		break;
		
		case "West" :
			if(isValid(x + 1, y)){
				x++;
			}
		break;
	
		case "South" :
			if(isValid(x, y + 1)){
				y++;
			}
		break;
		
		case "East" :
			if(isValid(x - 1, y)){
				x--;
			}
		}
	}
	
	private boolean isValid(int x, int y) throws InvalidPositionException{
		
		if(x < 1 || x > max || y < 1 || y > max){
			throw new InvalidPositionException("Invalid Position");
		}
		
		return true;
	}
	

}
