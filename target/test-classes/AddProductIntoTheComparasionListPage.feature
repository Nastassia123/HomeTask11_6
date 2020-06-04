Feature: 4FRAG product search

  Background:
    Given I opened 4FRAG home page
    And I log in to the site using header tab "Вход/регистрация"

  Scenario Outline: Searching product in 4FRAG
    When I search "<item>"
    And I add "<item>" to the comparasion list page
    And I close "Успешно!" notification pop-up
    And I open tab "Сравнение товаров"
    And I click on 'Buy' button
    And I close "Успешно!" notification pop-up
    And I open tab "Корзина"
    Then "<item>" is on the basket page



    Examples:
      | item |
      | A4Tech Bloody A91 Light Strike |

