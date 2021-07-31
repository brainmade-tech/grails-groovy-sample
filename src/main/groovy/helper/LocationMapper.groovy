package helper

import models.Location

/**
 * This class maps JSON argument to Location model
 *
 * @author Yassine Chaoui
 * */
class LocationMapper {

    static def mapToLocationList(jsonArray) {
        def locations = []
        for (jsonObject in jsonArray)
            locations.add(mapToLocation(jsonObject))
        locations
    }

    static def mapToLocation(jsonObject) {
        def keys = ["name", "city", "zip", "streetAndNumber", "openingHours", "keywords", "lat", "lng"]
        def params = [:]
        keys.each {params.put("$it",jsonObject["$it"])}
        new Location(params)
    }
}
