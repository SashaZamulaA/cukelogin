# AP-2032: Show customer TIN and validation for all Spanish merchants
# Business Rules:
#  R1. TIN is always visible for all Spanish merchants on the Customer Info Screen
#  R2. Transactions > €3000 require a TIN, otherwise show an error and block
#  R3. Validation triggers on Payment, Split, and Tips screens
#
# Notes:
#  - Applies to AEAT and non-AEAT merchants
#  - Error message: “Customer TIN required for amounts over €3000”
#  - Refunds excluded
#
# Source: https://confluence.company.com/display/ESFISCAL/AP-2032

@AP-2032 @POS @Spain @Tax
Feature: Show customer TIN and validation for all Spanish merchants

  @AP-2032-S1
  Scenario: Display TIN for all Spanish merchants
    Given I am a Spanish merchant
    When I open the Customer Info Screen
    Then I see the customer’s TIN displayed

  @AP-2032-S2
  Scenario: Block transaction if total exceeds 3000 EUR without TIN
    Given total is 3200 EUR and customer has no TIN
    When I try to complete the payment
    Then I see error message "Customer TIN required for amounts over €3000"
    And the transaction is not completed
