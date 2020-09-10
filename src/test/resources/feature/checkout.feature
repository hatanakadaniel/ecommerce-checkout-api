Feature: Checkout Resource

  Background:
    Given checkout code "c3ec1783-67b5-4924-b8d3-e57c8dd2dd08"

  Scenario: create checkout
    When the client calls "/v1/checkout/"
    Then the client receives status code of 201
    And response is "{\"code\":\"c3ec1783-67b5-4924-b8d3-e57c8dd2dd08\"}"