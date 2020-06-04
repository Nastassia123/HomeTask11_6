Feature: 4FRAG product search

  Background:
    Given I opened 4FRAG home page
    And I log in to the site using header tab "Вход/регистрация"

   Scenario Outline: Searching product in 4FRAG
     When I search "<item>"
     And I add "<item>" to the wish list page
     And I close "Успешно!" notification pop-up
     And I open tab "Закладки"
     Then "<item>" is on the wish list page

     Examples:
       | item              |
       | Logitech BRIO     |
       | Dark Project Mouse |

