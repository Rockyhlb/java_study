package code.hlb;

public class Car extends Vehicles {

    int seats;        // 小汽车座位数

    public Car(){

    }

    public Car(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public double countFee(int days){
        double fee = 0;
        if (seats <= 5){
            fee = days*120;
        }
        else{
            fee = days*150;
        }
        return fee;
    }
}
