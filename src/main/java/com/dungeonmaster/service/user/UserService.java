package com.dungeonmaster.service.user;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dungeonmaster.domain.user.Role;
import com.dungeonmaster.domain.user.User;
import com.dungeonmaster.errros.user.InvalidUserData;
import com.dungeonmaster.errros.user.UserError;
import com.dungeonmaster.modelDto.user.LoginForm;
import com.dungeonmaster.modelDto.user.UserDTO;
import com.dungeonmaster.repository.user.RoleRepository;
import com.dungeonmaster.repository.user.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	private final UserRepository userRepository;
	@Autowired
    RoleRepository roleRepository;
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository repository) {
		this.userRepository = repository;
	}
	
	public User register(User user) {
		return userRepository.save(user);
	}
	
	public boolean login(LoginForm form) {
		
		
		return false;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			user = userRepository.findByEmail(username);
		}
        if (user == null) {
            throw new UsernameNotFoundException("������������ �� ������");
        }

        return user;
	}
	
	public UserDTO findByUsername(String username) {
		User user = (User) loadUserByUsername(username);
		return new UserDTO(user);
	}
	
	public UserDTO findByEmail(String email) {
		User user = (User) userRepository.findByEmail(email);
		if (user == null) {
			 throw new UsernameNotFoundException("������������ �� ������");
		}
		return new UserDTO(user);
	}
	
	
	public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public void saveUser(UserDTO dto) throws InvalidUserData {
        User user = null;
        
        user = userRepository.findByUsername(dto.getUsername());

        if (user != null) {
            throw new InvalidUserData(UserError.UserAlreadyExists);
        }
        if (dto.getUsername().equals("")) {
        	throw new InvalidUserData(UserError.InvalidName);
        }
        if (dto.getEmail().equals("")) {
            throw new InvalidUserData(UserError.InvalidEmail);
        }
        
        user = new User(dto);
        
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println();
        userRepository.save(user);
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> userList(Long idMin) {
        return entityManager.createQuery("SELECT u FROM user u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
