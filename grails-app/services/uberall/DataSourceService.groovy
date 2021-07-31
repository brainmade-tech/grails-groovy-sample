package uberall

import groovy.json.JsonSlurper
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient

/**
 * @author Yassine Chaoui
 * */
class DataSourceService {

    def host = "https://sandbox.uberall.com"
    def endpoint = '/api/locations?max=100'
    def tokenKey = "privateKey"
    def tokenValue = "aGQZ9qMJmh2QOWGmuNw0RhZvPcN4Lmt4FUFdIc4ltf6d0Bopeq2IuhyGB3ihr1P9"
    def response

    /**
     * Sends a request to Uberall API
     * @return response body into String format
     * */
    def getResponse() {
        println("Uberall API call...")
        HttpClient httpClient = HttpClient.create(host.toURL())
        HttpRequest request = HttpRequest.GET(endpoint).header(tokenKey,tokenValue)
        response = httpClient.toBlocking().exchange(request,String)
        httpClient.close()
        response.body()
    }

    /**
     * @return response body into JSON format
     * */
    def getJSONResponse() {
        if (response == null) {// To reduce API calls
            JsonSlurper jsonParser = new JsonSlurper()
            response = jsonParser.parseText(getResponse())
        }
        response
    }
}
