package shape;

public class Square extends Rectangle{
    public Square(){
    }
    public Square(double side){
        super(side,side);
    }
    public Square(double side, String color, boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){
        return getWidth();
    }

    @Override
    public String toString() {
        return "A square with side = "
                +getSide()
                +", which a subclass of "
                + super.toString();
    }
    @Override
    public Square resize(double percent) {
        double newSide = this.getSide() + this.getSide()*percent/100;
        return new Square(newSide);
    }
}

