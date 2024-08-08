Feature: Sim Card Activation

  Scenario: Successful Activation(iccid:1255789453849037777)
    Given a functional sim card
    When I request this iccid to the SimCardActivatior
    Then I will be told "Successfully Activated"

  Scenario: Failed Activation(iccid:8944500102198304826)
    Given a broken sim card
    When I request this iccid to the SimCardActivatior
    Then I will be told "Failed Activated"

