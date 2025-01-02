Feature: Servicios SOAP para consultar información de Pokémon
  Como usuario del servicio SOAP
  Quiero realizar solicitudes a los endpoints
  Para obtener información sobre Pokémon

  Scenario: Obtener habilidades de un Pokémon
    Given el servicio SOAP esta disponible
    When realizo una peticion SOAP para obtener habilidades del Pokemon "pikachu"
    Then la respuesta debe contener las habilidades "static, lightning-rod"

  Scenario: Obtener la experiencia base de un Pokémon
    Given el servicio SOAP esta disponible
    When realizo una peticion SOAP para obtener la experiencia base del Pokemon "pikachu"
    Then la respuesta debe contener la experiencia base "112"

  Scenario: Obtener los objetos que sostiene un Pokémon
    Given el servicio SOAP esta disponible
    When realizo una peticion SOAP para obtener los objetos que sostiene el Pokemon "pikachu"
    Then la respuesta debe contener los objetos "oran-berry, sitrus-berry"

  Scenario: Obtener el ID de un Pokémon
    Given el servicio SOAP esta disponible
    When realizo una peticion SOAP para obtener el ID del Pokemon "pikachu"
    Then la respuesta debe contener el ID "25"

  Scenario: Obtener el nombre de un Pokémon
    Given el servicio SOAP esta disponible
    When realizo una peticion SOAP para obtener el nombre del Pokemon "pikachu"
    Then la respuesta debe contener el nombre "pikachu"

  Scenario: Obtener las áreas de encuentro de un Pokémon
    Given el servicio SOAP esta disponible
    When realizo una peticion SOAP para obtener las áreas de encuentro del Pokemon "pikachu"
    Then la respuesta debe contener las áreas de encuentro "forest, plains"
