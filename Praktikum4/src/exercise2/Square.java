package exercise2;

public class Square extends Rectangle{

	public Square() {
		super();
	}
	
	public Square(double side) {
		super(side, side);
	}
	
	public double getSide(){
		return getWidth();
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side);
		super.setColor(color);
		super.setFilled(filled);
	}
	
	public void setSide(double side) {
		super.setLength(side);
		super.setWidth(side);
	}
	
	@Override
	public void setWidth(double side) {
		super.setLength(side);
		super.setWidth(side);
	}
	
	@Override
	public void setLength(double side) {
		super.setLength(side);
		super.setWidth(side);
	}
	
	@Override
	public double getArea() {
		return getSide()*getSide();
	}
	
	@Override 
	public double getPerimeter() {
		return 4*getSide();
	}
	
	@Override
	public String toString() {
		return "A Square with side = " + getSide() + ", which is a subclass of " + super.toString();
	}
	
	@Override
	public String detail() {
		return "The square area is " +getArea() +" and the perimeter is " +getPerimeter();
	}
}
