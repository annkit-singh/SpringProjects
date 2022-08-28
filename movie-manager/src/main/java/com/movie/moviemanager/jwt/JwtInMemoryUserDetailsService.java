package com.movie.moviemanager.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
//    inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
//        "$2a$10$d6xYz.M7D9lD8SXA8ue1VO6eC9UUuzNniQ8ujoDenXSLxrVyRMiSG", "ROLE_USER_2"));
    
    inMemoryUserList.add(new JwtUserDetails(2L, "akshay12minutes",
            "$2a$10$f8HA7YUx3DkwHOA7tEIC1u5uoT8JwNe2gZjWBaQYGKvx81tmU/4Ai", "ROLE_USER_2"));
    
    
  
    
    
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


