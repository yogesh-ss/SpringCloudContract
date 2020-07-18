import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return list of frauds"
    request {
        url "/fraud"
        method GET()
    }
    response {
        status 200
        body(["yogesh","nihal"])
    }
}