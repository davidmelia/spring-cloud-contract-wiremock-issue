package contracts.cashbalances

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/dave-service/api/1/cash'
    }
    response {
        status 200
        body(file('get-cash.response.json'))
        headers {
            contentType('application/json')
        }
    }
}
