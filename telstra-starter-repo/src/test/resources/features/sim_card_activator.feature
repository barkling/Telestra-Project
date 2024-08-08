Feature: Sim Card Activation

  Scenario: Successful Activation(iccid:1255789453849037777)
    Given the ICCID number is 1255789453849037777
    When I request this iccid to the SimCardActivatior
    Then I will be told "Successfully Activated"
    And "查询端点结果确认为激活"

  Scenario: Failed Activation(iccid:8944500102198304826)
    Given the ICCID number is 8944500102198304826
    When I request this iccid to the SimCardActivatior
    Then I will be told "Failed Activated"
    And "查询端点结果确认为失败"
