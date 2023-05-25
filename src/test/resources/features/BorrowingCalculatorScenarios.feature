Feature: Borrowing Calculator Scenarios


  Scenario Outline: Scenario 1
    Given Navigate to Borrowing Calculator Page
    When Complete person financial details "<ApplicationType>","<NumberOfDependants>","<PropertyLikeToBuy>","<AnnualIncome>","<AnnualOtherIncome>","<MonthlyLivingExp>","<CurHomeLnMnthyRep>","<OthLnMnthyRep>","<OthMnthyCommt>","<TotalCredCardLmts>","<borrowingEstimate>"
    And Close the application page
    Examples:
      | ApplicationType | NumberOfDependants | PropertyLikeToBuy | AnnualIncome | AnnualOtherIncome | MonthlyLivingExp | CurHomeLnMnthyRep | OthLnMnthyRep | OthMnthyCommt | TotalCredCardLmts | borrowingEstimate |
      | Single          | 0                  | Home to Live In   | 80000        | 10000             | 500              | 0                 | 100           | 0             | 10000             | 415,000           |


  Scenario Outline: Scenario 2
    Given Navigate to Borrowing Calculator Page
    When Complete person financial details "<ApplicationType>","<NumberOfDependants>","<PropertyLikeToBuy>","<AnnualIncome>","<AnnualOtherIncome>","<MonthlyLivingExp>","<CurHomeLnMnthyRep>","<OthLnMnthyRep>","<OthMnthyCommt>","<TotalCredCardLmts>","<borrowingEstimate>"
    Then Click on Start over should clear all fields
    And Close the application page
    Examples:
      | ApplicationType | NumberOfDependants | PropertyLikeToBuy | AnnualIncome | AnnualOtherIncome | MonthlyLivingExp | CurHomeLnMnthyRep | OthLnMnthyRep | OthMnthyCommt | TotalCredCardLmts | borrowingEstimate |
      | Single          | 0                  | Home to Live In   | 80000        | 10000             | 500              | 0                 | 100           | 0             | 10000             | 415,000           |

  @Calc
  Scenario Outline: Scenario 3
    Given Navigate to Borrowing Calculator Page
    When Complete person financial details "<ApplicationType>","<NumberOfDependants>","<PropertyLikeToBuy>","<AnnualIncome>","<AnnualOtherIncome>","<MonthlyLivingExp>","<CurHomeLnMnthyRep>","<OthLnMnthyRep>","<OthMnthyCommt>","<TotalCredCardLmts>","<borrowingEstimate>"
    Then Close the application page
    Examples:
      | ApplicationType | NumberOfDependants | PropertyLikeToBuy | AnnualIncome | AnnualOtherIncome | MonthlyLivingExp | CurHomeLnMnthyRep | OthLnMnthyRep | OthMnthyCommt | TotalCredCardLmts | borrowingEstimate |
      | Single          | 0                  | Home to Live In   | 0            | 0                 | 1                | 0                 | 0             | 0             | 0                 | 0                 |
