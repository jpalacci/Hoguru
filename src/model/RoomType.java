package model;

import java.util.LinkedList;
import java.util.List;

public class RoomType {
	
	private String hotelName;
	private String description;
	private String type;
	private double cost;
	
	public RoomType(String hotelName , String description , String type , double cost) {
		this.hotelName = hotelName;
		this.description = description;
		this.type = type;
		this.cost = cost;
	}
	
	public double getCost() {
		return cost;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static List<String> getRoomTypes(String hotelName){
		DataBaseFacade db = DataBaseFacade.getInstance();
		List<RoomType> list =  db.getRoomTypesFromHotel(hotelName);
		if(db == null) return null;
		List<String> result = new LinkedList<>();
		for(RoomType rt : list){
			result.add(rt.type);
		}
		return result;
	}

	public boolean addRoomType(){
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.addRoomType(this);
	}
	
	
	
	

}
