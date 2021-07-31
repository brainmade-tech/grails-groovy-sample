package helper
/**
 * @author Yassine Chaoui
 * */
class CsvRenderer {

    static def render(locations) {
        def response = ""
        def header = ["name", "city", "zip", "streetAndNumber", "keywords", "lat", "lng", "openingHours"]
        response += header.join(",") + "\n" // writes CSV header
        for (location in locations) {
            response += format(location) + "\n" // writes CSV body
        }
        response
    }

    // formats Location model to CSV
    static def format(location) {
        def _location = [location["name"], location["city"], location["zip"], location["streetAndNumber"],
                   location["keywords"], location["lat"], location["lng"]]
        def openingHours = []
        for (l in location["openingHours"]) {
            // day format is "dayOfWeek-from1-to1" as "1-08:00-20:00"
            openingHours.add(l["dayOfWeek"] + "-" + l["from1"] + "-" + l["to1"])
        }
        _location.add(openingHours.join("|")) // adds formatted openingHours
        _location.join(",") // returns location with comma separator
    }

}
