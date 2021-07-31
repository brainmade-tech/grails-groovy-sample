package uberall

import grails.rest.RestfulController
import helper.CsvRenderer

/**
 * @author Yassine Chaoui
 * */
class LocationController extends RestfulController<models.Location> {

    def locationService

    LocationController() {
        super(models.Location)
    }

    def index() {
        withFormat {
            json { respond locationService.getLocations() }
            csv { render contentType:'text/csv',CsvRenderer.render(locationService.getLocations()) }
            //other content types here
        }
    }

}
