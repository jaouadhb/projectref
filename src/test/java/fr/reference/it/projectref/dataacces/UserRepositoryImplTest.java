package fr.reference.it.projectref.dataacces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserRepositoryImplTest {

    UserRepositoryImpl utilisateurRepository;
    @Mock
    JpaUserDAO jpaUserDAO;

    @BeforeEach
    void setUp() {
        utilisateurRepository = new UserRepositoryImpl(jpaUserDAO, UserMapper.INSTANCE);
    }

    @Test
    void should_FindAll() {
        BDDMockito.given(jpaUserDAO.findAll()).willReturn(Arrays.asList(new UserEntity("jaouad@gmail.com","jaouad","hba",new Date())));
        assertThat(utilisateurRepository.findAll()).hasSize(1);
    }
}
