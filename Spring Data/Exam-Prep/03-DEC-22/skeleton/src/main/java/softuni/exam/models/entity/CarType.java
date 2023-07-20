package softuni.exam.models.entity;

public enum CarType {
    SUV,
    coupe,
    sport;

    public static boolean contains(String str){
        for(CarType carType : CarType.values()){
            if(carType.toString().equals(str)){
                return true;
            }
        }
        return false;
    }
}
