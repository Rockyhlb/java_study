package code.hlb;

public class TuoLaJi extends Vehicles {

    float discharge;  // 拖拉机排放量

    public TuoLaJi() {
    }

    public TuoLaJi(float discharge) {
        this.discharge = discharge;
    }

    public float getDischarge() {
        return discharge;
    }

    public void setDischarge(float discharge) {
        this.discharge = discharge;
    }

    @Override
    public double countFee(int days){
        double fee = 0;
        if (discharge <= 1.5){
            fee = days*180;
        }
        else{
            fee = days*220;
        }
        return fee;
    }
}
