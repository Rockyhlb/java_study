package code.hlb;

public class Truck extends Vehicles {

    int weights;      // 卡车吨位

    public Truck(){
    }

    public Truck(int weights) {
        this.weights = weights;
    }

    public int getWeights() {
        return weights;
    }

    public void setWeights(int weights) {
        this.weights = weights;
    }

    @Override
    public double countFee(int days){
        double fee = 0;
        if (weights <= 5){
            fee = days*230;
        }
        else{
            fee = days*280;
        }
        return fee;
    }
}
