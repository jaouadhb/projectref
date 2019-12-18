package fr.reference.it.projectref.dataacces;

import fr.reference.it.projectref.domaine.dto.Utilisateur;
import fr.reference.it.projectref.domaine.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserDAO jpaUserDAO;
    private final UserMapper userMapper;

    public UserRepositoryImpl(JpaUserDAO jpaUserDAO, UserMapper utilisateurMapper) {
        this.jpaUserDAO = jpaUserDAO;
        this.userMapper = utilisateurMapper;
    }

    @Override
    public List<Utilisateur> findAll() {
        return jpaUserDAO.findAll().stream().map(userMapper::map).collect(Collectors.toList());
    }

    @Override
    public Optional<Utilisateur> findUserById(int pId) {
        return jpaUserDAO.findById(pId).map(userMapper::map);
    }

    @Override
    public void deleteUser(int pId) {
        jpaUserDAO.deleteById(pId);
    }

    @Override
    public void updateUser(Utilisateur pUtilisateur) {
        jpaUserDAO.save(userMapper.map(pUtilisateur));
    }
    @Override
    public void saveUser(Utilisateur pUtilisateur) {
        jpaUserDAO.save(userMapper.map(pUtilisateur));
    }
}
