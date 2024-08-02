package basic_project.core.singleton;

public class StatefulService {

    // 상태를 유지하는 필드
//    private int price;

    public int order(String name, int price){
        System.out.println("name = " +name + " price = " + price);
//        this.price = price; // 여기서 문제 발생
        return price;
    }


}
