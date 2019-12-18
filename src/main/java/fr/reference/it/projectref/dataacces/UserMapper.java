package fr.reference.it.projectref.dataacces;


import fr.reference.it.projectref.domaine.dto.Utilisateur;

public interface UserMapper {

    UserMapper INSTANCE =new UserMapperImpl();

    Utilisateur map(UserEntity userEntity);
    UserEntity map(Utilisateur utilisateur);

}
