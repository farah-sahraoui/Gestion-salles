Gestion des Salles - Hibernate & JPA

 Description:

Application Java développée avec **Hibernate (JPA)** permettant la gestion des :

-  Utilisateurs
-  Salles

Le projet implémente les opérations **CRUD complètes** :
- Create
- Read
- Update
- Delete

Base de données utilisée : **H2 (en mémoire)**

 Technologies utilisées

- Java
- Hibernate
- JPA (Jakarta Persistence)
- Maven
- Base de données H2
- IntelliJ IDEA


##  Structure du projet:

![WhatsApp Image 2026-02-18 at 13 13 33](https://github.com/user-attachments/assets/aa061f1b-9074-4030-a259-cc42822b5e64)


![WhatsApp Image 2026-02-18 at 13 14 18](https://github.com/user-attachments/assets/d6776844-f261-4dfd-aeaf-44d242ca715e)

## Démarrage des tests CRUD – Utilisateur:

Ces captures illustrent l’exécution complète des opérations CRUD sur l’entité Utilisateur avec Hibernate.
Elles montrent d’abord la recherche d’un utilisateur par email, confirmant le bon fonctionnement des requêtes avec condition, 
puis la mise à jour des informations d’un utilisateur, prouvant que les modifications sont correctement enregistrées dans la base de données,
et enfin la suppression d’un utilisateur, validant que l’enregistrement est bien supprimé de la table.
L’ensemble des résultats affichés démontre que le mapping entre l’entité Java et la base de données relationnelle est correct et que toutes les opérations
(Create, Read, Update, Delete) fonctionnent parfaitement.

![WhatsApp Image 2026-02-18 at 13 17 16](https://github.com/user-attachments/assets/b31d1f03-2e6f-4e68-a5a4-57e603525957)


![WhatsApp Image 2026-02-18 at 13 19 27](https://github.com/user-attachments/assets/8b102f72-57b8-4b0a-9fea-583db9088e4d)


![WhatsApp Image 2026-02-18 at 13 20 26](https://github.com/user-attachments/assets/caa818b1-95a7-4b56-a74c-c50d3ee6688a)


![WhatsApp Image 2026-02-18 at 13 21 15](https://github.com/user-attachments/assets/cde920c6-190f-459c-a364-1271665af398)

## Démarrage des tests CRUD – Salle:

Ces captures illustrent l’exécution complète des opérations CRUD sur l’entité Salle à l’aide de Hibernate. 
On observe d’abord l’insertion de plusieurs salles dans la base de données, confirmant que l’opération d’ajout fonctionne correctement.
Ensuite, l’affichage de toutes les salles ainsi que la recherche par identifiant démontrent la bonne récupération des données.
Des requêtes avec conditions sont également exécutées, notamment pour afficher les salles disponibles et celles ayant une capacité
supérieure ou égale à une valeur donnée, ce qui valide le bon fonctionnement des filtres. La mise à jour de la capacité
d’une salle prouve que les modifications sont correctement persistées, et enfin la suppression d’une salle confirme que l’enregistrement
est bien retiré de la base de données. L’ensemble des résultats affichés montre que le mapping entre l’entité Java et la table relationnelle
est correct et que toutes les fonctionnalités CRUD de l’entité Salle sont pleinement opérationnelles.



![WhatsApp Image 2026-02-18 at 13 23 24](https://github.com/user-attachments/assets/7051034e-4c4b-429b-8ef7-de9ce74cc695)


![WhatsApp Image 2026-02-18 at 13 24 10](https://github.com/user-attachments/assets/95ba6abd-e5f0-45ed-945c-7856d62eed44)

![WhatsApp Image 2026-02-18 at 13 25 00](https://github.com/user-attachments/assets/5779676a-0c60-46ff-86a4-023ab2e37c69)

![WhatsApp Image 2026-02-18 at 13 26 16](https://github.com/user-attachments/assets/6c5867cd-83a4-46a1-9a46-e591533d7fb7)

![WhatsApp Image 2026-02-18 at 13 26 55](https://github.com/user-attachments/assets/05c7a5a1-6867-43a7-b95a-4e4fbb94bad5)


![WhatsApp Image 2026-02-18 at 13 27 47](https://github.com/user-attachments/assets/2305a62c-2403-4291-be9d-9ba37998b3e3)

![WhatsApp Image 2026-02-18 at 21 14 28](https://github.com/user-attachments/assets/2a4e7fe3-2a68-46f1-bfd2-17fe6bea26bd)


![WhatsApp Image 2026-02-18 at 21 15 08](https://github.com/user-attachments/assets/2009c48c-deff-4f8f-ab6e-1ebd1723456b)


![WhatsApp Image 2026-02-18 at 21 15 44](https://github.com/user-attachments/assets/1a1bfb26-2c87-405a-8863-6862c27ef92a)



 ## Opérations CRUD sur l’entité Utilisateur:

 Ces captures montrent les opérations CRUD effectuées sur l’entité **Utilisateur** via Hibernate. 
 On y observe l’insertion d’un nouvel utilisateur dans la table `utilisateurs`, suivie de requêtes de sélection permettant
 de récupérer les informations par identifiant. Ensuite, une mise à jour des données (date de naissance, email, nom, prénom, téléphone) est exécutée, 
 puis une nouvelle vérification par requête `select` confirme la modification. Une opération de suppression (`delete`)
 est également réalisée pour retirer un utilisateur de la base. Enfin, lors de l’arrêt de l’application, 
 Hibernate supprime automatiquement les tables `salles` et `utilisateurs`, ce qui montre que la gestion du cycle de vie de la base de données est correctement configurée.


![WhatsApp Image 2026-02-18 at 21 23 28](https://github.com/user-attachments/assets/3b6402a7-901c-4d9c-94bc-f3e9ddf4c253)


![WhatsApp Image 2026-02-18 at 21 23 33](https://github.com/user-attachments/assets/44a39c5d-35a3-4098-97c5-cd14eee220e9)


![WhatsApp Image 2026-02-18 at 21 25 16](https://github.com/user-attachments/assets/03adf502-4c54-4028-8152-b2f1ae2a437a)


![WhatsApp Image 2026-02-18 at 21 25 46](https://github.com/user-attachments/assets/40878a43-1d42-453e-8842-358e9f1fe091)













