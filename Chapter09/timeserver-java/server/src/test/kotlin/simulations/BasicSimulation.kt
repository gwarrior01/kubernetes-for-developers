package simulations

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import io.gatling.javaapi.core.Simulation
import java.time.Duration

class BasicSimulation : Simulation() {

    private val httpProtocol = http
        .baseUrl("http://localhost:8080")
        .acceptHeader("application/json")

    private val scn = scenario("Load test /hello endpoint")
        .exec(
            http("GET /")
                .get("/")
                .check(status().shouldBe(200))
        )
        .pause(Duration.ofSeconds(1))

    init {
        setUp(
            scn.injectOpen(
                rampUsers(100).during(Duration.ofSeconds(60))
            )
        ).protocols(httpProtocol)
    }
}