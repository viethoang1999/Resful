package solid;
//giả tỷ như Travel bây giờ là tàu thì phải vào code rồi sửa ==> bất tiện, sau này dự án to,
// sửa sửa thì không thể nào chấp nhận được
//Trong trường hợp này sử dụng interface chung là cách giải quyết tốt nhất
public class Travel {
//    Car car = new Car();
//
//    void startJourney() {
//        car.move();
//    }

    Vehicle vehicle;

    public Travel(Car car) { // đây chính là dependency inversion, đảo ngược sự phụ thuộc
        this.vehicle = vehicle;
    }

    public void run() {
        this.vehicle.move();
    }
}
