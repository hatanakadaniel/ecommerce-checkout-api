Feature: the version can be retrieved

  Scenario: client makes call to GET /version
    When the client calls "/version"
    Then the client receives status code of 200