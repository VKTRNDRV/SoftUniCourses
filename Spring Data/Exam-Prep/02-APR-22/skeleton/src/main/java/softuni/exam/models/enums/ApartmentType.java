package softuni.exam.models.enums;

public enum ApartmentType {
    two_rooms,
    three_rooms,
    four_rooms;

    public static boolean contains(String str){
        for(ApartmentType apartmentType : ApartmentType.values()){
            if(apartmentType.toString().equals(str)){
                return true;
            }
        }
        return false;
    }
}
