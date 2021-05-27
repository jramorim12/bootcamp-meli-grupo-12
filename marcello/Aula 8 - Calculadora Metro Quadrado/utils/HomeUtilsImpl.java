package br.com.marcello.ApiCasa.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class HomeUtilsImpl implements HomeUtils {

    public Map<String, Double> getRoomsArea(JSONObject homeJson) {

        Map<String, Double> roomMap = new HashMap<>();

        JSONArray roomsArray = (JSONArray) homeJson.get("rooms");
        for(int i=0; i < roomsArray.length(); i++) {
            JSONObject roomJson = roomsArray.getJSONObject(i);
            Double roomArea = this.getArea(roomJson.getDouble("width"), roomJson.getDouble("height"));
            roomMap.put(roomJson.getString("name"), roomArea);
        }

        return roomMap;

    }

    private Double getArea(Double width, Double height) {
        return width * height;
    }

    private List<Double> getAreaList(Map<String, Double> roomMap) {

        List<Double> areasList = new ArrayList<>();
        for(Map.Entry<String,Double> entry : roomMap.entrySet()) {
            areasList.add(entry.getValue());
        }

        return areasList;
    }

    private Double getHomeValue(Double totalArea) {
        return totalArea * 800;
    }

    private String getMaxRoom(Map<String, Double> roomMap) {

        List<Double> areaList = this.getAreaList(roomMap);
        String maxRoom = "";

        Double maxArea = areaList
                .stream()
                .max(Double::compareTo)
                .get();

        for(Map.Entry<String, Double> entry : roomMap.entrySet()) {
            if(entry.getValue().equals(maxArea))
                maxRoom = entry.getKey();
        }

        return maxRoom;

    }

    private Double getHomeArea(List<Double> areasList) {

        Double totalArea = areasList.stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        return totalArea;
    }

    @Override
    public JSONObject getFinalHomeJson(JSONObject homeJson) {

        Map<String, Double> roomMap = this.getRoomsArea(homeJson);
        List<Double> areasList = this.getAreaList(roomMap);
        Double totalArea = this.getHomeArea(areasList);
        String maxRoom = this.getMaxRoom(roomMap);

        JSONObject finalHomeJson = new JSONObject();
        JSONObject roomsJson = new JSONObject(roomMap);

        finalHomeJson.put("totalArea", totalArea)
                .put("homeValue", this.getHomeValue(totalArea))
                .put("maxRoom", maxRoom)
                .put("rooms", roomsJson);

        return finalHomeJson;

    }

}
