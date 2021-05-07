Feature: Login Niubiz

  Scenario Outline: Log Out Correcto
    Given que me encuentro en la pagina de Niubiz
    When ingreso "<username>" y "<password>"
    And selecciono el boton de ingresar
    And selecciono la opcion para cerrar sesion
    Then verifico que al salir muestre el Login

    Examples:
      |username                        | password  |
      | jimena@altaircrossfit.com      | Password  |
      | alfredo.salvador@latam.com     | Password1 |
      | qabackend01@yopmail.com        | Password  |
      | qasagafalabella@yopmail.com    | Password  |
      | qasagafalabellatope@yopmail.com| Password1 |

  Scenario Outline: Login Correcto
    Given que me encuentro en la pagina de Niubiz
    When ingreso "<username>" y "<password>"
    And selecciono el boton de ingresar
    Then verifico que al ingresar se muestre el "<nickname>"

    Examples:
    |username                        | password  | nickname            |
    | jimena@altaircrossfit.com      | Password  | Jimena Navarro      |
    | alfredo.salvador@latam.com     | Password1 | Alfredo Salvador    |
    | qabackend01@yopmail.com        | Password  | MOISES ELIUT CASTRO |
    | qasagafalabella@yopmail.com    | Password  | Cindy Nalvarte      |
    | qasagafalabellatope@yopmail.com| Password1 | Testing Testing     |

