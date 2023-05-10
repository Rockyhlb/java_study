package code.hlb;

public class Truck extends Rent{
    public float truck_rent(int nums,float weight,int days){
        if (0 != nums){
            return nums*weight*days*100;
        }
        return 0;
    }

    public float car_rent(int nums,int days){return 0;}
}
