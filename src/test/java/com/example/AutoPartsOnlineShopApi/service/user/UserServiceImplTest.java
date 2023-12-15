package com.example.AutoPartsOnlineShopApi.service.user;

import com.example.AutoPartsOnlineShopApi.entity.user.User;
import com.example.AutoPartsOnlineShopApi.repository.user.UserRepository;
import com.example.AutoPartsOnlineShopApi.service.user.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests for UserService")
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    @DisplayName("Save User - Success")
    void testSave() {
        // Arrange
        User userToSave = new User("testUser", "testPassword", "ROLE_USER");
        User savedUser = new User(1L, "testUser", "testPassword", "ROLE_USER");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        User result = userService.save(userToSave);

        // Assert
        assertNotNull(result.getId());
        assertEquals("testUser", result.getUsername());
        assertEquals("testPassword", result.getPassword());
        assertEquals("ROLE_USER", result.getRole());

        verify(userRepository, times(1)).save(any(User.class));
    }


    @Test
    @DisplayName("Find User By Username - Success")
    void testFindByUsername() {
        // Arrange
        String username = "testUser";
        User mockUser = new User(username, "testPassword");
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(mockUser));

        // Act
        Optional<User> result = userService.findByUsername(username);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockUser, result.get());
        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    @DisplayName("Create User - Success")
    void testCreateUser() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";
        when(userRepository.existsByUsername(username)).thenReturn(false);
        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");

        // Act
        userService.createUser(username, password);

        // Assert
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Create User Username Taken")
    void testCreateUserUsernameTaken() {
        // Arrange
        String username = "existingUser";
        String password = "testPassword";
        when(userRepository.existsByUsername(username)).thenReturn(true);

        // Act
        userService.createUser(username, password);

        // Assert
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Load User By Username - Success")
    void testLoadUserByUsername() {
        // Arrange
        String username = "testUser";
        String encodedPassword = "encodedPassword";
        User mockUser = new User(username, encodedPassword, "USER");

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(mockUser));

        // Act
        UserDetails userDetails = userService.loadUserByUsername(username);

        // Assert
        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertEquals(encodedPassword, userDetails.getPassword());
    }


    @Test
    @DisplayName("Load User By Username User Not Found")
    void testLoadUserByUsernameUserNotFound() {
        // Arrange
        String username = "nonExistingUser";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(username));
    }
}
