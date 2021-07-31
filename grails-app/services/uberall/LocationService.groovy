package uberall

import helper.LocationMapper

/**
 * @author Yassine Chaoui
 * */
class LocationService {

    def dataSourceService

    def getLocations() {
        def json = dataSourceService.getJSONResponse()
        // Extracts location array from json response and passes it as argument
        return LocationMapper.mapToLocationList(json["response"]["locations"])
    }
}
