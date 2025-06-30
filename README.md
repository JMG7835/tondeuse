Tondeuse

Une société souhaite développer une tondeuse à gazon automatique, destinée aux surfaces rectangulaires.\n
La tondeuse peut être programmée pour parcourir l'intégralité de la surface. 
La position de la tondeuse est représentée par une combinaison de coordonnées (x,y) et d'une lettre indiquant l'orientation selon la notation cardinale anglaise (N,E,W,S). 
La pelouse est divisée en grille pour simplifier la navigation.

On lui fournit une payload d'entrée au format json a l'adresse api/mowerorder en basic Auth login=toto mdp=mesTondeuses.
{
	"field": {
		"max_x": 5,
		"max_y": 5
	},
	"mowers": [
	{
		"id": "mower1",
		"start_position": {
			"x": 1,
			"y": 2
		},
		"orientation": "N",
		"instructions": [
			"G",
			"A",
			"G",
			"A",
			"G",
			"A",
			"G",
			"A",
			"A"
		]
	},
	{
		"id": "mower2",
		"start_position": {
			"x": 3,
			"y": 3
		},
		"orientation": "E",
		"instructions": [
			"A",
			"A",
			"D",
			"A",
			"A",
			"D",
			"A",
			"D",
			"D",
			"A"
		]
	}]
}

l'application retourne une Json de sortie:
{
  "mowers": [
    {
      "id": "mower1",
      "position": {
        "x": 1,
        "y": 3
      },
      "orientation": "N"
    },
    {
      "id": "mower2",
      "position": {
        "x": 5,
        "y": 1
      },
      "orientation": "E"
    }
  ]
}


Stack technique

| Technologie       | Usage                                       |
|-------------------|---------------------------------------------|
| Java 21           | Langage principal                           |
| Spring Boot       | Framework d’application                     |
| Spring Security   | Securisation de l'application (basic Auth)  |
| Lombok            | Réduction du boilerplate                    |
| JUnit + AssertJ   | Tests unitaires                             |
| Mockito           | Mock et isolation des composants            |
| Spring Web MVC    | Création des API REST                       |

Architecture

Le projet suit les principes de l’architecture Hexagonale

a modifier si j'ai plus de temps

Passer la sécurisation a un JWT,
Géré les colisiont entre tondeuse
Conteneurisation de l'application pour un déploiement plus simple
apprendre a faire des Pipelines GitHub pour build le projet en automatique
